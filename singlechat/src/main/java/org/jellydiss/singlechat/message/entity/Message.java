package org.jellydiss.singlechat.message.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "MSG_MST_TB")
public class Message {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Id
	@Column(name = "MSG_SEQ")
	@NotNull
	private String messageSeq;

	@Column(name = "MSG_CONTENT")
	@NotNull
	@Type(type = "text")
	private String messageContent;

	@Column(name = "REG_DATETIME")
	private String regDateTime;

	public Message() {
		super();
	}

	public Message(String messageSeq, String messageContent, String regDateTime) {
		super();
		this.messageSeq = messageSeq;
		this.messageContent = messageContent;
		this.regDateTime = regDateTime;
	}

	public String getMessageSeq() {
		return messageSeq;
	}

	public void setMessageSeq(String messageSeq) {
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
