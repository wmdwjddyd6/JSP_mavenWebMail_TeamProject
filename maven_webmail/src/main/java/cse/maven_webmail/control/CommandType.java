/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.maven_webmail.control;

public class CommandType {

    private CommandType() {
        // not called private constructor
    }
    public static final int READ_MENU = 1;
    public static final int WRITE_MENU = 2;

    public static final int ADD_USER_MENU = 3;
    public static final int DELETE_USER_MENU = 4;

    public static final int SEND_MAIL_COMMAND = 21;
    public static final int DELETE_MAIL_COMMAND = 41;
    public static final int DOWNLOAD_COMMAND = 51;

    public static final int ADD_USER_COMMAND = 61;
    public static final int DELETE_USER_COMMAND = 62;

    public static final int JOIN = 81;
    public static final int SECESSION = 82;

    public static final int LOGIN = 91;
    public static final int LOGOUT = 92;

    //휘정 : tag파일 DB에는 아직 사용전임. 후에 수정예정
    public static final String JdbcDriver = "com.mysql.cj.jdbc.Driver";
    public static final String JdbcUrl = "jdbc:mysql://localhost:3306/webmail?serverTime=Asia/Seoul";
    public static final String User = "jdbctester";
    public static final String Password = "1895";
}
