package org.example.CnJava_Project.controller.manager;

import org.example.CnJava_Project.view.manager.frame.AccountEmployeeView;
import org.example.CnJava_Project.AES256;
import org.example.CnJava_Project.model.AccountModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountEmployeeController implements ActionListener {
	AccountEmployeeView accountEmployeeView;
	public AccountEmployeeController(AccountEmployeeView accountEmployeeView){
		this.accountEmployeeView = accountEmployeeView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Oke")) {
			String username = accountEmployeeView.textFieldUsername.getText();
			String password = accountEmployeeView.passwordField.getText();

			if (accountEmployeeView.comboBoxCCCD.getSelectedItem().toString().equals("cccd")) {
				JOptionPane.showMessageDialog(accountEmployeeView, "Mời bạn chọn cccd của nhân viên");
			} else {
				if (!username.isEmpty() && !password.isEmpty()) {
					String secretKey = "MySecretKey";
					String salt = "MySalt";
					String passwordEncrypt = AES256.encrypt(password, secretKey, salt);

					accountEmployeeView.employeeModel.setUsername(username);
					accountEmployeeView.employeeModel.setPassword(passwordEncrypt);
					accountEmployeeView.employeeRepository.save(accountEmployeeView.employeeModel);

					AccountModel accountModel = new AccountModel();
					accountModel.setUsername(username);
					accountModel.setPassword(passwordEncrypt);
					accountModel.setRole(false);
					accountEmployeeView.accountRepository.save(accountModel);

					accountEmployeeView.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(accountEmployeeView, "Mời bạn nhập tài khoản, mật khẩu");
				}
			}
		}else if (eventString.equals("Cancel")) {
			accountEmployeeView.setVisible(false);
		}
	}
}
