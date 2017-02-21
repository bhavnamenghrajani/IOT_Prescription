/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Drug;

import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class DrugInventory {

	public ArrayList<DrugItem> getDrugInventory() {
		return drugInventoryList;
	}

	public void setDrugInventory(ArrayList<DrugItem> drugInventory) {
		this.drugInventoryList = drugInventory;
	}

	private ArrayList<DrugItem> drugInventoryList;

	public DrugInventory() {
		drugInventoryList = new ArrayList<>();
	}

	public DrugItem addDrugItem() {
		DrugItem drugItem = new DrugItem();
		drugInventoryList.add(drugItem);
		return drugItem;
	}

	public void removeDrugItem(DrugItem di) {
		drugInventoryList.remove(di);
	}

	public double searchDrugItem(int drugId) {
		double count = 0;
		for (DrugItem di : drugInventoryList) {
			if (di.getDrug().getDrugId() == drugId) {
				count = count + di.getQuantity();

			}
			return count;
		}
		return 0;

	}

}
