package org.example.CnJava_Project.GUI;

import org.example.CnJava_Project.constants.AssetsConstants;
import org.example.CnJava_Project.controller.LoginController;
import org.example.CnJava_Project.respository.AccountRepository;
import org.example.CnJava_Project.respository.DishRepository;
import org.example.CnJava_Project.respository.EmployeeRepository;
import org.example.CnJava_Project.respository.InfoShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class LoginView extends JFrame  {
	@Autowired
	public AccountRepository accountRepository;
	@Autowired
	public EmployeeRepository employeeRepository;
	@Autowired
	public DishRepository dishRepository;
	@Autowired
	public InfoShopRepository infoShopRepository;
	public JTextField textFieldUsername;
	public JPasswordField passwordField;
	public JLabel lbError;
//	@Autowired
//	public ConfigurableApplicationContext context;
	public LoginView(){
//		this.context = context;
		setSize(400, 300);
		setLocationRelativeTo(null);
		this.setTitle("Đăng nhập");

		ImageIcon icon = new ImageIcon(AssetsConstants.imageLogin);
		this.setIconImage(icon.getImage());

		this.setLayout(null);

		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init(){
		ActionListener ac = new LoginController(this);

		JLabel labelLogin = new JLabel("Đăng nhập");
		labelLogin.setFont(new Font("Arita", Font.BOLD, 36));
		labelLogin.setBounds(100, 20, 190, 50);
		labelLogin.setHorizontalAlignment(JLabel.CENTER);
		this.add(labelLogin);

		JLabel labelUsername = new JLabel("Tài khoản : ");
		labelUsername.setFont(new Font("Arita", Font.ITALIC, 18));
		labelUsername.setBounds(40, 80, 120, 20);
		this.add(labelUsername);

		JLabel labelPassword = new JLabel("Mật khẩu : ");
		labelPassword.setFont(new Font("Arita", Font.ITALIC, 18));
		labelPassword.setBounds(40, 120, 120, 20);
		this.add(labelPassword);

		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(1);
		textFieldUsername.setBounds(160, 80, 200, 30);
		textFieldUsername.setFont(new Font("Arita",Font.PLAIN, 18));
		this.add(textFieldUsername);

		passwordField = new JPasswordField();
		passwordField.setBounds(160, 120, 200, 30);
		passwordField.setFont(new Font("Arita", Font.ITALIC, 18));
		textFieldUsername.setColumns(1);
		this.add(passwordField);

		JButton btnLogin = new JButton("đăng nhập");
		btnLogin.addActionListener(ac);
		btnLogin.setBounds( 125, 170, 150, 30);
		btnLogin.setFont(new Font("Arita", Font.PLAIN, 18));
		btnLogin.setHorizontalAlignment(JButton.CENTER);
		this.add(btnLogin);

		lbError = new JLabel();
		lbError.setBounds(100, 200,200, 30);
		lbError.setHorizontalAlignment(JLabel.CENTER);
		lbError.setForeground(Color.red);
		this.add(lbError);
	}
}
