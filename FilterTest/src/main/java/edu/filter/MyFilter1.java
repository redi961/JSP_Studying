package edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;


@WebFilter("/*")

public class MyFilter1 implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("MyFilter1- dofilter");
		
		arg2.doFilter(req, resp);

	}

}
