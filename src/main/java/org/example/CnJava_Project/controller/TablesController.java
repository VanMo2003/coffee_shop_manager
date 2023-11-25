package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.panel.employee.TablePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablesController implements ActionListener {
	TablePanel view;
	public TablesController(TablePanel view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		view.employeeView.showOrderPanel(Integer.parseInt(eventString));
		System.out.println(eventString);
	}
}
