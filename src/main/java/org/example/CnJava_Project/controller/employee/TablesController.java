package org.example.CnJava_Project.controller.employee;

import org.example.CnJava_Project.view.employee.panel.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablesController implements ActionListener {
	TablePanel tablePanel;
	public TablesController(TablePanel tablePanel){
		this.tablePanel = tablePanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();

//		JButton buttonSelected = tablePanel.listButton.get(Integer.parseInt(eventString)-1);
//		buttonSelected.setBackground(Color.GREEN);
		tablePanel.employeeView.showOrderPanel(Integer.parseInt(eventString));
	}
}
