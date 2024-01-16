package org.example.CnJava_Project.controller.employee;

import org.example.CnJava_Project.view.employee.dialog.OrderDialog;
import org.example.CnJava_Project.view.employee.panel.DishPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DishController implements ActionListener {
	DishPanel dishPanel;
	public DishController(DishPanel dishPanel){
		this.dishPanel = dishPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		String unitPrice = ((JButton) e.getSource()).getToolTipText();

		showDialog(eventString, unitPrice);
	}

	private void showDialog(String nameDish, String unitPrice) {
		DefaultTableModel defaultTableModel= (DefaultTableModel) dishPanel.menuPanel.employeeView.orderPanel.table.getModel();
		boolean existed = false;
		int index = 0;
		int quantityExist = 1;
		for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
			String nameDishTables = defaultTableModel.getValueAt(i, 0).toString();
			if (nameDishTables.equals(nameDish)){
				existed = true;
				quantityExist = Integer.parseInt(defaultTableModel.getValueAt(i, 2).toString());
				index = i;
			}
		}
		if (!existed) {
			OrderDialog orderDialog = new OrderDialog(dishPanel.menuPanel.employeeView, nameDish, Double.parseDouble(unitPrice));
			orderDialog.setTitle("Gọi món");
			orderDialog.setVisible(true);
			dishPanel.menuPanel.employeeView.setEnabled(false);
		}else {
			OrderDialog orderDialog = new OrderDialog(dishPanel.menuPanel.employeeView, nameDish, Double.parseDouble(unitPrice));
			orderDialog.setTitle("Chỉnh sửa");
			orderDialog.soluong[0] = quantityExist;
			orderDialog.textField_SoLuong.setText(quantityExist+"");
			orderDialog.setVisible(true);

			dishPanel.menuPanel.employeeView.orderPanel.table.changeSelection(index, 0, false, false);

			dishPanel.menuPanel.employeeView.setEnabled(false);
		}
	}
}
