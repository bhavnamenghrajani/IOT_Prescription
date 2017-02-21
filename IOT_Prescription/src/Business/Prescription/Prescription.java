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
public class Prescription {

    private static int count = 0;

    private ArrayList<DrugDosages> drugDosagesList;
    private int prescription_id;
    private String status;

    public int getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<DrugDosages> getDrugDosagesList() {
        return drugDosagesList;
    }

    public DrugDosages createDrugDosages() {
        DrugDosages dd = new DrugDosages();
        drugDosagesList.add(dd);
        return dd;

    }

    public void setDrugDosagesList(ArrayList<DrugDosages> drugDosagesList) {
        this.drugDosagesList = drugDosagesList;
    }

    public Prescription() {
        drugDosagesList = new ArrayList<>();
        count++;
        prescription_id = count;

    }

    @Override
    public String toString() {
        return String.valueOf(prescription_id);
    }

}
