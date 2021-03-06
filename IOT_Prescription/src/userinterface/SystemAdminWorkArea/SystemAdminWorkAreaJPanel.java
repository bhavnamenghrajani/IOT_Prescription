/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Bhavna Menghrajani
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateTree();
        selectedNodeJLabel.setText("Select your node.");
    }

    public void populateTree() {

        DefaultTreeModel model = (DefaultTreeModel) JTree.getModel();
        ArrayList<Network> networkList = system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        Network network;
        Enterprise enterprise;
        Organization organization;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);

        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        for (int i = 0; i < networkList.size(); i++) {
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();

            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }

        model.reload();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTree = new javax.swing.JTree();
        selectedNodeJLabel = new javax.swing.JLabel();
        manageNetwork = new javax.swing.JButton();
        manageEnterprise = new javax.swing.JButton();
        manageEnterpriseLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("System Admin Work Area");
        add(jLabel1);
        jLabel1.setBounds(420, 20, 310, 62);

        JTree.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("System");
        JTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        JTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                JTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(JTree);

        add(jScrollPane2);
        jScrollPane2.setBounds(810, 100, 299, 358);

        selectedNodeJLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        selectedNodeJLabel.setText("<<>>");
        add(selectedNodeJLabel);
        selectedNodeJLabel.setBounds(920, 480, 80, 20);

        manageNetwork.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        manageNetwork.setText("Manage Network");
        manageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkActionPerformed(evt);
            }
        });
        add(manageNetwork);
        manageNetwork.setBounds(420, 120, 310, 60);

        manageEnterprise.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        manageEnterprise.setText("Manage Enterprise");
        manageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseActionPerformed(evt);
            }
        });
        add(manageEnterprise);
        manageEnterprise.setBounds(420, 220, 310, 60);

        manageEnterpriseLogin.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        manageEnterpriseLogin.setText("Manage Enterprise Admin");
        manageEnterpriseLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseLoginActionPerformed(evt);
            }
        });
        add(manageEnterpriseLogin);
        manageEnterpriseLogin.setBounds(420, 330, 310, 60);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background2.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 2000, 960);
    }// </editor-fold>//GEN-END:initComponents

    private void JTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_JTreeValueChanged
        // TODO add your handling code here:

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) JTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            selectedNodeJLabel.setText(selectedNode.toString());
        }


    }//GEN-LAST:event_JTreeValueChanged

    private void manageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkActionPerformed
        // TODO add your handling code here:
        ManageNetworkJPanel manageNetworkJPanel = new ManageNetworkJPanel(userProcessContainer, system);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkActionPerformed

    private void manageEnterpriseLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseLoginActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseAdminJPanel(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseAdminJPanel", manageEnterpriseAdminJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageEnterpriseLoginActionPerformed

    private void manageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseActionPerformed
        // TODO add your handling code here:

        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseJPanel", manageEnterpriseJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterpriseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree JTree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton manageEnterprise;
    private javax.swing.JButton manageEnterpriseLogin;
    private javax.swing.JButton manageNetwork;
    private javax.swing.JLabel selectedNodeJLabel;
    // End of variables declaration//GEN-END:variables

}
