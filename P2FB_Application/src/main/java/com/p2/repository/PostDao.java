package com.p2.repository;

import java.util.List;

//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Expression;
//import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.p2.model.Post;
import com.p2.model.User;

/**
 * @author Barton Carson
 * @since 2019-9-11
 */
@Repository("postRepo")
@Transactional
@SuppressWarnings("unchecked")
public class PostDao {
	
	@Autowired
	private SessionFactory sf;
	
	public PostDao() {}
	
	/**
	 * @param p the post object you want to enter into the database
	 */
	public void insert(Post p) {sf.getCurrentSession().save(p);}
	
	/**
	 * @param p the post object you want to update in the database
	 */
	public void update(Post p) {sf.getCurrentSession().update(p);}
	
	/**
	 * @param u the user you are using to find your users posts in the database
	 * @return all posts that have the same email in the database
	 */
	@SuppressWarnings("deprecation")
	public List<Post> selectAllByUser(User u) {
		return sf.getCurrentSession().createCriteria(Post.class).add(Restrictions.like("user", u)).list();
		/*CriteriaBuilder cb = sf.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Post> cr = cb.createQuery(Post.class);
		Root<Post> root = cr.from(Post.class);
		cr.select(root).where(cb.like(root.get("user"), (Expression<String>) u));
		Query query = sf.getCurrentSession().createQuery(cr);
		List<Post> results = query.getResultList();
		return results;*/
	}
	
	/**
	 * @return all posts in the database
	 */
	public List<Post> selectAll() {return sf.getCurrentSession().createQuery("from Post", Post.class).list();}

}
