package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.*;

import java.awt.event.*;

public class ManagerController implements ActionListener {
	private ManagerView view;
	public ManagerController(ManagerView view){
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();

		if (eventString.equals("Thông tin")){
			view.showQLNV();
		} else if (eventString.equals("Tài khoản")) {
			AccountEmployeeView accountEmployeeView = new AccountEmployeeView(view.employeeRepository, view.accountRepository);
			accountEmployeeView.setVisible(true);
		}else if (eventString.equals("Nhóm món")) {
			DishGroupView dishGroupView = new DishGroupView(view.dishGroupRepository);
			dishGroupView.setVisible(true);
		}
		else if (eventString.equals("Thực đơn")){
			view.showQLMA();
		}else if (eventString.equals("Doanh Thu")){
			System.out.println(eventString);
		}else if (eventString.equals("Thông tin quán")){
			InfoShopView infoShopView = new InfoShopView(view.infoShopRepository, view.tableDataRepository);
			infoShopView.setVisible(true);
		}else if (eventString.equals("Đăng xuất")){
			view.setVisible(false);
			LoginView loginView = view.context.getBean(LoginView.class);
			loginView.textFieldUsername.setText("");
			loginView.passwordField.setText("");
			loginView.setVisible(true);
		}

	}


}
