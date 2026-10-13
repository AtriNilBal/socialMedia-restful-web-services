package org.atrinil.rest.webservices.socialMedia_restful_web_services.authentication;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtEncoder jwtEncoder;

    @Value("${app.jwt.expiration-ms}")
    public long jwtExpiration;

    public AuthController(@Value("${app.jwt.secret}") String secretKey) {
        JWKSource<SecurityContext> jwkSource = new ImmutableSecret<>(secretKey.getBytes());
        this.jwtEncoder = new NimbusJwtEncoder(jwkSource);
    }

    @PostMapping("/token")
    public String authenticateAndGetToken(@RequestBody String username) {
        Instant now = Instant.now();

        JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256).build();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("socialMedia-restful-web-services")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(jwtExpiration))
                .subject(username)
                .build();

        // 3. Combine both the header and claims into the parameters
        JwtEncoderParameters parameters = JwtEncoderParameters.from(jwsHeader, claims);

        return this.jwtEncoder.encode(parameters).getTokenValue();
    }
}
