package org.example.CnJava_Project.GUI.panel.manager;

import org.example.CnJava_Project.GUI.ManagerView;
import org.example.CnJava_Project.controller.QLNVController;
import org.example.CnJava_Project.model.TinhModel;
import org.example.CnJava_Project.model.EmployeeModel;
import org.example.CnJava_Project.respository.AccountRepository;
import org.example.CnJava_Project.respository.EmployeeRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class QLNVPanel extends JPanel {
	private ManagerView managerView;
	private  JPanel contentPane = new JPanel();
	public  JTextField textField_Search;
	public  JTable table;
	public  JTextField textField_CCCD;
	public  JTextField textField_FullName;
	public  JTextField textField_DateOfBirth;
	public  JTextField textField_NumberPhone;
	public  JTextField textField_Role;
	public  JComboBox comboBox_BirthPlace;
	public  JRadioButton JRadioNam;
	public  JRadioButton JRadioNu;
	public  ButtonGroup buttonGroup_gioiTinh;
	public EmployeeRepository employeeRepository;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public QLNVPanel(ManagerView managerView, EmployeeRepository employeeRepository){
		this.managerView = managerView;

		this.employeeRepository = employeeRepository;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setVisible(false);

		ActionListener ac = new QLNVController(this);

		JLabel lblTitle = new JLabel("Quản lý nhân viên");
		lblTitle.setToolTipText("Nhập cccd để tìm kiếm");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(980/2-150, 0, 300, 25);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTitle);

		JLabel lblSearchCCCD = new JLabel("Căn cước công dân : ");
		lblSearchCCCD.setToolTipText("Nhập cccd để tìm kiếm");
		lblSearchCCCD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchCCCD.setBounds(13, 39, 200, 25);
		contentPane.add(lblSearchCCCD);

		textField_Search = new JTextField();
		textField_Search.setColumns(10);
		textField_Search.setBounds(210, 39, 600, 25);
		contentPane.add(textField_Search);

		JButton btnNoFind = new JButton("Tìm");
		btnNoFind.addActionListener(ac);
		btnNoFind.setToolTipText("Ấn để tìm kiếm theo tên được nhập");
		btnNoFind.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNoFind.setBounds(825, 39, 128, 26);
		contentPane.add(btnNoFind);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(203, 94, 761, 2);
		contentPane.add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("Danh sách nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(13, 76, 200, 37);
		contentPane.add(lblNewLabel_1);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"CCCD", "Họ và tên", "Ngày sinh", "Quê quán", "Sđt","Giới Tính", "Chức vụ"}));
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

		JLabel lblNewLabel_2 = new JLabel("Thông tin thí sinh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(13, 404, 157, 25);
		contentPane.add(lblNewLabel_2);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(169, 421, 784, 2);
		contentPane.add(separator_2);

		JLabel lbID = new JLabel("CCCD");
		lbID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbID.setBounds(13, 439, 105, 25);
		contentPane.add(lbID);

		JLabel lbName = new JLabel("Họ và tên");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbName.setBounds(13, 474, 105, 25);
		contentPane.add(lbName);

		JLabel lbDate = new JLabel("Ngày sinh");
		lbDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbDate.setBounds(13, 509, 105, 25);
		contentPane.add(lbDate);

		JLabel lbBirthPlace = new JLabel("Quê quán");
		lbBirthPlace.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbBirthPlace.setBounds(13, 544, 105, 25);
		contentPane.add(lbBirthPlace);

		JLabel lbMon1 = new JLabel("Sđt");
		lbMon1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbMon1.setBounds(477, 433, 105, 25);
		contentPane.add(lbMon1);

		JLabel lbMon2 = new JLabel("Chức vụ");
		lbMon2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbMon2.setBounds(477, 474, 105, 25);
		contentPane.add(lbMon2);

		JLabel lbSex = new JLabel("Sex");
		lbSex.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbSex.setBounds(477, 509, 105, 25);
		contentPane.add(lbSex);

		textField_CCCD = new JTextField();
		textField_CCCD.setBounds(117, 439, 274, 25);
		contentPane.add(textField_CCCD);
		textField_CCCD.setColumns(10);

		textField_FullName = new JTextField();
		textField_FullName.setColumns(10);
		textField_FullName.setBounds(117, 474, 274, 25);
		contentPane.add(textField_FullName);

		comboBox_BirthPlace = new JComboBox();
		ArrayList<TinhModel> listCity = TinhModel.getDSTinh();
		comboBox_BirthPlace.addItem("");
		for (TinhModel tinh : listCity) {
			comboBox_BirthPlace.addItem(tinh.getTenTinh());
		}
		comboBox_BirthPlace.setBounds(117, 544, 274, 25);
		contentPane.add(comboBox_BirthPlace);

		textField_DateOfBirth = new JTextField();
		textField_DateOfBirth.setColumns(10);
		textField_DateOfBirth.setBounds(117, 509, 274, 25);
		contentPane.add(textField_DateOfBirth);

		textField_NumberPhone = new JTextField();
		textField_NumberPhone.setColumns(10);
		textField_NumberPhone.setBounds(623, 433, 274, 25);
		contentPane.add(textField_NumberPhone);

		textField_Role = new JTextField();
		textField_Role.setColumns(10);
		textField_Role.setBounds(623, 468, 274, 25);
		contentPane.add(textField_Role);

		JRadioNam = new JRadioButton("Nam");
		JRadioNam.setBounds(623, 509, 105, 24);
		contentPane.add(JRadioNam);

		JRadioNu = new JRadioButton("Nữ");
		JRadioNu.setBounds(730, 509, 105, 24);
		contentPane.add(JRadioNu);

		buttonGroup_gioiTinh = new ButtonGroup();
		buttonGroup_gioiTinh.add(JRadioNam);
		buttonGroup_gioiTinh.add(JRadioNu);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(13, 602, 940, 2);
		contentPane.add(separator_3);

		JButton btnInSert = new JButton("Thêm");
		btnInSert.addActionListener(ac);
		btnInSert.setToolTipText("Thêm");
		btnInSert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInSert.setBounds(13, 626, 175, 38);
		contentPane.add(btnInSert);

		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(ac);
		btnDelete.setToolTipText("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(198, 626, 175, 38);
		contentPane.add(btnDelete);

		JButton btnEdit = new JButton("Chỉnh sửa");
		btnEdit.addActionListener(ac);
		btnEdit.setToolTipText("Cập nhật");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEdit.setBounds(393, 626, 175, 38);
		contentPane.add(btnEdit);

		JButton btnSave = new JButton("Tài khoản");
		btnSave.addActionListener(ac);
		btnSave.setToolTipText("Lưu");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSave.setBounds(582, 626, 175, 38);
		contentPane.add(btnSave);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(ac);
		btnCancel.setToolTipText("Tắt");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(769, 626, 183, 38);
		contentPane.add(btnCancel);

		getDataTable();

		this.managerView.setContentPane(contentPane);
	}
	public void updateEmployeeSelected(){
		EmployeeModel employeeModel = getDataSelected();
		if (employeeModel!=null) {
			Optional<EmployeeModel> employeeModelFound = employeeRepository.findById(employeeModel.getCccd());

			if (employeeModelFound.isPresent()){
				EmployeeModel employeeModelUpdate = employeeModelFound.get();
				employeeModelUpdate.setCccd(textField_CCCD.getText());
				employeeModelUpdate.setFullName(textField_FullName.getText());
				try {
					employeeModelUpdate.setDateOfBirth(sdf.parse(textField_DateOfBirth.getText()));
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
				int intBirthPlace = comboBox_BirthPlace.getSelectedIndex();
				String birthPlace = TinhModel.getTinhById(intBirthPlace);
				employeeModelUpdate.setBirthPlace(birthPlace);
				employeeModelUpdate.setNumberPhone(textField_NumberPhone.getText());
				employeeModelUpdate.setRole(!textField_Role.getText().equals("Nhân viên"));
				employeeModelUpdate.setSex(JRadioNam.isSelected());

				updateRowTable(employeeModelUpdate);

				if (employeeModel.getCccd().equals(employeeModelUpdate.getCccd())){
					employeeRepository.save(employeeModelUpdate);
				}else {
					employeeRepository.delete(employeeModel);
					employeeRepository.save(employeeModelUpdate);
				}

				reset();
			}
		}
	}
	private void updateRowTable(EmployeeModel employeeModelUpdate){
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		if (table.getSelectedRowCount() == 1){
			int i_row = table.getSelectedRow();
			dftm.setValueAt(employeeModelUpdate.getCccd(), i_row, 0);
			dftm.setValueAt(employeeModelUpdate.getFullName(), i_row, 1);
			dftm.setValueAt(sdf.format(employeeModelUpdate.getDateOfBirth()), i_row, 2);
			dftm.setValueAt(employeeModelUpdate.getBirthPlace(), i_row, 3);
			dftm.setValueAt(employeeModelUpdate.getNumberPhone(), i_row, 4);
			dftm.setValueAt(employeeModelUpdate.isSex() ? "Nam" : "Nữ", i_row, 5);
			dftm.setValueAt(!employeeModelUpdate.isRole() ? "Nhân viên" : "Quản lý", i_row, 6);

			JOptionPane.showMessageDialog(managerView, "Update Successfully");
		}else {
			if (table.getRowCount() == 0){
				JOptionPane.showMessageDialog(managerView, "Danh sách rỗng");
			}
		}
	}
	public void deleteEmployeeSelected()  {
		EmployeeModel employeeModel = getDataSelected();

		if (employeeModel != null) {
			int luaChon = JOptionPane.showConfirmDialog(
					managerView,
					"Bạn muốn xóa nhân viên " + employeeModel.getFullName() + "(" + employeeModel.getCccd() + ")",
					"Delete",
					JOptionPane.YES_NO_OPTION
			);

			if (luaChon == JOptionPane.YES_OPTION) {
				employeeRepository.delete(employeeModel);
				DefaultTableModel dftm = (DefaultTableModel) table.getModel();
				int i_row = table.getSelectedRow();
				dftm.removeRow(i_row);
				reset();
			}
		} else {
			JOptionPane.showMessageDialog(managerView, "Bạn chưa chọn nhân viên", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void setDataSelectedToTF()  {
		EmployeeModel employeeModel = getDataSelected();
		if (employeeModel!=null){
			textField_CCCD.setText(employeeModel.getCccd());
			textField_FullName.setText(employeeModel.getFullName());
			textField_DateOfBirth.setText(sdf.format(employeeModel.getDateOfBirth()));
			TinhModel tinhModel = TinhModel.getTinhByTen(employeeModel.getBirthPlace());
			comboBox_BirthPlace.setSelectedItem(tinhModel.getTenTinh());
			textField_NumberPhone.setText(employeeModel.getNumberPhone());
			textField_Role.setText(!employeeModel.isRole()? "Nhân viên":"Quản lý");
			if (employeeModel.isSex()){
				JRadioNam.setSelected(true);
			}else {
				JRadioNu.setSelected(true);
			}
		}
	}
	private EmployeeModel getDataSelected()  {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		int index_row = table.getSelectedRow();
		if (index_row>=0) {
			EmployeeModel employeeModel = new EmployeeModel();
			employeeModel.setCccd(dftm.getValueAt(index_row, 0).toString());
			employeeModel.setFullName(dftm.getValueAt(index_row, 1).toString());
			try {
				employeeModel.setDateOfBirth(sdf.parse(dftm.getValueAt(index_row, 2).toString()));
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
			employeeModel.setBirthPlace(dftm.getValueAt(index_row, 3).toString());
			employeeModel.setNumberPhone(dftm.getValueAt(index_row, 4).toString());
			employeeModel.setSex(dftm.getValueAt(index_row, 5).toString().equals("Nam"));
			employeeModel.setRole(!dftm.getValueAt(index_row, 6).toString().equals("Nhân viên"));
			return employeeModel;
		}else {
			return null;
		}
	}

	public void insertData(EmployeeModel employeeModel){
		Optional<EmployeeModel> employeeModelFound = employeeRepository.findById(employeeModel.getCccd());

		if (!employeeModelFound.isPresent()) {
			System.out.println(employeeModel.getBirthPlace());
			employeeRepository.save(employeeModel);
			addDataTable(employeeModel);
			reset();
		}else {
			JOptionPane.showMessageDialog(managerView, "Trùng số căn cước công dân", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void getDataTable(){
		List<EmployeeModel> employeeModelFound = employeeRepository.findAll();

		if (!employeeModelFound.isEmpty()){
			for (EmployeeModel employeeModel :
					employeeModelFound) {
				addDataTable(employeeModel);
			}
		}
	}
	public  void addDataTable(EmployeeModel employeeModel) {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();

		dftm.addRow(new Object[]{
				employeeModel.getCccd(),
				employeeModel.getFullName(),
				sdf.format(employeeModel.getDateOfBirth()),
				employeeModel.getBirthPlace(),
				employeeModel.getNumberPhone(),
				employeeModel.isSex() ? "Nam" : "Nữ",
				employeeModel.isRole() ? "Quản lý" : "Nhân viên"
		});
	}
	public void reset(){
		textField_CCCD.setText("");
		textField_FullName.setText("");
		textField_DateOfBirth.setText("");
		comboBox_BirthPlace.setSelectedIndex(-1);
		textField_NumberPhone.setText("");
		textField_Role.setText("");
		buttonGroup_gioiTinh.clearSelection();
	}
	public void showPanel(){
		contentPane.setVisible(true);
	}
	public void closePanel(){
		contentPane.setVisible(false);
	}
}
