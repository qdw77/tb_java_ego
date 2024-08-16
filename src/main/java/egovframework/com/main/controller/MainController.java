package egovframework.com.main.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
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

	@RequestMapping("/sessionTest.do")
	public ModelAndView sessionTest(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("main");

		HttpSession session =request.getSession(false);
		if(session == null) {
			System.out.println("최초방문");
		}else {
			String sessionID = session.getId();
			System.out.println("세션 ID : " + sessionID);
		}
		return mv;
	}

	@RequestMapping("/sessionNumberTest.do")
	public ModelAndView sessionNumberTest(HttpSession session) {
		ModelAndView mv = new ModelAndView("main");

		Integer randomNumber = (Integer)session.getAttribute("random-number");
		if(randomNumber  == null) {
			Integer generated = new Random().nextInt();
			System.out.println("generate-random-number : " + generated.toString());
			session.setAttribute("random-number",generated);
		}else {
			System.out.println("my random umber : "+randomNumber.toString());
		}

		return mv;
	}

	@GetMapping("/CookieTest.do")
	public ModelAndView mair(HttpServletResponse response) throws UnsupportedEncodingException {
		//Cookie cookie = new Cookie("message","from_main");
		ModelAndView mv = new ModelAndView("main");
				
		Cookie cookie = new Cookie("message", URLEncoder.encode("from main", "UTF-8"));
		response.addCookie(cookie);
		return mv;
	}

	@RequestMapping("/getCookie.do")
	public ModelAndView getCookie(@CookieValue(value="message", required=false) Cookie cookie) throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("main");

		if(cookie !=null) {
			String value = cookie.getValue();
			System.out.println("cookie message : " + URLDecoder.decode(value, "UTF-8"));
		}

		return mv;

	}
}
