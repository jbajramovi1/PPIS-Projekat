package com.example.netflixmgmt.services;

import com.example.netflixmgmt.models.User;
import com.example.netflixmgmt.models.UserRole;
import com.example.netflixmgmt.repositories.IUserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;

@Service
public class TokenAuthenticationService {


    private static IUserRepository userRepository;

    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletRequest req, HttpServletResponse res, String email) {
        ServletContext servletContext = req.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        userRepository = webApplicationContext.getBean(IUserRepository.class);

        String JWT = Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        res.addHeader("Roles", userRepository.findUserByEmail(email)
                .getUserRoleList()
                .stream()
                .map(ur -> ur.getRole().getTitle())
                .collect(Collectors.toList()).toString());
    }

    public static Authentication getAuthentication(HttpServletRequest request) {

        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        userRepository = webApplicationContext.getBean(IUserRepository.class);

        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            User userAccount = userRepository.findUserByEmail(user);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            if(userAccount != null) {
                for(UserRole userRole : userAccount.getUserRoleList())
                    authorities.add(new SimpleGrantedAuthority(userRole.getRole().getTitle()));
            }

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, authorities) :
                    null;
        }
        return null;
    }
}

