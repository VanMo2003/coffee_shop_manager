package org.example.CnJava_Project.controller.employee;

import org.example.CnJava_Project.view.employee.panel.MenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
	MenuPanel view;
	public MenuController(MenuPanel view){
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();

	}
}
