package com.suamo.zuulapiproxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class StopPostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        Instant stop = Instant.now();

        RequestContext context = RequestContext.getCurrentContext();
        Instant start = (Instant)context.get("starttime");
        long diff = ChronoUnit.MILLIS.between(start, stop);
        System.out.println("Call took " + diff + " milliseconds");
        return null;
    }
}
