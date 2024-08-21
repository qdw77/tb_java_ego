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
		System.out.println(0);
		List<HashMap<String, Object>> list = schoolService.selectSchoolList();
		model.addAttribute("schoolList",list);
		System.out.println(1);
		/* return "jsp경로"; */
		return "school/schoolList";
	}

	//	@RequestMapping("/school/getSchoolInfo.do")
	//	public ModelAndView getSchoolInfo(@RequestParam(name="schoolIdx") int schoolIdx) {
	//		ModelAndView mv = new ModelAndView("school/schoolInfo");
	//		
	//		HashMap<String, Object> schoolInfo = schoolService.selectSchoolInfo(schoolIdx);
	//		mv.addObject("schoolInfo", schoolInfo);
	//		
	//		return mv;
	//	}

	//	@RequestMapping("/school/getSchoolInfo.do")
	//	public ModelAndView getSchoolInfo(@RequestParam(name="schoolIdx") int schoolIdx) {
	//		ModelAndView mv = new ModelAndView();
	//		
	//		HashMap<String, Object> schoolInfo = schoolService.selectSchoolInfo(schoolIdx);
	//		mv.addObject("schoolInfo", schoolInfo);
	//		
	//		mv.setViewName("jsonView");
	//		return mv;
	//	}


	//	  @RequestMapping("/school/getSchoolInfo.do") 
	//	  public ModelAndView getSchoolInfo(@RequestParam HashMap<String, Object> paramMap) { 
	//		ModelAndView mv = new ModelAndView();
	//	  
	//	  int schoolIdx = Integer.parseInt(paramMap.get("schoolId").toString());
	//	  HashMap<String, Object> schoolInfo = schoolService.selectSchoolInfo(schoolIdx);
	//	  schoolService.selectSchoolInfo(schoolIdx); 
	//	  mv.addObject("schoolInfo", schoolInfo);
	//	  
	//	  mv.setViewName("jsonView"); 
	//	  return mv; 
	//	  }

	@RequestMapping("/school/insertSchoolInfo.do")
	public ModelAndView insertSchoolInfo(@RequestParam HashMap<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView();

		// ModelAndView 화면/데이터 등 상관없이 사용> ModelAndView(화면) mv.addObject(데이터) 담고 제이슨으로 보여줌
		//mv.setViewName(""school/schoolInfo"");>
		int resultChk = 0;
		resultChk = schoolService.insertSchoolInfo(paramMap);

		mv.addObject("resultChk", resultChk);
		mv.setViewName("jsonView");

		return mv;

		// 항상 쿼리부터 몸에 먼저 익히고 기억하는 게 우선
	}
//	@RequestMapping("/school/insertSchoolInfo.do")
//	public ModelAndView test(@RequestParam HashMap<String, Object> paramMap) {
//		ModelAndView mv = new ModelAndView();
//		
//		int resultChk =0;
//		resultChk = schoolService.insertSchoolInfo(paramMap);
//		
//		mv.addObject("resultChk", resultChk);
//		mv.setViewName("jsonView");
//		return mv;
//	}


}
