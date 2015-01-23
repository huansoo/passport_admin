package com.wugu.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * @ClassName: EncodingFilter
 * @Description: 字符集过滤器
 * @author yangch
 * @date 2014-12-12 
 *
 */
public class EncodingFilter /*implements Filter*/{

    private FilterConfig filterConfig;
    private String encoding;
    private static final Pattern p = Pattern.compile("[a-zA-Z0-9\\.\\]\\[_'\\s]+");
    /* (非 Javadoc)
    * <p>Title: destroy</p>
    * <p>Description: </p>
    * @see javax.servlet.Filter#destroy()
    */
    public void destroy() {
        System.out.println("销毁了。。。。。。。。。。。。。。。。。。。。");
    }

    /* (非 Javadoc)
    * <p>Title: doFilter</p>
    * <p>Description: </p>
    * @param arg0
    * @param arg1
    * @param arg2
    * @throws IOException
    * @throws ServletException
    * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
    */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("filterName---------"+filterConfig.getFilterName());
        request.setCharacterEncoding(this.encoding);
        
        Enumeration<?> en =  request.getParameterNames();
        while(en.hasMoreElements()){
            Object pv = en.nextElement();
            if(null != pv){
                Matcher match = p.matcher(pv.toString());
                String value = request.getParameter(pv.toString());
                System.out.println("Enum======================"+value);
                if(match.matches() && !chkWord(value)){
                    continue;
                }else{
                    response.setContentType("text/html");
                    response.setCharacterEncoding("utf-8");
                    PrintWriter out = response.getWriter();
                    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
                    out.println("<HTML>");
                    out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
                    out.println("  <BODY>");
                    out.println("  请求被拒绝，因为请求中包含了敏感字符</br>请求中的参数值不能包含<font color='red'>insert、upate、delete、truncate、create</font> 单词!!!");
                    out.println("  </BODY>");
                    out.println("</HTML>");
                    out.flush();
                    out.close();
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    /* (非 Javadoc)
    * <p>Title: init</p>
    * <p>Description: </p>应用启动时被调用，初始化fiterConfig
    * @param arg0
    * @throws ServletException
    * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
    */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = this.filterConfig.getInitParameter("enocoding");
        System.out.println("初始化了");
    }

    /**
     * 
      * @Title: chkWord
      * @Description: 检查是否有敏感单词
      * @author yangch
      * @date 2014-12-17 
      * @param word
      * @return 如果有敏感单词返回true 否则返回false
      * @throws
     */
    private boolean chkWord(String word){
        if(null != word && !"".equals(word)){
            word = word.trim().toLowerCase();
            if(word.indexOf("select") > -1 ||word.indexOf("insert") > -1 ||word.indexOf("update") > -1 ||word.indexOf("create") > -1 ||word.indexOf("truncate") > -1){
                return true;
            }
        }
        return false;
    }
}
