package com.hhdplus.concert.interfaces.presentation.common;


import com.hhdplus.concert.application.facade.QueueFacade;
import com.hhdplus.concert.interfaces.presentation.common.exception.ForbidenException;
import com.hhdplus.concert.interfaces.presentation.common.exception.UnauthorizedException;
import com.hhdplus.concert.interfaces.presentation.dto.request.QueueRequestDto;
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
