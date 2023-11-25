package org.example.CnJava_Project.GUI.panel.employee;

import org.example.CnJava_Project.GUI.EmployeeView;
import org.example.CnJava_Project.constants.SizeEmployeeConstants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuPanel extends JPanel {
	private static final int width = SizeEmployeeConstants.width;
	private static final int height = SizeEmployeeConstants.height;
	public EmployeeView employeeView;

	public MenuPanel(EmployeeView employeeView){
		this.employeeView = employeeView;
		setBounds((int) (width*0.008*3+(width-60)/3*2),(int) (height*0.017), (width-60)/3,(int) (height*0.9));
		setBorder(new LineBorder(Color.BLACK, 4));
		setVisible(false);
		setLayout(null);

		employeeView.add(this);
	}
	public void showMenuPanel(){
		this.setVisible(true);
	}
	public void closeMenuPanel(){
		this.setVisible(false);
	}
}
