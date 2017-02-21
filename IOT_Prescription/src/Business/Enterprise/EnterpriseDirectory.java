/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class EnterpriseDirectory {

	public ArrayList<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}

	private ArrayList<Enterprise> enterpriseList;

	public EnterpriseDirectory() {
		enterpriseList = new ArrayList<>();
	}

	public boolean checkIfEnterpriseNameIsUnique(String enterpriseName) {
		for (Enterprise enterprise : enterpriseList) {
			if (enterprise.getName().equalsIgnoreCase(enterpriseName)) {
				return false;
			}
		}
		return true;
	}

	public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
		Enterprise enterprise = null;
		if (type == Enterprise.EnterpriseType.Hospital) {
			enterprise = new HospitalEnterprise(name);
			enterpriseList.add(enterprise);
		} else if (type == Enterprise.EnterpriseType.Supplier) {
			enterprise = new SupplierEnterprise(name);
			enterpriseList.add(enterprise);

		} else if (type == Enterprise.EnterpriseType.Pharmacy) {
			enterprise = new PharmacyEnterprise(name);
			enterpriseList.add(enterprise);
		}
		return enterprise;
	}

}
