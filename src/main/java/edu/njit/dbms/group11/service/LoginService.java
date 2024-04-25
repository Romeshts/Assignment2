package edu.njit.dbms.group11.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import edu.njit.dbms.group11.bean.LoginBean;
 
public class LoginService {
	
	private static final String CONN_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String CONN_DB_URL = "jdbc:mysql://127.0.0.1:3306/group11_lms";
	private static final String CONN_USERNAME = "root";
	private static final String CONN_PASSWORD = "";

	public LoginService () {
		super();
	}
 
    public int doLoginAndReturnDetails (LoginBean loginBean) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean isValidUser = false;
        int id = -1;
        try {
    	    Class.forName (CONN_JDBC_DRIVER);
    	    connection = DriverManager.getConnection (CONN_DB_URL, CONN_USERNAME, CONN_PASSWORD);
            String sqlLogin = new String ();
            if (loginBean != null) {
            	if (loginBean.getCheckAdmin () == 1) {
            		sqlLogin = "SELECT ADMINID FROM group11_lms.administrator WHERE ADMINNAME = ? AND PASSWORD = ?";
            	} else {
            		sqlLogin = "SELECT READERID FROM group11_lms.reader WHERE READUSERNAME = ? AND READPASSWORD = ?";
            	}
            }
            preparedStatement = connection.prepareStatement (sqlLogin);
            preparedStatement.setString (1, loginBean.getUserName ().trim ());
            preparedStatement.setString (2, loginBean.getPassword ().trim ());
            ResultSet rs = preparedStatement.executeQuery ();
            if (rs.next ()) {
            	isValidUser = true;
            	if (loginBean != null) {
            		if (loginBean.getCheckAdmin () == 1) {
            			id = rs.getInt ("ADMINID");
            		} else {
            			id = rs.getInt ("READERID");
            		}
            	}
            	//loginBean.setId (id);
            }
            System.out.println ("isValidUser::" + isValidUser);
            System.out.println ("id::" + id);
            rs.close();
    	} catch (SQLException se) {
    		se.printStackTrace ();
    	} catch (Exception e) {
    		e.printStackTrace ();
    	} finally {
    		try {
    			if(preparedStatement != null) {
                    preparedStatement.close ();
    			}
    		} catch (SQLException se) {}
    		try {
    			if (connection != null) {
                    connection.close ();
    			}
    		} catch (SQLException se) {
    			se.printStackTrace ();
    		}
    	}
    	return id;
    }
}