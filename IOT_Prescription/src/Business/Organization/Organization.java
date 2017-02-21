/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;

    private static int counter;
    protected ArrayList<Role> roles = null;

    public Organization(String name) {
        this.name = name;
        this.workQueue = new WorkQueue();
        this.personDirectory = new PersonDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.organizationID = ++counter;
        this.roles = new ArrayList();
    }

    public abstract ArrayList<Role> getSupportedRole();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public boolean checkIfFullNameisUnique(String firstName, String lastName) {
        for (Person person : personDirectory.getPersonList()) {
            if ((person.getFirstName().equalsIgnoreCase(firstName)) && (person.getLastName().equalsIgnoreCase(lastName))) {

                return false;
            }

        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static enum Type {

        Admin("Admin Organization"),
        Doctor("Doctor Organization"),
        Patient("Patient Organization"),
        Supplier("Supplier Organization"),
        Pharmacy("Pharmacy Organization");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

}
