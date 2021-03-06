package com.example.springboot.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * Block access to protected resources if authentication failed (e.g. logged in
 * but the role is not allowed to access the protected resource).
 * 
 * @author bobyuan
 */
@Component
public class LoggingAccessDeniedHandler implements AccessDeniedHandler {

	private static final Logger log = LoggerFactory.getLogger(LoggingAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex)
			throws IOException, ServletException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			log.info("User '" + auth.getName() + "' was trying to access protected resource: "
					+ request.getRequestURI());
		}

		response.sendRedirect(request.getContextPath() + "/error/access-denied");
	}
}