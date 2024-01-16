package org.example.CnJava_Project.controller.manager;

import org.example.CnJava_Project.view.manager.panel.QLMAPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLMAController implements ActionListener {
	QLMAPanel qlmaPanel;

	public QLMAController(QLMAPanel qlmaPanel) {
		this.qlmaPanel = qlmaPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Thêm")) {
			qlmaPanel.insertData();
		} else if (eventString.equals("Xóa")) {
			qlmaPanel.deleteDishSelected();
		} else if (eventString.equals("Chỉnh sửa")) {
			qlmaPanel.updateDishSelected();
		}  else if (eventString.equals("Đặt lại")) {
			qlmaPanel.reset();
		}
	}
}


