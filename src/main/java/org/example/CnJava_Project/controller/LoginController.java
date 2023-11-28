package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.EmployeeView;
import org.example.CnJava_Project.GUI.LoginView;

import org.example.CnJava_Project.GUI.ManagerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
	private LoginView view;
	public LoginController(LoginView view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		String secretKey = "MySecretKey";
//		String salt = "MySalt";
//
//		String username = view.textFieldUsername.getText();
//		String password = view.passwordField.getText();
//
//		Optional<AccountModel> accountFound = view.accountRepository.findById(username);
//		if (!accountFound.isPresent()){
//			view.lbError.setText("Login Faild");
//		}else {
//			String passwordDecrypt = AES256.decrypt(accountFound.get().getPassword(), secretKey, salt);
//			if (password.equals(passwordDecrypt)){
//				if (accountFound.get().isRole()){
//					ManagerView managerView = view.context.getBean(ManagerView.class);
//					managerView.setVisible(true);
//					if (managerView.qlmaPanel != null || managerView.qlnvPanel != null) {
//						managerView.qlnvPanel.closePanel();
//						managerView.qlmaPanel.closePanel();
//					}
//					System.out.println("Login Successfully Quản lý");
//				}
//				else {
//					EmployeeView employeeView = new EmployeeView(view.context.getBean(ManagerView.class).infoShopRepository);
//					employeeView.setVisible(true);
//					System.out.println("Login Successfully Nhân viên");
//				}
//				view.setVisible(false);
//			}else {
//				view.lbError.setText("Login Faild");
//			}
//		}
		EmployeeView employeeView = new EmployeeView(view.context.getBean(ManagerView.class).infoShopRepository);
		employeeView.setVisible(true);
		view.setVisible(false);
	}
}
