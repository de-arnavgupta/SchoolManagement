//package de.arnav.schoolmanagement.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        String[] studentEndpoints = {"/students/**"};
//        String[] staffEndpoints = {"/staff/**"};
//        String[] adminEndpoints = {"/admin/**"};
//
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers(studentEndpoints).hasAnyRole("STUDENTS", "STAFF", "ADMIN")
//                        .requestMatchers(staffEndpoints).hasAnyRole("STAFF", "ADMIN")
//                        .requestMatchers(adminEndpoints).hasRole("ADMIN")
//                );
//
//        HttpMethod[] methods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
//
//        for (String endpoint : studentEndpoints) {
//            for (HttpMethod method : methods) {
//                http.authorizeHttpRequests(authorize -> authorize.requestMatchers(method, endpoint).hasAnyRole("STAFF", "ADMIN"));
//            }
//        }
//
//        for (String endpoint : staffEndpoints) {
//            for (HttpMethod method : methods) {
//                http.authorizeHttpRequests(authorize -> authorize.requestMatchers(method, endpoint).hasRole("ADMIN"));
//            }
//        }
//
//        for (String endpoint : adminEndpoints) {
//            for (HttpMethod method : methods) {
//                http.authorizeHttpRequests(authorize -> authorize.requestMatchers(method, endpoint).hasRole("ADMIN"));
//            }
//        }
//
//        http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());
//
//        http.formLogin(form -> form
//                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/", true)
//                .failureUrl("/login?error=true")
//                .permitAll()
//        );
//
//        http.logout(logout -> logout
//                .permitAll()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//        );
//
//        return http.build();
//    }
//}
