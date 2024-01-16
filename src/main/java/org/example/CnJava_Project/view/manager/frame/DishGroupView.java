package org.example.CnJava_Project.view.manager.frame;

import org.example.CnJava_Project.controller.manager.DishGroupController;
import org.example.CnJava_Project.model.DishGroupModel;
import org.example.CnJava_Project.respository.DishGroupRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Optional;

public class DishGroupView extends JFrame {
	public JTextField textFieldName;
	public JTextField textFieldId;
	public JTable table;
	public DishGroupRepository dishGroupRepository;

	public DishGroupView(DishGroupRepository dishGroupRepository){
		this.dishGroupRepository = dishGroupRepository;
		setSize(400, 500);
		setTitle("Nhóm món");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		ActionListener ac = new DishGroupController(this);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"mã nhóm món", "tên nhóm món"}));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getDataSelected();
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 365, 300);
		this.add(scrollPane);

		JLabel labelIdDishGroup = new JLabel("Mã nhóm món:");
		labelIdDishGroup.setBounds(10, 330, 180, 30);
		this.add(labelIdDishGroup);

		JLabel labelNameDishGroup = new JLabel("Tên nhóm món:");
		labelNameDishGroup.setBounds(190, 330, 180, 30);
		this.add(labelNameDishGroup);

		textFieldId = new JTextField();
		textFieldId.setBounds(10, 360, 175, 30);
		this.add(textFieldId);

		textFieldName = new JTextField();
		textFieldName.setBounds(195, 360, 175, 30);
		this.add(textFieldName);

		JButton buttonAdd = new JButton("Thêm");
		buttonAdd.addActionListener(ac);
		buttonAdd.setBounds(10, 420, 115, 30);
		this.add(buttonAdd);

		JButton buttonEdit = new JButton("Sửa");
		buttonEdit.addActionListener(ac);
		buttonEdit.setBounds(135, 420, 115, 30);
		this.add(buttonEdit);

		JButton buttonDelete = new JButton("Xóa");
		buttonDelete.addActionListener(ac);
		buttonDelete.setBounds(260, 420, 115, 30);
		this.add(buttonDelete);

		getTables();
	}

	public void deleteData(){
		DishGroupModel dishGroupModel = textFieldToObject();
		if (dishGroupModel!=null){
			dishGroupRepository.deleteById(dishGroupModel.getIdDishGroup());
			DefaultTableModel dftm = (DefaultTableModel) table.getModel();
			int i_row = table.getSelectedRow();
			dftm.removeRow(i_row);
			reset();
		}
	}

	public void updateData(){
		DishGroupModel dishGroupModel = textFieldToObject();
		if (dishGroupModel!=null){
			updateRowTable(dishGroupModel);
			dishGroupRepository.save(dishGroupModel);
			reset();
		}
	}
	private void updateRowTable(DishGroupModel dishGroupModel){
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		if (table.getSelectedRowCount() == 1){
			int i_row = table.getSelectedRow();
			dftm.setValueAt(dishGroupModel.getIdDishGroup(), i_row, 0);
			dftm.setValueAt(dishGroupModel.getNameDishGroup(), i_row, 1);

			JOptionPane.showMessageDialog(this, "Update Successfully");
		}
	}
	private void getDataSelected() {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		int index_row = table.getSelectedRow();
		if (index_row>=0) {
			textFieldId.setText(dftm.getValueAt(index_row, 0).toString());
			textFieldName.setText(dftm.getValueAt(index_row, 1).toString());
		}
	}

	public void insertData(){
		String id = textFieldId.getText();
		String name = textFieldName.getText();

		if (!id.equals("") && !name.equals("")) {
			Optional<DishGroupModel> dishGroupModelFound = dishGroupRepository.findById(Integer.parseInt(textFieldId.getText()));
			if (!dishGroupModelFound.isPresent()) {
				DishGroupModel dishGroupModel = textFieldToObject();
				if (dishGroupModel != null) {
					addDataTables(dishGroupModel);
					dishGroupRepository.save(dishGroupModel);
					reset();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Nhóm món đã tồn tại", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(this, "Mời bạn nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private DishGroupModel textFieldToObject(){
		String id = textFieldId.getText();
		String name = textFieldName.getText();
		if (!id.equals("") && !name.equals("")) {
			DishGroupModel dishGroupModel = new DishGroupModel();
			dishGroupModel.setIdDishGroup(Integer.parseInt(id));
			dishGroupModel.setNameDishGroup(name);
			return dishGroupModel;
		}else {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhóm món", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	private void getTables(){
		List<DishGroupModel> list = dishGroupRepository.findAll();

		list.forEach(dishGroupModel -> addDataTables(dishGroupModel));

	}
	private void addDataTables(DishGroupModel dishGroupModel){
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		dftm.addRow(new Object[]{
				dishGroupModel.getIdDishGroup(),
				dishGroupModel.getNameDishGroup(),
		});
	}
	private void reset(){
		textFieldId.setText("");
		textFieldName.setText("");
	}
}
