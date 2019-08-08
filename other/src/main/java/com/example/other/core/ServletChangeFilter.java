package com.example.other.core;

import javax.servlet.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

/**
 * @author wxq
 * @date 2018-11-19
 */
public class ServletChangeFilter implements Filter {
    private static Field requestField;

    private static Field parametersParsedField;

    private static Field coyoteRequestField;

    private static Field parametersField;

    private static Field hashTabArrField;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            Class clazz = Class.forName("org.apache.catalina.connector.RequestFacade");
            requestField = clazz.getDeclaredField("request");
            requestField.setAccessible(true);


            parametersParsedField = requestField.getType().getDeclaredField("parametersParsed");
            parametersParsedField.setAccessible(true);


            coyoteRequestField = requestField.getType().getDeclaredField("coyoteRequest");
            coyoteRequestField.setAccessible(true);


            parametersField = coyoteRequestField.getType().getDeclaredField("parameters");
            parametersField.setAccessible(true);


            hashTabArrField = parametersField.getType().getDeclaredField("paramHashStringArray");
            hashTabArrField.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String, String[]> map = getRequestMap(request);
        if (map != null) {
            map.put("fuck", new String[]{"fuck you!"});
        }


    }

    @Override
    public void destroy() {

    }


    @SuppressWarnings("unchecked")
    private Map<String, String[]> getRequestMap(ServletRequest request) {
        try {
            Object innerRequest = requestField.get(request);
            parametersParsedField.setBoolean(innerRequest, true);
            Object coyoteRequestObject = coyoteRequestField.get(innerRequest);
            Object parameterObject = parametersField.get(coyoteRequestObject);
            return (Map<String, String[]>) hashTabArrField.get(parameterObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }
}
