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
		
}
