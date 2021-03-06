package com.wmrk.demotracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    @Autowired
    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/map/*", "/api/devicex/*", "/gui/*", "/api/user", "/favicon.ico", "/map", "/img/*", "/style/*", "/reg").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                .successForwardUrl("/")
                    .loginPage("/auth")
                    .defaultSuccessUrl("/", true)
                    .loginProcessingUrl("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select name, password, active from usr where name=?")
                .authoritiesByUsernameQuery("select u.name, ur.roles from usr as u " +
                        "inner join user_role as ur on u.id = ur.user_id where u.name=?");

    }


}