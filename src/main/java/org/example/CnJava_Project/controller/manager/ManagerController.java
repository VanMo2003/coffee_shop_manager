package org.example.CnJava_Project.controller.manager;

import org.example.CnJava_Project.model.AccountModel;
import org.example.CnJava_Project.view.LoginView;
import org.example.CnJava_Project.view.manager.frame.*;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.event.*;

import static org.example.CnJava_Project.view.manager.frame.RevenueView.createChart;


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
			ChartPanel chartPanel = new ChartPanel(createChart(managerView.billRepositoryManager));
			chartPanel.setPreferredSize(new java.awt.Dimension(940, 400));
			JFrame frame = new JFrame();
			frame.add(chartPanel);
			frame.setTitle("Doanh thu");
			frame.setSize(600, 400);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setVisible(true);
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
		}else if (eventString.equals("Đổi mật khẩu")){
			JFrame frame = new ChangePasswordView(managerView.accountRepositoryManager);
			frame.setVisible(true);
		}

	}


}
