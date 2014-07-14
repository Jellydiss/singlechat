package org.jellydiss.singlechat.message.entity;

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
public class ChatUser implements Serializable{
	
	private static final long serialVersionUID = -8543402649913328392L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Id
	@Column(name = "USER_SEQ", unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userSeq;
	
	@Column(name="USER_ID", unique=true, nullable=false)
	private String userId;

	public ChatUser() {
		super();
	}

	public ChatUser(int userSeq, String userId) {
		super();
		this.userSeq = userSeq;
		this.userId = userId;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
