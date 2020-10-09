package com.capg.hcms.center.model;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**************************************************************************
 * @author       Divya
 * Description   It is the Entity class DiagnosticCenter for center
                 management
 * Created Date  06-Oct-2020
 **************************************************************************/

@Entity
@Table(name = "center_info")
public class DiagnosticCenter {

	@Id
	@GeneratedValue
	private long centerId;
	private String centerName;
	@ElementCollection
	private List<String> tests;
	private String contact;
	private String address;

	public DiagnosticCenter() {
		super();
	}

	public DiagnosticCenter(long centerId, String centerName, List<String> tests, String contact, String address) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.tests = tests;
		this.contact = contact;
		this.address = address;
	}

	public long getCenterId() {
		return centerId;
	}

	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<String> getTests() {
		return tests;
	}

	public void setTests(List<String> tests) {
		this.tests = tests;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", testId=" + tests
				+ ", Contact=" + contact + ", Address=" + address + "]";
	}

}
