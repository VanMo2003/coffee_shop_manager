package org.example.CnJava_Project.view.manager.panel;

import org.example.CnJava_Project.view.manager.frame.ManagerView;
import org.example.CnJava_Project.controller.manager.QLMAController;
import org.example.CnJava_Project.model.DishGroupModel;
import org.example.CnJava_Project.model.DishModel;
import org.example.CnJava_Project.respository.DishGroupRepository;
import org.example.CnJava_Project.respository.DishRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QLMAPanel extends JPanel {
	private ManagerView managerView;
	private  JPanel contentPane = new JPanel();
	public  JTextField textFieldSearch;
	public JComboBox comboBoxDishGroup;
	public  JTable table;
	public  JTextField textFieldNameDish;
	public  JTextField textFieldUnitPrice;
	private DishRepository dishRepository;
	private DishGroupRepository dishGroupRepository;
	public QLMAPanel(ManagerView managerView, DishRepository dishRepository, DishGroupRepository dishGroupRepository) {
		this.managerView = managerView;
		this.dishRepository = dishRepository;
		this.dishGroupRepository = dishGroupRepository;
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

		textFieldSearch = new JTextField();
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(150, 39, 660, 25);
		contentPane.add(textFieldSearch);

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
				"tên món", "đơn giá", "nhóm món"}));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getDataSelected();
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

		JLabel lbID = new JLabel("Tên món");
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbID.setBounds(13, 440, 105, 25);
		contentPane.add(lbID);

		JLabel lbName = new JLabel("Đơn giá");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbName.setBounds(13, 490, 105, 25);
		contentPane.add(lbName);

		JLabel lbDate = new JLabel("Nhóm món");
		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbDate.setBounds(13, 540, 105, 25);
		contentPane.add(lbDate);

		textFieldNameDish = new JTextField();
		textFieldNameDish.setColumns(10);
		textFieldNameDish.setBounds(117, 440, 274, 25);
		contentPane.add(textFieldNameDish);

		textFieldUnitPrice = new JTextField();
		textFieldUnitPrice.setColumns(10);
		textFieldUnitPrice.setBounds(117, 490, 274, 25);
		contentPane.add(textFieldUnitPrice);

		comboBoxDishGroup = new JComboBox();
		ArrayList<DishGroupModel> listDishGroup = getListDishGroup();
		for (DishGroupModel dishGroupModel : listDishGroup) {
			comboBoxDishGroup.addItem(dishGroupModel.getNameDishGroup());
		}
		comboBoxDishGroup.setBounds(117, 540, 274, 25);
		contentPane.add(comboBoxDishGroup);

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

		JButton btnCancel = new JButton("Đặt lại");
		btnCancel.addActionListener(ac);
		btnCancel.setToolTipText("Tắt");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(740, 626, 220, 38);
		contentPane.add(btnCancel);

		getDataTable();

		this.managerView.setContentPane(contentPane);
	}

	private ArrayList<DishGroupModel> getListDishGroup() {
		return (ArrayList<DishGroupModel>) dishGroupRepository.findAll();
	}

	public void updateDishSelected(){
		DishModel dishModelUpdate = textFieldToObject();
		if (dishModelUpdate!=null) {
			DefaultTableModel dftm = (DefaultTableModel) table.getModel();
			int i_row = table.getSelectedRow();
			String nameDishOld = dftm.getValueAt(i_row,0).toString();

			if (dftm.getValueAt(i_row,0).toString().equals(dishModelUpdate.getNameDish())){
				dishRepository.save(dishModelUpdate);
			}else {
				dishRepository.deleteById(nameDishOld);
				dishRepository.save(dishModelUpdate);
			}

			dftm.setValueAt(dishModelUpdate.getNameDish(), i_row, 0);
			dftm.setValueAt(dishModelUpdate.getUnitPrice(), i_row, 1);
			dftm.setValueAt(dishModelUpdate.getDishGroup(), i_row, 2);

			JOptionPane.showMessageDialog(managerView, "Update Successfully");
			reset();
		}
	}
	public void deleteDishSelected()  {
		DishModel dishModel = textFieldToObject();

		if (dishModel != null) {
			int luaChon = JOptionPane.showConfirmDialog(
					managerView,
					"Bạn muốn xóa món ăn " + dishModel.getNameDish(),
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
		}
	}
	public void insertData(){
		DishModel dishModel = textFieldToObject();
		if (dishModel!=null) {
			Optional<DishModel> dishModelFound = dishRepository.findById(dishModel.getNameDish());

			if (!dishModelFound.isPresent()) {
				dishRepository.save(dishModel);
				addDataTable(dishModel);
				reset();
			} else {
				JOptionPane.showMessageDialog(managerView, "Món ăn đã có trong thực đơn", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private DishModel textFieldToObject(){
		String ten = textFieldNameDish.getText();
		String gia = textFieldUnitPrice.getText();
		int nhom = comboBoxDishGroup.getSelectedIndex();
		System.out.println(ten);
		System.out.println(gia);
		if (!ten.equals("") && !gia.equals("")){
			DishModel dishModel = new DishModel();
			dishModel.setNameDish(ten);
			dishModel.setUnitPrice(Double.parseDouble(gia));
			dishModel.setDishGroup(nhom+1);
			return dishModel;
		}else {
			JOptionPane.showMessageDialog(managerView, "Mời bạn nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
			return  null;
		}
	}
	private void getDataSelected()  {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		int index_row = table.getSelectedRow();
		if (index_row>=0) {
			textFieldNameDish.setText(dftm.getValueAt(index_row,0).toString());
			textFieldUnitPrice.setText(dftm.getValueAt(index_row,1).toString());
			comboBoxDishGroup.setSelectedIndex(Integer.parseInt(dftm.getValueAt(index_row,2).toString())-1);
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
				dishModel.getNameDish(),
				dishModel.getUnitPrice(),
				dishModel.getDishGroup(),
		});
	}
	public void reset(){
		textFieldNameDish.setText("");
		textFieldUnitPrice.setText("");
		comboBoxDishGroup.setSelectedIndex(0);
	}
	public void showPanel(){
		contentPane.setVisible(true);
	}
	public void closePanel(){
		contentPane.setVisible(false);
	}
}
