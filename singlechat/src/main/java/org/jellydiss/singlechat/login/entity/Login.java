package org.jellydiss.singlechat.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="USERS_TB")
public class Login {
	@Id
	@Column(name = "USER_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userSeq;

	@Column(name ="USER_ID")
	@NotNull
	private String userId;
	
	@Column(name = "USER_PW")
	private String userpw;
	
	@Column(name = "REG_DATETIME")
	private String regDateTime;
	
	@Column(name = "UPD_DATETIME")
	private String updDateTime;
	
	
	public Login() {
		super();
	}


	public Login(Integer userSeq, String userId, String userpw, String regDateTime,
		String updDateTime) {
	super();
	this.userSeq = userSeq;
	this.userId = userId;
	this.userpw = userpw;
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

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
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
