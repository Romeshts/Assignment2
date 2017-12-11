package edu.njit.dbms.group11.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 
import edu.njit.dbms.group11.bean.AvailableCopiesBean;
 
public class AvailableCopiesService {

	static HashMap <Integer, AvailableCopiesBean> availableBooksMap = getAvailableBooksMap ();
	private static final String CONN_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String CONN_DB_URL = "jdbc:mysql://127.0.0.1:3306/group11_lms";
	private static final String CONN_USERNAME = "root";
	private static final String CONN_PASSWORD = "2017@Group11";

	public AvailableCopiesService () {
		super();
		//if (availableBooksMap == null)
        //{
			availableBooksMap = new HashMap <Integer, AvailableCopiesBean> ();
			Connection connection = null;
	    	Statement statement = null;
	    	try {
	    		Class.forName (CONN_JDBC_DRIVER);
	    		System.out.println("Connecting to mysql db...");
	    		connection = DriverManager.getConnection (CONN_DB_URL, CONN_USERNAME, CONN_PASSWORD);
	            System.out.println("Successfully connected to mysql db.");
	            statement = connection.createStatement ();
	            StringBuffer sql = new StringBuffer ();
	            sql.append ("SELECT BRANCH.NAME AS BRANCH_NAME, BRANCH.LIBID AS BRANCH_ID, DOC.DOCID AS DOC_ID, DOC.TITLE AS DOC_TITLE, ");
	            sql.append ("COPY.COPYNO AS COPY_NO, COPY.POSITION AS COPY_POSITION ");
	            sql.append ("FROM group11_lms.copy COPY, group11_lms.document DOC, group11_lms.branch BRANCH WHERE COPY.DOCID = DOC.DOCID and BRANCH.LIBID = COPY.LIBID;");
	            ResultSet rs = statement.executeQuery (sql.toString ());
	            int counter = 1;
	            while (rs.next ()) {
	            	AvailableCopiesBean copy = new AvailableCopiesBean ();
	            	String branchName = rs.getString ("BRANCH_NAME");
	            	int branchId = rs.getInt ("BRANCH_ID");
	            	int docId = rs.getInt ("DOC_ID");
	            	String docTitle = rs.getString("DOC_TITLE");
	            	int copyNo = rs.getInt ("COPY_NO");
	            	String copyPosition = rs.getString("COPY_POSITION");
	            	System.out.print ("RECORD --> branchName::" + branchName);
	            	System.out.print (", branchId: " + branchId);
	            	System.out.print (", docId: " + docId);
	            	System.out.print (", docTitle: " + docTitle);
	            	System.out.print (", copyNo: " + copyNo);
	            	System.out.println (", copyPosition: " + copyPosition);
	            	copy.setBranchName (branchName);
	            	copy.setBranchId (branchId);
	            	copy.setDocId (docId);
	            	copy.setDocTitle (docTitle);
	            	copy.setCopyNo (copyNo);
	            	copy.setCopyPosition (copyPosition);
	            	availableBooksMap.put (counter, copy);
	            	counter++;
	            }
	            rs.close();
	    	} catch (SQLException se) {
	    		se.printStackTrace ();
	    	} catch (Exception e) {
	    		e.printStackTrace ();
	    	} finally {
	    		try {
	    			if(statement != null)
	    				statement.close ();
	    		} catch (SQLException se) {}
	    		try {
	    			if (connection != null)
	    				connection.close ();
	    		} catch (SQLException se) {
	    			se.printStackTrace ();
	    		}
	    	}
        //}
	}
 
	public List getAllAvaiableBookCopies () {
		List availableBooksList = new ArrayList (availableBooksMap.values ());
		return availableBooksList;
	}
 
    public static HashMap <Integer, AvailableCopiesBean> getAvailableBooksMap () {
        return availableBooksMap;
    }
}