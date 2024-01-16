package org.example.CnJava_Project.controller.employee;

import org.example.CnJava_Project.model.BillModel;
import org.example.CnJava_Project.model.TableDataModel;
import org.example.CnJava_Project.view.employee.dialog.PayDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class PayController implements ActionListener {
	PayDialog payDialog;
	public PayController(PayDialog payDialog){
		this.payDialog = payDialog;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Thanh toán")){

		}
		payDialog.employeeView.setEnabled(true);
		payDialog.dispose();
	}
}
