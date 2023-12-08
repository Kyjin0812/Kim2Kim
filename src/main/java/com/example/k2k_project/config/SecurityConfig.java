package com.example.k2k_project.config;

import com.example.k2k_project.Service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserSecurityService boardUserDetailsService;
    //spring security 5.0 사용
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/k2k/login")
                .defaultSuccessUrl("/k2k/loginSuccess", true) //로그인 성공시 이동 url
                .and()
                .logout()
                .logoutUrl("/k2k/logout_page")
                .logoutSuccessUrl("/k2k")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/k2k", "/k2k/login").permitAll()
                                .antMatchers("/k2k/Lodgment/**", "/k2k/Member/**", "/k2k/admin").hasAnyAuthority("ADMIN")
                                .antMatchers("/k2k/Lodgment/view", "/k2k/Member/view").hasAuthority("MEMBER")
                                .anyRequest().authenticated() //그 외 request는 모두 authenticated되어야함
                )
                .csrf().disable()
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .accessDeniedPage("/accessDenied")
                )
                .userDetailsService(boardUserDetailsService);
        return http.build();
    }
    //패스워드 암호화 처리
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
