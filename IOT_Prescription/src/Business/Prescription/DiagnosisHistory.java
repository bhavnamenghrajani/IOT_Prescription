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
public class DiagnosisHistory {

    public ArrayList<Diagnosis> getDiagnosisHistoryList() {
        return diagnosisHistoryList;
    }

    public Diagnosis createDiagnosis() {
        Diagnosis d = new Diagnosis();
        diagnosisHistoryList.add(d);
        return d;
    }

    public void setDiagnosisHistoryList(ArrayList<Diagnosis> diagnosisHistoryList) {
        this.diagnosisHistoryList = diagnosisHistoryList;
    }

    private ArrayList<Diagnosis> diagnosisHistoryList;

    public DiagnosisHistory() {
        diagnosisHistoryList = new ArrayList<>();

    }

}
