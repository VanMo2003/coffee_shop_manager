package org.example.CnJava_Project.view.manager.frame;

import org.example.CnJava_Project.controller.manager.ChangePasswordController;
import org.example.CnJava_Project.respository.AccountRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChangePasswordView extends JFrame {
	public JPasswordField passwordOld;
	public JPasswordField passwordNew;
	public JPasswordField passwordNewAgain;
	public AccountRepository accountRepository;
	public ChangePasswordView(AccountRepository accountRepository){
		this.accountRepository = accountRepository;
		this.setTitle("Thông tin");
		this.setSize(330, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);

		ActionListener ac = new ChangePasswordController(this);

		JLabel lblPasswordOld = new JLabel("mật khẩu hiện tại: ");
		lblPasswordOld.setBounds(10, 25, 130, 25);
		lblPasswordOld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblPasswordOld);

		JLabel lblPasswordNew = new JLabel("mật khẩu mới: ");
		lblPasswordNew.setBounds(10, 65, 130, 25);
		lblPasswordNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblPasswordNew);

		JLabel lblPasswordNewAgain = new JLabel("nhập lại mật khẩu: ");
		lblPasswordNewAgain.setBounds(10, 105, 130, 25);
		lblPasswordNewAgain.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.add(lblPasswordNewAgain);

		passwordOld = new JPasswordField();
		passwordOld.setBounds(140, 25, 150, 25);
		this.add(passwordOld);

		passwordNew = new JPasswordField();
		passwordNew.setBounds(140, 65, 150, 25);
		this.add(passwordNew);

		passwordNewAgain = new JPasswordField();
		passwordNewAgain.setBounds(140, 105, 150, 25);
		this.add(passwordNewAgain);

		JButton buttonOke = new JButton("Oke");
		buttonOke.addActionListener(ac);
		buttonOke.setBounds(30, 205, 100, 25);
		this.add(buttonOke);

		JButton buttonCancel = new JButton("Hủy");
		buttonCancel.addActionListener(ac);
		buttonCancel.setBounds(155, 205, 100, 25);
		this.add(buttonCancel);
	}
}
