package edu.eazybytes.social_logins.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                requests -> requests.requestMatchers("/secure").authenticated()
                .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration github = gitHubclientRegistration();
        ClientRegistration facebook = facebookclientRegistration();

        return new InMemoryClientRegistrationRepository(github, facebook);
    }

    private ClientRegistration gitHubclientRegistration() {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("")
                .clientSecret("").build();
    }

    private ClientRegistration facebookclientRegistration() {
        return CommonOAuth2Provider.FACEBOOK.getBuilder("github")
                .clientId("")
                .clientSecret("").build();
    }
}
