package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.AES256;
import org.example.CnJava_Project.model.AccountModel;
import org.example.CnJava_Project.view.employee.frame.EmployeeView;
import org.example.CnJava_Project.view.LoginView;
import org.example.CnJava_Project.view.manager.frame.ManagerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class LoginController implements ActionListener {
	private LoginView loginView;
	public LoginController(LoginView loginView){
		this.loginView = loginView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String secretKey = "MySecretKey";
		String salt = "MySalt";

		String username = loginView.textFieldUsername.getText();
		String password = loginView.passwordField.getText();

		Optional<AccountModel> accountFound = loginView.accountRepository.findById(username);
		if (!accountFound.isPresent()){
			loginView.labelError.setText("Login Faild");
		}else {
			String passwordDecrypt = AES256.decrypt(accountFound.get().getPassword(), secretKey, salt);
			if (password.equals(passwordDecrypt)){
				if (accountFound.get().isRole()){
					ManagerView managerView = loginView.context.getBean(ManagerView.class);
					managerView.setVisible(true);
					if (managerView.qlmaPanel != null || managerView.qlnvPanel != null) {
						managerView.qlnvPanel.closePanel();
						managerView.qlmaPanel.closePanel();
					}
					System.out.println("Login Successfully Quản lý");
				}
				else {
					EmployeeView employeeView = loginView.context.getBean(EmployeeView.class);
					employeeView.setVisible(true);
					System.out.println("Login Successfully Nhân viên");
				}
				loginView.setVisible(false);
			}else {
				loginView.labelError.setText("Login Faild");
			}
		}
	}
}
