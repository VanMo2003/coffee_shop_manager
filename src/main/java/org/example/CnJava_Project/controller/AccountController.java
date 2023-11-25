package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.AccountEmployeeView;
import org.example.CnJava_Project.config.AES256;
import org.example.CnJava_Project.model.AccountModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountController implements ActionListener {
	AccountEmployeeView view;
	public AccountController(AccountEmployeeView view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Oke")) {
			String username = view.textField_Username.getText();
			String password = view.textField_Password.getText();

			if (view.comboBox_CCCD.getSelectedItem().toString().equals("cccd")) {
				JOptionPane.showMessageDialog(view, "Mời bạn chọn cccd của nhân viên");
			} else {
				if (!username.isEmpty() && !password.isEmpty()) {
					String secretKey = "MySecretKey";
					String salt = "MySalt";
					String passwordEncrypt = AES256.encrypt(password, secretKey, salt);

					view.employeeModel.setUsername(username);
					view.employeeModel.setPassword(passwordEncrypt);
					view.employeeRepository.save(view.employeeModel);

					AccountModel accountModel = new AccountModel();
					accountModel.setUsername(username);
					accountModel.setPassword(passwordEncrypt);
					accountModel.setRole(false);
					view.accountRepository.save(accountModel);

					view.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(view, "Mời bạn nhập tài khoản, mật khẩu");
				}
			}
		}else if (eventString.equals("Cancel")) {
			view.setVisible(false);
		}
	}
}
