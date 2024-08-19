package egovframework.com.school.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.school.service.SchoolService;

@Controller
//컨트롤 쉬프트 O<자동 오류 수정
public class SchoolController {
//	컨트롤러 > 서비스(+impl)>DAO
	@Resource(name="SchoolService")
	private SchoolService schoolService;
	
	@RequestMapping("/school/getSchoolList.do")
	public String getSchoolList(Model model) {
		
		List<HashMap<String, Object>> list = schoolService.selectSchoolList();
		model.addAttribute("schoolList",list);
		
		/* return "jsp경로"; */
		return "school/schoolList";
	}
	
	@RequestMapping("/school/getSchoolInfo.do")
	public ModelAndView getSchoolInfo(@RequestParam(name="schoolIdx") int schoolIdx) {
		ModelAndView mv = new ModelAndView("school/schoolInfo");
		
		HashMap<String, Object> schoolInfo = schoolService.selectSchoolInfo(schoolIdx);
		mv.addObject("schoolInfo", schoolInfo);
		
		return mv;
	}
	
}
