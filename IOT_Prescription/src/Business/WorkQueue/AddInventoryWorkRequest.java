/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Drug.Drug;
import Business.Drug.DrugItem;
import com.db4o.collections.ActivatableArrayList;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class AddInventoryWorkRequest extends WorkRequest {

    private ArrayList<DrugItem> drugItemList;

    public ArrayList<DrugItem> getDrugItemList() {
        return drugItemList;
    }

    public void setDrugItemList(ArrayList<DrugItem> drugItemList) {
        this.drugItemList = drugItemList;
    }

    public AddInventoryWorkRequest() {
        drugItemList = new ArrayList<>();
    }

    public DrugItem addDrugItem() {
        DrugItem drugItem = new DrugItem();
        drugItemList.add(drugItem);
        return drugItem;
    }

}
