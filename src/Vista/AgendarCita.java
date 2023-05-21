/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 *
 * @author edgue
 */
public class AgendarCita extends javax.swing.JFrame {

    /**
     * Creates new form AgendarCita
     */
    public AgendarCita() {
        initComponents();
        UpdateMedicsList();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabeltext = new javax.swing.JLabel();
        jLabeltitle = new javax.swing.JLabel();
        botonVerHorario = new ComponentesUI.Button();
        botonCancelar = new ComponentesUI.Button();
        medicos = new ComponentesUI.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agendar cita");
        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jLabeltext.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabeltext.setText("Elija un(a) doctor(a):");
        jLabeltext.setName("jlabeltext");

        jLabeltitle.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabeltitle.setText("Agendar cita");

        botonVerHorario.setBackground(new java.awt.Color(78, 158, 185));
        botonVerHorario.setForeground(new java.awt.Color(244, 240, 238));
        botonVerHorario.setText("Ver horario");
        botonVerHorario.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonVerHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerHorarioActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(78, 158, 185));
        botonCancelar.setForeground(new java.awt.Color(244, 240, 238));
        botonCancelar.setText("Cancelar");
        botonCancelar.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        medicos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jose Eduardo Ramirez", "Nombre2", "Nombre3", "" }));
        medicos.setToolTipText("");
        medicos.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        medicos.setLabeText("");
        medicos.setLineColor(new java.awt.Color(0, 153, 153));
        medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(botonVerHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabeltext)
                        .addComponent(jLabeltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(medicos, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabeltitle)
                .addGap(29, 29, 29)
                .addComponent(jLabeltext)
                .addGap(18, 18, 18)
                .addComponent(medicos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVerHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateMedicsList(){
        String[] meds = ConexionBD.ConexionBD.consultarMedicos();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(meds);
        medicos.setModel(comboBoxModel);
    }
    
    
    private void botonVerHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerHorarioActionPerformed
        // TODO add your handling code here:
        VerHorarioVista ventana = new VerHorarioVista();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonVerHorarioActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        MenuPaciente ventana = new MenuPaciente();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private ComponentesUI.Button botonCancelar;
    private ComponentesUI.Button botonVerHorario;
    private javax.swing.JLabel jLabeltext;
    private javax.swing.JLabel jLabeltitle;
    private ComponentesUI.Combobox medicos;
    // End of variables declaration//GEN-END:variables
}
