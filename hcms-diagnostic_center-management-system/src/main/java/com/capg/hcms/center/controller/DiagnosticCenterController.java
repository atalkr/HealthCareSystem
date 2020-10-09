package com.capg.hcms.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.center.model.DiagnosticCenter;
import com.capg.hcms.center.model.DiagnosticCenterList;
import com.capg.hcms.center.service.DiagnosticCenterService;

/**************************************************************************
 * @author      Divya 
 * Description  It is the controller class for center management
 * Created Date 07-Oct-2020
 **************************************************************************/

@RestController
@RequestMapping("/center")
public class DiagnosticCenterController {

	@Autowired
	private DiagnosticCenterService centerService;

	@GetMapping("/getallcenters")
	public DiagnosticCenterList getAllCenters() {
		return centerService.getAllCenters();
	}

	@GetMapping("/getcenter/center-id/{centerId}")
	public DiagnosticCenter getCenter(@PathVariable Long centerId) {
		return centerService.getCenterById(centerId);
	}

	@PostMapping("/addcenter")
	public DiagnosticCenter addCenter(@RequestBody DiagnosticCenter center) {
		return centerService.addCenter(center);
	}

	@DeleteMapping("/removecenter/center-id/{centerId}")
	public boolean removeCenter(@PathVariable Long centerId) {
		return centerService.removeCenter(getCenter(centerId));
	}

	@PutMapping("/updatecenter/{centerId}")
	public DiagnosticCenter updateCenter(@RequestBody DiagnosticCenter center, @PathVariable Long centerId) {
		return centerService.updateCenter(center, centerId);
	}

	@PutMapping("/assign-test/{centerId}/test-name/{testName}")
	public DiagnosticCenter assignTest(@PathVariable Long centerId, @PathVariable String testName) {
		return centerService.assignTest(centerId, testName);
	}

	@PutMapping("/remove-test/{centerId}/test-name/{testName}")
	public boolean removeTest(@PathVariable Long centerId, @PathVariable String testName) {
		return centerService.removeTest(centerId, testName);
	}

	@DeleteMapping("removeallcenters")
	public String removeAllCenters() {
		centerService.removeAllCenters();
		return "All Center Removed";
	}
}
