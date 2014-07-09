package org.jellydiss.singlechat.user.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jellydiss.singlechat.message.entity.Chat;

@Entity
@Table(name = "USER_MST_TB")
public class User implements Serializable {

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	private static final long serialVersionUID = 7111232751743240524L;

	@OneToOne
	@JoinColumn(name="USER_SEQ")
	private Set<Chat> chat = new HashSet<Chat>();

	@Id
	@Column(name = "USER_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userSeq;

	@Column(name = "USER_ID")
	@NotNull
	private String userId;

	@Column(name = "USER_PW")
	@NotNull
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

	public Set<Chat> getChat() {
		return chat;
	}

	public void setChat(Set<Chat> chat) {
		this.chat = chat;
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
