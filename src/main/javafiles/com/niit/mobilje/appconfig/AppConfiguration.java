package com.niit.mobilje.appconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.mobilje.trans.CartDetails;
import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.Register;
import com.niit.mobilje.trans.SupplierDetails;

@Configuration
	@ComponentScan("com.niit")
	@EnableTransactionManagement
	public class AppConfiguration {
		
		@Bean(name="dataStructure")
		public DataSource getDataSource()
		{
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setUrl("jdbc:h2:tcp://localhost/~/Mobilje");
			ds.setDriverClassName("org.h2.Driver");
			ds.setUsername("sa");
			ds.setPassword("sa");
			return ds;
		}
		
		private Properties getHibernateProperties()
		{
			Properties prop = new Properties();
			prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			return prop;
		}
		
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSession(DataSource ds){
			LocalSessionFactoryBuilder session = new LocalSessionFactoryBuilder(ds);
			session.addProperties(getHibernateProperties());
			session.addAnnotatedClass(Register.class);
			session.addAnnotatedClass(CategoryDetails.class);
			session.addAnnotatedClass(SupplierDetails.class);
			session.addAnnotatedClass(ProductDetails.class);
			session.addAnnotatedClass(CartDetails.class);
			
			return session.buildSessionFactory();
		}
		
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransaction(SessionFactory session)
		{
			HibernateTransactionManager transaction= new HibernateTransactionManager(session);
			return transaction;
		}

}
