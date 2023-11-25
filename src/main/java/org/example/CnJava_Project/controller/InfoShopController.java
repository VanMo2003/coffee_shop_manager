package org.example.CnJava_Project.controller;

import org.example.CnJava_Project.GUI.InfoShopView;
import org.example.CnJava_Project.model.InfoShopModel;
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
			infoShopModel.setTotalTable(Integer.parseInt(view.textField_TotalTable.getText()));

			view.infoShopRepository.save(infoShopModel);
			view.setVisible(false);
		}else if (eventString.equals("Cancel")) {
			view.setVisible(false);
		}
	}
}
