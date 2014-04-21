package com.spring.test.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test.hibernate.model.BoardUser;

@Repository
public class BoardUserDAOImpl extends HibernateDaoSupport implements BoardUserDAO {
	@Autowired
	public BoardUserDAOImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		return (List<BoardUser>) getHibernateTemplate().find("FROM board_user");
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return getHibernateTemplate().get(BoardUser.class, id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		getHibernateTemplate().persist(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		getHibernateTemplate().delete(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		getHibernateTemplate().delete(getHibernateTemplate().get(BoardUser.class, id));
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		getHibernateTemplate().update(user);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return getHibernateTemplate().find("FROM board_user WHERE id = '" + id + "'").size();
	}
}
