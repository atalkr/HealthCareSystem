package com.capg.hcms.center.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.center.exception.CenterListIsEmptyException;
import com.capg.hcms.center.exception.CenterNameAlreadyExistException;
import com.capg.hcms.center.exception.CenterNotFoundException;
import com.capg.hcms.center.exception.TestNameAlreadyExistException;
import com.capg.hcms.center.model.DiagnosticCenter;
import com.capg.hcms.center.model.DiagnosticCenterList;
import com.capg.hcms.center.repository.DiagnosticCenterRepository;

/**************************************************************************
 * @author        Divya
 * Description    It is the service class for center management
 * Created Date   07-Oct-2020
 **************************************************************************/


@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService {

    @Autowired
	private DiagnosticCenterRepository centerRepo;
	
	
    /*******************************************************************************************************************************
	-Function Name            :     getAllCenters
	-Input Parameters         :     -
	-Return Type              :     List of centers
	-Throws                   :     CenterListIsEmptyException
	-Author                   :     Divya
	-Created/Modified Date    :     07-10-2020
	-Description              :     getting all centers from the database calls the method getAllCenters()
	*******************************************************************************************************************************/

	
	@Override
	public DiagnosticCenterList getAllCenters() {
		
		if(centerRepo.findAll().isEmpty()) {
			throw new CenterListIsEmptyException("CenterList Is Empty");
		}
		
		return new DiagnosticCenterList(centerRepo.findAll());
	}
	
	
	 /*******************************************************************************************************************************
		-Function Name            :     addCenter
		-Input Parameters         :     Center object
		-Return Type              :     added center object
		-Throws                   :     CenterNameAlreadyExistException
		-Author                   :     Divya
		-Created/Modified Date    :     07-10-2020
		-Description              :     adding Center to the Center Database Table using Spring Data
		*******************************************************************************************************************************/

	
	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center) {
		
		if(centerRepo.getByCenterName(center.getCenterName())!=null) {
			throw new CenterNameAlreadyExistException("Center with Name"+center.getCenterName()+" Already Exist");
		
		}
		List<String> test=  new ArrayList<String>() {{
			add("Blood Group");
			add("Blood Sugar");
			add("Blood pressure");
		}};
		center.setTests(test);
		return centerRepo.save(center);
	}
	
	
    /*******************************************************************************************************************************
    -Function Name            :     removeCenter
    -Input Parameters         :     Center Object
    -Return Type              :     boolean
    -Throws                   :     CenterNotFoundException
    -Author                   :     Divya
    -Created/Modified Date    :     07-10-2020
    -Description              :     removing center to the database calls the method removeCenter(center)
    *******************************************************************************************************************************/
    

	@Override
	public boolean removeCenter(DiagnosticCenter center) {
		
		if(!centerRepo.existsById(center.getCenterId()))
 			throw new CenterNotFoundException("Center with Id :" + center.getCenterId()+" is Not Found");
		
		centerRepo.delete(center);
		
		return !centerRepo.existsById(center.getCenterId());
	}
	
	
	/*******************************************************************************************************************************
	-Function Name            :     getCenterById
	-Input Parameters         :     centerId
	-Return Type              :     center object
	-Throws                   :     centerNotFoundException
	-Author                   :     Divya
	-Created/Modified Date    :     07-10-2020
	-Description              :     getting a center from the database calls the method getCenterById(centerId)
	*******************************************************************************************************************************/

	@Override
	public DiagnosticCenter getCenterById(Long centerId) {
	
		if(!centerRepo.existsById(centerId))
 			throw new CenterNotFoundException("Center with Id :" + centerId+" is Not Found");
		
		return centerRepo.getOne(centerId);
	}
	
	
	/*******************************************************************************************************************************
	-Function Name            :     updateCenter
	-Input Parameters         :     Center obejct, centerId
	-Return Type              :     center object
	-Throws                   :     centerNotFoundException
	-Author                   :     Divya
	-Created/Modified Date    :     07-10-2020
	-Description              :     update a center from the database calls the method updateCenter(center,centerId)
	*******************************************************************************************************************************/

		@Override
		public DiagnosticCenter updateCenter(DiagnosticCenter center, Long centerId) {
		
			if(!centerRepo.existsById(centerId))
	 			throw new CenterNotFoundException("Center with Id :" + centerId+" is Not Found");
			center.setCenterId(centerId);
			return centerRepo.save(center);
		}
	
		/*******************************************************************************************************************************
		-Function Name            :     assignTestId
		-Input Parameters         :     centerId, testName
		-Return Type              :     center object
		-Throws                   :     TestNameAlreadyExistException
		-Author                   :     Divya
		-Created/Modified Date    :     07-10-2020
		-Description              :     adding testId Into tests Property of DiagnosticCenter of particular centerId
		*******************************************************************************************************************************/

	@Override
	public DiagnosticCenter assignTest(Long centerId, String testName) {
		
		if(centerRepo.getOne(centerId).getTests().contains(testName))
			throw new TestNameAlreadyExistException("Tes with Name "+testName+" Already Exist");
		
		DiagnosticCenter center=centerRepo.getOne(centerId);
		
		center.getTests().add(testName);
		
		return centerRepo.save(center);
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     removeTestId
	-Input Parameters         :     centerId, testName
	-Return Type              :     center object
	-Throws                   :     -
	-Author                   :     Divya
	-Created/Modified Date    :     07-10-2020
	-Description              :     removing testId Into tests Property of DiagnosticCenter of particular centerId
	*******************************************************************************************************************************/

	@Override
	public boolean removeTest(Long centerId, String testName) {
		
		DiagnosticCenter center=centerRepo.getOne(centerId);
		center.getTests().remove(testName);
		centerRepo.save(center);
		return true;
	}
	
	 /*******************************************************************************************************************************
		-Function Name            :     removeAllCenters
		-Input Parameters         :     -
		-Return Type              :     boolean
		-Throws                   :     -
		-Author                   :     Divya
		-Created/Modified Date    :     07-10-2020
		-Description              :     deleting all centers from the database calls the method removeAllCenters()
		*******************************************************************************************************************************/

	
	@Override
	public boolean removeAllCenters() {
		
		centerRepo.deleteAll();
		
		return true;
	}
	
	
}
