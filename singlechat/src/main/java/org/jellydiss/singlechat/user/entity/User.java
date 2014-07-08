package org.jellydiss.singlechat.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS_TB")
public class User implements Serializable {

	@Override
	public String toString() {
		return "User [userSeq=" + userSeq + ", userId=" + userId + ", userpw="
				+ userpw + ", regDateTime=" + regDateTime + ", updDateTime="
				+ updDateTime + "]";
	}

	private static final long serialVersionUID = 7111232751743240524L;

	@Id
	@Column(name = "USER_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userSeq;

	@Column(name = "USER_ID")
	@NotNull
	private String userId;

	@Column(name = "USER_PW")
	private String userpw;

	@Column(name = "REG_DATETIME")
	private String regDateTime;

	@Column(name = "UPD_DATETIME")
	private String updDateTime;

	public User() {
		super();
	}

	public User(Integer userSeq, String userId, String userpw,
			String regDateTime, String updDateTime) {
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
