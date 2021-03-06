/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.maven_webmail.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cse.maven_webmail.model.Pop3Agent;
import cse.maven_webmail.model.BookmarkMessageAgent;
import cse.maven_webmail.model.SpamMessageAgent;
import cse.maven_webmail.model.VinMessageHandler;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;

/**
 *
 * @author jongmin
 */
public class ReadMailHandler extends HttpServlet {

    private BookmarkMessageAgent bookmarkMessageAgent = BookmarkMessageAgent.getInstance();
    private SpamMessageAgent spamMessageAgent = SpamMessageAgent.getInstance();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        int select = Integer.parseInt((String) request.getParameter("menu"));
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");

        switch (select) {
            case CommandType.DELETE_MAIL_COMMAND_IN_BOOKMARK:
                try (PrintWriter out = response.getWriter()) {
                deleteMessage(request);
                int msgid = Integer.parseInt(request.getParameter("msgid"));

                boolean isSuccess = bookmarkMessageAgent.removeMessage(msgid);
                if (isSuccess) {
                    out.println("<script>alert('???????????? ???????????? ?????????????????????.');location.href='bookmarked_mail.jsp'</script>");
                    bookmarkMessageAgent.updateMsgId(msgid);
                    spamMessageAgent.removeMessage(msgid);
                    spamMessageAgent.updateMsgId(msgid);
                } else {
                    out.println("<script>alert('???????????? ????????? ????????? ??????????????????.');location.href='bookmarked_mail.jsp'</script>");
                }
            }
            break;
            case CommandType.DELETE_MAIL_COMMAND_IN_SPAM:
                try (PrintWriter out = response.getWriter()) {
                deleteMessage(request);
                spamMessageAgent.setNeedUpdate(true);

                int msgid = Integer.parseInt(request.getParameter("msgid"));

                boolean isSuccess = spamMessageAgent.removeMessage(msgid);
                if (isSuccess) {
                    out.println("<script>alert('?????? ???????????? ?????????????????????.');location.href='spam_mail_list.jsp'</script>");
                    spamMessageAgent.updateMsgId(msgid);
                    bookmarkMessageAgent.removeMessage(msgid);
                    bookmarkMessageAgent.updateMsgId(msgid);
                } else {
                    out.println("<script>alert('?????? ????????? ????????? ??????????????????.');location.href='spam_mail_list.jsp'</script>");
                }
            }
            break;
            //-------------
            case CommandType.MAIL_REMOVE_COMMAND: //?????? ?????? ????????? ???????????? ->?????????
                try (PrintWriter out = response.getWriter()) {
                moveMsgBin(request);
                response.sendRedirect("main_menu.jsp"); //?????? ??? ???????????? ??????
            }
            break;
            case CommandType.VIN_DBDELETE_COMMAND: //??????????????? ??????????????? ???????????????????????? ?????? ??????
                try (PrintWriter out = response.getWriter()) {
                System.out.println("VIN_DBDELETE_COMMAND ON");
                deleteInDBMessage(request);
                response.sendRedirect("trash_can.jsp"); //?????? ??? ???????????? ??????
            }
            break;

            case CommandType.DOWNLOAD_COMMAND: // ?????? ???????????? ??????
                download(request, response);
                break;

            case CommandType.SET_BOOKMARK: // ???????????????
                try (PrintWriter out = response.getWriter()) {
                int msgid = Integer.parseInt((String) request.getParameter("msgid"));
                if (bookmarkMessageAgent.addMessage(msgid)) {
                    //bookmarking ??????
                    out.println(/*"userid : "+userid+"???, "+msgid+"??? ??????*/"<script>alert('????????? ????????? ???????????????.');location.href='main_menu.jsp'</script>");
                } else {
                    out.println("<script>alert('????????? ????????? ??????????????????.');location.href='main_menu.jsp'</script>");
                }
            } catch (Exception ex) {
                PrintWriter out = response.getWriter();
                out.println("ReadmailHandler.cancelBookmarking error : " + ex);
            }
            break;
            case CommandType.CANCLE_BOOKMARK: // ???????????????
                try (PrintWriter out = response.getWriter()) {
                int msgid = Integer.parseInt((String) request.getParameter("msgid"));
                System.out.println("request.getParameter msgid  : " + Integer.toString(msgid));
                if (bookmarkMessageAgent.removeMessage(msgid)) {
                    //bookmarking ??????
                    out.println("<script>alert('????????? ????????? ?????????????????????.');location.href='bookmarked_mail.jsp'</script>");
                } else {
                    out.println("<script>alert('????????? ????????? ??????????????????.');location.href='bookmarked_mail.jsp'</script>");
                }
            } catch (Exception ex) {
                PrintWriter out = response.getWriter();
                out.println("ReadmailHandler.cancelBookmarking error : " + ex);
            }
            break;
            default:
                try (PrintWriter out = response.getWriter()) {
                out.println("?????? ????????? ?????????????????????. ????????? ??? ?????? ???????????????????");
            }
            break;

        }
    }

    private void download(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/octet-stream");

        ServletOutputStream sos = null;

        try {
            request.setCharacterEncoding("UTF-8");
            // LJM 041203 - ????????? ?????? ?????? ??????????????? ????????? ???????????? ??? ????????????.
            String fileName = request.getParameter("filename");
            
            System.out.println(">>>>>> ReadMailHandler.download : file name = " + fileName);

            String userid = request.getParameter("userid");
            //String fileName = URLDecoder.decode(request.getParameter("filename"), "utf-8");

            // download??? ?????? ??????
            // ???????????? ?????? ?????????
            String downloadDir = request.getServletContext().getRealPath("/WEB-INF")
                    + File.separator + "download";
            File f = new File(downloadDir);
            if (!f.exists()) {
                f.mkdir();
            }

            response.setHeader("Content-Disposition", "attachment; filename=\""+  URLEncoder.encode(fileName, "UTF-8") + "\"");
            
            File file = new File(downloadDir + File.separator + userid + File.separator + fileName);
            byte[] b = new byte[(int) file.length()];
            // try-with-resource ?????? fis??? ??????????????? close??? ?????? ????????? ???.
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = fis.read(b)) > 0) {
                    // fis.read(b);
                }
            };

            // ????????????
            sos = response.getOutputStream();
            sos.write(b);
            sos.flush();
            sos.close();
        } catch (Exception ex) {
            System.out.println("====== DOWNLOAD exception : " + ex);
        }
    }

    private boolean deleteMessage(HttpServletRequest request) {
        int msgid = Integer.parseInt((String) request.getParameter("msgid"));

        HttpSession httpSession = request.getSession();
        String host = (String) httpSession.getAttribute("host");
        String userid = (String) httpSession.getAttribute("userid");
        String password = (String) httpSession.getAttribute("password");

        //System.out.println();
        Pop3Agent pop3 = new Pop3Agent(host, userid, password);
        boolean status = pop3.deleteMessage(msgid, true);
        return status;
    }

    //----------------------------------------
    // ????????? ????????? ????????? ???????????????????????? ??????
    //void->boolean?????? ????????????
    private String moveMsgBin(HttpServletRequest request) {

        int msgid = Integer.parseInt((String) request.getParameter("msgid"));

        HttpSession httpSession = request.getSession();
        String host = (String) httpSession.getAttribute("host");
        String userid = (String) httpSession.getAttribute("userid");
        String password = (String) httpSession.getAttribute("password");

        Pop3Agent pop3 = new Pop3Agent(host, userid, password);
        Message binMessage = pop3.Go_to_trash(msgid);
        System.out.println(pop3.checkMsgAlive(binMessage));
        return pop3.checkMsgAlive(binMessage);
        //return newMsg;

    }

    private boolean deleteInDBMessage(HttpServletRequest request) {
        boolean status = false;
        try {
            System.out.println("delete_inDBMessage ON");
            HttpSession httpSession = request.getSession();
            String sendperson = request.getParameter("sendPerson");
            String mtitle = request.getParameter("mTitle");
            VinMessageHandler vinMessageHandler = new VinMessageHandler(sendperson, mtitle);

            boolean vinStatus = vinMessageHandler.deleteVinMessage(sendperson, mtitle);
            if (vinStatus) {
                status = true;
            }
            return status;
        } catch (Exception ex) {
            System.out.println("delete_inDBMessage ON Exception " + ex);
        }
        return status;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReadMailHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadMailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReadMailHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadMailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
