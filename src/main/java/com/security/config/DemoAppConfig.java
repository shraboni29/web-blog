package com.security.config;

//import java.beans.PropertyVetoException;
//import java.util.logging.Logger;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//similar to the  <mvc:annotation-driven>>
//similar to the spring-servlet-xml 
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.security")
@PropertySource("classpath:database.properties")
public class DemoAppConfig implements WebMvcConfigurer {

	// read the properties file
	// first set up a variable which hold the properties file
	@Autowired
	private Environment env;
	// set up logger for just fetch the information when everything set up
	private Logger logger = Logger.getLogger(getClass().getName());

	// define bean for view resolver

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);

		return tilesConfigurer;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(104857600); // 100MB
		multipartResolver.setMaxUploadSizePerFile(10485760); // 10MB
		return multipartResolver;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// define bean for datasource
	@Bean
	public DataSource securityDataSource()

	{
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		// setup jdbc driver class
		try {
			System.out.print(" << JDBC Connection  >> ");
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		}

		catch (PropertyVetoException exc) {

			throw new RuntimeException(exc);
		}

		// log the all connection properties
		logger.info(">>>jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>>jdbc.user=" + env.getProperty("jdbc.user"));

		// setting up database connection properties

		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		// setting up connection pool properties
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;
	}

	// need helper method
	private int getIntProperty(String propName) {

		String propval = env.getProperty(propName);
		// convert to int
		int proIntVal = Integer.parseInt(propval);
		return proIntVal;
	}

	////////////////////////////////// HIBERNATE
	////////////////////////////////// BEANS//////////////////////////////////
	// deine a bean for session Factory
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(securityDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.security.entity" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		System.out.print("<<<<<      >>>>>>");
		System.out.print("<<<<<      >>>>>>");
		System.out.print("<<<<<      >>>>>>");
		System.out.print("<<<<<   Session Factory got created   >>>>>>");
		System.out.print("<<<<<      >>>>>>");
		System.out.print("<<<<<      >>>>>>");
		System.out.print("<<<<<      >>>>>>");
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	// deine a bean for transaction manager

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;

	}

}

// @Bean
// public void addResourceHandlers(final ResourceHandlerRegistry registry) {
// registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
// }
