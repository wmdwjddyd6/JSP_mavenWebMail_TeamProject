/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat9
 * Generated at: 2021-06-01 12:12:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cse.maven_webmail.control.CommandType;
import java.sql.*;
import javax.servlet.*;

public final class write_005fmail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

    String ctx = request.getContextPath();    //콘텍스트명 얻어오기.

      out.write("\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n\r\n");
      out.write("\r\n\r\n\r\n<html>\r\n    <head>\r\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n        <title>메일 쓰기 화면</title>\r\n        \r\n        <!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->\r\n        <script type=\"text/javascript\" src=\"");
      out.print(ctx );
      out.write("/SE2/js/HuskyEZCreator.js\" charset=\"utf-8\"></script>\r\n        <!-- jQuery를 사용하기위해 jQuery라이브러리 추가 -->\r\n        <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.9.0.min.js\"></script>\r\n\r\n        <script type=\"text/javascript\">\r\n        var oEditors = [];\r\n        $(function(){\r\n              nhn.husky.EZCreator.createInIFrame({\r\n                  oAppRef: oEditors,\r\n                  elPlaceHolder: \"cont\", //textarea에서 지정한 id와 일치해야 합니다. \r\n                  //SmartEditor2Skin.html 파일이 존재하는 경로\r\n                  sSkinURI: \"/maven_webmail/SE2/SmartEditor2Skin.html\",  \r\n                  htParams : {\r\n                      // 툴바 사용 여부 (true:사용/ false:사용하지 않음)\r\n                      bUseToolbar : true,             \r\n                      // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)\r\n                      bUseVerticalResizer : false,     \r\n                      // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)\r\n                      bUseModeChanger : false,\r\n                      \r\n                      fOnBeforeUnload : function(){\r\n");
      out.write("                          \r\n              }\r\n                  },\r\n                  fCreator: \"createSEditor2\"\r\n              });\r\n\r\n              //버튼 클릭시 form 전송\r\n              $(\"#submit\").click(function(){\r\n                  oEditors.getById[\"cont\"].exec(\"UPDATE_CONTENTS_FIELD\", []);\r\n                  $(\"#main\").submit();\r\n              });    \r\n              $(\"#save\").click(function(){\r\n                  oEditors.getById[\"cont\"].exec(\"UPDATE_CONTENTS_FIELD\", []);\r\n                  $(\"#main\").submit();\r\n              });    \r\n        });\r\n        \r\n        function check_file_size(){\r\n            var size_limit = 50*1024*1024; //50MB\r\n            var oFiles = document.getElementById(\"input_file\").files;\r\n            var nFiles = oFiles.length;\r\n            var nBytes = 0;\r\n            for (var nFileId = 0; nFileId < nFiles; nFileId++) {\r\n                nBytes += oFiles[nFileId].size;\r\n            }\r\n            if( nBytes > size_limit){\r\n                alert('파일 크기가 50MB를 초과하여 전송을 할 수 없습니다.');\r\n                return false;\r\n");
      out.write("            }else{\r\n                return true;\r\n            }\r\n        }\r\n        </script>\r\n        \r\n        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/main_style.css\" />\r\n    </head>\r\n    <body>\r\n        ");

        String userid = (String) session.getAttribute("userid");
        final String JdbcDriver = "com.mysql.jdbc.Driver";
        String JdbcUrl = "jdbc:mysql://localhost:3306/webmail?useUnicode=true&characterEncoding=utf8";
        final String User = "jdbctester";
        final String Password = "0000";
        response.setContentType("text/html;charset=UTF-8");
        String DBemail = null;
        String DBtitle = null;
        String DBcont = null;

        try{
            Class.forName(JdbcDriver);
            Connection conn = DriverManager.getConnection(JdbcUrl, User, Password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM tempmail WHERE user='"+userid+"';";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                DBemail = rs.getString("email");
                DBtitle = rs.getString("title");
                DBcont = rs.getString("content");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            out.println("오류가 발생했습니다. (발생 오류: "+ ex.getMessage() + ")");
          }
        
      out.write("\r\n        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n\r\n        <div id=\"sidebar\">\r\n            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar_previous_menu.jsp", out, false);
      out.write("\r\n            \r\n        </div>\r\n            \r\n        <div id=\"main\">\r\n            <form id=\"frm\" enctype=\"multipart/form-data\" method=\"POST\" name=\"frm\"\r\n\r\n                  action=\"WriteMail.do?menu=");
      out.print( CommandType.SEND_MAIL_COMMAND);
      out.write("\" \r\n                  onsubmit =\"return check_file_size()\">\r\n                <table> <!-- 메일쓰기 폼 설정 -->\r\n\r\n                    ");

                        String to = request.getParameter("to") == null ? "" : request.getParameter("to");
                        String cc = request.getParameter("cc") == null ? "" : request.getParameter("cc");
                        String subj = request.getParameter("subj") == null ? "" : request.getParameter("subj");
                        String text = request.getParameter("text") == null ? "" : request.getParameter("text");
                        String temp = request.getParameter("temp") == null ? "" : request.getParameter("temp");
                        
      out.write("\r\n                        \r\n                    <tr>\r\n                        <td> 수신 </td>\r\n                        <td> <input type=\"text\" id=\"to\" name=\"to\" size=\"80\"\r\n                                    value=");
      out.print(to);
      out.write(">  </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>참조</td>\r\n                        <td> <input type=\"text\" id=\"cc\" name=\"cc\" size=\"80\" value=\"");
      out.print(cc);
      out.write("\">  </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td> 메일 제목 </td>\r\n                        <td> <input type=\"text\" id=\"subj\" name=\"subj\" size=\"80\" value=\"");
      out.print(subj);
      out.write("\">  </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td colspan=\"2\">본  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 문</td>\r\n                    </tr>\r\n                    <tr>  ");
      out.write("\r\n                        <td colspan=\"2\">\r\n                            <textarea rows=\"10\" cols=\"30\" id=\"cont\" name=\"body\" style=\"width:675px; height:350px; \" >");
      out.print(text);
      out.print(DBcont);
      out.write("</textarea>\r\n                        </td>\r\n                    </tr>\r\n                    <tr>\r\n                        <td>첨부 파일</td>\r\n                        <td> <input type=\"file\" name=\"file1\" id=\"input_file\" multiple size=\"80\" > \r\n                    </tr>\r\n                    <input type=\"text\" name=\"temp\" id=\"temp\" value=\"temp\" value=\"");
      out.print(temp);
      out.write("\" hidden>\r\n                    <tr>\r\n                        <td colspan=\"4\">\r\n                            <input type=\"submit\" id=\"submit\" value=\"메일 보내기\" onclick=\"sendSubmit()\">\r\n                            <input type=\"reset\" value=\"다시 입력\">\r\n                            <input type=\"submit\" id=\"save\" value=\"임시저장\" onclick=\"saveSubmit();\">\r\n                            <input type=\"button\" value=\"불러오기\" onclick=\"loadMail();\">\r\n                        </td>\r\n                    </tr>\r\n                </table>\r\n            </form>\r\n\r\n            <script type=\"text/javascript\">\r\n                var DBemail = \"");
      out.print(DBemail);
      out.write("\";\r\n                var DBtitle = \"");
      out.print(DBtitle);
      out.write("\";\r\n                var DBcontent = \"");
      out.print(DBcont);
      out.write("\";\r\n                var text = \"");
      out.print(text);
      out.write("\";\r\n                \r\n                function saveSubmit() {\r\n                    frm.action = \"temp_mail_save.jsp\";\r\n                    frm.encoding = \"application/x-www-form-urlencoded\";\r\n                    frm.submit();\r\n                }\r\n\r\n                function sendSubmit() {\r\n                    frm.action = \"WriteMail.do?menu=");
      out.print( CommandType.SEND_MAIL_COMMAND);
      out.write("\";\r\n                    frm.encoding = \"multipart/form-data\";\r\n                    frm.submit();\r\n                }\r\n                \r\n                function loadMail(){\r\n                    document.getElementById(\"to\").value = DBemail;\r\n                    document.getElementById(\"subj\").value = DBtitle;\r\n                    document.getElementById(\"cont\").value = DBcont;\r\n                    text = DBcontent;\r\n                    frm.submit();\r\n                }\r\n            </script>   \r\n        </div>\r\n                    \r\n                    \r\n        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
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
