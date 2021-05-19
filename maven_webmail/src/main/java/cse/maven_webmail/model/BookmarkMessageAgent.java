/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.maven_webmail.model;

import cse.maven_webmail.control.CommandType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gleyd
 */
public class BookmarkMessageAgent {


    private static BookmarkMessageAgent uniqueInstance = new BookmarkMessageAgent();
    private ArrayList<Integer> bookmarkMsgId = new ArrayList<Integer>();
    private String userid = null;

    private BookmarkMessageAgent() {
    }

    public static BookmarkMessageAgent getInstance() {
        return uniqueInstance;
    }

    public boolean addBookmarking(String userid, int msgid) {
        boolean status = false;
        String result = "";

        try {
            setEmail(userid);
            if (!bookmarkMsgId.contains(Integer.valueOf(msgid))) {
                bookmarkMsgId.add(msgid);
                result = insertBookmarkMsgID(msgid);
                status = true;

                System.out.println(result);

            }
        } catch (Exception ex) {
            System.out.println("BookmarkMessageAgent.addBookmarkMessage error : " + ex);
        } finally {
            return status;
        }
    }

    private String insertBookmarkMsgID(int msgid) {
        String result = null;

        try {
            Class.forName(CommandType.JdbcDriver);
            Connection conn = DriverManager.getConnection(CommandType.JdbcUrl, CommandType.JdbcUser, CommandType.JdbcPassword);

            String sql = "INSERT INTO `webmail`.`bookmark_list` (`email`, `msgid`) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (userid != null || !(userid.equals(""))) { //email 값이 null이 아니면.
                pstmt.setString(1, userid);
                pstmt.setInt(2, msgid);
            }
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
            //sql문 완성

        } catch (Exception ex) {
            result = "BookmarkMessageAgent.insertBookmarkMsgID error : " + ex;
        }

        return result;
    }

    public boolean cancelBookmarking(String userid, int msgid) {
        boolean status = false;
        String result = "";
        result +="try canceling Bookmarking";
        try {
            setEmail(userid);
            if (bookmarkMsgId.contains(Integer.valueOf(msgid))) {
                bookmarkMsgId.remove(Integer.valueOf(msgid));
                result = deleteBookmarkMsgID(msgid);
                status = true;

                System.out.println(result);
            }
        } catch (Exception ex) {
            System.out.println("BookmarkMessageAgent.cancelBookmarking error : " + ex);
        } finally {
            return status;
        }
    }

    private String deleteBookmarkMsgID(int msgid) {
        String result = null;            result += "\ntry deleteBookmarking" +Integer.toString(msgid);


        try {
            Class.forName(CommandType.JdbcDriver);
            Connection conn = DriverManager.getConnection(CommandType.JdbcUrl, CommandType.JdbcUser, CommandType.JdbcPassword);
            result += "\ntry deleteBookmarking";

            result += "\nBookmarkMessageAgent.deleteBookmarkMsgID email : " + userid;
            result += "\nBookmarkMessageAgent.deleteBookmarkMsgID msgid : " + Integer.toString(msgid);
            String sql = "DELETE FROM `webmail`.`bookmark_list` WHERE (`email` = ?) and (`msgid` = ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (userid != null || !(userid.equals(""))) { //email 값이 null이 아니면.
                if (userid != null || !(userid.equals(""))) { //email 값이 null이 아니면.
                    pstmt.setString(1, userid);
                    pstmt.setInt(2, msgid);
                }
                pstmt.executeUpdate();

                result += "\nBookmarkMessageAgent.deleteBookmarkMsgID email : " + userid;
                result += "\nBookmarkMessageAgent.deleteBookmarkMsgID msgid : " + Integer.toString(msgid);
                result += "\n end deleteBookmarking";

                pstmt.close();
                conn.close();
                //sql문 완성
            }
        } catch (Exception ex) {
            result = "BookmarkMessageAgent.deleteBookmarkMsgID error : " + ex;
        } finally {
            return result;
        }
    }

    private void setEmail(String email) {
        this.userid = email;
    }

    public ArrayList<Integer> getBookmarkMessageList(String userid) {
        bookmarkMsgId = null;
        bookmarkMsgId = new ArrayList<Integer>();
        setEmail(userid);
        System.out.println("BookmarkMessageAgent.getBookmarkMessageList : ");

        bookmarkMsgId = readBookmarkMsgData();
        return bookmarkMsgId;
    }

    private ArrayList<Integer> readBookmarkMsgData() {
        try {
            Class.forName(CommandType.JdbcDriver);
            Connection conn = DriverManager.getConnection(CommandType.JdbcUrl, CommandType.JdbcUser, CommandType.JdbcPassword);

            String sql = "select msgid from webmail.bookmark_list where email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { // ResultSet에 다음 값이 없을때까지 출력
                int buf_msgid = rs.getInt("msgid");	// 컬럼 값 받아오기
                bookmarkMsgId.add(buf_msgid);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception ex) {
            System.out.println("BookmarkMessageAgent.readBookmarkMsgData Error : " + ex);
        } finally {
            return bookmarkMsgId;
        }
    }

    public String showBookmarkingList() {
        String result = "";
        for (int list : bookmarkMsgId) {
            result += Integer.toString(list) + " ";
        }
        result += "<br><br><p> <a href=\"bookmarked_mail.jsp\"> 즐겨찾기함 </a> </p>";
        return result;
        /* test해볼것.
                StringBuffer str;
        for (int list : bookmarkMsgID) {
            str.append(Integer.toString(list) + " ");
        }
        str.append("<br><br><p> <a href=\"main_menu.jsp\"> 즐겨찾기함 </a> </p>");
        return str;
         */
    }
}

/*
    buffer.append(i + " : " +messages[i].getFlags().contains("bookmarked") +"<br>");
    
     //if (!(messages[i].getFlags().contains("bookmarked"))) {
    
                 Flags bookmarkFlag = new Flags("bookmarked");
            msg.setFlags(bookmarkFlag, true );
    
 */
 /*
    * TODO : bookmark할 flag설정
     
    public boolean bookmarkMessage(int msgid) {
        boolean status = false;

        if (!connectToStore()) {
            return status;
        }

        try {
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);

            Message msg = folder.getMessage(msgid);

            //set bookmark
            Flags bookmarkFlag = new Flags("bookmarked");
            msg.setFlags(bookmarkFlag, true);

            folder.close(true);  // expunge == true
            store.close();
            status = true;
        } catch (Exception ex) {
            System.out.println("bookmarkMessage() error: " + ex);
        } finally {
            return status;
        }
    }
 */
