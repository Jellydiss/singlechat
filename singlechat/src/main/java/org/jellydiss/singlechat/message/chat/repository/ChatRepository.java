package org.jellydiss.singlechat.message.chat.repository;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.jellydiss.singlechat.message.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ChatRepository {
	@Autowired
	private SessionFactory sessionFactory;

	public void insertMessage(Chat chatMessage) {
		sessionFactory.getCurrentSession().save(chatMessage);
	}

	public Chat getMessage(int chatSeq) {
		return (Chat) sessionFactory.getCurrentSession().get(Chat.class, chatSeq);
	}

	public int getLastMessageNumber() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select max(c.messageSeq) as MSG_SEQ from Chat as c");

		return (Integer) query.uniqueResult();
	}

}
