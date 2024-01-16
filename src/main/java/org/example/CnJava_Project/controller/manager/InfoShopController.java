package org.example.CnJava_Project.controller.manager;

import org.example.CnJava_Project.view.manager.frame.InfoShopView;
import org.example.CnJava_Project.model.InfoShopModel;
import org.example.CnJava_Project.model.TableDataModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoShopController implements ActionListener {
	InfoShopView infoShopView;
	public InfoShopController(InfoShopView infoShopView){
		this.infoShopView = infoShopView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Oke")) {
			infoShopView.infoShopRepository.deleteAll();

			String nameShop = infoShopView.textFieldNameShop.getText();
			int totalTables = Integer.parseInt(infoShopView.textFieldTotalTable.getText());

			InfoShopModel infoShopModel = new InfoShopModel();
			infoShopModel.setNameShop(nameShop);
			infoShopModel.setTotalTable(totalTables);

			infoShopView.infoShopRepository.save(infoShopModel);

			for (int i=1;i<=totalTables;i++) {
				TableDataModel tableDataModel = new TableDataModel();
				tableDataModel.setId(i);
				tableDataModel.setStatus("Trống");
				tableDataModel.setListOrder(null);
				tableDataModel.setTimeOrder(null);

				infoShopView.tableDataRepository.save(tableDataModel);
			}

			infoShopView.setVisible(false);
		}else if (eventString.equals("Cancel")) {
			infoShopView.setVisible(false);
		}
	}
}
