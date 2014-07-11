package org.jellydiss.singlechat.message.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "MSG_MST_TB")
public class Message implements Serializable{
	private static final long serialVersionUID = 1983965883403289470L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@OneToOne(cascade=CascadeType.ALL, mappedBy="message")
	private Chat chat;
	
	@Id
	@GeneratedValue
	@Column(name = "MSG_SEQ",unique=true, nullable=false)
	private Integer messageSeq;

	@Column(name = "MSG_CONTENT", nullable=false)
	@Type(type = "text")
	private String messageContent;

	@Column(name = "REG_DATETIME")
	private String regDateTime;

	public Message() {
		super();
	}

	public Message(Integer messageSeq, String messageContent, String regDateTime) {
		super();
		this.messageSeq = messageSeq;
		this.messageContent = messageContent;
		this.regDateTime = regDateTime;
	}

	public Integer getMessageSeq() {
		return messageSeq;
	}

	public void setMessageSeq(Integer messageSeq) {
		this.messageSeq = messageSeq;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}

}
