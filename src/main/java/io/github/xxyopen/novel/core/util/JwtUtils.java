package io.github.xxyopen.novel.core.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@ConditionalOnProperty("novel.jwt.secret")
@Component
@Slf4j
public class JwtUtils {

    @Value("${novel.jwt.secret}")
    private String secret;

    public static final String HEADER_SYSTEM_KEY = "systemKeyHeader";

    public String generateToken(Long uid, String systemKey) {
        return Jwts.builder()
                .setHeaderParam(HEADER_SYSTEM_KEY, systemKey)
                .setSubject(uid.toString())
                .signWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    public Long parseToken(String token, String systemKey) {
        Jws<Claims> claimsJws;

        claimsJws = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token);

        if (Objects.equals(claimsJws.getHeader().get(HEADER_SYSTEM_KEY),systemKey)) {
            return Long.parseLong(claimsJws.getBody().getSubject());
        }
        return null;
    }
}
