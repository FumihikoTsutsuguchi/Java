package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.constant.UrlConst;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    /** パスワードエンコーダー */
    private final PasswordEncoder passwordEncoder;

    /** ユーザー情報取得Service */
    private final UserDetailsService userDetailsService;

    /** メッセージ取得 */
    private final MessageSource messageSource;

    /** ユーザー名のname属性 */
    private final String USERNAME_PARAMETER = "loginId";

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // .authorizeHttpRequests(
            //     authorize -> authorize.requestMatchers(UrlConst.NO_AUTHENTICATION).permitAll()
            //         .anyRequest().authenticated())

            .formLogin(
                login -> login.loginPage(UrlConst.LOGIN)
                    .usernameParameter(USERNAME_PARAMETER)
                    .defaultSuccessUrl(UrlConst.MENU))

            // .oauth2Login(customizer -> customizer
            //     .loginPage("/login")
            //     .defaultSuccessUrl("/")
            // )
            .logout(customizer -> customizer
                .logoutSuccessUrl("/login")
            )
            .authorizeHttpRequests(customizer -> customizer
                // .requestMatchers("/css/**", "/favicon.ico").permitAll()
                .requestMatchers(UrlConst.NO_AUTHENTICATION).permitAll()
                .anyRequest().authenticated()
            );

            return http.build();
    }

    /**
     * Provider定義
     *
     * @return カスタマイズProvider情報
     */

    @Bean
    AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        provider.setMessageSource(messageSource);

        return provider;
    }

}
