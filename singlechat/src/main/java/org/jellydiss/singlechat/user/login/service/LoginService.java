package org.jellydiss.singlechat.user.login.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.jellydiss.singlechat.common.util.SecurityUtil;
import org.jellydiss.singlechat.user.entity.User;
import org.jellydiss.singlechat.user.login.enums.LoginCheckStatus;
import org.jellydiss.singlechat.user.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	
	 
	
	@Transactional
	public User getUser(User user) {
		
		return loginRepository.getUser(loginRepository.getUserSeq(user));
	}
	
	@Transactional
	public void createUser(User user) {
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date nowDate = new Date();
		user.setRegDateTime(new String( sdFormat.format(nowDate)));
		user.setUpdDateTime(new String( sdFormat.format(nowDate)));
		
		loginRepository.createUser(encodeUser(user));
	
	}

	public LoginCheckStatus login(User user){
		
		User selectedUser = getUser(user);
		
		if(selectedUser == null){
			createUser(user);
			return login(user); 
		}
		if(encodeUser(user).getUserpw().equals(selectedUser.getUserpw()))
			return LoginCheckStatus.LOGIN_SUCCESS;
		
		return  LoginCheckStatus.PW_INCORRECT;
			
		
			
	}
	
	private User encodeUser(User user){
		try {
			SecurityUtil.getInstance();
			user.setUserpw(SecurityUtil.AES_Encode(user.getUserpw()));
		} catch (InvalidKeyException | 
				UnsupportedEncodingException | 
				NoSuchAlgorithmException | 
				NoSuchPaddingException	| 
				InvalidAlgorithmParameterException |
				IllegalBlockSizeException |
				BadPaddingException e) {

			e.printStackTrace();
			return null;
		}
		return user;
		
	}
	
}
