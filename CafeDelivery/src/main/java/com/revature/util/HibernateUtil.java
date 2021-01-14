package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sf = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();

    private static Session sesh; //This is our Global Session Object


    public static Session getSession() {
        if(sesh == null) {
            return sesh = sf.openSession();
        }

        return sesh;
    }

    public static void closeSession() {
        sesh.close();
        sesh = null;
        sf.close();
    }
}