package org.example.CnJava_Project.GUI;

import org.example.CnJava_Project.controller.InfoShopController;
import org.example.CnJava_Project.model.InfoShopModel;
import org.example.CnJava_Project.respository.InfoShopRepository;
import org.example.CnJava_Project.respository.TableDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class InfoShopView extends JFrame {
	public JTextField textField_NameShop;
	public JTextField textField_TotalTable;
	public InfoShopRepository infoShopRepository;
	public TableDataRepository tableDataRepository;
	public InfoShopView(InfoShopRepository infoShopRepository, TableDataRepository tableDataRepository){
		this.infoShopRepository = infoShopRepository;
		this.tableDataRepository = tableDataRepository;
		this.setTitle("Thông tin");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		ActionListener ac = new InfoShopController(this);

		JLabel lblNameShop = new JLabel("tên quán: ");
		lblNameShop.setBounds(10, 25, 100, 25);
		lblNameShop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblNameShop);

		JLabel lblTotalTable = new JLabel("tổng số bàn: ");
		lblTotalTable.setBounds(10, 65, 100, 25);
		lblTotalTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblTotalTable);

		textField_NameShop = new JTextField();
		textField_NameShop.setBounds(110, 25, 150, 25);
		this.add(textField_NameShop);

		textField_TotalTable = new JTextField();
		textField_TotalTable.setBounds(110, 65, 150, 25);
		this.add(textField_TotalTable);

		setInfoShop();

		JButton btnOke = new JButton("Oke");
		btnOke.addActionListener(ac);
		btnOke.setBounds(30, 205, 100, 25);
		this.add(btnOke);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(ac);
		btnCancel.setBounds(155, 205, 100, 25);
		this.add(btnCancel);
	}

	private void setInfoShop() {
		List<InfoShopModel> infoShopModelFound = infoShopRepository.findAll();

		if (!infoShopModelFound.isEmpty()){
			textField_NameShop.setText(infoShopModelFound.get(0).getNameShop());
			textField_TotalTable.setText(infoShopModelFound.get(0).getTotalTable()+"");
		}

	}
}
