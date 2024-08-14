package egovframework.com.main.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.main.serivce.MainService;

@Controller
public class MainController {

	@Resource(name="MainService")
	private MainService mainService;

	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}

	@RequestMapping("/main/student.do")
	public ModelAndView student() {
		ModelAndView mv = new ModelAndView("main/student");
		System.out.println(1);
		List<HashMap<String, Object>> list = mainService.selectstudentInfo();
		System.out.println(2);
		mv.addObject("list", list);
		return mv;

	}

	/*
	 * 	@RequestMapping("/test.do")
		public ModelAndView test(@RequestParam HashMap<String, Object> paramMap, @RequestHeader String name ) {

			ModelAndView mv = new ModelAndView();

			mv.addObject("data" , data);
			mv.setViewName("jsonView");
			return mv;

		}
	 */
	/*	@RequestMapping("/test.do")
	public ModelAndView test(@RequestParam HashMap<String, Object> paramMap,
			@RequestHeader String name, 

			@SessionAttributes("loginVO") Model model) {
		//@SessionAttributes("name",name);
		ModelAndView mv = new ModelAndView();
		model.addAttribute("loginVO", loginVO);
		mv.addObject("data" , data);
		mv.setViewName("jsonView");
		return mv;

	}*/

	@RequestMapping("/main/score.do")
	public ModelAndView score() {
		ModelAndView mv = new ModelAndView("main/score");
		System.out.println(1);
		List<HashMap<String, Object>> scorelist = mainService.selectStudentScore();
		System.out.println(2);
		mv.addObject("list", scorelist);
		return mv;

	}
}
