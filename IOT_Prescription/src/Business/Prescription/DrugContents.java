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
public class DrugContents {

    public ArrayList<DrugItems> getDrugItemList() {
        return drugItemList;
    }

    public void setDrugItemList(ArrayList<DrugItems> drugItemList) {
        this.drugItemList = drugItemList;
    }

    public DrugItems createDrugItems() {
        DrugItems drugItems = new DrugItems();
        drugItemList.add(drugItems);
        return drugItems;

    }

    private ArrayList<DrugItems> drugItemList;

    public DrugContents() {
        drugItemList = new ArrayList<>();

    }

}
