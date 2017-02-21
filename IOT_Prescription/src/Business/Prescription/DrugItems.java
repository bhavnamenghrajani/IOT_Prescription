/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Prescription;

import Business.Drug.Drug;
import Business.Drug.DrugItem;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class DrugItems {

    private int quantity;
    private int totalQuantity;
    private int actualQuantity;

    public DrugItem getDrugItem() {
        return drugItem;
    }

    public void setDrugItem(DrugItem drugItem) {
        this.drugItem = drugItem;
    }
    private DrugItem drugItem;

    public DrugItems() {
        drugItem = new DrugItem();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(int actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

}
