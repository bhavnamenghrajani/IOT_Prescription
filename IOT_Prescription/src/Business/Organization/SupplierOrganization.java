/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Drug.DrugCatalog;

import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class SupplierOrganization extends Organization {

    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }

    public void setDrugCatalog(DrugCatalog drugCatalog) {
        this.drugCatalog = drugCatalog;
    }

    private DrugCatalog drugCatalog;

    public SupplierOrganization() {
        super(Organization.Type.Supplier.getValue());
        drugCatalog = new DrugCatalog();

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return this.roles;
    }

}
