package com.crizen.gw.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {//필터실행여부
		return true;
	}

	@Override
	public Object run() throws ZuulException {//필터가실행할 내용
		RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        if (!request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {//로컬에서만 접근가능하게
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }

        return null;
	}

	@Override
	public String filterType() {//필터타입
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {//필터실행순서
		return FilterConstants.PRE_DECORATION_FILTER_ORDER -1;
	}
	
	

}
