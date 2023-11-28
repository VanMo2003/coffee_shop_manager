package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.AccountEmployeeView;
import org.example.CnJava_Project.GUI.panel.manager.QLNVPanel;
import org.example.CnJava_Project.model.EmployeeModel;
import org.example.CnJava_Project.model.TinhModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QLNVController implements ActionListener {
	QLNVPanel view;
	public QLNVController(QLNVPanel view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Thêm")) {
			view.insertData();
		}else if (eventString.equals("Xóa")) {
			view.deleteEmployeeSelected();
		}else if (eventString.equals("Chỉnh sửa")) {
			view.updateEmployeeSelected();
		}else if (eventString.equals("Hủy")) {
			view.reset();
		}
	}
}
