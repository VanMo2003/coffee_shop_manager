package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.DishGroupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DishGroupController implements ActionListener {
	DishGroupView view;
	public DishGroupController(DishGroupView view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Thêm")){
			view.insertData();
		}else if (eventString.equals("Sửa")){
			view.updateData();
		}else if (eventString.equals("Xóa")){
			view.deleteData();
		}
	}
}
