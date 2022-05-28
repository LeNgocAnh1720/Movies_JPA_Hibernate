package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.poly.entity.video;
import com.poly.util.JpaUtils;



public class VideoDao {
	private EntityManager em = JpaUtils.getEntityManager();
	private EntityTransaction trans = em.getTransaction();
	
	public void insert(video entity) {
		try {
			if(entity != null) {
				trans.begin();
				em.persist(entity);
				trans.commit();
			}else {
				throw new Exception("video null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public void update(video entity) {
		try {
			if(entity != null) {
				trans.begin();
				em.merge(entity);
				trans.commit();
			}else {
				throw new Exception("video null");
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public video delete(String key) {
		try {
			trans.begin();
			video video = em.find(video.class, key);
			if(video !=null) {
				em.remove(video);
			}else {
				throw new Exception("This video does not exist!");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		return null;
	}
	
	public List<video> findAll(){
		String sql = "select o from video o ";
		TypedQuery<video> query = em.createQuery(sql, video.class);
		return query.getResultList();
	}
	
	public video findId(String id) {
		video video = em.find(video.class, id);
		return video;
	}
	
	public List<video> SelectTop10(){
		String jpql = "SELECT o FROM video o";
		TypedQuery<video> query = em.createQuery(jpql, video.class);
		return query.getResultList();
	}
	
	public List<video> SelectTop15(){
		String jpql = "SELECT TOP(15) o FROM video o";
		TypedQuery<video> query = em.createQuery(jpql, video.class);
		return query.getResultList();
	}
	
	public List<video> SearchVideo(String title){
		String jpql = "SELECT o FROM video o WHERE o.Title = :title";
		TypedQuery<video> query = em.createQuery(jpql, video.class);
		query.setParameter("title", "%"+title+"%");
		List<video> list = query.getResultList();
		return list;
	}
	
	
	public List<video> DanhSachYeuThich(com.poly.entity.users user){
		String jpql = "SELECT o.video FROM favorite o WHERE o.user.UserId like :vid";
		TypedQuery<video> query = em.createQuery(jpql, video.class).setParameter("vid", user.getUserId());
		List<video> list = query.getResultList();
		return list;
	}
	
}
