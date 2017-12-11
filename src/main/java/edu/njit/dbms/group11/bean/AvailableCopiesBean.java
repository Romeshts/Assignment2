package edu.njit.dbms.group11.bean;

public class AvailableCopiesBean {

	private String branchName;
	private int branchId;
	private int docId;
	private String docTitle;
	private int copyNo;
	private String copyPosition;

	public AvailableCopiesBean () {
        super();
    }

	public String getBranchName () {
    	return branchName;
	}
	
    public void setBranchName (String branchName) {
	    this.branchName = branchName;
	}
    
    public int getBranchId () {
    	return branchId;
	}
	
    public void setBranchId (int branchId) {
	    this.branchId = branchId;
	}
    
    public int getDocId () {
    	return docId;
	}
	
    public void setDocId (int docId) {
	    this.docId = docId;
	}
    
    public String getDocTitle () {
    	return docTitle;
	}
	
    public void setDocTitle (String docTitle) {
	    this.docTitle = docTitle;
	}
    
    public int getCopyNo () {
    	return copyNo;
	}
	
    public void setCopyNo (int copyNo) {
	    this.copyNo = copyNo;
	}
    
    public String getCopyPosition () {
    	return copyPosition;
	}
	
    public void setCopyPosition (String copyPosition) {
	    this.copyPosition = copyPosition;
	}
}