package org.example.CnJava_Project.view.employee.frame;

import org.example.CnJava_Project.respository.*;
import org.example.CnJava_Project.view.employee.panel.MenuPanel;
import org.example.CnJava_Project.view.employee.panel.OrderPanel;
import org.example.CnJava_Project.view.employee.panel.TablePanel;
import org.example.CnJava_Project.constants.SizeEmployeeConstants;
import org.example.CnJava_Project.model.InfoShopModel;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@Component
public class EmployeeView extends JFrame {
	public TablePanel tablePanel;
	public TableDataRepository tableDataRepository;
	private InfoShopRepository infoShopRepository;
	public BillRepository billRepository;
	private InfoShopModel infoShopModel = new InfoShopModel();
	private int height = SizeEmployeeConstants.height;
	private int width = SizeEmployeeConstants.width;
	public OrderPanel orderPanel;
	public MenuPanel menuPanel;
	public EmployeeView(
			InfoShopRepository infoShopRepository,
			TableDataRepository tableDataRepository,
			DishGroupRepository dishGroupRepository,
			DishRepository dishRepository,
			BillRepository billRepository
			){
		this.infoShopRepository = infoShopRepository;
		this.tableDataRepository = tableDataRepository;
		this.billRepository = billRepository;
		getInfoShop();
		setTitle(infoShopModel.getNameShop());
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		tablePanel = new TablePanel(this,infoShopModel, tableDataRepository);
		this.add(tablePanel);

		menuPanel = new MenuPanel(this, dishGroupRepository, dishRepository, tableDataRepository);

		this.setLayout(null);
	}
	private void getInfoShop() {
		infoShopModel = infoShopRepository.findAll().get(0);
	}
	public void showMenuPanel(int tableSelected){
			menuPanel.showMenuPanel(tableSelected);
	}
	public void closeMenuPanel(){
		if (menuPanel!=null) {
			menuPanel.closeMenuPanel();
		}
	}
	public void showOrderPanel(int numberTable){
		if (orderPanel==null) {
			orderPanel = new OrderPanel(this, numberTable, tableDataRepository);
			orderPanel.showOrderPanel();
		}else if (orderPanel!=null){
			orderPanel.closeOrderPanel();
			if (menuPanel!=null){
				closeMenuPanel();
			}
			orderPanel = new OrderPanel(this, numberTable, tableDataRepository);
			orderPanel.showOrderPanel();
		}
	}
	public void closeOrderPanel(){
		orderPanel.closeOrderPanel();
	}
	public void resetTablePanel(){
		this.remove(tablePanel);
		tablePanel = new TablePanel(this,infoShopModel, tableDataRepository);
		this.add(tablePanel);
	}

	public void addTableOrder(String nameDish, Double unitPrice, int quantity){
		DefaultTableModel dftm = (DefaultTableModel) this.orderPanel.table.getModel();

		dftm.addRow(new Object[]{
				nameDish,
				unitPrice,
				quantity
		});
	}

}
