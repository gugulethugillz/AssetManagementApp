package com.gugulethuapps.AssetManagementApp;

import com.gugulethuapps.AssetManagementApp.User.service.MyUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    private final UserDetailsService userDetailsService;


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/signUp/**", "/login","/resources/**",  "/assets/**", "/js/**", "/css/**", "/fonts/**", "/img/**").permitAll()
                .antMatchers( "/login/**", "/resources/**", "/assets/**", "/js/**", "/css/**", "/fonts/**", "/img/**").permitAll()
                .antMatchers("/users/addNew/**", "/resources/**", "/assets/**", "/js/**", "/css/**", "/fonts/**", "/img/**").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index").permitAll()
                //.failureUrl("/login/error")
                .and()
                .logout().invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll();

    }





//    @Bean
//    protected InMemoryUserDetailsManager configureAuthentication(){
//        List<UserDetails> userDetails = new ArrayList<>();
//        List<GrantedAuthority> userRoles = new ArrayList<>();
//        userRoles.add(new SimpleGrantedAuthority("USER"));
//
//        List<GrantedAuthority> adminRoles = new ArrayList<>();
//        adminRoles.add(new SimpleGrantedAuthority("ADMIN"));
//
//        userDetails.add(new User("user", "user",userRoles));
//        userDetails.add(new User("admin", "admin",adminRoles));
//        return new InMemoryUserDetailsManager(userDetails);
//    }


//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
//                                             MyUserDetailsServiceImpl userDetailService) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(bCryptPasswordEncoder)
//                .and()
//                .build();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/login/**","/resources/**", "/login/**", "/register", "/js/**", "/css/**", "/fonts/**", "/img/**")
//                .hasAuthority("ADMIN")
//                .antMatchers("/login/**","/resources/**", "/login/**", "/register", "/js/**", "/css/**", "/fonts/**", "/img/**")
//                .authenticated()
//                .antMatchers("/login/**","/resources/**", "/login/**", "/register", "/js/**", "/css/**", "/fonts/**", "/img/**")
//                .hasAnyAuthority(  "USER", "ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/index", true)
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/index");
//        return http.build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web
//                .ignoring()
//                .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder);
//    }

}
