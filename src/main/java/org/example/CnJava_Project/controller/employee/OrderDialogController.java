package org.example.CnJava_Project.controller.employee;

import org.example.CnJava_Project.model.TableDataModel;
import org.example.CnJava_Project.view.employee.dialog.OrderDialog;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class OrderDialogController implements ActionListener {
	OrderDialog orderDialog;
	public OrderDialogController(OrderDialog orderDialog){
		this.orderDialog = orderDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("+")){
			orderDialog.soluong[0]++;
			orderDialog.textField_SoLuong.setText(orderDialog.soluong[0]+"");
		}else if (eventString.equals("-")){
			if (orderDialog.soluong[0]>1){
				orderDialog.soluong[0]--;
				orderDialog.textField_SoLuong.setText(orderDialog.soluong[0]+"");
			}
		}else if (eventString.equals("Đồng ý")){
			if (orderDialog.getTitle().equals("Gọi món")) {
				orderDialog.employeeView.menuPanel.addTablesOrder(orderDialog.nameDish, orderDialog.unitPrice, orderDialog.soluong[0]);

				int tablesSelected = orderDialog.employeeView.menuPanel.tableSelected;

				Optional<TableDataModel> tableDataModel = orderDialog.employeeView.tableDataRepository.findById(tablesSelected);
				if (tableDataModel.isPresent()) {
					String dishAdd = orderDialog.nameDish + "-" + orderDialog.unitPrice + "-" + orderDialog.soluong[0];
					if (tableDataModel.get().getListOrder() == null) {
						tableDataModel.get().setListOrder(dishAdd);
						orderDialog.employeeView.tableDataRepository.save(tableDataModel.get());
					} else {
						String listDishOld = tableDataModel.get().getListOrder();
						String listDishNew = listDishOld + "," + dishAdd;
						tableDataModel.get().setListOrder(listDishNew);
						orderDialog.employeeView.tableDataRepository.save(tableDataModel.get());
					}
				}
			}else if (orderDialog.getTitle().equals("Chỉnh sửa")){
				DefaultTableModel defaultTableModel = (DefaultTableModel) orderDialog.employeeView.orderPanel.table.getModel();
				int i_row = orderDialog.employeeView.orderPanel.table.getSelectedRow();
				System.out.println(i_row);
				if (i_row>=0){
					defaultTableModel.setValueAt(orderDialog.soluong[0], i_row, 2);
					Optional<TableDataModel> tableDataModel = orderDialog.employeeView.tableDataRepository.findById(orderDialog.employeeView.menuPanel.tableSelected);
					if (tableDataModel.isPresent()){
						String dishOld = tableDataModel.get().getListOrder().split(",")[i_row];
						String dishNew = orderDialog.nameDish+"-"+ orderDialog.unitPrice+"-"+ orderDialog.soluong[0];
						String listDishUpdate = tableDataModel.get().getListOrder().replace(dishOld, dishNew);
						tableDataModel.get().setListOrder(listDishUpdate);

						orderDialog.employeeView.tableDataRepository.save(tableDataModel.get());
					}
				}
			}
			orderDialog.employeeView.setEnabled(true);
			orderDialog.dispose();
		}else if (eventString.equals("Hủy")){
			orderDialog.employeeView.setEnabled(true);
			orderDialog.dispose();
		}
	}
}
