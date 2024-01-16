package org.example.CnJava_Project.controller.manager;

import org.example.CnJava_Project.AES256;
import org.example.CnJava_Project.model.AccountModel;
import org.example.CnJava_Project.view.manager.frame.ChangePasswordView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class ChangePasswordController implements ActionListener {
	ChangePasswordView changePasswordView;
	public ChangePasswordController(ChangePasswordView changePasswordView){
		this.changePasswordView = changePasswordView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventString = e.getActionCommand();
		if (eventString.equals("Oke")){
			String passwordOld = changePasswordView.passwordOld.getText();
			String passwordNew = changePasswordView.passwordNew.getText();
			String passwordNewAgain = changePasswordView.passwordNewAgain.getText();
			AccountModel accountModel = changePasswordView.accountRepository.findAll().get(0);
			String secretKey = "MySecretKey";
			String salt = "MySalt";
			String passwordDecrypt = AES256.decrypt(accountModel.getPassword(), secretKey, salt);
			System.out.println(passwordDecrypt);
			System.out.println(passwordOld);
			if (passwordDecrypt.equals(passwordOld)){
				if (passwordNew.equals(passwordNewAgain)){
					AccountModel accountNew = new AccountModel();
					accountNew.setUsername(accountModel.getUsername());
					String passwordEncrypt = AES256.encrypt(passwordNew, secretKey, salt);
					accountNew.setPassword(passwordEncrypt);
					accountNew.setRole(true);
					changePasswordView.accountRepository.save(accountNew);

					JOptionPane.showMessageDialog(changePasswordView, "Chỉnh sửa thành công");
				}else {
					JOptionPane.showMessageDialog(changePasswordView, "mật khẩu mới không khớp nhau", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}else {
				JOptionPane.showMessageDialog(changePasswordView, "mật khẩu hiện tại k đúng", "Error", JOptionPane.ERROR_MESSAGE);
			}
			changePasswordView.setVisible(false);
		}else if(eventString.equals("Hủy")) {

		}
	}
}
