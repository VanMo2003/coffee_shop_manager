package org.example.CnJava_Project.GUI;

import org.example.CnJava_Project.GUI.panel.manager.QLMAPanel;
import org.example.CnJava_Project.GUI.panel.manager.QLNVPanel;
import org.example.CnJava_Project.controller.ManagerController;
import org.example.CnJava_Project.respository.AccountRepository;
import org.example.CnJava_Project.respository.DishRepository;
import org.example.CnJava_Project.respository.EmployeeRepository;
import org.example.CnJava_Project.respository.InfoShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionListener;
@Component
public class ManagerView extends JFrame {
	public QLNVPanel qlnvPanel;
	public QLMAPanel qlmaPanel;
	@Autowired
	public EmployeeRepository employeeRepository;
	@Autowired
	public DishRepository dishRepository;
	@Autowired
	public InfoShopRepository infoShopRepository;
	@Autowired
	public AccountRepository accountRepository;
	public ActionListener ac;
	@Autowired
	public ConfigurableApplicationContext context;
	public ManagerView(){
		setTitle("Quản lý");
		setBounds(100, 100, 980, 740);
		setLocationRelativeTo(null);
		ac = new ManagerController(this);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mnQuanLy = new JMenu("Chức năng");
		menuBar.add(mnQuanLy);

		JMenu mnQLNhanVien = new JMenu("Quản Lý Nhân Viên");
		mnQuanLy.add(mnQLNhanVien);

		JMenuItem mnThongTin = new JMenuItem("Thông tin");
		mnThongTin.addActionListener(ac);
		mnQLNhanVien.add(mnThongTin);
		JMenuItem mnTaiKhoan = new JMenuItem("Tài khoản");
		mnTaiKhoan.addActionListener(ac);
		mnQLNhanVien.add(mnTaiKhoan);

		JMenu mnQLMonAn = new JMenu("Quản lý món ăn");
		mnQuanLy.add(mnQLMonAn);

		JMenuItem mnNhomMon = new JMenuItem("Nhóm món");
		mnNhomMon.addActionListener(ac);
		mnQLMonAn.add(mnNhomMon);
		JMenuItem mnThucDon = new JMenuItem("Thực đơn");
		mnThucDon.addActionListener(ac);
		mnQLMonAn.add(mnThucDon);

		JSeparator separator = new JSeparator();
		mnQuanLy.add(separator);

		JMenuItem mnThongTinQuan = new JMenuItem("Thông tin quán");
		mnThongTinQuan.addActionListener(ac);
		mnQuanLy.add(mnThongTinQuan);

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
		qlnvPanel = new QLNVPanel(this,employeeRepository);

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
