package model;

import java.util.Date;

/**
 * The Patient class represents a patient record in the system.
 */
public class Patient {
    private int patientId;
    private String name;
    private String contact;
    private String reason;
    private String disease;
    private Date visitDate;

    /**
     * Gets the patient ID.
     *
     * @return The patient ID
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Sets the patient ID.
     *
     * @param patientId The patient ID to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets the patient's name.
     *
     * @return The patient's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the patient's name.
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the patient's contact information.
     *
     * @return The patient's contact information
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the patient's contact information.
     *
     * @param contact The contact information to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Gets the reason for the patient's visit.
     *
     * @return The reason for the visit
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the reason for the patient's visit.
     *
     * @param reason The reason for the visit to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets the disease the patient is diagnosed with.
     *
     * @return The disease the patient is diagnosed with
     */
    public String getDisease() {
        return disease;
    }

    /**
     * Sets the disease the patient is diagnosed with.
     *
     * @param disease The disease to set
     */
    public void setDisease(String disease) {
        this.disease = disease;
    }

    /**
     * Gets the date of the patient's visit.
     *
     * @return The date of the visit
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * Sets the date of the patient's visit.
     *
     * @param visitDate The date of the visit to set
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * Constructs a new Patient object.
     *
     * @param patientId The patient ID
     * @param name      The patient's name
     * @param contact   The patient's contact information
     * @param reason    The reason for the visit
     * @param disease   The disease diagnosed
     * @param visitDate The date of the visit
     */
    public Patient(int patientId, String name, String contact, String reason, String disease, Date visitDate) {
        this.patientId = patientId;
        this.name = name;
        this.contact = contact;
        this.reason = reason;
        this.disease = disease;
        this.visitDate = visitDate;
    }

    /**
     * Returns a string representation of the Patient object.
     *
     * @return A string representation of the Patient object
     */
    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", name=" + name + ", contact=" + contact + ", reason=" + reason
                + ", disease=" + disease + ", visitDate=" + visitDate + "]\n";
    }
}
