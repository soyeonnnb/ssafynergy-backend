package com.ssafy.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtUtil {

	private static final String SALT = "S2S0A2F3Y0N5E2R6GY";
	
	 private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	// 토큰생성
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT").claim(claimId, data)
				.signWith(key).compact();
	}

	// 유효성 검사
	public void valid(String token) throws SignatureException, ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
	}
	
	// 헤더에서 토큰 정보 가져오기
	public Claims parseToken(String token) throws SignatureException, ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, UnsupportedEncodingException {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
}
