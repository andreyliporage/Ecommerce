package br.com.truedev.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.GET, "/produtos")
                                .permitAll()
                                .requestMatchers(HttpMethod.POST, "/usuarios")
                                .permitAll()
                                .requestMatchers(HttpMethod.POST, "/login")
                                .permitAll()
                                .requestMatchers(HttpMethod.GET, "/v3/api-docs/**")
                                .permitAll()
                                .requestMatchers(HttpMethod.GET, "/swagger**")
                                .permitAll()
                                .anyRequest().authenticated());

        http.addFilterBefore(new MyECFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
