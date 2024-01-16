package org.example.CnJava_Project.controller.manager;

import org.example.CnJava_Project.view.LoginView;
import org.example.CnJava_Project.view.manager.frame.AccountEmployeeView;
import org.example.CnJava_Project.view.manager.frame.DishGroupView;
import org.example.CnJava_Project.view.manager.frame.InfoShopView;
import org.example.CnJava_Project.view.manager.frame.ManagerView;

import java.awt.event.*;

public class ManagerController implements ActionListener {
	private ManagerView managerView;
	public ManagerController(ManagerView managerView){
		this.managerView = managerView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();

		if (eventString.equals("Thông tin cá nhân")){
			managerView.showQLNV();
		} else if (eventString.equals("Tài khoản")) {
			AccountEmployeeView accountEmployeeView = new AccountEmployeeView(
					managerView.employeeRepositoryManager,
					managerView.accountRepositoryManager
			);
			accountEmployeeView.setVisible(true);
		} else if (eventString.equals("Nhóm món")) {
			DishGroupView dishGroupView = new DishGroupView(
					managerView.dishGroupRepositoryManager
			);
			dishGroupView.setVisible(true);
		} else if (eventString.equals("Thực đơn")){
			managerView.showQLMA();
		} else if (eventString.equals("Doanh Thu")){
			System.out.println(eventString);
		} else if (eventString.equals("Thông tin quán")){
			InfoShopView infoShopView = new InfoShopView(
					managerView.infoShopRepositoryManager,
					managerView.tableDataRepositoryManager
			);
			infoShopView.setVisible(true);
		} else if (eventString.equals("Đăng xuất")){
			managerView.setVisible(false);
			LoginView loginView = managerView.context.getBean(LoginView.class);
			loginView.textFieldUsername.setText("");
			loginView.passwordField.setText("");
			loginView.setVisible(true);
		}

	}


}
