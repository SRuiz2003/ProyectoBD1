/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static ConexionBD.ConexionBD.cedulaMedico;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Cortés
 */
public class VerHorarioVista extends javax.swing.JFrame {

    private static  String medico;

    /**
     * Creates new form VerHorarioVista
     * @param medico
     */
    public VerHorarioVista(String medico) {
        VerHorarioVista.medico = medico;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        nombreMedico.setText(medico);

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
        jLabeltext = new javax.swing.JLabel();
        nombreMedico = new javax.swing.JLabel();
        campoFechaCita = new ComponentesUI.TextField();
        jchooser = new com.toedter.calendar.JDateChooser();
        horarioMedico = new ComponentesUI.Combobox();
        jLabeltext1 = new javax.swing.JLabel();
        botonCancelar = new ComponentesUI.Button();
        botonAgendarCita = new ComponentesUI.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Horario");
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabeltitle.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabeltitle.setText("Horario disponible");
        bg.add(jLabeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 349, -1));

        jLabeltext.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabeltext.setText("<html>tiene el siguiente horario disponible para el dia seleccionado. <br>Seleccione la hora</html>");
        jLabeltext.setName("jlabeltext");
        bg.add(jLabeltext, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 330, -1));

        nombreMedico.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        nombreMedico.setText("(nombre del doctor)");
        jLabeltext.setName("jlabeltext");
        bg.add(nombreMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 170, -1));

        campoFechaCita.setBackground(new java.awt.Color(252, 252, 252));
        campoFechaCita.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        campoFechaCita.setShadowColor(new java.awt.Color(0, 153, 153));
        campoFechaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoFechaCitaMouseClicked(evt);
            }
        });
        campoFechaCita.setPlaceholder("Fecha deseada para la cita...");
        bg.add(campoFechaCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 260, 47));

        jchooser.setBackground(new java.awt.Color(255, 255, 255));
        jchooser.setToolTipText("");
        jchooser.setDateFormatString(" yyyy-MM-dd");
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
        bg.add(jchooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 44, 39));

        horarioMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00", " ", " " }));
        horarioMedico.setToolTipText("");
        horarioMedico.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        horarioMedico.setLabeText("");
        horarioMedico.setLineColor(new java.awt.Color(0, 153, 153));
        bg.add(horarioMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 320, 50));

        jLabeltext1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabeltext1.setText("El/la Dr(a) ");
        jLabeltext.setName("jlabeltext");
        bg.add(jLabeltext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        botonCancelar.setBackground(new java.awt.Color(78, 158, 185));
        botonCancelar.setForeground(new java.awt.Color(244, 240, 238));
        botonCancelar.setText("Cancelar");
        botonCancelar.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        bg.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 330, 48));

        botonAgendarCita.setBackground(new java.awt.Color(78, 158, 185));
        botonAgendarCita.setForeground(new java.awt.Color(244, 240, 238));
        botonAgendarCita.setText("Agendar cita");
        botonAgendarCita.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonAgendarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgendarCitaActionPerformed(evt);
            }
        });
        bg.add(botonAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 330, 48));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lineasFondo.png"))); // NOI18N
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

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
    
     private void UpdateHorasList(String fecha){
        String[] meds = ConexionBD.ConexionBD.consultarHorario(medico, fecha);
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(meds);
        horarioMedico.setModel(comboBoxModel);
    }
    
    private void campoFechaCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoFechaCitaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoFechaCitaMouseClicked

    private void jchooserInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jchooserInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jchooserInputMethodTextChanged

    private void jchooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jchooserPropertyChange
        // TODO add your handling code here:
        Date selectedDate = jchooser.getDate();

        if (selectedDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);
            campoFechaCita.setText(formattedDate);
            UpdateHorasList(formattedDate);
            
        }
    }//GEN-LAST:event_jchooserPropertyChange

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        AgendarCita ventana = new AgendarCita();
        this.setVisible(false);
        ventana.setVisible(true);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgendarCitaActionPerformed
        // TODO add your handling code here:
        try{
            String laFecha = campoFechaCita.getText();
            String laHora = horarioMedico.getSelectedItem().toString();
            String[] words = medico.split("\\s+");
            int laCedula = cedulaMedico(words[0]);
            ConexionBD.ConexionBD.agendarCita(laFecha, laHora, laCedula);
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog( this, e.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE );
        }finally{
        this.dispose();
        AgendarCita ventana = new AgendarCita();
        this.setVisible(false);
        ventana.setVisible(true);
        }
    }//GEN-LAST:event_botonAgendarCitaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private ComponentesUI.Button botonAgendarCita;
    private ComponentesUI.Button botonCancelar;
    private ComponentesUI.TextField campoFechaCita;
    private ComponentesUI.Combobox horarioMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabeltext;
    private javax.swing.JLabel jLabeltext1;
    private javax.swing.JLabel jLabeltitle;
    private com.toedter.calendar.JDateChooser jchooser;
    private javax.swing.JLabel nombreMedico;
    // End of variables declaration//GEN-END:variables
}
