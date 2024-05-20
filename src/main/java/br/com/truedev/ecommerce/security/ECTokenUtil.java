package br.com.truedev.ecommerce.security;

import br.com.truedev.ecommerce.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import static io.jsonwebtoken.Jwts.SIG.HS384;

public class ECTokenUtil {

    public static final long UM_SEGUNDO =   1000;
    public static final long UM_MINUTO  =   60 * UM_SEGUNDO;
    public static final long UMA_HORA   =   60 * UM_MINUTO;
    public static final long UM_DIA     =   24 * UMA_HORA;
    public static final long UMA_SEMANA =   7  * UM_DIA;

    public static final String EMISSOR = "*TrueDEV*";
    public static final String TOKEN_KEY = HS384.key().toString();
    public static final String TOKEN_HEADER = "Bearer ";

    public static ECToken generateToken(Usuario usuario) {
        Key secretKey = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());
        String jwt = Jwts.builder()
                .subject(usuario.getLogin())
                .issuer(EMISSOR)
                .expiration(new Date(System.currentTimeMillis() + UMA_SEMANA))
                .signWith(secretKey)
                .compact();

        return new ECToken(TOKEN_HEADER + jwt);
    }

    public static Authentication decodeToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        token = token.replace(TOKEN_HEADER, "");

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(TOKEN_KEY.getBytes()).build().parseSignedClaims(token);
        String login = claimsJws.getPayload().getSubject();
        String emissor = claimsJws.getPayload().getIssuer();
        Date validade = claimsJws.getPayload().getExpiration();

        if (!login.isEmpty() && emissor.equals(EMISSOR) && validade.after(new Date(System.currentTimeMillis()))) {
            return new UsernamePasswordAuthenticationToken(login, null, Collections.emptyList());
        }

        return null;
    }
}
