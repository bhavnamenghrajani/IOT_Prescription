/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.Patient.Patient;
import Business.Prescription.DrugContents;
import Business.Prescription.DrugItems;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bhavna Menghrajani
 */
public class DrugsLowInStockJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Patient patient;
    private DrugContents drugContents;

    /**
     * Creates new form DrugsLowInStockJPanel
     */
    public DrugsLowInStockJPanel(JPanel userProcessContainer, Patient patient) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.patient = patient;
        populateQuantity();
        drugContents = patient.getDrugContents();
    }

    public void populateQuantity() {

        DefaultTableModel dtm = (DefaultTableModel) tblLowStock.getModel();
        dtm.setRowCount(0);

        for (DrugItems di : patient.getDrugContents().getDrugItemList()) {
            if (di.getDrugItem() != null) {
                Object row[] = new Object[4];
                row[0] = di.getDrugItem().getDrug().getDrugId();
                row[1] = di.getDrugItem().getDrug().getDrugName();
                row[2] = di.getDrugItem().getDrug().getPrice();
                row[3] = di.getTotalQuantity();

                dtm.addRow(row);
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLowStock = new javax.swing.JTable();
        btnHighlight = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Drugs Low in Stock");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 250, 30));

        tblLowStock.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblLowStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Id", "Drug Name", "Cost price in $", "Drugs quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLowStock);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 950, 220));

        btnHighlight.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnHighlight.setText("Highlight Lowest quantity");
        btnHighlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighlightActionPerformed(evt);
            }
        });
        add(btnHighlight, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 250, 40));

        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background2.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2000, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnHighlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighlightActionPerformed
        // TODO add your handling code here:

        for (int tr = 0; tr < tblLowStock.getRowCount(); tr++) {
            if ((Integer) tblLowStock.getValueAt(tr, 3) <= 10) {
                tblLowStock.setValueAt("<html><h3><b><font color=\"red\">" + tblLowStock.getValueAt(tr, 3) + "</font></b></h3></html>", tr, 3);
            }

        }
    }//GEN-LAST:event_btnHighlightActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
        
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHighlight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLowStock;
    // End of variables declaration//GEN-END:variables

}
