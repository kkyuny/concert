package com.hhdplus.concert.presentation.common;


import com.hhdplus.concert.application.facade.QueueFacade;
import com.hhdplus.concert.presentation.common.exception.ForbidenException;
import com.hhdplus.concert.presentation.common.exception.UnauthorizedException;
import com.hhdplus.concert.presentation.dto.request.QueueRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class TokenInterceptor implements HandlerInterceptor {

	@Autowired
	QueueFacade queueFacade;

	static Logger LOGGER = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception, UnauthorizedException, ForbidenException {
		/*
			만들고나서 생각해보니 사용해야할 user 정보를
			어떤식으로 controller로 넘겨서 사용할 수 있는지 궁금합니다.
		 */
		LOGGER.info("ACCESS URI : " + request.getRequestURI());

		QueueRequestDto queueRequestDto = new QueueRequestDto();
		queueRequestDto.setToken(request.getHeader("authorization"));

		String checkResult = queueFacade.checkToken(QueueRequestDto.toFacadeDto(queueRequestDto)).getCheckToken();

		if(checkResult.equals("allowAccess")) {
			return true;
		}
		else if(checkResult.equals("fullWaitingQueue"))
			throw new ForbidenException("Waiting Queue is full.");
		else
			throw new UnauthorizedException("Your token is not valid.");
	}
}
