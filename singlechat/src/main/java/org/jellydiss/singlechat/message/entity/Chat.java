package org.jellydiss.singlechat.message.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.jellydiss.singlechat.user.entity.User;

public class Chat {
	
	@ManyToOne
	private User user;

	@OneToOne
	private Set<Message> message = new HashSet<Message>();

	public Chat() {
		super();
	}

	public Chat(User user, Set<Message> message) {
		super();
		this.user = user;
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Message> getMessage() {
		return message;
	}

	public void setMessage(Set<Message> message) {
		this.message = message;
	}

}
