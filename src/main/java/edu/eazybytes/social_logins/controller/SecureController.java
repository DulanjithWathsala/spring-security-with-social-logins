package edu.eazybytes.social_logins.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class SecureController {

    @GetMapping("/secure")
    public String securePage(Authentication authentication) {
        if (authentication instanceof
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
            log.info(String.valueOf(usernamePasswordAuthenticationToken));
        }

        if (authentication instanceof
                OAuth2AuthenticationToken oAuth2AuthenticationToken) {
            log.info(String.valueOf(oAuth2AuthenticationToken));
        }

        return "secure.html";
    }
}
