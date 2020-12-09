package ru.xorsiphus.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ComponentScan("ru.xorsiphus.controllers")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("ru.xorsiphus.dao")
@EnableTransactionManagement
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer
{
    private final Environment env;

    @Autowired
    public SpringConfig(Environment env)
    {
        this.env = env;
    }

    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("security/authentication");
    }

    @Bean
    public PlatformTransactionManager transactionManager()
    {
        var txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    @Primary
    public EntityManagerFactory entityManagerFactory()
    {
        var vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        var factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ru.xorsiphus.entity");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public SessionFactory localSessionFactory()
    {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("ru.xorsiphus");
        return builder.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource()
    {
        var dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("dataSource.driverClassName"));
        dataSource.setUrl(env.getProperty("dataSource.url"));
        dataSource.setUsername(env.getProperty("dataSource.username"));
        dataSource.setPassword(env.getProperty("dataSource.password"));

        return dataSource;
    }

//    @Bean
//    public FilterRegistrationBean hiddenHttpMethodFilter()
//    {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HiddenHttpMethodFilter());
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        return filterRegistrationBean;
//    }

//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/resources/templates/");
//        templateResolver.setSuffix(".html");
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        registry.viewResolver(resolver);
//    }
}
