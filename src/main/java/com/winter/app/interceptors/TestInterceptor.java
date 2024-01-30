package com.winter.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class Testinterceptor extends HandlerInterceptorAdapter{
	
	
// ds -> controller 진입 전	
// pre 치고 ctrl + space preHandel ( 컨트롤러 진입 전 핸들링 )
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		// return이 true면 controller로 계속 진행
		// return이 false면 controller 진입 방지
	System.out.println("preHandle Controller 진입 전이다.");
	return true;
}	


//post 치고 ctrl + space postHandel ( 컨트롤러 에서 나갈 때 )
@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("PostHandle Controller에서 나갈 떄");

	}
// after ctrl + space afterCompletion ( JSP를 렌더링 후 [HTTP를 작성 후 응답 나가기 전]) 
@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("afterCompletion JSP 렌더링 후 ");
	}

}
