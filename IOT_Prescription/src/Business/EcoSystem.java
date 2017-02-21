/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Bhavna Menghrajani
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
    private ArrayList<Network> networkList = new ArrayList<>();

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;

    }

    private EcoSystem() {
        super(null);

    }

    public Network createAndAddNetwork() {

        Network network = new Network();
        this.networkList.add(network);
        return network;

    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());

        return roleList;
    }
    public boolean checkIfNetworkNameIsUnique(String networkName) {
        for (Network network : networkList) {
            if (network.getName().equalsIgnoreCase(networkName)) {
                return false;
            }
        }
        return true;
    }

}
