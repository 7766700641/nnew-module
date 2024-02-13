package tech.getarrays.employeemanager.Gen;

import java.util.Map;



import tech.getarrays.employeemanager.model.Employee;

public interface JwtGenerator {
	
public Map<String,String> genrateToken(Employee employee);
}
