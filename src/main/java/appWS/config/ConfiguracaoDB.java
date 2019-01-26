/**
 * 
 */
package appWS.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Tiago Ferezin Data: 25/01/2019
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "appWS.model.repositories")
public class ConfiguracaoDB {

	@Bean
	public DataSource dataSource() throws IllegalStateException,
			PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		dataSource.setDriverClass("org.postgresql.Driver");
		dataSource
				.setJdbcUrl("jdbc:postgresql://localhost:5432/beblue_tiago_ferezin");
		dataSource.setUser("postgres");
		dataSource.setPassword("dsv");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
			throws Exception {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("appWS.model.entity");
		entityManagerFactoryBean
				.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());

		Properties jpaProterties = new Properties();
		jpaProterties.put("hibernate.dialect",
				"org.hibernate.dialect.PostgreSQL82Dialect");
		jpaProterties.put("hibernate.hbm2ddl.auto", "update");
		jpaProterties.put("hibernate.show_sql", "true");
		jpaProterties.put("hibernate.format_sql", "true");

		// jpaProterties.put("hibernate.c3p0.min_size", "5");
		// jpaProterties.put("hibernate.c3p0.max_size", "10");
		// jpaProterties.put("hibernate.c3p0.timeout", "1800");
		// jpaProterties.put("hibernate.c3p0.max_statements", "50");

		entityManagerFactoryBean.setJpaProperties(jpaProterties);
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory()
				.getObject());
		return transactionManager;
	}

}
