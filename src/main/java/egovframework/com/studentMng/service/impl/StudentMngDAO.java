package egovframework.com.studentMng.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("StudentMngDAO")
public class StudentMngDAO extends EgovAbstractMapper {

	public List<HashMap<String, Object>> selectStudentMngList(){
		return selectList("selectStudentMngList");
	}
	
	public HashMap<String, Object> selectStudentMngInfo(int schoolId){
		return selectOne("selectStudentMngInfo", schoolId);
//		selectOne >단권조회 
	}
	
	/*
	 * public List<HashMap<String, Object>> selectSchoolMngInfoList(){ return
	 * selectList("selectSchoolMngInfoList"); }
	 */
	
	public int insertStudentMng(HashMap<String, Object> paramMap) {
		return insert("insertStudentMng", paramMap);
	}
	
	
}

