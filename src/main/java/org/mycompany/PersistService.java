package org.mycompany;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.HibernateException;

@Component
public class PersistService{

	@Autowired
	SessionFactory sessionFactory;

	public void save(List<AISDatabaseRecord> records) {
		System.out.println("Save " + records.size() + " records ...");
		//Session session = sessionFactory.getCurrentSession();
		Session session;
try {
    session = sessionFactory.getCurrentSession();
} catch (HibernateException e) {
    session = sessionFactory.openSession();
}
		try {
			for (AISDatabaseRecord temp : records) {
				session.save(temp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("End saveing " + records.size() + " records ...");

	}

}
