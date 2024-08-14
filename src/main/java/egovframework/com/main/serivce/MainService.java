package egovframework.com.main.serivce;

import java.util.HashMap;
import java.util.List;

public interface MainService {
	
	public List<HashMap<String, Object>> selectstudentInfo();

	public List<HashMap<String, Object>> selectStudentScore();

}
