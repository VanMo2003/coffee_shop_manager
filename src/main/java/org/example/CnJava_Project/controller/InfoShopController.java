package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.InfoShopView;
import org.example.CnJava_Project.model.InfoShopModel;
import org.example.CnJava_Project.model.TableDataModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoShopController implements ActionListener {
	InfoShopView view;
	public InfoShopController(InfoShopView view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Oke")) {
			view.infoShopRepository.deleteAll();

			InfoShopModel infoShopModel = new InfoShopModel();
			infoShopModel.setNameShop(view.textField_NameShop.getText());
			int totalTables = Integer.parseInt(view.textField_TotalTable.getText());
			infoShopModel.setTotalTable(totalTables);

			view.infoShopRepository.save(infoShopModel);
			view.setVisible(false);
			for (int i=1;i<=totalTables;i++) {
				TableDataModel tableDataModel = new TableDataModel();
				tableDataModel.setId(i);
				tableDataModel.setStatus("Trống");
				tableDataModel.setListOrder(null);

				view.tableDataRepository.save(tableDataModel);
			}
		}else if (eventString.equals("Cancel")) {
			view.setVisible(false);
		}
	}
}
