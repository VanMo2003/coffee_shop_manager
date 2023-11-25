package org.example.CnJava_Project.GUI.panel.employee;

import org.example.CnJava_Project.GUI.EmployeeView;
import org.example.CnJava_Project.constants.AssetsConstants;
import org.example.CnJava_Project.constants.SizeEmployeeConstants;
import org.example.CnJava_Project.controller.TablesController;
import org.example.CnJava_Project.model.InfoShopModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablePanel extends JPanel {
	private int width = SizeEmployeeConstants.width;
	private int height = SizeEmployeeConstants.height;
	public InfoShopModel infoShopModel;
	public EmployeeView employeeView;
	public TablePanel(EmployeeView employeeView, InfoShopModel infoShopModel){
		this.employeeView = employeeView;
		this.infoShopModel = infoShopModel;
		this.setBounds((int) (width*0.008),(int) (height*0.017), (width-60)/3,(int) (height*0.9));
		this.setBorder(new LineBorder(Color.BLACK, 4));

		ActionListener ac = new TablesController(this);

		JLabel lblTables = new JLabel("Khu vực bàn");
		lblTables.setHorizontalAlignment(JLabel.CENTER);
		lblTables.setBounds((int) (width*0.008), (int) (height*0.017), (width-60)/3, 25);
		lblTables.setFont(new Font("Tahoma", Font.BOLD, 24));
		this.add(lblTables, BorderLayout.NORTH);

		JPanel panelGridView = new JPanel();
		panelGridView.setBounds((int) (width*0.008+5), (int) (height*0.017+40), (width-60)/3 - 10,(int) (height*0.9)-10);
		panelGridView.setLayout(new GridLayout(5, 4, 5, 10));

		for (int i = 0; i < infoShopModel.getTotalTable(); i++) {
			Icon icon = new ImageIcon(AssetsConstants.imageTables);
			JButton btn = new JButton();
			btn.setText((i+1)+"");
			btn.setIcon(icon);
			btn.setOpaque(true);
			btn.setBackground(Color.CYAN.darker());
			btn.setBorder(new LineBorder(Color.WHITE, 12));
			btn.setFocusPainted(false);
			btn.addActionListener(ac);
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					btn.setBackground(Color.CYAN.darker());
					btn.setBorder(new LineBorder(Color.WHITE, 12));
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btn.setBackground(Color.CYAN);
					btn.setBorder(new LineBorder(Color.WHITE, 12));
				}
			});
			btn.setFont(new Font("Tahoma", Font.BOLD, 18));
			panelGridView.add(btn);
		}
		this.add(panelGridView);
	}
}
