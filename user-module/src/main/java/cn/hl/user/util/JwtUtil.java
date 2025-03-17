package cn.hl.user.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {

    public static String createJwtToken(String token, String jwtPrivateKey, String account) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String authorization = JWT.create()
                .withHeader(map)
                .withClaim("Authorization", token)
                .withClaim("user-account", account)
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(jwtPrivateKey));
        return authorization;
    }
}
