package org.example.CnJava_Project.view.employee.panel;

import org.example.CnJava_Project.respository.BillRepository;
import org.example.CnJava_Project.view.employee.frame.EmployeeView;
import org.example.CnJava_Project.constants.AssetsConstants;
import org.example.CnJava_Project.constants.SizeEmployeeConstants;
import org.example.CnJava_Project.controller.employee.OrderController;
import org.example.CnJava_Project.model.TableDataModel;
import org.example.CnJava_Project.respository.TableDataRepository;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class OrderPanel extends JPanel {
	private JButton buttonDelete;
	private JButton buttonEdit;
	public JButton buttonClose;
	public JButton buttonOrder;
	public JTable table;
	public JLabel labelStatusChose;
	public JLabel labelTime;
	private int width = SizeEmployeeConstants.width;
	private int height = SizeEmployeeConstants.height;
	public EmployeeView employeeView;
	public TableDataRepository tableDataRepository;
	public int tableSelected;

	public OrderPanel(EmployeeView employeeView, int numberTable, TableDataRepository tableDataRepository){
		this.employeeView = employeeView;
		this.tableSelected = numberTable;
		this.tableDataRepository = tableDataRepository;
		setBounds((int) (width*0.008*2+(width-60)/3),(int) (height*0.017), (width-60)/3,(int) (height*0.9));
		setBorder(new LineBorder(Color.BLACK, 5));
		setVisible(false);
		setLayout(null);

		ActionListener ac = new OrderController(this);

		JLabel labelCoffee = new JLabel(new ImageIcon(AssetsConstants.imageCoffee));
		labelCoffee.setBounds(0, 20, (width-60)*2/9, 130);
		labelCoffee.setHorizontalAlignment(JLabel.CENTER);
		add(labelCoffee);

		JLabel labelTableSelected = new JLabel("Bàn " + numberTable);
		labelTableSelected.setBounds((width-60)/9, 20, (width-60)*2/9, 130);
		labelTableSelected.setFont(new Font("Tahoma", Font.ITALIC, 28));
		labelTableSelected.setHorizontalAlignment(JLabel.CENTER);
		this.add(labelTableSelected);

		JLabel labelComeTime = new JLabel("Giờ lúc :");
		labelComeTime.setBounds(10, 180, 70, 20);
		labelComeTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(labelComeTime);

		JLabel lblStatus = new JLabel("Status : ");
		lblStatus.setBounds(10, 210, 70, 20);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblStatus);

		labelTime = new JLabel();
		labelTime.setBounds(80, 180, 200, 20);
		labelTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(labelTime);

		labelStatusChose = new JLabel();
		labelStatusChose.setBounds(80, 210, 200, 20);
		labelStatusChose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(labelStatusChose);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Tên món ăn", "Đơn giá", "số lượng"}));
		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 250, (width-60)/3-20, 250);
		this.add(scrollPane);

		buttonEdit = new JButton("Chỉnh Sửa");
		buttonEdit.setBounds((width-60)/6-150,550,145, 40);
		buttonEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonEdit.setHorizontalAlignment(JButton.CENTER);
		buttonEdit.setForeground(Color.RED.darker());
		buttonEdit.setFocusPainted(false);
		buttonEdit.addActionListener(ac);
		this.add(buttonEdit);

		buttonDelete = new JButton("Xóa");
		buttonDelete.setBounds((width-60)/6+5,550,145, 40);
		buttonDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonDelete.setHorizontalAlignment(JButton.CENTER);
		buttonDelete.setForeground(Color.RED.darker());
		buttonDelete.setFocusPainted(false);
		buttonDelete.addActionListener(ac);
		this.add(buttonDelete);

		buttonOrder = new JButton();
		buttonOrder.setBounds((width-60)/6-200,630,195, 60);
		buttonOrder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		buttonOrder.setHorizontalAlignment(JButton.CENTER);
		buttonOrder.setForeground(Color.RED.darker());
		buttonOrder.setFocusPainted(false);
		buttonOrder.addActionListener(ac);
		this.add(buttonOrder);

		buttonClose = new JButton();
		buttonClose.setBounds((width-60)/6+5,630,195, 60);
		buttonClose.setFont(new Font("Tahoma", Font.PLAIN, 22));
		buttonClose.setHorizontalAlignment(JButton.CENTER);
		buttonClose.setForeground(Color.RED.darker());
		buttonClose.setFocusPainted(false);
		buttonClose.addActionListener(ac);
		this.add(buttonClose);

		setTablesData();

		employeeView.add(this);
	}
	void setTablesData(){
		Optional<TableDataModel> tableDataFound = tableDataRepository.findById(tableSelected);
		if (tableDataFound.isPresent()){
			setOrderPanel(tableDataFound.get());
			if (tableDataFound.get().getListOrder() !=null) {
				addDataToTables(tableDataFound.get());
			}
		}
	}
	private void addDataToTables(TableDataModel tableDataSelected) {
		DefaultTableModel dftm = (DefaultTableModel) table.getModel();
		String[] listDish = tableDataSelected.getListOrder().split(",");

		int quantityDish = listDish.length;
		for (int i = 0; i < quantityDish; i++) {
			dftm.addRow(new Object[]{
				listDish[i].split("-")[0],
				listDish[i].split("-")[1],
				listDish[i].split("-")[2],
		});
		}

	}
	public void resetOrderPanel(){
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		for (int i = defaultTableModel.getRowCount()-1; i >= 0; i--) {
			defaultTableModel.removeRow(i);
		}
		TableDataModel tableDataModel = new TableDataModel();
		tableDataModel.setId(tableSelected);
		tableDataModel.setStatus("Trống");
		tableDataModel.setTimeOrder(null);
		tableDataRepository.save(tableDataModel);

		labelTime.setText("....");
		labelStatusChose.setText("Trống");
		buttonOrder.setText("Gọi món");
		buttonClose.setText("Đóng");
		employeeView.closeMenuPanel();
	}
	private void setOrderPanel(TableDataModel tableDataSelected){
		String timeOrder = tableDataSelected.getTimeOrder();
		String status = tableDataSelected.getStatus();
		labelTime.setText(timeOrder==null?"....":timeOrder);
		labelStatusChose.setText(status);
		buttonOrder.setText(status.equals("Trống") ? "Gọi món":"Thanh toán");
		buttonClose.setText(status.equals("Trống") ? "Đóng":"Hủy bàn");
		if (status.equals("Đang phục vụ")){
			employeeView.showMenuPanel(tableSelected);
		}else {
			employeeView.closeMenuPanel();
		}
	}
	public void showOrderPanel(){
		this.setVisible(true);
	}

	public void closeOrderPanel(){
		this.setVisible(false);
	}
}
