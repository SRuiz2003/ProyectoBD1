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
public class GestionarCitasVista extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public GestionarCitasVista() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabeltitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoFechaConsulta = new ComponentesUI.TextField();
        jchooser = new com.toedter.calendar.JDateChooser();
        botonGuardar = new ComponentesUI.Button();
        botonVer = new ComponentesUI.Button();
        botonVerTodas1 = new ComponentesUI.Button();
        botonAceptarCita = new ComponentesUI.Button();
        botonEliminarCita = new ComponentesUI.Button();
        botonModificarCita = new ComponentesUI.Button();
        botonGuardar1 = new ComponentesUI.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestionar citas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 205, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Identificador cita", "Cedula paciente", "Nombre paciente", "Hora", "Estado", "Tipo de cita", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);  // Columna 1
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);  // Columna 2
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(200);  // Columna 1

        // Ajusta los valores de setPreferredWidth según tus necesidades
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 840, 194));

        jLabeltitle.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabeltitle.setText("Gestión de citas");
        jPanel1.add(jLabeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 400, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel3.setText("Seleccione un dia para ver las citas.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 320, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel4.setText("Para aceptar, eliminar o modificar una cita seleccionela en la tabla.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 530, -1));

        campoFechaConsulta.setBackground(new java.awt.Color(252, 252, 252));
        campoFechaConsulta.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        campoFechaConsulta.setShadowColor(new java.awt.Color(0, 153, 153));
        campoFechaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoFechaConsultaMouseClicked(evt);
            }
        });
        campoFechaConsulta.setPlaceholder("Fecha de consulta...");
        jPanel1.add(campoFechaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 140, 47));

        jchooser.setBackground(new java.awt.Color(255, 255, 255));
        jchooser.setToolTipText("");
        jchooser.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jchooserInputMethodTextChanged(evt);
            }
        });
        jchooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jchooserPropertyChange(evt);
            }
        });
        jPanel1.add(jchooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 44, 39));

        botonGuardar.setBackground(new java.awt.Color(78, 158, 185));
        botonGuardar.setForeground(new java.awt.Color(244, 240, 238));
        botonGuardar.setText("Regresar");
        botonGuardar.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 260, 48));

        botonVer.setBackground(new java.awt.Color(78, 158, 185));
        botonVer.setForeground(new java.awt.Color(244, 240, 238));
        botonVer.setText("Ver");
        botonVer.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerActionPerformed(evt);
            }
        });
        jPanel1.add(botonVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 80, 48));

        botonVerTodas1.setBackground(new java.awt.Color(78, 158, 185));
        botonVerTodas1.setForeground(new java.awt.Color(244, 240, 238));
        botonVerTodas1.setText("Ver todas");
        botonVerTodas1.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonVerTodas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerTodas1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonVerTodas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 230, 160, 48));

        botonAceptarCita.setBackground(new java.awt.Color(78, 158, 185));
        botonAceptarCita.setForeground(new java.awt.Color(244, 240, 238));
        botonAceptarCita.setText("Aceptar cita");
        botonAceptarCita.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonAceptarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarCitaActionPerformed(evt);
            }
        });
        jPanel1.add(botonAceptarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 160, 48));

        botonEliminarCita.setBackground(new java.awt.Color(78, 158, 185));
        botonEliminarCita.setForeground(new java.awt.Color(244, 240, 238));
        botonEliminarCita.setText("Eliminar cita");
        botonEliminarCita.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonEliminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarCitaActionPerformed(evt);
            }
        });
        jPanel1.add(botonEliminarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 160, 48));

        botonModificarCita.setBackground(new java.awt.Color(78, 158, 185));
        botonModificarCita.setForeground(new java.awt.Color(244, 240, 238));
        botonModificarCita.setText("Modificar cita");
        botonModificarCita.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonModificarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarCitaActionPerformed(evt);
            }
        });
        jPanel1.add(botonModificarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 160, 48));

        botonGuardar1.setBackground(new java.awt.Color(78, 158, 185));
        botonGuardar1.setForeground(new java.awt.Color(244, 240, 238));
        botonGuardar1.setText("Guardar");
        botonGuardar1.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardar1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, 160, 48));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lineasFondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoFechaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoFechaConsultaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoFechaConsultaMouseClicked

    private void jchooserInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jchooserInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jchooserInputMethodTextChanged

    private void jchooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jchooserPropertyChange
        // TODO add your handling code here:
        Date selectedDate = jchooser.getDate();

        if (selectedDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = dateFormat.format(selectedDate);
            campoFechaConsulta.setText(formattedDate);
        }
    }//GEN-LAST:event_jchooserPropertyChange

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        MenuMedicos ventana = new MenuMedicos();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVerActionPerformed

    private void botonVerTodas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerTodas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVerTodas1ActionPerformed

    private void botonAceptarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAceptarCitaActionPerformed

    private void botonEliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarCitaActionPerformed

    private void botonModificarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarCitaActionPerformed
        // TODO add your handling code here:
        ModificarCitaVista ventana = new ModificarCitaVista();
        ventana.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_botonModificarCitaActionPerformed

    private void botonGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGuardar1ActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarCitasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarCitasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarCitasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarCitasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarCitasVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ComponentesUI.Button botonAceptarCita;
    private ComponentesUI.Button botonEliminarCita;
    private ComponentesUI.Button botonGuardar;
    private ComponentesUI.Button botonGuardar1;
    private ComponentesUI.Button botonModificarCita;
    private ComponentesUI.Button botonVer;
    private ComponentesUI.Button botonVerTodas1;
    private ComponentesUI.TextField campoFechaConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jchooser;
    // End of variables declaration//GEN-END:variables
}
