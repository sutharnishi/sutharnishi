package com.project.dao;

import java.util.List;

import com.project.model.ComplaintVO;

public interface ComplaintDAO {

	void insertComplaint(ComplaintVO complaintVO);
	
	public List viewComplaint();

	List searchComplaint(ComplaintVO complaintVO);

	List seeComplaint(ComplaintVO complaintVO);

}
