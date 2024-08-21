package egovframework.com.school.service.impl;

import java.util.HashMap;
import java.util.List;


import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("SchoolDAO")
//컨트롤 스페이스 자동 완성
public class SchoolDAO extends EgovAbstractMapper{
	
	public List<HashMap<String, Object>> selectSchoolList(){
		return selectList("selectSchoolList");
	}
	
	public HashMap<String, Object> selectSchoolInfo(int schoolIdx){
		return selectOne("selectSchoolInfo", schoolIdx);
	}
	
	public int insertSchoolInfo(HashMap<String, Object> paramMap) {
		return insert("insertSchoolInfo", paramMap);
	}

}
