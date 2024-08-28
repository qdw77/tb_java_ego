package egovframework.com.studentMng.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.studentMng.service.StudentMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
//
@Service("StudentMngService")
public class StudentMngServiceImpl extends EgovAbstractServiceImpl implements StudentMngService{

	@Resource(name="StudentMngDAO")
	private StudentMngDAO studentMngDAO;
	
	@Override
	public List<HashMap<String, Object>> selectStudentMngList(){
		return studentMngDAO.selectStudentMngList();
	}
	


	@Override
	public HashMap<String, Object> selectStudentMngInfo(int schoolId) {
		// TODO Auto-generated method stub
		return studentMngDAO.selectStudentMngInfo(schoolId);
	}



	/*
	  @Override public List<HashMap<String, Object>> selectSchoolMngInfoList() { //
	 TODO Auto-generated method stub return studentMngDAO.selectSchoolMngList(); }
	

	/*
	 * @Override public int insertStudentMngInfo(HashMap<String, Object> paramMap) {
	 * int resultChk =0; resultChk = studentMngDAO.insertStudentMngInfo(paramMap);
	 * 
	 * return resultChk;
	 * 
	 * }
	 */



	@Override
	public int insertStudentMng(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		
		int resultChk =0;
		resultChk =studentMngDAO.insertStudentMng(paramMap);
		
		return resultChk;
	}

}
