package cn.hl.common.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;
import java.util.Date;

@Configuration
@Data
public class JwtConfig {

    @Value("${jwt.tokenExpire:1800}")
    private int tokenExpire;

    @Value("${jwt.privateKey:asdasd}")
    private String privateKey;

    public String generateToken(String tokenData) {
        Date now = new Date();
        Date expireDate = DateUtils.addSeconds(now, tokenExpire);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(tokenData)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, new String(Base64.getEncoder().encode(privateKey.getBytes())))
                .compact();
    }

    public Claims getClaimsByToken(String token) {
        return Jwts.parser()
                .setSigningKey(new String(Base64.getEncoder().encode(privateKey.getBytes())))
                .parseClaimsJws(token)
                .getBody();
    }

    public static void main(String[] args) {

        String s = new String(Base64.getEncoder().encode("7815696ecbf1c96e6894b779456d330e".getBytes()));
        System.out.println(s);

//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJBdXRob3JpemF0aW9uIjoiOGNiZDk1Yjc4NWUyNDlkMzlhODJlYjRhNzNiNGQwZDQiLCJ1c2VyLWFjY291bnQiOiIxMjMiLCJpYXQiOjE3NDIyMDczNzB9.j8ZwpKJwuL12CmqQStcN6OKYWJwoiCuAFDvzyssdLek";
//        Claims claimsByToken = new JwtConfig().getClaimsByToken(token);
//        String subject = claimsByToken.getSubject();
//        System.out.println(subject);
    }
}
