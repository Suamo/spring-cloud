package com.suamo.zuulapiproxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * http://localhost:8086/api/tollproxy/tollrate/2?source=mobile
 */
public class ProxyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String source = context.getRequest().getParameter("source");

        return source != null && source.equals("mobile");
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("calling a filter!");
        return null;
    }
}
