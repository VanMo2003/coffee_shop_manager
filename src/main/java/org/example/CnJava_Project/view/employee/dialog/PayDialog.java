package org.example.CnJava_Project.view.employee.dialog;

import org.example.CnJava_Project.controller.employee.PayController;
import org.example.CnJava_Project.view.employee.frame.EmployeeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PayDialog extends JDialog {
	public  JLabel labelPayToBill;
	public JTextField textFieldCustomerMoney;
	public JLabel labelMoneyGiveBack;
	public JComboBox comboBoxDiscount;
	public Double totalMoney;
	public Double totalMoneyDiscount;
	public EmployeeView employeeView;
	public PayDialog(EmployeeView employeeView, Double totalMoney){
		this.employeeView = employeeView;
		this.totalMoney = totalMoney;
		this.totalMoneyDiscount = totalMoney;
		Point local = employeeView.getLocationOnScreen();
		int x = (local.x+1500)/2 - 150;
		int y = (local.y+800)/2 - 150;

		this.setTitle("Thanh toán hóa đơn");
		this.setBounds(x,y,300, 300);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		ActionListener ac = new PayController(this);

		labelPayToBill = new JLabel("Tổng tiền :   "+totalMoney);
		labelPayToBill.setBounds(10, 10, 270, 30);
		labelPayToBill.setHorizontalAlignment(JLabel.LEFT);
		labelPayToBill.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.add(labelPayToBill);

		JLabel labelDiscount = new JLabel("Giảm giá : ");
		labelDiscount.setBounds(10, 50, 120, 25);
		labelDiscount.setHorizontalAlignment(JLabel.LEFT);
		labelDiscount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(labelDiscount);

		comboBoxDiscount = new JComboBox();
		comboBoxDiscount.addItem("");
		comboBoxDiscount.addItem("5%");
		comboBoxDiscount.addItem("10%");
		comboBoxDiscount.addItem("15%");
		comboBoxDiscount.addItem("20%");
		comboBoxDiscount.addItem("30%");
		comboBoxDiscount.addItem("40%");
		comboBoxDiscount.setBounds(130, 50, 150, 25);
		comboBoxDiscount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxDiscount.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				listenerComboBox(e);
			}
		});
		this.add(comboBoxDiscount);

		JLabel labelCustomerMoney = new JLabel("Tiền khách đưa : ");
		labelCustomerMoney.setBounds(10, 90, 120, 25);
		labelCustomerMoney.setHorizontalAlignment(JLabel.LEFT);
		labelCustomerMoney.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(labelCustomerMoney);

		textFieldCustomerMoney = new JTextField();
		textFieldCustomerMoney.setBounds(130, 90, 150, 25);
		textFieldCustomerMoney.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCustomerMoney.addActionListener(new EventTextFieldListener(this));
		this.add(textFieldCustomerMoney);

		JLabel labelGiveBack = new JLabel("Thừa/Thiếu : ");
		labelGiveBack.setBounds(10, 130, 120, 25);
		labelGiveBack.setHorizontalAlignment(JLabel.LEFT);
		labelGiveBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(labelGiveBack);

		labelMoneyGiveBack = new JLabel();
		labelMoneyGiveBack.setBounds(130, 130, 170, 25);
		labelMoneyGiveBack.setHorizontalAlignment(JLabel.LEFT);
		labelMoneyGiveBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.add(labelMoneyGiveBack);

		JButton btnOke = new JButton("Thanh toán");
		btnOke.setBounds(15, 200, 120, 40);
		btnOke.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOke.addActionListener(ac);
		this.add(btnOke);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(155, 200, 120, 40);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.addActionListener(ac);
		this.add(btnCancel);

		this.setLayout(null);
		this.setVisible(true);
	}

	private void listenerComboBox(ItemEvent e) {
		if (!e.getItem().equals("")){
			int discount = Integer.parseInt(e.getItem().toString().split("%")[0]);
			totalMoneyDiscount = totalMoney*(100-discount)/100.0;
		}else {
			totalMoneyDiscount = totalMoney;
		}
		labelPayToBill.setText("Tổng tiền :   "+totalMoneyDiscount);
		if (!textFieldCustomerMoney.getText().equals("")){
			Double customerMoney = Double.parseDouble(textFieldCustomerMoney.getText());
			labelMoneyGiveBack.setText((customerMoney-totalMoneyDiscount)+"");
		}
	}
}

class EventTextFieldListener implements ActionListener{
	private PayDialog payDialog;

	public EventTextFieldListener(PayDialog payDialog){
		this.payDialog = payDialog;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Double customerMoney = Double.parseDouble(e.getActionCommand());
		payDialog.labelMoneyGiveBack.setText((customerMoney-payDialog.totalMoneyDiscount)+""); ;
	}
}
