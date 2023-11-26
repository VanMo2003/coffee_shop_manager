package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.AccountEmployeeView;
import org.example.CnJava_Project.GUI.panel.manager.QLNVPanel;
import org.example.CnJava_Project.model.EmployeeModel;
import org.example.CnJava_Project.model.TinhModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QLNVController implements ActionListener {
	QLNVPanel view;
	public QLNVController(QLNVPanel view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Thêm")) {
			addNV();
		}else if (eventString.equals("Xóa")) {
			view.deleteEmployeeSelected();
		}else if (eventString.equals("Chỉnh sửa")) {
			view.updateEmployeeSelected();
		}else if (eventString.equals("Hủy")) {
			view.reset();
		}
	}

	private void addNV() {
		String cccd = view.textField_CCCD.getText();
		String fullName = view.textField_FullName.getText();
		String dateOfBirthString = view.textField_DateOfBirth.getText();
		int intBirthPlace = view.comboBox_BirthPlace.getSelectedIndex();
		System.out.println(intBirthPlace);
		String birthPlace = TinhModel.getTinhById(intBirthPlace);
		System.out.println(birthPlace);
		String numberPhone = view.textField_NumberPhone.getText();
		String role = view.textField_Role.getText();
		boolean gioiTinh = true;
		if (view.JRadioNam.isSelected()) {
			gioiTinh = true;
		} else if (view.JRadioNu.isSelected()) {
			gioiTinh = false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfBirth;
		try {
			dateOfBirth = sdf.parse(dateOfBirthString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setCccd(cccd);
		employeeModel.setFullName(fullName);
		employeeModel.setDateOfBirth(dateOfBirth);
		employeeModel.setBirthPlace(birthPlace);
		employeeModel.setNumberPhone(numberPhone);
		employeeModel.setRole(role.equals("Nhân viên") ? false : true);
		employeeModel.setSex(gioiTinh);

		view.insertData(employeeModel);
	}
}
