package org.example.CnJava_Project.view.employee.panel;

import org.example.CnJava_Project.controller.employee.DishController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DishPanel extends JPanel {
	public MenuPanel menuPanel;
	public DishPanel(MenuPanel menuPanel,int idDishGroup, int width, int height){
		this.menuPanel = menuPanel;

		setBounds((width-60)/9+5, 5, (width-60)*2/9-10, (int) (height*0.9)-10);
		setVisible(false);
		setLayout(null);

		ActionListener ac = new DishController(this);

		menuPanel.listDish = menuPanel.dishRepository.findByDishGroup(idDishGroup);
		for (int i = 0; i < menuPanel.listDish.size(); i++) {
			JButton button = new JButton(menuPanel.listDish.get(i).getNameDish());
			button.setToolTipText(menuPanel.listDish.get(i).getUnitPrice()+"");
			button.setBounds((((width-60)*2/9-10)/2*(i%2+1)-(((width-60)*2/9-10)/2-10) - 5),90*(i/2+1) - 80,((width-60)*2/9-10)/2-10, 80);
			button.setFont(new Font("Tahoma", Font.ITALIC, 11));
			button.setHorizontalAlignment(JButton.CENTER);
			button.setFocusPainted(false);
			button.addActionListener(ac);
			this.add(button);
		}
		menuPanel.add(this);
	}
	public void showDishPanel(){
		this.setVisible(true);
	}

	public void closeDishPanel(){
		this.setVisible(false);
	}
}
