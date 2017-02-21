/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Drug.DrugItem;
import Business.Prescription.DrugDosages;
import Business.Prescription.Prescription;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class AddDrugWorkRequest extends WorkRequest {

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    private Prescription prescription;

    private ArrayList<DrugDosages> drugDosageList;

    public ArrayList<DrugItem> getDrugItemList() {
        return drugItemList;
    }

    public void setDrugItemList(ArrayList<DrugItem> drugItemList) {
        this.drugItemList = drugItemList;
    }
    private ArrayList<DrugItem> drugItemList;

    public ArrayList<DrugDosages> getDrugDosageList() {
        return drugDosageList;
    }

    public void setDrugDosageList(ArrayList<DrugDosages> drugDosageList) {
        this.drugDosageList = drugDosageList;
    }

    public DrugItem createDrugItem() {
        DrugItem drugItem = new DrugItem();
        drugItemList.add(drugItem);
        return drugItem;

    }

    public AddDrugWorkRequest() {
        drugDosageList = new ArrayList<>();
        drugItemList = new ArrayList<>();

    }

}
