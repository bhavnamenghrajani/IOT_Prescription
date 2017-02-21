/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Prescription;

import Business.Drug.Drug;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class DrugDosageTrack {

    private static int count = 0;
    private int drugDosageTrackId;

    private Drug drug;
    private ArrayList<FrequencyTrack> frequencyTrackList;

    public DrugDosages getDrugDosages() {
        return drugDosages;
    }

    public void setDrugDosages(DrugDosages drugDosages) {
        this.drugDosages = drugDosages;
    }

    private DrugDosages drugDosages;

    public DrugDosageTrack() {
        frequencyTrackList = new ArrayList<>();
        count++;
        drugDosageTrackId = count++;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public ArrayList<FrequencyTrack> getFrequencyTrackList() {
        return frequencyTrackList;
    }

    public void setFrequencyTrackList(ArrayList<FrequencyTrack> frequencyTrackList) {
        this.frequencyTrackList = frequencyTrackList;
    }

    public String toString() {
        return String.valueOf(drugDosageTrackId);
    }
}
