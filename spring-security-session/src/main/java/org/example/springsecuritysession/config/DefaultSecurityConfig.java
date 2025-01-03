package org.example.springsecuritysession.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DefaultSecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
    http.formLogin(Customizer.withDefaults());
    http.sessionManagement(sessionManagement -> sessionManagement.maximumSessions(1).maxSessionsPreventsLogin(true));
    http.sessionManagement(sessionManagement -> sessionManagement.sessionFixation().changeSessionId());
    return http.build();
  }
}
