package org.jellydiss.singlechat.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "USER_MST_TB")
public class User implements Serializable {

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	private static final long serialVersionUID = 7111232751743240524L;
	
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
		this.userPw = userpw;
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
