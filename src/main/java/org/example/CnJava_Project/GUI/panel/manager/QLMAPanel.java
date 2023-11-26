package org.example.CnJava_Project.GUI.panel.manager;

import org.example.CnJava_Project.GUI.ManagerView;
import org.example.CnJava_Project.controller.QLMAController;
import org.example.CnJava_Project.model.DishModel;
import org.example.CnJava_Project.respository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Optional;

public class QLMAPanel extends JPanel {
	private ManagerView managerView;
	private  JPanel contentPane = new JPanel();
	public  JTextField textField_Search;
	public  JTable table;
	public  JTextField textField_ID;
	public  JTextField textField_NameDish;
	public  JTextField textField_UnitPrice;
	private DishRepository dishRepository;
	public QLMAPanel(ManagerView managerView, DishRepository dishRepository){
		this.dishRepository = dishRepository;
		this.managerView = managerView;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setVisible(false);

		ActionListener ac = new QLMAController(this);

		JLabel lblTitle = new JLabel("Quản lý món ăn");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(980/2-150, 0, 300, 25);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTitle);

		JLabel lblSearchCCCD = new JLabel("Tên món ăn : ");
		lblSearchCCCD.setToolTipText("Nhập tên món ăn");
		lblSearchCCCD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchCCCD.setBounds(13, 39, 150, 25);
		contentPane.add(lblSearchCCCD);

		textField_Search = new JTextField();
		textField_Search.setColumns(10);
		textField_Search.setBounds(150, 39, 660, 25);
		contentPane.add(textField_Search);

		JButton btnNoFind = new JButton("Tìm");
		btnNoFind.addActionListener(ac);
		btnNoFind.setToolTipText("Tìm kiếm món ăn theo tên");
		btnNoFind.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNoFind.setBounds(825, 39, 128, 26);
		contentPane.add(btnNoFind);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(203, 94, 761, 2);
		contentPane.add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("Danh sách món ăn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(13, 76, 200, 37);
		contentPane.add(lblNewLabel_1);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"ID", "Tên món ăn", "đơn giá"}));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDataSelectedToTF();
			}
		});
		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(13, 123, 940, 271);
		contentPane.add(scrollPane);

		JLabel lblNewLabel_2 = new JLabel("Thông tin món ăn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(13, 404, 170, 25);
		contentPane.add(lblNewLabel_2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(182, 421, 784, 2);
		contentPane.add(separator_2);

		JLabel lbID = new JLabel("Id");
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbID.setBounds(13, 440, 105, 25);
		contentPane.add(lbID);

		JLabel lbName = new JLabel("Tên món ăn");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbName.setBounds(13, 490, 105, 25);
		contentPane.add(lbName);

		JLabel lbDate = new JLabel("Đơn giá");
		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbDate.setBounds(13, 540, 105, 25);
		contentPane.add(lbDate);

		textField_ID = new JTextField();
		textField_ID.setBounds(117, 440, 274, 25);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);

		textField_NameDish = new JTextField();
		textField_NameDish.setColumns(10);
		textField_NameDish.setBounds(117, 490, 274, 25);
		contentPane.add(textField_NameDish);

		textField_UnitPrice = new JTextField();
		textField_UnitPrice.setColumns(10);
		textField_UnitPrice.setBounds(117, 540, 274, 25);
		contentPane.add(textField_UnitPrice);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(13, 602, 940, 2);
		contentPane.add(separator_3);

		JButton btnInSert = new JButton("Thêm");
		btnInSert.addActionListener(ac);
		btnInSert.setToolTipText("Thêm");
		btnInSert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInSert.setBounds(20, 626, 220, 38);
		contentPane.add(btnInSert);

		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(ac);
		btnDelete.setToolTipText("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(260, 626, 220, 38);
		contentPane.add(btnDelete);

		JButton btnEdit = new JButton("Chỉnh sửa");
		btnEdit.addActionListener(ac);
		btnEdit.setToolTipText("Cập nhật");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(500, 626, 220, 38);
		contentPane.add(btnEdit);

		JButton btnCancel = new JButton("Reset");
		btnCancel.addActionListener(ac);
		btnCancel.setToolTipText("Tắt");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(740, 626, 220, 38);
		contentPane.add(btnCancel);

		getDataTable();

		this.managerView.setContentPane(contentPane);
	}

	public void updateDishSelected(){
		DishModel dishModel = getDataSelected();
		if (dishModel!=null) {
			Optional<DishModel> dishModelFound = dishRepository.findById(dishModel.getId());

			if (dishModelFound.isPresent()){
				DishModel dishModelUpdate = dishModelFound.get();
				dishModelUpdate.setId(textField_ID.getText());
				dishModelUpdate.setNameDish(textField_NameDish.getText());
				dishModelUpdate.setUnitPrice(Double.parseDouble(textField_UnitPrice.getText()));


				updateRowTable(dishModelUpdate);

				if (dishModel.getId().equals(dishModelUpdate.getId())){
					dishRepository.save(dishModelUpdate);
				}else {
					dishRepository.delete(dishModel);
					dishRepository.save(dishModelUpdate);
				}

				reset();
			}
		}
	}
	private void updateRowTable(DishModel dishModel){
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		if (table.getSelectedRowCount() == 1){
			int i_row = table.getSelectedRow();
			dftm.setValueAt(dishModel.getId(), i_row, 0);
			dftm.setValueAt(dishModel.getNameDish(), i_row, 1);
			dftm.setValueAt(dishModel.getUnitPrice(), i_row, 2);

			JOptionPane.showMessageDialog(managerView, "Update Successfully");
		}else {
			if (table.getRowCount() == 0){
				JOptionPane.showMessageDialog(managerView, "Danh sách rỗng");
			}
		}
	}
	public void deleteDishSelected()  {
		DishModel dishModel = getDataSelected();

		if (dishModel != null) {
			int luaChon = JOptionPane.showConfirmDialog(
					managerView,
					"Bạn muốn xóa món ăn " + dishModel.getId() + "(" + dishModel.getNameDish() + ")",
					"Delete",
					JOptionPane.YES_NO_OPTION
			);

			if (luaChon == JOptionPane.YES_OPTION) {
				dishRepository.delete(dishModel);
				DefaultTableModel dftm = (DefaultTableModel) table.getModel();
				int i_row = table.getSelectedRow();
				dftm.removeRow(i_row);
				reset();
			}
		} else {
			JOptionPane.showMessageDialog(managerView, "Bạn chưa chọn món ăn", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void setDataSelectedToTF()  {
		DishModel dishModel = getDataSelected();
		if (dishModel!=null){
			textField_ID.setText(dishModel.getId());
			textField_NameDish.setText(dishModel.getNameDish());
			textField_UnitPrice.setText(dishModel.getUnitPrice()+"");
		}
	}
	private DishModel getDataSelected()  {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		int index_row = table.getSelectedRow();
		if (index_row>=0) {
			DishModel dishModel = new DishModel();
			dishModel.setId(dftm.getValueAt(index_row, 0).toString());
			dishModel.setNameDish(dftm.getValueAt(index_row, 1).toString());
			dishModel.setUnitPrice(Double.parseDouble(dftm.getValueAt(index_row, 2).toString()));

			return dishModel;
		}else {
			return null;
		}
	}

	public void insertData(DishModel dishModel){
		Optional<DishModel> dishModelFound = dishRepository.findById(dishModel.getId());

		if (!dishModelFound.isPresent()) {
			dishRepository.save(dishModel);
			addDataTable(dishModel);
			reset();
		}else {
			JOptionPane.showMessageDialog(managerView, "Trùng id", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void getDataTable(){
		List<DishModel> dishModelList = dishRepository.findAll();

		if (!dishModelList.isEmpty()){
			for (DishModel dishModel :
					dishModelList) {
				addDataTable(dishModel);
			}
		}
	}
	public  void addDataTable(DishModel dishModel) {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();

		dftm.addRow(new Object[]{
				dishModel.getId(),
				dishModel.getNameDish(),
				dishModel.getUnitPrice(),
		});
	}
	public void reset(){
		textField_ID.setText("");
		textField_NameDish.setText("");
		textField_UnitPrice.setText("");
	}
	public void showPanel(){
		contentPane.setVisible(true);
	}
	public void closePanel(){
		contentPane.setVisible(false);
	}
}
