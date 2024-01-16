package org.example.CnJava_Project.view;

import org.example.CnJava_Project.constants.AssetsConstants;
import org.example.CnJava_Project.controller.LoginController;
import org.example.CnJava_Project.respository.AccountRepository;
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
	public JTextField textFieldUsername;
	public JPasswordField passwordField;
	public JLabel labelError;
	@Autowired
	public ConfigurableApplicationContext context;
	public LoginView(){
		setSize(400, 300);
		setLocationRelativeTo(null);
		this.setTitle("Đăng nhập");
		this.setResizable(false);
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

		labelError = new JLabel();
		labelError.setBounds(100, 200,200, 30);
		labelError.setHorizontalAlignment(JLabel.CENTER);
		labelError.setForeground(Color.red);
		this.add(labelError);
	}
}
