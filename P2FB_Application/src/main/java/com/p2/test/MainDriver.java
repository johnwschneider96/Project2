package com.p2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.p2.model.Post;
import com.p2.model.User;
import com.p2.repository.PostDao;
import com.p2.repository.UserDao;

public class MainDriver {
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static UserDao ud = appContext.getBean("userRepo", UserDao.class);
	public static PostDao pd = appContext.getBean("postRepo", PostDao.class);

	public static void main(String[] args) {
		
		User u = new User("lbcarson@hotmail.com", "lbc4", "image", "Lester", "Carson", "18432241773");
		Post p = new Post("Cool", 6, u);
		
		ud.insert(u);
		pd.insert(p);
		System.out.println(pd.selectAllByUser(u));
		System.out.println(pd.selectAll());

	}

}
