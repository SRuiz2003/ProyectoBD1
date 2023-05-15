/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Santiago Cortés
 */
public class CancelarCitaVista extends javax.swing.JFrame {

    /**
     * Creates new form VerHorarioVista
     */
    public CancelarCitaVista() {
        initComponents();
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
        jLabeltitle = new javax.swing.JLabel();
        botonCancelar = new ComponentesUI.Button();
        botonAgendarCita = new ComponentesUI.Button();
        citasPaciente = new ComponentesUI.Combobox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Horario");
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabeltitle.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabeltitle.setText("Cancelar cita");
        bg.add(jLabeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 349, -1));

        botonCancelar.setBackground(new java.awt.Color(78, 158, 185));
        botonCancelar.setForeground(new java.awt.Color(244, 240, 238));
        botonCancelar.setText("Cancelar");
        botonCancelar.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        bg.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 320, 48));

        botonAgendarCita.setBackground(new java.awt.Color(78, 158, 185));
        botonAgendarCita.setForeground(new java.awt.Color(244, 240, 238));
        botonAgendarCita.setText("Cancelar cita");
        botonAgendarCita.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonAgendarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgendarCitaActionPerformed(evt);
            }
        });
        bg.add(botonAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 320, 48));

        citasPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cod: 231,2022-11-02, Consulta", "Cod: 120, 2022-12-05, Cirugia", " ", " " }));
        citasPaciente.setToolTipText("");
        citasPaciente.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        citasPaciente.setLabeText("");
        citasPaciente.setLineColor(new java.awt.Color(0, 153, 153));
        bg.add(citasPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 320, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lineasFondo.png"))); // NOI18N
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -10, -1, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        MenuPaciente ventana = new MenuPaciente();
        ventana.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgendarCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAgendarCitaActionPerformed

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
            java.util.logging.Logger.getLogger(CancelarCitaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelarCitaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelarCitaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelarCitaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CancelarCitaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private ComponentesUI.Button botonAgendarCita;
    private ComponentesUI.Button botonCancelar;
    private ComponentesUI.Combobox citasPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabeltitle;
    // End of variables declaration//GEN-END:variables
}
