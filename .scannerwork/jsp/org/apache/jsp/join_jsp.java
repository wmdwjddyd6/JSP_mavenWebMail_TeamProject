/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2021-06-01 07:23:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cse.maven_webmail.control.CommandType;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer_kwang.jspf", Long.valueOf(1622466104517L));
    _jspx_dependants.put("/header.jspf", Long.valueOf(1622466104519L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("cse.maven_webmail.control.CommandType");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n\r\n\r\n<!DOCTYPE html>\r\n\r\n\r\n<html lang=\"en\" xml:lang=\"en\">\r\n    <head>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n        <title>회원가입</title>\r\n        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/main_style.css\" />\r\n    </head>\r\n    <body>\r\n        ");
      out.write("\r\n\r\n\r\n\r\n<div id=\"login_header\">\r\n    웹메일 시스템 <br />\r\n    (");
      out.print( session.getAttribute("host"));
      out.write(")\r\n</div>\r\n");
      out.write(" <br>\r\n        <div class=\"join_form\">\r\n            <div id=\"join\">\r\n                <form  action=\"UserAdmin.do?menu=");
      out.print( CommandType.JOIN);
      out.write("\" method=\"POST\"> \r\n                    <table border=\"0\" align=\"left\">\r\n                        <caption> User 회원가입 </caption>\r\n                        <tr>\r\n                            <th colspan=\"2\">정보입력</th>\r\n                        </tr>\r\n                        <tr>\r\n                            <td>ID</td>\r\n                            <td> <input type=\"text\" name=\"userid\" maxlength=\"20\"/>  </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td>암호</td>\r\n                            <td> <input type=\"password\" name=\"password\" maxlength=\"20\"/> </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td>암호 확인</td>\r\n                            <td> <input type=\"password\" name=\"password_check\" maxlength=\"20\"/> </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td>이름</td>\r\n                            <td> <input type=\"text\" name=\"username\"/> </td>\r\n                        </tr>\r\n                        <tr>\r\n");
      out.write("                            <td>생일</td>\r\n                            <td> <input type=\"text\" name=\"birth\" maxlength=\"8\"/> </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td>전화번호</td>\r\n                            <td> <input type=\"text\" name=\"phone\" maxlength=\"16\"/> </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td colspan=\"2\">\r\n                                <input type=\"submit\" value=\"저장\" name=\"register\"/>&nbsp;&nbsp;&nbsp;\r\n                                <input type=\"button\" value=\"나가기\" onClick=\"location.href = '");
      out.print( getServletContext().getInitParameter("HomeDirectory"));
      out.write("'\"/>\r\n                            </td>\r\n                        </tr>\r\n                    </table>\r\n                </form>\r\n            </div>\r\n            <div id=\"constraint_text\">\r\n                <span style=\"color:red\">* 다음의 형식으로 입력하세요.</span> <br>\r\n                &nbsp;&nbsp;ID: 5자 이상 <br>\r\n                &nbsp;&nbsp;암호: 6자 이상 <br>\r\n                &nbsp;&nbsp;생일: 예)900202 <br>\r\n                &nbsp;&nbsp;전화번호: 010-xxxx-xxxx <br> <br>\r\n            </div>\r\n        </div>\r\n\r\n        ");
      out.write("\r\n\r\n\r\n\r\n<div id=\"footer\">\r\n    &copy; 2021, Student Kwang Min Kim <br />\r\n    Dept. of Computer Software Engineering, Dong-eui University <br />\r\n    WebMail System\r\n</div>\r\n");
      out.write("\r\n    </body>\r\n</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
