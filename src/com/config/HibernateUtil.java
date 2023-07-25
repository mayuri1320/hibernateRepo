package com.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.MetadataSource;

import com.model.Student1;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory()
	{
		try {
			if(sf==null)
			{
				Map<String, String>map=new HashMap<>();
				map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				map.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernatedemo");
				map.put(Environment.USER, "root");
				map.put(Environment.PASS, "root");
				map.put(Environment.DIALECT,"");
				map.put(Environment.HBM2DDL_AUTO, "update");
				map.put(Environment.SHOW_SQL, "true");
				
				registry= new StandardServiceRegistryBuilder().applySettings(map).build();
				
				MetadataSources mds=new MetadataSources(registry);
				
				mds.addAnnotatedClass(Student1.class);
				Metadata md=mds.getMetadataBuilder().build();
				sf=md.getSessionFactoryBuilder().build();
				
				
				
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return sf;
		
	}
}
