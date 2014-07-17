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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	public User getUser(User user) {
		return loginRepository.getUser(loginRepository.getUserSeq(user));
	}

	public void createUser(User user) {
		DateFormat sdFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date nowDate = new Date();
		user.setRegDateTime(new String(sdFormat.format(nowDate)));
		user.setUpdDateTime(new String(sdFormat.format(nowDate)));

		loginRepository.createUser(encodeUser(user));
	}

	@Transactional
	public LoginCheckStatus login(User user, HttpServletRequest request) {

		User selectedUser = getUser(user);

		if (selectedUser == null) {
			createUser(user);
			return login(user,request);
		}
		if (encodeUser(user).getUserPw().equals(selectedUser.getUserPw())){
			registerUserToSession(user, request.getSession());
			return LoginCheckStatus.LOGIN_SUCCESS;
		
		}

		return LoginCheckStatus.PW_INCORRECT;

	}

	private void registerUserToSession(User user, HttpSession session) {
		session.setAttribute("user", user);		
	}

	private User encodeUser(User user) {
		try {
			SecurityUtil.getInstance();
			user.setUserPw(SecurityUtil.AES_Encode(user.getUserPw()));
		} catch (InvalidKeyException | UnsupportedEncodingException
				| NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException
				| IllegalBlockSizeException | BadPaddingException e) {

			e.printStackTrace();
			return null;
		}
		return user;

	}

}
