package edu.njit.dbms.group11.bean;

public class LoginBean {

	private String userName;
	private String password;
	private int checkAdmin;
	private int id;
	
	public LoginBean () {
        super();
    }

    public LoginBean (String userName, String password, int checkAdmin, int id) {
   	    super ();
   	    this.userName = userName;
   	    this.password = password;
   	    this.checkAdmin = checkAdmin;
   	    this.id = id;
    }

	public String getUserName () {
    	return userName;
	}
	
    public void setUserName (String userName) {
	    this.userName = userName;
	}
    
    public String getPassword () {
    	return password;
	}
	
    public void setPassword (String password) {
	    this.password = password;
	}
    
    public int getCheckAdmin () {
    	return checkAdmin;
	}
	
    public void setCheckAdmin (int checkAdmin) {
	    this.checkAdmin = checkAdmin;
	}
    
    public int getId () {
    	return id;
	}
	
    public void setId (int id) {
	    this.id = id;
	}
    
    /*@Override
	public String toString () {
		return "LoginBean [id=" + id + ", userName=" + userName + ", password=" + password + ", checkAdmin=" + checkAdmin + "]";
    }*/
}