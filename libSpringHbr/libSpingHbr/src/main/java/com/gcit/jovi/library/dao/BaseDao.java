package com.gcit.jovi.library.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class BaseDao<T extends Serializable>
{
	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager em;
	
	public BaseDao()
	{
		setEntityClass();
	}
	
	protected abstract void setEntityClass();
	
	@Transactional
	public void save(T entity)
	{
		em.persist(entity);
	}
	
	@Transactional
	public void update(T entity)
	{
		em.merge(entity);
	}
	
	@Transactional
	public  T read(Integer id)
	{
		return em.find(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> readAll()
	{
		List<T> aList = this.em.createQuery( "from " + this.entityClass.getName()).getResultList();
		 return aList;
	}
	
	@Transactional
	public void delete(T entity)
	{
		em.remove(em.contains(entity)? entity: em.merge(entity));
	}
}
