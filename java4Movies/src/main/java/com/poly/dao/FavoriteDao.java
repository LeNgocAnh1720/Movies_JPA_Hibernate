package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.poly.entity.favorite;
import com.poly.util.JpaUtils;

public class FavoriteDao {
	private EntityManager em = JpaUtils.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	
	public favorite insert(favorite entity) {
		try {
			if(entity != null) {
				trans.begin();
				em.persist(entity);
				trans.commit();
			}else {
				throw new Exception("favorite null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		return entity;
	}
	
	public void update(favorite entity) {
		try {
			if(entity != null) {
				trans.begin();
				em.merge(entity);
				trans.commit();
			}else {
				throw new Exception("favorite null");
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
			favorite favorite = em.find(favorite.class, key);
			if(favorite !=null) {
				em.remove(favorite);
			}else {
				throw new Exception("This favorite does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public List<favorite> findAll(){
		String sql = "select o from favorite o ";
		TypedQuery<favorite> query = em.createQuery(sql, favorite.class);
		return query.getResultList();
	}
	
	public favorite findId(String id) {
		favorite favorite = em.find(favorite.class, id);
		return favorite;
	}
}
