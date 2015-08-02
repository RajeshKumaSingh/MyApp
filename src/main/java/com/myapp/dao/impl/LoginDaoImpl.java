package com.myapp.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.api.LoginDao;

@Transactional
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean validateUser(String username, String password) {
		System.out.println("User Name in DaoImpl : "+username);
		System.out.println("Password in Dao Impl : "+password);
		try{
			//String hql="select us from User us where us.username = :uid"; 
			/*Query query=sessionFactory.getCurrentSession().createFilter(hql); 
			query.setParameter("uid", username);
		List<User> usr = (List<User>)query.list();
		if(usr.size()>0){
			for(User user: usr){
				if(user.getPassword().equals(password)){
					return true;
				}
			}
		}else{
			System.out.println("No data found in DB");
			return false;
		}*/
			return true;
		}catch(Exception e){
			System.out.print("Error in DAO");
			e.printStackTrace();
		}
		return false;
	}

}