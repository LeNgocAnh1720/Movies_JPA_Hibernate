package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.poly.entity.users;
import com.poly.util.JpaUtils;


public class UserDao {
	private EntityManager em = JpaUtils.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		em.close(); //Đóng EntityManager khi DAO bị giải phóng
		super.finalize();
	}
	public users insert(users user) {
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new RuntimeException();
		}
		return user;
	}
	
	public users Update(users user) {
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new RuntimeException();
		}
		return user;
		
	}
	
	public users delete(String id) {
		users user;
		try {
			trans.begin();
			user = this.findId(id);
			em.remove(user);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			throw new RuntimeException();
		}
		return user;
		
	}
	
	public List<users> findAll(){
		String sql = "select o from users o ";
		TypedQuery<users> query = em.createQuery(sql, users.class);
		return query.getResultList();
	}
	
	public users findId(String id) {
		users user = em.find(users.class, id);
		return user;
	}
}
