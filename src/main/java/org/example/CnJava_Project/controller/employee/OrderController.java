package org.example.CnJava_Project.controller.employee;

import org.example.CnJava_Project.view.employee.dialog.OrderDialog;
import org.example.CnJava_Project.view.employee.dialog.PayDialog;
import org.example.CnJava_Project.view.employee.panel.OrderPanel;
import org.example.CnJava_Project.model.TableDataModel;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class OrderController implements ActionListener {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	OrderPanel orderPanel;
	public OrderController(OrderPanel orderPanel){
		this.orderPanel = orderPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();

		if (eventString.equals("Gọi món")){
			String timeOrder = sdf.format(Calendar.getInstance().getTime());

			TableDataModel tableDataModel = new TableDataModel();
			tableDataModel.setId(orderPanel.tableSelected);
			tableDataModel.setStatus("Đang phục vụ");
			tableDataModel.setTimeOrder(timeOrder);

			orderPanel.tableDataRepository.save(tableDataModel);

			orderPanel.labelTime.setText(timeOrder);
			orderPanel.labelStatusChose.setText("Đang phục vụ");
			orderPanel.buttonOrder.setText("Thanh toán");
			orderPanel.buttonClose.setText("Hủy bàn");

			orderPanel.employeeView.resetTablePanel();

			orderPanel.employeeView.showMenuPanel(orderPanel.tableSelected);
		}else if (eventString.equals("Đóng")){
			orderPanel.employeeView.closeOrderPanel();
			orderPanel.employeeView.closeMenuPanel();
			System.out.println(eventString);
		}else if (eventString.equals("Thanh toán")){
			
			DefaultTableModel defaultTableModel =(DefaultTableModel) orderPanel.table.getModel();
			Double totalMoney = 0.0;
			for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
				Double unitPrice = Double.parseDouble(defaultTableModel.getValueAt(i, 1).toString());
				int quantity = Integer.parseInt(defaultTableModel.getValueAt(i, 2).toString());
				totalMoney += unitPrice*quantity;
			}
			
			PayDialog payDialog = new PayDialog(orderPanel.employeeView, totalMoney);
			orderPanel.employeeView.setEnabled(false);

//			orderPanel.resetOrderPanel();
//			orderPanel.employeeView.resetTablePanel();

		}else if (eventString.equals("Hủy bàn")){
			orderPanel.resetOrderPanel();
			orderPanel.employeeView.resetTablePanel();
		}else if (eventString.equals("Chỉnh Sửa")){
			edit();
		}else if (eventString.equals("Xóa")){
			delete();
		}
	}

	private void delete() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) orderPanel.table.getModel();
		int i_row = orderPanel.table.getSelectedRow();
		if (i_row>=0) {
			String dishName = defaultTableModel.getValueAt(i_row, 0).toString();
			String unitPrice = defaultTableModel.getValueAt(i_row, 1).toString();
			String quantity = defaultTableModel.getValueAt(i_row, 2).toString();

			defaultTableModel.removeRow(i_row);
			Optional<TableDataModel> tableDataModel = orderPanel.tableDataRepository.findById(orderPanel.tableSelected);
			if (tableDataModel.isPresent()){
				String dishDelete = dishName+"-"+unitPrice+"-"+quantity+",";
				System.out.println(dishDelete);
				String listDishOld = tableDataModel.get().getListOrder();
				String listDishNew = listDishOld.replace(dishDelete, "");

				tableDataModel.get().setListOrder(listDishNew);
				orderPanel.tableDataRepository.save(tableDataModel.get());
			}
		}
	}

	private void edit() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) orderPanel.table.getModel();
		int i_row = orderPanel.table.getSelectedRow();
		if (i_row>=0) {
			String dishName = defaultTableModel.getValueAt(i_row, 0).toString();
			String unitPrice = defaultTableModel.getValueAt(i_row, 1).toString();
			String quantity = defaultTableModel.getValueAt(i_row, 2).toString();

			OrderDialog orderDialog = new OrderDialog(orderPanel.employeeView, dishName, Double.parseDouble(unitPrice));
			orderDialog.soluong[0] = Integer.parseInt(quantity);
			orderDialog.textField_SoLuong.setText(quantity);
			orderDialog.setTitle("Chỉnh sửa");
			orderDialog.setVisible(true);
			orderPanel.employeeView.setEnabled(false);
		}
	}
}
