package org.example.CnJava_Project.view.employee.panel;

import org.example.CnJava_Project.model.TableDataModel;
import org.example.CnJava_Project.respository.TableDataRepository;
import org.example.CnJava_Project.view.employee.frame.EmployeeView;
import org.example.CnJava_Project.constants.AssetsConstants;
import org.example.CnJava_Project.constants.SizeEmployeeConstants;
import org.example.CnJava_Project.controller.employee.TablesController;
import org.example.CnJava_Project.model.InfoShopModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TablePanel extends JPanel {
	public ArrayList<JButton> listButton = new ArrayList<>();
	private int width = SizeEmployeeConstants.width;
	private int height = SizeEmployeeConstants.height;
	public EmployeeView employeeView;
	public TableDataRepository tableDataRepository;
	public TablePanel(EmployeeView employeeView, InfoShopModel infoShopModel, TableDataRepository tableDataRepository){
		this.employeeView = employeeView;
		this.tableDataRepository = tableDataRepository;
		this.setBounds((int) (width*0.008),(int) (height*0.017), (width-60)/3,(int) (height*0.9));
		this.setBorder(new LineBorder(Color.BLACK, 5));

		ActionListener ac = new TablesController(this);

		JLabel labelTables = new JLabel("Khu vực bàn");
		labelTables.setHorizontalAlignment(JLabel.CENTER);
		labelTables.setBounds((int) (width*0.008), (int) (height*0.017), (width-60)/3, 25);
		labelTables.setFont(new Font("Tahoma", Font.BOLD, 24));
		this.add(labelTables, BorderLayout.NORTH);

		JPanel panelGridViewTables = new JPanel();
		panelGridViewTables.setBounds((int) (width*0.008+5), (int) (height*0.017+40), (width-60)/3 - 10,(int) (height*0.9)-10);
		panelGridViewTables.setLayout(new GridLayout(infoShopModel.getTotalTable()/4+1, 4, 5, 10));
		List<TableDataModel> list = tableDataRepository.findAll();

		if (!list.isEmpty()){
			list.forEach(tableDataModel -> {
				Icon iconTables = new ImageIcon(AssetsConstants.imageTables);
				JButton buttonTables = new JButton();
				buttonTables.setText(tableDataModel.getId()+"");
				buttonTables.setIcon(iconTables);
				buttonTables.setOpaque(true);
				if (tableDataModel.getStatus().equals("Trống")){
					buttonTables.setBackground(Color.CYAN.darker());
				}else {
					buttonTables.setBackground(Color.GREEN);
				}
				buttonTables.setBorder(new LineBorder(Color.WHITE, 12));
				buttonTables.setFocusPainted(false);
				buttonTables.setFont(new Font("Tahoma", Font.BOLD, 18));
				buttonTables.addActionListener(ac);
				buttonTables.addMouseListener(new EventMouseTables(buttonTables, tableDataModel.getStatus()));
				listButton.add(buttonTables);

				panelGridViewTables.add(buttonTables);
			});
		}
		this.add(panelGridViewTables);
	}
}

class EventMouseTables extends MouseAdapter {
	JButton buttonTables;
	String status;
	EventMouseTables(JButton buttonTables, String status){
		this.buttonTables = buttonTables;
		this.status = status;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (status.equals("Trống")) {
			buttonTables.setBackground(Color.CYAN.darker());
		}else {
			buttonTables.setBackground(Color.GREEN);
		}
		buttonTables.setBorder(new LineBorder(Color.WHITE, 12));
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		buttonTables.setBackground(Color.CYAN);
		buttonTables.setBorder(new LineBorder(Color.WHITE, 12));
	}

}
