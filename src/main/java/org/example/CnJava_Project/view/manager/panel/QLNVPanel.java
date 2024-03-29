package org.example.CnJava_Project.view.manager.panel;

import org.example.CnJava_Project.view.manager.frame.ManagerView;
import org.example.CnJava_Project.controller.manager.QLNVController;
import org.example.CnJava_Project.model.TinhModel;
import org.example.CnJava_Project.model.EmployeeModel;
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
	private JTextField textFieldSearch;
	private  JTable table;
	private  JTextField textFieldCCCD;
	private  JTextField textFieldFullName;
	private  JTextField textFieldDateOfBirth;
	private  JTextField textFieldNumberPhone;
	private  JComboBox comboBoxRole;
	private  JComboBox comboBoxBirthPlace;
	private  JRadioButton radioButtonMale;
	private  JRadioButton radioButtonFeMale;
	private  ButtonGroup buttonGroupSex;
	private EmployeeRepository employeeRepository;
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

		textFieldSearch = new JTextField();
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(210, 39, 600, 25);
		contentPane.add(textFieldSearch);

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
				getDataSelected();
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

		textFieldCCCD = new JTextField();
		textFieldCCCD.setBounds(117, 439, 274, 25);
		contentPane.add(textFieldCCCD);
		textFieldCCCD.setColumns(10);

		textFieldFullName = new JTextField();
		textFieldFullName.setColumns(10);
		textFieldFullName.setBounds(117, 474, 274, 25);
		contentPane.add(textFieldFullName);

		textFieldDateOfBirth = new JTextField();
		textFieldDateOfBirth.setColumns(10);
		textFieldDateOfBirth.setBounds(117, 509, 274, 25);
		contentPane.add(textFieldDateOfBirth);

		comboBoxBirthPlace = new JComboBox();
		ArrayList<TinhModel> listCity = TinhModel.getDSTinh();
		for (TinhModel tinh : listCity) {
			comboBoxBirthPlace.addItem(tinh.getTenTinh());
		}
		comboBoxBirthPlace.setBounds(117, 544, 274, 25);
		contentPane.add(comboBoxBirthPlace);

		textFieldNumberPhone = new JTextField();
		textFieldNumberPhone.setColumns(10);
		textFieldNumberPhone.setBounds(623, 433, 274, 25);
		contentPane.add(textFieldNumberPhone);

		comboBoxRole = new JComboBox();
		comboBoxRole.addItem("Nhân viên");
		comboBoxRole.addItem("Quản lý");
		comboBoxRole.setBounds(623, 468, 274, 25);
		contentPane.add(comboBoxRole);

		radioButtonMale = new JRadioButton("Nam");
		radioButtonMale.setBounds(623, 509, 105, 24);
		contentPane.add(radioButtonMale);

		radioButtonFeMale = new JRadioButton("Nữ");
		radioButtonFeMale.setBounds(730, 509, 105, 24);
		contentPane.add(radioButtonFeMale);

		buttonGroupSex = new ButtonGroup();
		buttonGroupSex.add(radioButtonMale);
		buttonGroupSex.add(radioButtonFeMale);

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

		JButton btnCancel = new JButton("Đặt lại");
		btnCancel.addActionListener(ac);
		btnCancel.setToolTipText("Tắt");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(769, 626, 183, 38);
		contentPane.add(btnCancel);

		getDataTable();

		this.managerView.setContentPane(contentPane);
	}
	public void updateEmployeeSelected(){
		EmployeeModel employeeModelUpdate = textFieldToObject();
		if (employeeModelUpdate!=null) {
			DefaultTableModel dftm = (DefaultTableModel) table.getModel();
			int i_row = table.getSelectedRow();
			String cccdOld = dftm.getValueAt(i_row, 0).toString();
			Optional<EmployeeModel> employeeModelFound = employeeRepository.findById(cccdOld);

			if (employeeModelFound.isPresent()){
				updateRowTable(employeeModelUpdate, dftm);

				if (cccdOld.equals(employeeModelUpdate.getCccd())){
					employeeRepository.save(employeeModelUpdate);
				}else {
					employeeRepository.deleteById(cccdOld);
					employeeRepository.save(employeeModelUpdate);
				}

				reset();
			}
		}
	}
	private void updateRowTable(EmployeeModel employeeModelUpdate, DefaultTableModel dftm){
			int i_row = table.getSelectedRow();
			dftm.setValueAt(employeeModelUpdate.getCccd(), i_row, 0);
			dftm.setValueAt(employeeModelUpdate.getFullName(), i_row, 1);
			dftm.setValueAt(sdf.format(employeeModelUpdate.getDateOfBirth()), i_row, 2);
			dftm.setValueAt(employeeModelUpdate.getBirthPlace(), i_row, 3);
			dftm.setValueAt(employeeModelUpdate.getNumberPhone(), i_row, 4);
			dftm.setValueAt(employeeModelUpdate.isSex() ? "Nam" : "Nữ", i_row, 5);
			dftm.setValueAt(!employeeModelUpdate.isRole() ? "Nhân viên" : "Quản lý", i_row, 6);

			JOptionPane.showMessageDialog(managerView, "Update Successfully");
	}
	public void deleteEmployeeSelected()  {
		EmployeeModel employeeModel = textFieldToObject();

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
		}
	}
	private void getDataSelected()  {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		int index_row = table.getSelectedRow();
		if (index_row>=0) {
			textFieldCCCD.setText(dftm.getValueAt(index_row, 0).toString());
			textFieldFullName.setText(dftm.getValueAt(index_row, 1).toString());
			textFieldDateOfBirth.setText(dftm.getValueAt(index_row, 2).toString());
			comboBoxBirthPlace.setSelectedItem(dftm.getValueAt(index_row, 3).toString());
			textFieldNumberPhone.setText(dftm.getValueAt(index_row, 4).toString());
			if (dftm.getValueAt(index_row, 5).toString().equals("Nam")){
				radioButtonMale.setSelected(true);
			}else {
				radioButtonFeMale.setSelected(true);
			}
			comboBoxRole.setSelectedItem((dftm.getValueAt(index_row, 6).toString()));
		}
	}

	public void insertData(){
		EmployeeModel employeeModel = textFieldToObject();
		if (employeeModel!=null) {
			Optional<EmployeeModel> employeeModelFound = employeeRepository.findById(employeeModel.getCccd());

			if (!employeeModelFound.isPresent()) {
				employeeRepository.save(employeeModel);
				addDataTable(employeeModel);
				reset();
			} else {
				JOptionPane.showMessageDialog(managerView, "Trùng số căn cước công dân", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private EmployeeModel textFieldToObject(){
		String cccd = textFieldCCCD.getText();
		String fullName = textFieldFullName.getText();
		String dateOfBirth = textFieldDateOfBirth.getText();
		String birthPlace = comboBoxBirthPlace.getSelectedItem().toString();
		String numberPhone = textFieldNumberPhone.getText();
		String role = comboBoxRole.getSelectedItem().toString();

		if (!cccd.equals("") && !fullName.equals("") && !birthPlace.equals("") && !numberPhone.equals("")
			&& !role.equals("") && (radioButtonMale.isSelected() || radioButtonFeMale.isSelected())
		){
			EmployeeModel employeeModel = new EmployeeModel();
			employeeModel.setCccd(cccd);
			employeeModel.setFullName(fullName);
			try {
				employeeModel.setDateOfBirth(sdf.parse(dateOfBirth));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(managerView, "Nhập ngày sinh theo form dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
			employeeModel.setBirthPlace(birthPlace);
			employeeModel.setNumberPhone(numberPhone);
			employeeModel.setRole(!role.equals("Nhân viên"));
			employeeModel.setSex(radioButtonMale.isSelected());
			return employeeModel;
		}else {
			JOptionPane.showMessageDialog(managerView, "Mời bạn nhập đầy đủ thông tin", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
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
	public void addDataTable(EmployeeModel employeeModel) {
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
		textFieldCCCD.setText("");
		textFieldFullName.setText("");
		textFieldDateOfBirth.setText("");
		comboBoxBirthPlace.setSelectedIndex(0);
		textFieldNumberPhone.setText("");
		comboBoxRole.setSelectedIndex(0);
		buttonGroupSex.clearSelection();
	}
	public void showPanel(){
		contentPane.setVisible(true);
	}
	public void closePanel(){
		contentPane.setVisible(false);
	}
}
