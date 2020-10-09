package com.capg.hcms.center;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.capg.hcms.center.exception.CenterNotFoundException;
import com.capg.hcms.center.model.DiagnosticCenter;
import com.capg.hcms.center.repository.DiagnosticCenterRepository;
import com.capg.hcms.center.service.DiagnosticCenterServiceImpl;

/**************************************************************************
 * @author        Divya
 * Description    It is the test class for testing methods of center management service class
 * Created Date   07-Oct-2020
 **************************************************************************/


@SpringBootTest
class HcmsDiagnosticCenterApplicationTests {
    
	@Autowired
	DiagnosticCenterRepository repo;
	
	@Autowired
	DiagnosticCenterServiceImpl service;
	DiagnosticCenter center1;
	DiagnosticCenter center2;
	DiagnosticCenter center3;
	
	@BeforeEach
	public void init()
	{
		List<String> tests=new ArrayList<String>();		
		center1=new DiagnosticCenter(10,"Fortis Hostipal",tests,null,null);
		center2=new DiagnosticCenter(4,"Amu CLinic",null,null,null);
		}
	
	@Test
	public void testAddCenter()
	{
		service.addCenter(center1);
		assertEquals(true,repo.getByCenterName("Fortis' Hostipal")!=null);
	}
	
	@Test
	public void testRemoveCenter()
	{
		service.removeCenter(center2);
		assertEquals(false,repo.getByCenterName("Amu Clinic")!=null);
	}
	

	@Test
	public void testRemoveCenterException() {
		 Assertions.assertThrows(CenterNotFoundException.class, () -> {
		      service.removeCenter(center2);
		    });
	}
	
}
