/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Prescription;

import java.util.Date;

/**
 *
 * @author Bhavna Menghrajani
 */
public class FrequencyTrack {

    private Date dateDrugTaken;
    private Frequency frequency;

    public FrequencyTrack() {
        frequency = new Frequency();
    }

    public Date getDateDrugTaken() {
        return dateDrugTaken;
    }

    public void setDateDrugTaken(Date dateDrugTaken) {
        this.dateDrugTaken = dateDrugTaken;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

}
