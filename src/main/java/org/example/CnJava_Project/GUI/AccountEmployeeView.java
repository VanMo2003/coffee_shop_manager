package org.example.CnJava_Project.GUI;

import org.example.CnJava_Project.config.AES256;
import org.example.CnJava_Project.controller.AccountController;
import org.example.CnJava_Project.model.EmployeeModel;
import org.example.CnJava_Project.respository.AccountRepository;
import org.example.CnJava_Project.respository.EmployeeRepository;
import org.springframework.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountEmployeeView extends JFrame {
	public JLabel lblShowFullName;
	public JPasswordField textField_Password;
	public JTextField textField_Username;
	public  JComboBox comboBox_CCCD;
	public EmployeeRepository employeeRepository;
	public EmployeeModel employeeModel = new EmployeeModel();
	public AccountRepository accountRepository;
	public AccountEmployeeView(EmployeeRepository employeeRepository, AccountRepository accountRepository){
		this.employeeRepository = employeeRepository;
		this.accountRepository = accountRepository;
		this.setTitle("Tài khoản nhân viên");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		ActionListener ac = new AccountController(this);

		JLabel lblCCCD = new JLabel("cccd: ");
		lblCCCD.setBounds(10, 25, 100, 25);
		lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(lblCCCD);

		JLabel lblFullName = new JLabel("họ tên: ");
		lblFullName.setBounds(10, 65, 100, 25);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(lblFullName);

		JLabel lblUsername = new JLabel("tài khoản: ");
		lblUsername.setBounds(10, 105, 100, 25);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(lblUsername);

		JLabel lblPassword = new JLabel("mật khẩu:");
		lblPassword.setBounds(10, 145, 100, 25);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.add(lblPassword);

		comboBox_CCCD = new JComboBox<>();
		comboBox_CCCD.addItem("cccd");
		ArrayList<String> listCCCD = getListCCCD();
		listCCCD.forEach(s -> comboBox_CCCD.addItem(s));
		comboBox_CCCD.setBounds(110, 25, 150, 25);
		comboBox_CCCD.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				listenerComboBox(e);
			}
		});
		this.add(comboBox_CCCD);

		lblShowFullName = new JLabel("Họ và tên");
		lblShowFullName.setBounds(110,65, 150, 25);
		this.add(lblShowFullName);

		textField_Username = new JTextField();
		textField_Username.setBounds(110, 105, 150, 25);
		this.add(textField_Username);

		textField_Password = new JPasswordField();
		textField_Password.setBounds(110, 145, 150, 25);
		this.add(textField_Password);

		JButton btnOke = new JButton("Oke");
		btnOke.addActionListener(ac);
		btnOke.setBounds(30, 205, 100, 25);
		this.add(btnOke);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(ac);
		btnCancel.setBounds(155, 205, 100, 25);
		this.add(btnCancel);
	}
	void listenerComboBox(ItemEvent e){
		String secretKey = "MySecretKey";
		String salt = "MySalt";
		if (e.getStateChange() == ItemEvent.SELECTED){
			if (e.getItem()!="cccd"){
				Optional<EmployeeModel> employeeModelFound = employeeRepository.findById(e.getItem().toString());
				if (employeeModelFound.isPresent()){
					employeeModel = employeeModelFound.get();
					lblShowFullName.setText(employeeModel.getFullName());
					textField_Username.setText(employeeModel.getUsername());
					String passwordDecrypt = null;
					if (!StringUtils.isEmpty(employeeModel.getPassword())) {
						passwordDecrypt = AES256.decrypt(employeeModel.getPassword(), secretKey, salt);
					}
					textField_Password.setText(passwordDecrypt);
				}
			}else {
				lblShowFullName.setText("Họ và tên");
			}
		}
	}

	private ArrayList<String> getListCCCD() {
		List<EmployeeModel> list = employeeRepository.findAll();

		if (!list.isEmpty()){
			ArrayList<String> result = new ArrayList<>();
			list.forEach(employeeModel -> result.add(employeeModel.getCccd()));

			return result;
		}

		return new ArrayList<>();
	}
}
