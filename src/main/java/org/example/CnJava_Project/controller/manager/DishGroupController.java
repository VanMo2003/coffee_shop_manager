package org.example.CnJava_Project.controller.manager;

import org.example.CnJava_Project.view.manager.frame.DishGroupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DishGroupController implements ActionListener {
	DishGroupView dishGroupView;
	public DishGroupController(DishGroupView dishGroupView){
		this.dishGroupView = dishGroupView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Thêm")){
			dishGroupView.insertData();
		}else if (eventString.equals("Sửa")){
			dishGroupView.updateData();
		}else if (eventString.equals("Xóa")){
			dishGroupView.deleteData();
		}
	}
}
