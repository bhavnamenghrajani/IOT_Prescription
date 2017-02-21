/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Prescription.DrugDosageTrack;
import Business.Prescription.DrugDosages;
import Business.Prescription.Frequency;
import Business.Prescription.FrequencyTrack;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Bhavna Menghrajani
 */
public class TrackDiagnosisStatusJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DrugDosageTrack drugDosageTrack;
    private DrugDosages drugDosage;
    private Frequency frequency;
    int morning, afternoon, evening, night;

    /**
     * Creates new form TrackDiagnosisStatus
     */
    public TrackDiagnosisStatusJPanel(JPanel userProcessContainer, DrugDosageTrack drugDosageTrack) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.drugDosageTrack = drugDosageTrack;

        drugDosage = drugDosageTrack.getDrugDosages();
        frequency = drugDosage.getFrequency();
        morning = frequency.getMorning();
        afternoon = frequency.getAfternoon();
        evening = frequency.getEvening();
        night = frequency.getNight();

        createChart();
    }

    public void createChart() {

        DefaultCategoryDataset dcd = new DefaultCategoryDataset();

        for (int i = 0; i < drugDosageTrack.getFrequencyTrackList().size(); i++) {
            for (FrequencyTrack frequencyTrack : drugDosageTrack.getFrequencyTrackList()) {
                {
                    Frequency f = frequencyTrack.getFrequency();
                    dcd.setValue(f.getMorning(), "Morning", frequencyTrack.getDateDrugTaken());
                    System.out.println(f.getMorning());
                }
            }
        }

        JFreeChart jchart1 = ChartFactory.createBarChart3D("Morning", "Timestamp", "Morning", dcd, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart1.getCategoryPlot();

        ValueMarker minMarker = new ValueMarker(morning);
        minMarker.setLabel("Prescribed amount in morning");
        minMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        minMarker.setPaint(Color.red);
        plot.addRangeMarker(minMarker);

        plot.setRangeGridlinePaint(Color.black);

        ChartPanel chartpanel = new ChartPanel(jchart1);
        priReport.removeAll();
        priReport.add(chartpanel);
        priReport.updateUI();

        //second chart
        dcd = new DefaultCategoryDataset();

        for (int i = 0; i < drugDosageTrack.getFrequencyTrackList().size(); i++) {
            for (FrequencyTrack frequencyTrack : drugDosageTrack.getFrequencyTrackList()) {
                {
                    Frequency f = frequencyTrack.getFrequency();
                    dcd.setValue(f.getAfternoon(), "Afternoon", frequencyTrack.getDateDrugTaken());
                }
            }
        }

        JFreeChart jchart2 = ChartFactory.createBarChart3D("Afternoon", "Timestamp", "Afternoon", dcd, PlotOrientation.VERTICAL, true, true, false);
        plot = jchart2.getCategoryPlot();

        minMarker = new ValueMarker(afternoon);
        minMarker.setLabel("Prescribed amount in Afternoon");
        minMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        minMarker.setPaint(Color.red);
        plot.addRangeMarker(minMarker);

        plot.setRangeGridlinePaint(Color.black);
        chartpanel = new ChartPanel(jchart2);

        secReport.removeAll();
        secReport.add(chartpanel);
        secReport.updateUI();

        //third chart
        dcd = new DefaultCategoryDataset();

        for (int i = 0; i < drugDosageTrack.getFrequencyTrackList().size(); i++) {
            for (FrequencyTrack frequencyTrack : drugDosageTrack.getFrequencyTrackList()) {
                {
                    Frequency f = frequencyTrack.getFrequency();
                    dcd.setValue(f.getEvening(), "Evening", frequencyTrack.getDateDrugTaken());
                }
            }
        }

        JFreeChart jchart3 = ChartFactory.createBarChart3D("Evening", "Timestamp", "Evening", dcd, PlotOrientation.VERTICAL, true, true, false);
        plot = jchart3.getCategoryPlot();

        minMarker = new ValueMarker(evening);
        minMarker.setLabel("Min Level");
        minMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        minMarker.setPaint(Color.red);
        plot.addRangeMarker(minMarker);

        plot.setRangeGridlinePaint(Color.black);

        chartpanel = new ChartPanel(jchart3);

        terReport.removeAll();
        terReport.add(chartpanel);
        terReport.updateUI();

        //fourth chart
        dcd = new DefaultCategoryDataset();

        for (int i = 0; i < drugDosageTrack.getFrequencyTrackList().size(); i++) {
            for (FrequencyTrack frequencyTrack : drugDosageTrack.getFrequencyTrackList()) {
                {
                    Frequency f = frequencyTrack.getFrequency();
                    dcd.setValue(f.getNight(), "Night", frequencyTrack.getDateDrugTaken());
                }
            }
        }

        JFreeChart jchart4 = ChartFactory.createBarChart3D("Night", "Timestamp", "Night", dcd, PlotOrientation.VERTICAL, true, true, false);
        plot = jchart4.getCategoryPlot();

        minMarker = new ValueMarker(night);
        minMarker.setLabel("Min Level");
        minMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        minMarker.setPaint(Color.red);
        plot.addRangeMarker(minMarker);

        plot.setRangeGridlinePaint(Color.black);

        chartpanel = new ChartPanel(jchart4);

        quadReport.removeAll();
        quadReport.add(chartpanel);
        quadReport.updateUI();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priReport = new javax.swing.JPanel();
        secReport = new javax.swing.JPanel();
        terReport = new javax.swing.JPanel();
        quadReport = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        priReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Morning"));
        priReport.setLayout(new javax.swing.BoxLayout(priReport, javax.swing.BoxLayout.LINE_AXIS));
        add(priReport);
        priReport.setBounds(30, 80, 570, 350);

        secReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Afternoon"));
        secReport.setLayout(new javax.swing.BoxLayout(secReport, javax.swing.BoxLayout.LINE_AXIS));
        add(secReport);
        secReport.setBounds(730, 80, 620, 350);

        terReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Evening"));
        terReport.setLayout(new javax.swing.BoxLayout(terReport, javax.swing.BoxLayout.LINE_AXIS));
        add(terReport);
        terReport.setBounds(30, 450, 570, 380);

        quadReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Night"));
        quadReport.setLayout(new javax.swing.BoxLayout(quadReport, javax.swing.BoxLayout.LINE_AXIS));
        add(quadReport);
        quadReport.setBounds(730, 450, 620, 380);

        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(30, 20, 90, 30);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Bar Chart showing consumption status of a single drug");
        add(jLabel1);
        jLabel1.setBounds(340, 10, 640, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background2.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(2045, 950));
        add(jLabel2);
        jLabel2.setBounds(0, -140, 1920, 980);
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
    private javax.swing.JPanel priReport;
    private javax.swing.JPanel quadReport;
    private javax.swing.JPanel secReport;
    private javax.swing.JPanel terReport;
    // End of variables declaration//GEN-END:variables

}
