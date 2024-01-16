package org.example.CnJava_Project.view.manager.frame;

import org.example.CnJava_Project.constants.AssetsConstants;
import org.example.CnJava_Project.view.manager.panel.QLMAPanel;
import org.example.CnJava_Project.view.manager.panel.QLNVPanel;
import org.example.CnJava_Project.controller.manager.ManagerController;
import org.example.CnJava_Project.respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionListener;
@Component
public class ManagerView extends JFrame {
	@Autowired
	public EmployeeRepository employeeRepositoryManager;
	@Autowired
	public DishRepository dishRepositoryManager;
	@Autowired
	public InfoShopRepository infoShopRepositoryManager;
	@Autowired
	public AccountRepository accountRepositoryManager;
	@Autowired
	public DishGroupRepository dishGroupRepositoryManager;
	@Autowired
	public TableDataRepository tableDataRepositoryManager;
	@Autowired
	public BillRepository billRepositoryManager;
	@Autowired
	public ConfigurableApplicationContext context;
	public QLNVPanel qlnvPanel;
	public QLMAPanel qlmaPanel;
	public ManagerView(){
		this.setTitle("Quản lý");
		this.setBounds(100, 100, 980, 740);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		ActionListener ac = new ManagerController(this);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu menuFunc = new JMenu("Chức năng");
		menuBar.add(menuFunc);

		JMenu menuManageEmployee = new JMenu("Quản Lý Nhân Viên");
		menuFunc.add(menuManageEmployee);

		JMenuItem menuInformation = new JMenuItem("Thông tin cá nhân");
		menuInformation.addActionListener(ac);
		menuManageEmployee.add(menuInformation);
		JMenuItem menuAccount = new JMenuItem("Tài khoản");
		menuAccount.addActionListener(ac);
		menuManageEmployee.add(menuAccount);

		JMenu menuManageDish = new JMenu("Quản lý món ăn");
		menuFunc.add(menuManageDish);

		JMenuItem menuDishGroup = new JMenuItem("Nhóm món");
		menuDishGroup.addActionListener(ac);
		menuManageDish.add(menuDishGroup);
		JMenuItem menuDishMenu = new JMenuItem("Thực đơn");
		menuDishMenu.addActionListener(ac);
		menuManageDish.add(menuDishMenu);

		JSeparator separator = new JSeparator();
		menuFunc.add(separator);

		JMenuItem menuInformationShop = new JMenuItem("Thông tin quán");
		menuInformationShop.addActionListener(ac);
		menuFunc.add(menuInformationShop);

		JMenuItem menuRevenue = new JMenuItem("Doanh Thu");
		menuRevenue.addActionListener(ac);
		menuFunc.add(menuRevenue);

		JSeparator separator1 = new JSeparator();
		menuFunc.add(separator1);

		JMenuItem menuChangePassword = new JMenuItem("Đổi mật khẩu");
		menuChangePassword.addActionListener(ac);
		menuFunc.add(menuChangePassword);

		JSeparator separator2 = new JSeparator();
		menuFunc.add(separator2);

		JMenuItem menuSignOut = new JMenuItem("Đăng xuất");
		menuSignOut.addActionListener(ac);
		menuFunc.add(menuSignOut);


//		JLabel lbImage = new JLabel();
//		lbImage.setIcon(new ImageIcon(getClass().getResource(AssetsConstants.imageLogin)));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

	public void showQLNV() {
		qlnvPanel = new QLNVPanel(this,employeeRepositoryManager);

		qlnvPanel.showPanel();
		if (qlmaPanel!=null)
			qlmaPanel.closePanel();
	}
	public void showQLMA() {
		qlmaPanel = new QLMAPanel(this,dishRepositoryManager, dishGroupRepositoryManager);

		qlmaPanel.showPanel();
		if (qlnvPanel!=null)
			qlnvPanel.closePanel();
	}
}
