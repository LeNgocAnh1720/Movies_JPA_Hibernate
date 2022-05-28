package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.poly.entity.share;
import com.poly.util.JpaUtils;

public class ShareDao {
	private EntityManager em = JpaUtils.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	
	public share insert(share entity) {
		try {
			if(entity != null) {
				trans.begin();
				em.persist(entity);
				trans.commit();
			}else {
				throw new Exception("share null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		return entity;
	}
	
	public void update(share entity) {
		try {
			if(entity != null) {
				trans.begin();
				em.merge(entity);
				trans.commit();
			}else {
				throw new Exception("share null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public void delete(String key) {
		try {
			trans.begin();
			share share = em.find(share.class, key);
			if(share !=null) {
				em.remove(share);
			}else {
				throw new Exception("This share does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public List<share> findAll(){
		String sql = "select o from share o ";
		TypedQuery<share> query = em.createQuery(sql, share.class);
		return query.getResultList();
	}
	
	public share findId(String id) {
		share share = em.find(share.class, id);
		return share;
	}
}
