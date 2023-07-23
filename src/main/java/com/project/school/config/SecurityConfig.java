package com.project.school.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter ;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.school.security.CustomUserDetailService;
import com.project.school.security.JwtAuthenticationEntryPoint;
import com.project.school.security.JwtAuthenticationFilter; 

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {
	
	
	@Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    
//    @Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.securityMatcher("/eschool/**")                            
//			.authorizeHttpRequests(authorize -> authorize
//				.requestMatchers("/login").permitAll()       
////				.requestMatchers("/admin/**").hasRole("ADMIN")     
//				.anyRequest().authenticated()                      
//			)
//			.exceptionHandling(exception -> exception
//                  .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
//              ) ; 
//		return http.build();
//	}
    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	 http.
         csrf()
         .disable()
         .authorizeHttpRequests()
         .requestMatchers(HttpMethod.GET)
         .permitAll()
         .requestMatchers(HttpMethod.POST)
         .permitAll()
         .anyRequest()
         .authenticated()
         .and().exceptionHandling()
         .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
         .and()
         .sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    	 http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    	 http.authenticationProvider(daoAuthenticationProvider());
    	 DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();

         return defaultSecurityFilterChain;

    }


//	@Bean
//    public SecurityFilterChain web(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth->auth
//                		.requestMatchers("/eschool/login").permitAll()
//                        .anyRequest().authenticated()
//                	)
//                
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
//                    )
//                    .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    );
//
//        http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        	System.out.println("hello here"); 
////        http.authenticationProvider(daoAuthenticationProvider());
//        DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
//
//        return defaultSecurityFilterChain;
//
//
//    }

	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.
				csrf()
				.disable()
				.authorizeHttpRequests()
				.antMatchers(PUBLIC_URLS)
				.permitAll()
				.antMatchers(HttpMethod.GET)
				.permitAll()
				.anyRequest()
				.authenticated()
				.and().exceptionHandling()
				.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	}

	 */

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());

    }

    */


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

	 

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(this.customUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;

    }


    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

} 