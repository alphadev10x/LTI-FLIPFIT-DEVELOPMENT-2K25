package com.flipfit.constants;

public class JPQLConstant {
	
	public static final String JPQL_UPDATEOWNERAPPROVAL ="UPDATE GYMOWNER SET ISAPPROVED = true WHERE userid = ?1";
	public static final String JPQL_UPDATECENTERAPPROVAL="UPDATE GYMCENTER SET IS_APPROVED = true WHERE centerid = ?1";
	public static final String JPQL_UNAPPROVEDOWNER ="SELECT * FROM gymowner WHERE isapproved = false";	
	public static final String JPQL_UNAPPROVEDCENTER ="SELECT * FROM gymcenter WHERE is_approved = false";

}
