package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.EmployeeView;
import org.example.CnJava_Project.GUI.LoginView;

import org.example.CnJava_Project.GUI.ManagerView;
import org.example.CnJava_Project.config.AES256;
import org.example.CnJava_Project.model.AccountModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class LoginController implements ActionListener {
	private LoginView view;
	public LoginController(LoginView view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String secretKey = "MySecretKey";
		String salt = "MySalt";

		String username = view.textFieldUsername.getText();
		String password = view.passwordField.getText();

		Optional<AccountModel> accountFound = view.accountRepository.findById(username);
		if (!accountFound.isPresent()){
			view.lbError.setText("Login Faild");
		}else {
			String passwordDecrypt = AES256.decrypt(accountFound.get().getPassword(), secretKey, salt);
			if (password.equals(passwordDecrypt)){
				if (accountFound.get().isRole()){
					ManagerView managerView = new ManagerView(
							view.employeeRepository,
							view.dishRepository,
							view.accountRepository,
							view.infoShopRepository,
							view
					);
//					ManagerView managerView = view.context.getBean(ManagerView.class);
					managerView.setVisible(true);
					System.out.println("Login Successfully Quản lý");
				}else {
					EmployeeView employeeView = new EmployeeView(view.infoShopRepository);
					employeeView.setVisible(true);
					System.out.println("Login Successfully Nhân viên");
				}
				view.setVisible(false);
			}else {
				view.lbError.setText("Login Faild");
			}
		}
	}
}
