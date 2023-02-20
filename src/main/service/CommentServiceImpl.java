package main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dao.CommentDAO;
import main.model.Comment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public void save(Comment comment) {
		commentDAO.save(comment);
		
	}

}
