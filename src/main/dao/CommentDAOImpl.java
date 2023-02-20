package main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(comment);
	}

}
