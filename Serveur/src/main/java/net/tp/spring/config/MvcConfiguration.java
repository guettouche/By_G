package net.tp.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.tp.spring.dao.ITransactionDAO;
import net.tp.spring.dao.TransactionDAO;

@Configuration
@ComponentScan(basePackages="net.tp.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver IRVR = new InternalResourceViewResolver();
		IRVR.setPrefix("/WEB-INF/views/");
		IRVR.setSuffix(".jsp");
		return IRVR;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource DMDS = new DriverManagerDataSource();
		DMDS.setDriverClassName("com.mysql.jdbc.Driver");
		DMDS.setUrl("jdbc:mysql://localhost:3306/sepa_by_gi");
		DMDS.setUsername("root");
                
		
		
		return DMDS;
	}
	
	@Bean
	public ITransactionDAO getTransactionDAO() {
		return new TransactionDAO(getDataSource());
	}
}
