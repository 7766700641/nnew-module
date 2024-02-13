package tech.getarrays.employeemanager.Gen;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tech.getarrays.employeemanager.model.Employee;
@Service
public class JwtGenratorImp implements JwtGenerator {
	@Value("${jwt.secret}")
 private String jwtSecret;
	
	@Value("${jwt.message}")
	 private String jwtMessage;
	
	@Override
	public Map<String, String> genrateToken(Employee employee) {
		String jwtToken =" ";
		
		jwtToken = Jwts.builder()
				 .setSubject(employee.getPhone())
				 .setIssuedAt(new Date())
				 .signWith(SignatureAlgorithm.HS256,jwtSecret)
				 .compact();
		Map<String, String>jwtTokenGenrate=new HashMap<String, String>();
			jwtTokenGenrate.put("token", jwtToken);
			jwtTokenGenrate.put("message", jwtMessage);
			
		return  jwtTokenGenrate;
	}

}
