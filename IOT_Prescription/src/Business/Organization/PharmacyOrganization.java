/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Drug.DrugCatalog;
import Business.Drug.DrugInventory;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class PharmacyOrganization extends Organization {

    private DrugCatalog drugCatalog;

    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }

    public void setDrugCatalog(DrugCatalog drugCatalog) {
        this.drugCatalog = drugCatalog;
    }

    public DrugInventory getDrugInventory() {
        return drugInventory;
    }

    public void setDrugInventory(DrugInventory drugInventory) {
        this.drugInventory = drugInventory;
    }
    private DrugInventory drugInventory;

    public PharmacyOrganization() {
        super(Organization.Type.Pharmacy.getValue());
        drugCatalog = new DrugCatalog();
        drugInventory = new DrugInventory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return this.roles;
    }

}
