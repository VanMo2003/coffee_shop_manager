package org.example.CnJava_Project.view.manager.frame;

import org.example.CnJava_Project.AES256;
import org.example.CnJava_Project.controller.manager.AccountEmployeeController;
import org.example.CnJava_Project.model.EmployeeModel;
import org.example.CnJava_Project.respository.AccountRepository;
import org.example.CnJava_Project.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class AccountEmployeeView extends JFrame {
	public JLabel labelShowFullName;
	public JPasswordField passwordField;
	public JTextField textFieldUsername;
	public  JComboBox comboBoxCCCD;
	public EmployeeRepository employeeRepository;
	public EmployeeModel employeeModel = new EmployeeModel();
	@Autowired
	public AccountRepository accountRepository;
	public AccountEmployeeView(EmployeeRepository employeeRepository, AccountRepository accountRepository){
		this.employeeRepository = employeeRepository;
		this.accountRepository = accountRepository;
		this.setTitle("Tài khoản nhân viên");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);

		ActionListener ac = new AccountEmployeeController(this);

		JLabel labelCCCD = new JLabel("cccd: ");
		labelCCCD.setBounds(10, 25, 100, 25);
		labelCCCD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(labelCCCD);

		JLabel labelFullName = new JLabel("họ tên: ");
		labelFullName.setBounds(10, 65, 100, 25);
		labelFullName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(labelFullName);

		JLabel labelUsername = new JLabel("tài khoản: ");
		labelUsername.setBounds(10, 105, 100, 25);
		labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(labelUsername);

		JLabel labelPassword = new JLabel("mật khẩu:");
		labelPassword.setBounds(10, 145, 100, 25);
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(labelPassword);

		comboBoxCCCD = new JComboBox<>();
		comboBoxCCCD.addItem("cccd");
		ArrayList<String> listCCCD = getListCCCD();
		listCCCD.forEach(s -> comboBoxCCCD.addItem(s));
		comboBoxCCCD.setBounds(110, 25, 150, 25);
		comboBoxCCCD.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				listenerComboBox(e);
			}
		});
		this.add(comboBoxCCCD);

		labelShowFullName = new JLabel("Họ và tên");
		labelShowFullName.setBounds(110,65, 150, 25);
		this.add(labelShowFullName);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(110, 105, 150, 25);
		this.add(textFieldUsername);

		passwordField = new JPasswordField();
		passwordField.setBounds(110, 145, 150, 25);
		this.add(passwordField);

		JButton buttonOke = new JButton("Oke");
		buttonOke.addActionListener(ac);
		buttonOke.setBounds(30, 205, 100, 25);
		this.add(buttonOke);

		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(ac);
		buttonCancel.setBounds(155, 205, 100, 25);
		this.add(buttonCancel);
	}
	void listenerComboBox(ItemEvent e){
		String secretKey = "MySecretKey";
		String salt = "MySalt";
		if (e.getStateChange() == ItemEvent.SELECTED){
			if (e.getItem()!="cccd"){
				Optional<EmployeeModel> employeeModelFound = employeeRepository.findById(e.getItem().toString());
				if (employeeModelFound.isPresent()){
					employeeModel = employeeModelFound.get();
					labelShowFullName.setText(employeeModel.getFullName());
					textFieldUsername.setText(employeeModel.getUsername());
					String passwordDecrypt = null;
					if (!StringUtils.isEmpty(employeeModel.getPassword())) {
						passwordDecrypt = AES256.decrypt(employeeModel.getPassword(), secretKey, salt);
					}
					passwordField.setText(passwordDecrypt);
				}
			}else {
				labelShowFullName.setText("Họ và tên");
			}
		}
	}

	private ArrayList<String> getListCCCD() {
		List<EmployeeModel> listEmployee = employeeRepository.findAll();

		if (!listEmployee.isEmpty()){
			ArrayList<String> listCCCD = new ArrayList<>();
			listEmployee.forEach(employeeModel -> listCCCD.add(employeeModel.getCccd()));

			return listCCCD;
		}

		return new ArrayList<>();
	}
}
