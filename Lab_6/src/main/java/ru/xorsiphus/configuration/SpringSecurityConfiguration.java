package ru.xorsiphus.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter
{
//    private final PasswordEncoder passwordEncoder;
//    final DataSource dataSource;

//    @Bean
//    public PasswordEncoder getPasswordEncoder()
//    {
////        return new BCryptPasswordEncoder(8);
//        return NoOpPasswordEncoder.getInstance();
//    }



//    public SpringSecurityConfiguration(DataSource dataSource)
//    {
//        this.dataSource = dataSource;
//    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery(
//                        "select username, password, true from users where username=?");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
//                    .successForwardUrl("/profile")
                .and()
                    .logout()
                    .permitAll();
//        http.authorizeRequests()
//                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/**").permitAll()
//                .and().formLogin();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user =
                User
                        .withDefaultPasswordEncoder()
                        .username("u")
                        .password("123")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
