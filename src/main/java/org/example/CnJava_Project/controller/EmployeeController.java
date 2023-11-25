package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.EmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController implements ActionListener {
	EmployeeView view;
	public EmployeeController(EmployeeView view){
		 this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();

	}
}
