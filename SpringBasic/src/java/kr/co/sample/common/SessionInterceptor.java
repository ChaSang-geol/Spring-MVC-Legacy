package kr.co.sample.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



/**
 * 세션을 확인하고 세션이 없는 상태라면 로그인 페이지로 이동시킨다.
 * @author Hwang
 *
 */
public class SessionInterceptor extends HandlerInterceptorAdapter
{
	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	/**
	 * Controller 실행 후 VIEW를 보여주기전에 
	 * 세션정보를 VIEW에 포함시킨다.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler , ModelAndView modelAndView)
	{
		if(modelAndView == null)
			return;
		logger.debug("세션정보 입력");
		
		Map<String, String> sessionMap = new HashMap<String, String>();
		HttpSession session = request.getSession();
		//세션체크
		if(session.getAttribute("empNo") == null){
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("로그인 페이지로");
			//return new ModelAndView("redirect:/loginForm");			
		}

		// 세션정보 설정
		sessionMap.put("empNo", (String) session.getAttribute("empNo"));
		sessionMap.put("name", (String) session.getAttribute("name"));
		sessionMap.put("deptCode", (String) session.getAttribute("deptCode"));
		sessionMap.put("hqDeptCode", (String) session.getAttribute("hqDeptCode"));
		sessionMap.put("grpAuthCode", (String) session.getAttribute("grpAuthCode"));
		
		modelAndView.addObject("sessionMap", sessionMap);
	}
	/**
	 * Controller를 접근하기 전에 로그인 세션을 확인하고
	 * 세션 정보가 없을때에는 로그인 페이지로 이동시킨다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,	HttpServletResponse response, Object handler) throws Exception
	{
		String rootPath   =  request.getContextPath();
		String loginPath = "/login";
		
		logger.debug(rootPath + " Check Session");
		
		if(hasSessionInfo(request.getSession()))
    	{
    	
    		return true;
    	}
		//response.sendRedirect(rootPath + "/login");
		
		return true;
	}
	
	/**
	 * 세션에 로그인 정보가 있는지 확인한다
	 * @param session
	 * @return 
	 */
    private boolean hasSessionInfo(HttpSession session)
    {
    	return (session.getAttribute("empNo") != null);
    }
    
    


}


