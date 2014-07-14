package org.jellydiss.singlechat.message.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="CHAT_TB")
public class Chat implements Serializable{
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	private static final long serialVersionUID = 5897286548542801495L;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Message message;
	
	
	@ManyToOne
	@JoinColumn(name="USER_SEQ",nullable=false)
	private ChatUser chatUser;

	@Id
	@Column(name = "MSG_SEQ",unique=true, nullable=false)
	@GeneratedValue(generator="chatGen")			
	@GenericGenerator(name="chatGen",strategy="foreign", parameters=@Parameter(name="property", value="message"))
	private Integer messageSeq;

	public Chat() {
		super();
	}

	public Chat(Message message, ChatUser chatUser, Integer messageSeq) {
		super();
		this.message = message;
		this.chatUser = chatUser;
		this.messageSeq = messageSeq;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public ChatUser getChatUser() {
		return chatUser;
	}

	public void setChatUser(ChatUser chatUser) {
		this.chatUser = chatUser;
	}

	public Integer getMessageSeq() {
		return messageSeq;
	}

	public void setMessageSeq(Integer messageSeq) {
		this.messageSeq = messageSeq;
	}

}
