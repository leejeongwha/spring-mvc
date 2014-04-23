package com.spring.test.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.test.hibernate.model.BoardUser;

@Repository
public class BoardUserDAOImpl extends HibernateDaoSupport implements
		BoardUserDAO {
	@Autowired
	public BoardUserDAOImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<BoardUser> getBoardUserList(int page, int rownum)
			throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(BoardUser.class);
		criteria.addOrder(Order.desc("id"));
		return (List<BoardUser>) getHibernateTemplate().findByCriteria(
				criteria, (page - 1) * rownum, rownum);
	}

	@Override
	public int getTotalBoardUserCount() {
		return getHibernateTemplate().find("FROM board_user").size();
	}

	/*
	 * 캐쉬 적용
	 */
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "default")
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
		getHibernateTemplate().delete(
				getHibernateTemplate().get(BoardUser.class, id));
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		getHibernateTemplate().update(user);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public int getUserCountById(String id) throws Exception {
		return getHibernateTemplate().find(
				"FROM board_user WHERE id = '" + id + "'").size();
	}

	@Override
	@CacheEvict(value = "default", allEntries = true)
	public void cacheEvict() {
	}
}
