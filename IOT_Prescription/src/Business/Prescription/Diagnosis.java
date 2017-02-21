/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Prescription;

import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author Bhavna Menghrajani
 */
public class Diagnosis {

    private static int count = 0;

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }
    private Person doctor;

    public int getDiagnosis_Id() {
        return diagnosis_Id;
    }

    public void setDiagnosis_Id(int diagnosis_Id) {
        this.diagnosis_Id = diagnosis_Id;
    }
    private int diagnosis_Id;
    private Date startDate;
    private Prescription prescription;
    private String status;

    public Diagnosis() {
        prescription = new Prescription();
        count++;
        diagnosis_Id = count;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.valueOf(diagnosis_Id);
    }

}
