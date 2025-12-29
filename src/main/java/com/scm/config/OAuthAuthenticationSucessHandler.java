package com.scm.config;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.scm.entities.Providers;
import com.scm.entities.User;
import com.scm.repositories.UserRepo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthAuthenticationSucessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserRepo userRepo;
    Logger logger = LoggerFactory.getLogger(OAuthAuthenticationSucessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        logger.info("OAuthAuthenticationSuccessHandler");

        DefaultOAuth2User oauthUser = (DefaultOAuth2User) authentication.getPrincipal();

        // 1. Identify the Provider (GitHub vs Google)
        String authorizedClientRegistrationId = ((org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken) authentication)
                .getAuthorizedClientRegistrationId();

        String email = "";
        String name = "";
        String picture = "";

        if (authorizedClientRegistrationId.equalsIgnoreCase("github")) {
            // GitHub specific attributes
            email = oauthUser.getAttribute("email") != null ? oauthUser.getAttribute("email").toString()
                    : oauthUser.getAttribute("login").toString() + "@github.com";
            name = oauthUser.getAttribute("login").toString();
            picture = oauthUser.getAttribute("avatar_url").toString();
        }

        // 2. Build User Entity
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setProfilePic(picture);
        user.setPassword("DUMMY_PASSWORD"); // OAuth users don't use passwords
        user.setUserId(UUID.randomUUID().toString());
        user.setProvider(
                authorizedClientRegistrationId.equalsIgnoreCase("github") ? Providers.GITHUB : Providers.GOOGLE);
        user.setEnabled(true);
        user.setEmailVerified(true);
        user.setProviderUserId(oauthUser.getName());
        user.setRoleList(List.of("ROLE_USER"));
        user.setAbout("This account is created by using Github!");

        // 3. Save only if new
        User existingUser = userRepo.findByEmail(email).orElse(null);
        if (existingUser == null) {
            userRepo.save(user);
            logger.info("New OAuth User Saved: " + email);
        }

        new DefaultRedirectStrategy().sendRedirect(request, response, "/user/profile");
    }
}
