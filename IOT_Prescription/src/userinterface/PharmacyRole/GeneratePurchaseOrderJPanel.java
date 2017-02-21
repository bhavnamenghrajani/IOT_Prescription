/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyRole;

import Business.Drug.DrugItem;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bhavna Menghrajani
 */
public class GeneratePurchaseOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ArrayList<DrugItem> drugItemList;
    private String name;

    /**
     * Creates new form GenerateInvoiceJPanel
     */
    public GeneratePurchaseOrderJPanel(JPanel userProcessContainer, ArrayList<DrugItem> drugItemList, String name) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.drugItemList = drugItemList;
        this.name = name;

        lblSupplierName.setText(name);
        populateOrder();
        populateTotalAmount(drugItemList);
    }

    private void populateTotalAmount(ArrayList<DrugItem> drugItemList) {

        double total = 0;
        for (DrugItem di : drugItemList) {

            total = total + di.getDrug().getPrice() * di.getQuantity();
        }
        lblTotalAmount.setText(String.valueOf(total));

    }

    public void populateOrder() {
        DefaultTableModel dtm = (DefaultTableModel) tblOrder.getModel();
        dtm.setRowCount(0);

        for (DrugItem drugItem : drugItemList) {
            Object row[] = new Object[5];
            row[0] = drugItem.getDrug().getDrugId();
            row[1] = drugItem.getDrug().getDrugName();
            row[2] = drugItem.getDrug().getPrice();
            row[3] = drugItem.getQuantity();
            row[4] = drugItem.getDrug().getPrice() * drugItem.getQuantity();

            dtm.addRow(row);

        }

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
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblSupplierName = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Generate Purchase Order");
        add(jLabel1);
        jLabel1.setBounds(403, 31, 320, 30);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Order Requested from:");
        add(jLabel2);
        jLabel2.setBounds(50, 90, 160, 19);

        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(47, 27, 88, 31);

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Id", "Drug Name", "Drug Per quantity", "Quantity Ordered", "Total cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        add(jScrollPane1);
        jScrollPane1.setBounds(47, 121, 870, 201);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Total Amount: $");
        add(jLabel3);
        jLabel3.setBounds(600, 360, 135, 23);

        lblSupplierName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblSupplierName.setText("<<>>");
        add(lblSupplierName);
        lblSupplierName.setBounds(220, 90, 210, 19);

        lblTotalAmount.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblTotalAmount.setText("<<>>");
        add(lblTotalAmount);
        lblTotalAmount.setBounds(770, 360, 150, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background2.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4);
        jLabel4.setBounds(0, 0, 2000, 970);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables

}
