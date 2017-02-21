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
public class PrescriptionTrackHistory {

    private ArrayList<PrescriptionTrack> prescriptionTrack;

    public ArrayList<PrescriptionTrack> getPrescriptionTrack() {
        return prescriptionTrack;
    }

    public void setPrescriptionTrack(ArrayList<PrescriptionTrack> prescriptionTrack) {
        this.prescriptionTrack = prescriptionTrack;
    }

    public PrescriptionTrackHistory() {
        prescriptionTrack = new ArrayList<>();
    }

    public PrescriptionTrack createPrescriptionTrack() {
        PrescriptionTrack pt = new PrescriptionTrack();
        prescriptionTrack.add(pt);
        return pt;
    }

}
