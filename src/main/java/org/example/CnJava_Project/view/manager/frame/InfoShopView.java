package org.example.CnJava_Project.view.manager.frame;

import org.example.CnJava_Project.controller.manager.InfoShopController;
import org.example.CnJava_Project.model.InfoShopModel;
import org.example.CnJava_Project.respository.InfoShopRepository;
import org.example.CnJava_Project.respository.TableDataRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class InfoShopView extends JFrame {
	public JTextField textFieldNameShop;
	public JTextField textFieldTotalTable;
	public InfoShopRepository infoShopRepository;
	public TableDataRepository tableDataRepository;
	public InfoShopView(InfoShopRepository infoShopRepository, TableDataRepository tableDataRepository){
		this.infoShopRepository = infoShopRepository;
		this.tableDataRepository = tableDataRepository;
		this.setTitle("Thông tin");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);

		ActionListener ac = new InfoShopController(this);

		JLabel labelNameShop = new JLabel("tên quán: ");
		labelNameShop.setBounds(10, 25, 100, 25);
		labelNameShop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(labelNameShop);

		JLabel labelTotalTable = new JLabel("tổng số bàn: ");
		labelTotalTable.setBounds(10, 65, 100, 25);
		labelTotalTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(labelTotalTable);

		textFieldNameShop = new JTextField();
		textFieldNameShop.setBounds(110, 25, 150, 25);
		this.add(textFieldNameShop);

		textFieldTotalTable = new JTextField();
		textFieldTotalTable.setBounds(110, 65, 150, 25);
		this.add(textFieldTotalTable);

		setInfoShop();

		JButton buttonOke = new JButton("Oke");
		buttonOke.addActionListener(ac);
		buttonOke.setBounds(30, 205, 100, 25);
		this.add(buttonOke);

		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(ac);
		buttonCancel.setBounds(155, 205, 100, 25);
		this.add(buttonCancel);
	}

	private void setInfoShop() {
		List<InfoShopModel> infoShopModelFound = infoShopRepository.findAll();

		if (!infoShopModelFound.isEmpty()){
			textFieldNameShop.setText(infoShopModelFound.get(0).getNameShop());
			textFieldTotalTable.setText(infoShopModelFound.get(0).getTotalTable()+"");
		}

	}
}
