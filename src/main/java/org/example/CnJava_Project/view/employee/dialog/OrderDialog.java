package org.example.CnJava_Project.view.employee.dialog;

import org.example.CnJava_Project.view.employee.frame.EmployeeView;
import org.example.CnJava_Project.controller.employee.OrderDialogController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderDialog extends JDialog {
	public final int[] soluong = {1};
	public final JTextField textField_SoLuong;
	public String nameDish;
	public EmployeeView employeeView;
	public Double unitPrice;
	public OrderDialog(EmployeeView employeeView, String nameDish, Double unitPrice){
		this.nameDish = nameDish;
		this.unitPrice= unitPrice;
		this.employeeView = employeeView;

		Point local = employeeView.getLocationOnScreen();
		int x = (local.x+1500)/2 - 150;
		int y = (local.y+800)/2 - 150;

		this.setBounds(x,y,300, 300);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		ActionListener ac = new OrderDialogController(this);

		JLabel lblDishSelected = new JLabel(nameDish);
		lblDishSelected.setBounds(10, 10, 270, 30);
		lblDishSelected.setHorizontalAlignment(JLabel.CENTER);
		lblDishSelected.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.add(lblDishSelected);

		JLabel lblSoLuong = new JLabel("Số lượng : ");
		lblSoLuong.setBounds(10, 80, 120, 30);
		lblSoLuong.setHorizontalAlignment(JLabel.CENTER);
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(lblSoLuong);

		textField_SoLuong = new JTextField();
		textField_SoLuong.setText(soluong[0] +"");
		textField_SoLuong.setBounds(130, 80, 50, 30);
		textField_SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.add(textField_SoLuong);

		JButton btnCong = new JButton("+");
		btnCong.setBounds(210, 50, 50, 40);
		btnCong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCong.addActionListener(ac);
		this.add(btnCong);

		JButton btnTru = new JButton("-");
		btnTru.setBounds(210, 100, 50, 40);
		btnTru.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTru.addActionListener(ac);
		this.add(btnTru);

		JButton btnOke = new JButton("Đồng ý");
		btnOke.setBounds(40, 200, 100, 40);
		btnOke.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOke.addActionListener(ac);
		this.add(btnOke);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(160, 200, 100, 40);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.addActionListener(ac);
		this.add(btnCancel);

		this.setLayout(null);
		this.setVisible(true);
	}
}
