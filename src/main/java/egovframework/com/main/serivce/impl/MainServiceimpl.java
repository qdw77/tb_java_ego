package egovframework.com.main.serivce.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.main.serivce.MainService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("MainService")
public class MainServiceimpl extends EgovAbstractServiceImpl implements MainService{
	
	@Resource(name="MainDAO")
	private MainDAO mainDAO;
//컨트롤러>서비스>다오>

	@Override
	public List<HashMap<String, Object>> selectstudentInfo() {
		// TODO Auto-generated method stub
		
		List<HashMap<String, Object>> list = mainDAO.selectStudentInfo();
		
		return list;
	}

	@Override
	public List<HashMap<String, Object>> selectStudentScore() {
		// TODO Auto-generated method stub
		
		List<HashMap<String, Object>> scorelist = mainDAO.selectStudentScore();
		return scorelist;
	}

}
