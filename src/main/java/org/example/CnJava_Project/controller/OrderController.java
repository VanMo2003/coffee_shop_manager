package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.EmployeeView;
import org.example.CnJava_Project.GUI.panel.employee.OrderPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OrderController implements ActionListener {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	OrderPanel view;
	public OrderController(OrderPanel view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();

		if (eventString.equals("Gọi món")){
			String timeOrder = sdf.format(Calendar.getInstance().getTime());
			view.lblTime.setText(timeOrder);
			view.lblStatusChose.setText("Đang phục vụ");
			view.btnOrder.setText("Thanh toán");
			view.btnClose.setText("Hủy bàn");
			System.out.println("Mời bạn chọn menu");

			view.employeeView.showMenuPanel();
		}else if (eventString.equals("Đóng")){
			view.employeeView.closeOrderPanel();
			view.employeeView.closeMenuPanel();
			System.out.println(eventString);
		}else if (eventString.equals("Thanh toán")){
			resetTables();
		}else if (eventString.equals("Hủy bàn")){
			resetTables();
		}
	}

	private void resetTables(){
		view.lblTime.setText("....");
		view.lblStatusChose.setText("Trống");
		view.btnOrder.setText("Gọi món");
		view.btnClose.setText("Đóng");
		view.employeeView.closeMenuPanel();
	}
}
