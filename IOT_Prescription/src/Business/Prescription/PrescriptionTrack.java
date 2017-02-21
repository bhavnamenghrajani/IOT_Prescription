/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Prescription;

import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class PrescriptionTrack {

    private static int count = 1;
    private int prescriptionTrackId;

    private Prescription prescription;
    private ArrayList<DrugDosageTrack> drugDosageTrackList;

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public ArrayList<DrugDosageTrack> getDrugDosageTrackList() {
        return drugDosageTrackList;
    }

    public void setDrugDosageTrackList(ArrayList<DrugDosageTrack> drugDosageTrackList) {
        this.drugDosageTrackList = drugDosageTrackList;
    }

    public PrescriptionTrack() {
        drugDosageTrackList = new ArrayList<>();
        prescriptionTrackId = count++;
    }

    @Override
    public String toString() {
        return String.valueOf(prescriptionTrackId);
    }

}
