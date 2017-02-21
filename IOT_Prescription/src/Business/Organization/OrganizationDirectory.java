/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.PharmacyEnterprise;
import Business.Role.DoctorRole;
import Business.Role.PatientRole;
import Business.Role.PharmacistRole;
import Business.Role.SupplierRole;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();

    }

    public boolean checkIfOrganizationNameisUnique(String name) {

        for (Organization org : organizationList) {
            if (org.getName().equalsIgnoreCase(name)) {
                return true;
            }

        }

        return false;
    }

    public Organization createOrganization(Organization.Type type) {
        Organization organization = null;

        if (type.getValue().equals(Organization.Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organization.getSupportedRole().add(new DoctorRole());
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Patient.getValue())) {
            organization = new PatientOrganization();
            organization.getSupportedRole().add(new PatientRole());
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Pharmacy.getValue())) {
            organization = new PharmacyOrganization();
            organization.getSupportedRole().add(new PharmacistRole());
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Supplier.getValue())) {
            organization = new SupplierOrganization();
            organization.getSupportedRole().add(new SupplierRole());
            organizationList.add(organization);
        }

        return organization;
    }

}
