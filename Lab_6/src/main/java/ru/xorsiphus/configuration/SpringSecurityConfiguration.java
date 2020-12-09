package ru.xorsiphus.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    final DataSource dataSource;

    public SpringSecurityConfiguration(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("password").roles("USER").build());
//        return manager;
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
//        auth.inMemoryAuthentication()
//                .withUser("u")
//                .password("{noop}123")
//                .authorities("USER");

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, 'true' from users " +
                                "where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_aut " +
                                "where username=?");
//                .usersByUsernameQuery(
//                        "select username, password, true from users where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    .antMatchers("/books").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/books/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
//        http.authorizeRequests()
//                    .antMatchers("/profile").hasRole("USER")
//                    .antMatchers("/**").permitAll()
//                .and()
//                    .formLogin()
//                        .permitAll();
    }
}
