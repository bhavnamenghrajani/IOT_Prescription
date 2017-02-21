/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Bhavna Menghrajani
 */
public class ConfigureEcosystem {

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        Person sysadmin = system.getPersonDirectory().createPerson("Bhavna", "Menghrajani");

        UserAccount userAccount = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", sysadmin, new SystemAdminRole());
        return system;
    }
}
