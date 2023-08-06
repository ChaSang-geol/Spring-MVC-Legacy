package kr.co.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.co.sample.message.MessageService;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	// 프로퍼티 파일 읽기
	// @Value("${messages.greeting}")
	// private String m_greeting ;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("request : ", request);
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView showMain(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String message = "환영합니다.";
		mav.addObject("response", response); // 뷰에 전달할 데이터를 설정한다.
		// mav.addObject("message", message);
		mav.addObject("message", MessageService.getMessage("greeting"));
		mav.setViewName("main"); // 결과를 보여줄 뷰 이름을 설정한다.

		logger.debug("greeting : " + MessageService.getMessage("greeting"));
		// logger.debug("myname : " + MessageService.getMessage("myname", new String[] { "Cha, Sang-geol" }));
		return mav;

		// return new ModelAndView("main");
	}
	// 2023-08-06 17:55:51 2023-08-06 17:55:51 ERROR
	// [FrameworkServlet.java:initServletBean:458] - Context initialization failed
	// 2023-08-06 17:55:51
	// org.springframework.beans.factory.BeanDefinitionStoreException: Failed to
	// read candidate component class: file
	// [/usr/local/tomcat/webapps/ROOT/WEB-INF/classes/kr/co/sample/MainController.class];
	// nested exception is java.lang.ArrayIndexOutOfBoundsException: 9322
	// 2023-08-06 17:55:51 at
	// org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider.findCandidateComponents(ClassPathScanningCandidateComponentProvider.java:255)
}
