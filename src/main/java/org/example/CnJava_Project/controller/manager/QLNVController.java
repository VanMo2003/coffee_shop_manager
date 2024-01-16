package org.example.CnJava_Project.controller.manager;

import org.example.CnJava_Project.view.manager.panel.QLNVPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLNVController implements ActionListener {
	QLNVPanel qlnvPanel;
	public QLNVController(QLNVPanel qlnvPanel){
		this.qlnvPanel = qlnvPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Thêm")) {
			qlnvPanel.insertData();
		}else if (eventString.equals("Xóa")) {
			qlnvPanel.deleteEmployeeSelected();
		}else if (eventString.equals("Chỉnh sửa")) {
			qlnvPanel.updateEmployeeSelected();
		}else if (eventString.equals("Đặt lại")) {
			qlnvPanel.reset();
		}
	}
}
