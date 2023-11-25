package org.example.CnJava_Project.GUI;

import org.example.CnJava_Project.GUI.panel.employee.MenuPanel;
import org.example.CnJava_Project.GUI.panel.employee.OrderPanel;
import org.example.CnJava_Project.GUI.panel.employee.TablePanel;
import org.example.CnJava_Project.constants.SizeEmployeeConstants;
import org.example.CnJava_Project.model.InfoShopModel;
import org.example.CnJava_Project.respository.InfoShopRepository;

import javax.swing.*;

public class EmployeeView extends JFrame {
	public InfoShopRepository infoShopRepository;
	public InfoShopModel infoShopModel = new InfoShopModel();
	private int height = SizeEmployeeConstants.height;
	private int width = SizeEmployeeConstants.width;
	private OrderPanel orderPanel;
	private MenuPanel menuPanel;

	public EmployeeView(InfoShopRepository infoShopRepository){
		this.infoShopRepository = infoShopRepository;
		getInfoShop();
		pack();
		setTitle(infoShopModel.getNameShop());
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelTables = new TablePanel(this,infoShopModel);
		this.add(panelTables);

		this.setLayout(null);
	}
	private void getInfoShop() {
		infoShopModel = infoShopRepository.findAll().get(0);
	}
	public void showMenuPanel(){
			menuPanel = new MenuPanel(this);
			menuPanel.showMenuPanel();
	}
	public void closeMenuPanel(){
		if (menuPanel!=null) {
			menuPanel.closeMenuPanel();
		}
	}
	public void showOrderPanel(int numberTable){
		if (orderPanel==null) {
			orderPanel = new OrderPanel(this, numberTable);
			orderPanel.showOrderPanel();
		}else if (orderPanel!=null){
			orderPanel.closeOrderPanel();
			orderPanel = new OrderPanel(this, numberTable);
			orderPanel.showOrderPanel();
		}
	}
	public void closeOrderPanel(){
		orderPanel.closeOrderPanel();
	}

}
