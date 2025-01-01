package org.example.springsecurityformlogin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DefaultSecurityConfig  {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
    http.formLogin(
            formLogin -> formLogin.loginPage("/login.html")
                    .loginProcessingUrl("/doLogin")
                    .permitAll()
                    .successHandler(CustomerHandler::onAuthenticationSuccess)
                    .failureHandler(CustomerHandler::onAuthenticationFailure)
    );
    http.csrf(AbstractHttpConfigurer::disable);
    return http.build();
  }
}
