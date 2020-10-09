package com.capg.hcms.center.service;

import com.capg.hcms.center.model.DiagnosticCenter;
import com.capg.hcms.center.model.DiagnosticCenterList;


public interface DiagnosticCenterService {

	DiagnosticCenterList getAllCenters();

	DiagnosticCenter addCenter(DiagnosticCenter center);
	
	DiagnosticCenter getCenterById(Long centerId);
    
	DiagnosticCenter assignTest(Long centerId,String testId);
		
	boolean removeTest(Long centerId,String testId);
	
	boolean removeAllCenters();
	
	boolean removeCenter(DiagnosticCenter center);

	DiagnosticCenter updateCenter(DiagnosticCenter center, Long centerId);
}
