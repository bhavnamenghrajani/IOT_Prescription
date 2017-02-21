/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Drug;

import Business.Network.Network;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class DrugCatalog {

	public ArrayList<Drug> getDrugCatalog() {
		return drugCatalog;
	}

	public void setDrugCatalog(ArrayList<Drug> drugCatalog) {
		this.drugCatalog = drugCatalog;
	}

	private ArrayList<Drug> drugCatalog;

	public DrugCatalog() {
		drugCatalog = new ArrayList<>();
	}

	public Drug addDrug() {
		Drug drug = new Drug();
		drugCatalog.add(drug);
		return drug;
	}

	public void removeDrug(Drug drug) {
		drugCatalog.remove(drug);
	}

	public boolean checkIfDrugNameIsUnique(String drugName) {
		for (Drug drug : drugCatalog) {
			if (drug.getDrugName().equalsIgnoreCase(drugName)) {
				return false;
			}
		}
		return true;
	}

}
