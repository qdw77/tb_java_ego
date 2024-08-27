//package egovframework.com.studentMng.service;
//
//import java.util.HashMap;
//import java.util.List;
//
//public interface StudentMngService {
//	public List<HashMap<String, Object>> selectStudentMngList();
//}
package egovframework.com.studentMng.service;

import java.util.HashMap;
import java.util.List;

public interface StudentMngService {
	public List<HashMap<String, Object>> selectStudentMngList();


	public HashMap<String, Object> selectStudentMngInfo(int schoolId);
}