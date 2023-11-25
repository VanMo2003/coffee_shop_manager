package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.InfoShopView;
import org.example.CnJava_Project.GUI.LoginView;
import org.example.CnJava_Project.GUI.ManagerView;
import java.awt.event.*;

public class ManagerController implements ActionListener {
	private ManagerView view;
	public ManagerController(ManagerView view){
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();

		if (eventString.equals("Quản Lý Nhân Viên")){
			view.showQLNV();
		}else if (eventString.equals("Quản Lý Món Ăn")){
			view.showQLMA();
		}else if (eventString.equals("Doanh Thu")){
			System.out.println(eventString);
		}else if (eventString.equals("Thông tin quán")){
			InfoShopView infoShopView = new InfoShopView(view.infoShopRepository);
			infoShopView.setVisible(true);
		}else if (eventString.equals("Đăng xuất")){
//			view.setVisible(false);
//			LoginView loginView = new LoginView();
//			loginView.setVisible(true);
		}

	}


}
