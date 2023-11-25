package org.example.CnJava_Project.GUI;

import org.example.CnJava_Project.GUI.panel.manager.QLMAPanel;
import org.example.CnJava_Project.GUI.panel.manager.QLNVPanel;
import org.example.CnJava_Project.controller.ManagerController;
import org.example.CnJava_Project.respository.AccountRepository;
import org.example.CnJava_Project.respository.DishRepository;
import org.example.CnJava_Project.respository.EmployeeRepository;
import org.example.CnJava_Project.respository.InfoShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.swing.*;
import java.awt.event.ActionListener;
public class ManagerView extends JFrame {
	public JFrame loginView;
	public QLNVPanel qlnvPanel;
	public QLMAPanel qlmaPanel;
	public EmployeeRepository employeeRepository;
	public DishRepository dishRepository;
	public ActionListener ac;
	public AccountRepository accountRepository;
	public InfoShopRepository infoShopRepository;
	public ManagerView(
			EmployeeRepository employeeRepository,
			DishRepository dishRepository,
			AccountRepository accountRepository,
			InfoShopRepository infoShopRepository,
			LoginView loginView
	){
		this.employeeRepository = employeeRepository;
		this.dishRepository = dishRepository;
		this.accountRepository = accountRepository;
		this.infoShopRepository = infoShopRepository;
		this.loginView = loginView;
		setTitle("Quản lý");
		setBounds(100, 100, 980, 740);
		setLocationRelativeTo(null);
		ac = new ManagerController(this);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mnQuanLy = new JMenu("Quản lý");
		menuBar.add(mnQuanLy);

		JMenuItem mnQLNhanVien = new JMenuItem("Quản Lý Nhân Viên");
		mnQLNhanVien.addActionListener(ac);
		mnQuanLy.add(mnQLNhanVien);

		JMenuItem mnQLMonAn = new JMenuItem("Quản Lý Món Ăn");
		mnQLMonAn.addActionListener(ac);
		mnQuanLy.add(mnQLMonAn);

		JSeparator separator = new JSeparator();
		mnQuanLy.add(separator);

		JMenuItem mnThongTin = new JMenuItem("Thông tin quán");
		mnThongTin.addActionListener(ac);
		mnQuanLy.add(mnThongTin);

		JMenuItem mnQLDoanhThu = new JMenuItem("Doanh Thu");
		mnQLDoanhThu.addActionListener(ac);
		mnQuanLy.add(mnQLDoanhThu);

		JSeparator separator1 = new JSeparator();
		mnQuanLy.add(separator1);

		JMenuItem mnExit = new JMenuItem("Đăng xuất");
		mnExit.addActionListener(ac);
		mnQuanLy.add(mnExit);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

	public void showQLNV() {
		qlnvPanel = new QLNVPanel(this,employeeRepository, accountRepository);

		qlnvPanel.showPanel();
		if (qlmaPanel!=null)
			qlmaPanel.closePanel();
	}
	public void showQLMA() {
		qlmaPanel = new QLMAPanel(this,dishRepository);

		qlmaPanel.showPanel();
		if (qlnvPanel!=null)
			qlnvPanel.closePanel();
	}
}
