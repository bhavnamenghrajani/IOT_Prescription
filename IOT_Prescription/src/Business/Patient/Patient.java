/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Person.Person;
import Business.Prescription.Diagnosis;
import Business.Prescription.DiagnosisHistory;
import Business.Prescription.DrugContents;
import Business.Prescription.PrescriptionTrackHistory;

/**
 *
 * @author Bhavna Menghrajani
 */
public class Patient extends Person {

    private DiagnosisHistory diagnosisHistory;
    private DrugContents drugContents;
    private PrescriptionTrackHistory prescriptionTrackHistory;

    public Patient() {
        diagnosisHistory = new DiagnosisHistory();
        drugContents = new DrugContents();
        prescriptionTrackHistory = new PrescriptionTrackHistory();

    }

    public DiagnosisHistory getDiagnosisHistory() {
        return diagnosisHistory;
    }

    public void setDiagnosisHistory(DiagnosisHistory diagnosisHistory) {
        this.diagnosisHistory = diagnosisHistory;
    }

    public DrugContents getDrugContents() {
        return drugContents;
    }

    public void setDrugContents(DrugContents drugContents) {
        this.drugContents = drugContents;
    }

    public PrescriptionTrackHistory getPrescriptionTrackHistory() {
        return prescriptionTrackHistory;
    }

    public void setPrescriptionTrackHistory(PrescriptionTrackHistory prescriptionTrackHistory) {
        this.prescriptionTrackHistory = prescriptionTrackHistory;
    }

}
