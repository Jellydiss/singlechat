package org.jellydiss.singlechat.common.config.hibernate;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class RepositoryConfig {
	@Value("${jdbc.driverClassName}")     
	private String driverClassName;
	@Value("${jdbc.url}")                 
	private String url;
	@Value("${jdbc.username}")             
	private String username;
	@Value("${jdbc.password}")             
	private String password;
	@Value("${hibernate.dialect}")         
	private String hibernateDialect;
	@Value("${hibernate.show_sql}")     
	private String hibernateShowSql;
	@Value("${connection.pool_size}")
	private String connectionPoolSize;
	@Value("${current_session_context_class}")
	private String currentSessionContextClass;
	@Value("${hbm2ddl.auto}")
	private String hbm2ddlAuto;
	@Bean()
	public DataSource getDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);        
        return ds;
	}
	
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }
    @Bean
    @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }
        
    @Bean
    public LocalSessionFactoryBean getSessionFactory()
    {
    	LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(getDataSource());
        lsfb.setHibernateProperties(getHibernateProperties());        
        lsfb.setPackagesToScan(new String[]{"org.jellydiss.singlechat"});
        return lsfb;
    }

    @Bean
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("connection.pool_size", connectionPoolSize);
        properties.put("current_session_context_class",currentSessionContextClass);
        properties.put("hbm2ddl.auto", hbm2ddlAuto);

        return properties;
    }
}
