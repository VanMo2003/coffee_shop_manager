package org.example.CnJava_Project.GUI.panel.employee;

import org.example.CnJava_Project.GUI.EmployeeView;
import org.example.CnJava_Project.constants.AssetsConstants;
import org.example.CnJava_Project.constants.SizeEmployeeConstants;
import org.example.CnJava_Project.controller.OrderController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderPanel extends JPanel {
	public JButton btnClose;
	public JButton btnOrder;
	private JTable table;
	public JLabel lblStatusChose;
	public JLabel lblTime;
	private int width = SizeEmployeeConstants.width;
	private int height = SizeEmployeeConstants.height;
	public EmployeeView employeeView;

	public OrderPanel(EmployeeView employeeView, int numberTable){
		this.employeeView = employeeView;
		setBounds((int) (width*0.008*2+(width-60)/3),(int) (height*0.017), (width-60)/3,(int) (height*0.9));
		setBorder(new LineBorder(Color.BLACK, 4));
		setVisible(false);
		setLayout(null);

		ActionListener ac = new OrderController(this);

		JLabel lblCoffee = new JLabel(new ImageIcon(AssetsConstants.imageCoffee));
		lblCoffee.setBounds(0, 20, (width-60)*2/9, 130);
		lblCoffee.setHorizontalAlignment(JLabel.CENTER);
		add(lblCoffee);

		JLabel lblTableSelected = new JLabel("Bàn " + numberTable);
		lblTableSelected.setBounds((width-60)/9, 20, (width-60)*2/9, 130);
		lblTableSelected.setFont(new Font("Tahoma", Font.ITALIC, 28));
		lblTableSelected.setHorizontalAlignment(JLabel.CENTER);
		this.add(lblTableSelected);

		JLabel lblComeTime = new JLabel("Giờ lúc :");
		lblComeTime.setBounds(10, 180, 70, 20);
		lblComeTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblComeTime);

		JLabel lblStatus = new JLabel("Status : ");
		lblStatus.setBounds(10, 210, 70, 20);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblStatus);

		lblTime = new JLabel("....");
		lblTime.setBounds(80, 180, 200, 20);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblTime);

		lblStatusChose = new JLabel("Trống");
		lblStatusChose.setBounds(80, 210, 200, 20);
		lblStatusChose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblStatusChose);

//		JSeparator separator = new JSeparator();
//		separator.setBounds(50, 250, (width-60)/3-100, 2);
//		this.add(separator);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Tên món ăn", "Đơn giá", "số lượng"}));
		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 250, (width-60)/3-20, 300);
		this.add(scrollPane);

		btnOrder = new JButton("Gọi món");
		btnOrder.setBounds((width-60)/6-200,600,195, 60);
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOrder.setHorizontalAlignment(JButton.CENTER);
		btnOrder.setForeground(Color.RED.darker());
		btnOrder.setFocusPainted(false);
		btnOrder.addActionListener(ac);
		this.add(btnOrder);

		btnClose = new JButton("Đóng");
		btnClose.setBounds((width-60)/6+5,600,195, 60);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClose.setHorizontalAlignment(JButton.CENTER);
		btnClose.setForeground(Color.RED.darker());
		btnClose.setFocusPainted(false);
		btnClose.addActionListener(ac);
		this.add(btnClose);

		employeeView.add(this);

	}
	public void showOrderPanel(){
		this.setVisible(true);
	}

	public void closeOrderPanel(){
		this.setVisible(false);
	}
}
