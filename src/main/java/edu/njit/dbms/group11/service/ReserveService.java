package edu.njit.dbms.group11.service;

import edu.njit.dbms.group11.bean.ReserveOrBorrowBean;
 
public class ReserveService {

	public ReserveService () {
		super();
	}
 
	public ReserveOrBorrowBean reserveABook (ReserveOrBorrowBean reserveBean) {
		ReserveOrBorrowBean reserveOrBorrowBean = new ReserveOrBorrowBean ();
        return reserveOrBorrowBean;
	}
	
	public ReserveOrBorrowBean borrowABook (ReserveOrBorrowBean borrowBean) {
		ReserveOrBorrowBean reserveOrBorrowBean = new ReserveOrBorrowBean ();
        return reserveOrBorrowBean;
	}
}