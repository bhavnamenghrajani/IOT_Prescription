/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class AdminOrganization extends Organization {

    public AdminOrganization() {
        super(Organization.Type.Admin.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return this.roles;
    }

}
