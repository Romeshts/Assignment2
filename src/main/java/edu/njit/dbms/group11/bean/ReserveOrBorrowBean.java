package edu.njit.dbms.group11.bean;

public class ReserveOrBorrowBean {

	private String branchName;
	private int branchId;
	private int docId;
	private String docTitle;
	private int copyNo;
	private int reserveId;
	private int borrowId;

	public int getReserveId () {
		return reserveId;
	}

	public void setReserveId (int reserveId) {
		this.reserveId = reserveId;
	}

	public int getBorrowId () {
		return borrowId;
	}

	public void setBorrowId (int borrowId) {
		this.borrowId = borrowId;
	}

	public ReserveOrBorrowBean () {
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
}