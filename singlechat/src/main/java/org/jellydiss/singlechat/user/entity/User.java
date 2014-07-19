package org.jellydiss.singlechat.user.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jellydiss.singlechat.common.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "USER_MST_TB")
public class User implements Serializable {
	private static final Logger LOG = LoggerFactory.getLogger(User.class);
	private static final long serialVersionUID = 3615139577208253687L;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Id
	@Column(name = "USER_SEQ", unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userSeq;

	@Column(name = "USER_ID", unique=true, nullable=false)
	private String userId;

	@Column(name = "USER_PW", nullable=false)
	private String userPw;
	
	@Column(name = "REG_DATETIME")
	private String regDateTime;

	@Column(name = "UPD_DATETIME")
	private String updDateTime;

	public User() {
		super();
	}

	public User(Integer userSeq, String userId, String userPw,
			String regDateTime, String updDateTime) {
		super();
		this.userSeq = userSeq;
		this.userId = userId;
		this.userPw = userPw;
		this.regDateTime = regDateTime;
		this.updDateTime = updDateTime;
	}


	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userpw) {
		try {
			SecurityUtil.getInstance();
			this.userPw = SecurityUtil.AES_Encode(userpw);
		} catch (InvalidKeyException | UnsupportedEncodingException
				| NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException
				| IllegalBlockSizeException | BadPaddingException e) {
			LOG.error("Error occured while encode password User.", e);
		}
	}

	public String getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}

	public String getUpdDateTime() {
		return updDateTime;
	}

	public void setUpdDateTime(String updDateTime) {
		this.updDateTime = updDateTime;
	}

}
