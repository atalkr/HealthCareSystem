package com.capg.hcms.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.center.model.DiagnosticCenter;


public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Long>{
	
	public DiagnosticCenter getByCenterName(String centerName);
	public DiagnosticCenter getByCenterId(long centerId);

}
