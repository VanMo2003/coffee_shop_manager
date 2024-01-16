package org.example.CnJava_Project.view.employee.panel;

import org.example.CnJava_Project.view.employee.frame.EmployeeView;
import org.example.CnJava_Project.constants.SizeEmployeeConstants;
import org.example.CnJava_Project.model.DishGroupModel;
import org.example.CnJava_Project.model.DishModel;
import org.example.CnJava_Project.respository.DishGroupRepository;
import org.example.CnJava_Project.respository.DishRepository;
import org.example.CnJava_Project.respository.TableDataRepository;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPanel extends JPanel {
	private static final int width = SizeEmployeeConstants.width;
	private static final int height = SizeEmployeeConstants.height;
	public DishPanel panelDish;
	public JPanel panelDishGroup;
	public EmployeeView employeeView;
	public DishGroupRepository dishGroupRepository;
	public DishRepository dishRepository;
	public TableDataRepository tableDataRepository;
	public List<DishGroupModel> listDishGroup;
	public List<DishModel> listDish;
	public int tableSelected;

	public MenuPanel(EmployeeView employeeView, DishGroupRepository dishGroupRepository, DishRepository dishRepository, TableDataRepository tableDataRepository){
		this.employeeView = employeeView;
		this.dishGroupRepository = dishGroupRepository;
		this.dishRepository = dishRepository;
		this.tableDataRepository = tableDataRepository;
		this.setBounds((int) (width*0.008*3+(width-60)/3*2),(int) (height*0.017), (width-60)/3,(int) (height*0.9));
		this.setBorder(new LineBorder(Color.BLACK, 5));
		this.setVisible(false);
		this.setLayout(null);

		panelDishGroup = new JPanel();
		panelDishGroup.setBounds(5, 5, (width-60)/9, (int) (height*0.9)-10);
		panelDishGroup.setOpaque(true);
		panelDishGroup.setBackground(Color.GRAY);
		panelDishGroup.setLayout(null);
		this.getListDishGroup();
		this.add(panelDishGroup);

		this.employeeView.add(this);
	}
	void getListDishGroup(){
		listDishGroup = dishGroupRepository.findAll();
		for (DishGroupModel dishGroupModel: listDishGroup) {
			JButton btnDishGroup = new JButton(dishGroupModel.getNameDishGroup());
			btnDishGroup.setBounds(10,dishGroupModel.getIdDishGroup()*80-70,(width-60)/9-20, 70);
			btnDishGroup.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnDishGroup.setHorizontalAlignment(JButton.CENTER);
			btnDishGroup.setFocusPainted(false);
			btnDishGroup.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String eventString = e.getActionCommand();
					for (DishGroupModel dishGroupModel : listDishGroup) {
						if (dishGroupModel.getNameDishGroup().equals(eventString)){
							getListDish(dishGroupModel.getIdDishGroup());
						}
					}
				}
			});
			panelDishGroup.add(btnDishGroup);
		}
	}
	public void addTablesOrder(String nameDish, Double unitPrice, int quantity){
		this.employeeView.addTableOrder(nameDish, unitPrice, quantity);
	}
	void getListDish(int idDishGroup){
		if (panelDish==null) {
			panelDish = new DishPanel(this, idDishGroup, width, height);
			panelDish.showDishPanel();
		}else if (panelDish!=null){
			panelDish.closeDishPanel();
			panelDish = new DishPanel(this, idDishGroup, width, height);
			panelDish.showDishPanel();
		}
	}
	public void showMenuPanel(int tableSelected){
		this.tableSelected = tableSelected;
		this.setVisible(true);
	}
	public void closeMenuPanel(){
		this.setVisible(false);
	}
}
