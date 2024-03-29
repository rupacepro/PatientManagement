package model;

import java.util.Date;

public class Patient {
	private int patientId;
	private String name;
	private String contact;
	private String reason;
	private String disease;
	private Date visitDate;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getReason() {
		return reason;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String desease) {
		this.disease = desease;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public Patient(int patientId, String name, String contact, String reason, String desease, Date visitDate) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.contact = contact;
		this.reason = reason;
		this.disease = desease;
		this.visitDate = visitDate;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", contact=" + contact + ", reason=" + reason
				+ ", desease=" + disease + ", visitDate=" + visitDate + "]\n";
	}
	
}
