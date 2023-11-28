package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.panel.manager.QLMAPanel;
import org.example.CnJava_Project.model.DishModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLMAController implements ActionListener {
	QLMAPanel view;

	public QLMAController(QLMAPanel view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Thêm")) {
			view.insertData();
		} else if (eventString.equals("Xóa")) {
			view.deleteDishSelected();
		} else if (eventString.equals("Chỉnh sửa")) {
			view.updateDishSelected();
		} else if (eventString.equals("Tài khoản")) {
			System.out.println(eventString);
		} else if (eventString.equals("Reset")) {
			view.reset();
		}
	}
}


