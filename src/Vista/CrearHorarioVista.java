/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ConexionBD.ConexionBD;
import java.sql.Time;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;

/**
 *
 * @author scorg
 */
public class CrearHorarioVista extends javax.swing.JFrame {


    public CrearHorarioVista() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        
    }
        


private void guardarHorario() {
    
    int descanso = Integer.parseInt(diasLibres.getSelectedItem().toString());
    
    
    LocalDate fechaInicio = LocalDate.now().plusDays(1);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    LocalTime horaInicioSeleccionada = LocalTime.parse(horaInicio.getSelectedItem().toString(), formatter);
    LocalTime horaFinSeleccionada = LocalTime.parse(horaFin.getSelectedItem().toString(), formatter);
    LocalDate ultimoDiaMes = fechaInicio.with(TemporalAdjusters.lastDayOfMonth());
    
    LocalDateTime inicio = fechaInicio.atTime(horaInicioSeleccionada);
    LocalDateTime fin = fechaInicio.atTime(horaFinSeleccionada);

    Duration duracion = Duration.between(inicio, fin);
    long horas = duracion.toHours();

    LocalDate fechaActual = inicio.toLocalDate(); // Inicializar con la fecha de inicio
    LocalDate fechaDescanso = fechaInicio.plusDays(descanso);
    List<LocalDateTime> horarios = new ArrayList<>(); // Crear el arreglo para almacenar los horarios
     long diasDiferencia = ChronoUnit.DAYS.between(fechaInicio, ultimoDiaMes);
     if (diasDiferencia > 21){
         
     while (fechaInicio.getMonthValue() == fechaActual.getMonthValue()) {
    
        if (horas < 8 && horas >= 1 && !fechaActual.equals(fechaDescanso) && !fechaActual.equals(fechaDescanso.plusDays(7)) && !fechaActual.equals(fechaDescanso.plusDays(14))) {
            LocalDateTime actual = inicio;
            while (actual.isBefore(fin)) {
                horarios.add(actual);
                actual = actual.plusHours(1);
            }
        } else {
            // Si la diferencia es mayor o igual a 8 horas, realizar alguna acción adicional
        }

        // Avanzar al siguiente día
        fechaActual = fechaActual.plusDays(1);
        inicio = fechaActual.atTime(horaInicioSeleccionada);
        fin = fechaActual.atTime(horaFinSeleccionada);
    }
         
         
     }else{
     if(diasDiferencia > 14){
              while (fechaInicio.getMonthValue() == fechaActual.getMonthValue()) {
    
        if (horas < 8 && horas >= 1 && !fechaActual.equals(fechaDescanso) && !fechaActual.equals(fechaDescanso.plusDays(7))) {
            LocalDateTime actual = inicio;
            while (actual.isBefore(fin)) {
                horarios.add(actual);
                actual = actual.plusHours(1);
            }
        } else {
            // Si la diferencia es mayor o igual a 8 horas, realizar alguna acción adicional
        }

        // Avanzar al siguiente día
        fechaActual = fechaActual.plusDays(1);
        inicio = fechaActual.atTime(horaInicioSeleccionada);
        fin = fechaActual.atTime(horaFinSeleccionada);
    }
         
     }else{
         if(diasDiferencia >= 7){
            while (fechaInicio.getMonthValue() == fechaActual.getMonthValue()) {
    
        if (horas < 8 && horas >= 1 && !fechaActual.equals(fechaDescanso)) {
            LocalDateTime actual = inicio;
            while (actual.isBefore(fin)) {
                horarios.add(actual);
                actual = actual.plusHours(1);
            }
        } else {
            // Si la diferencia es mayor o igual a 8 horas, realizar alguna acción adicional
        }

        // Avanzar al siguiente día
        fechaActual = fechaActual.plusDays(1);
        inicio = fechaActual.atTime(horaInicioSeleccionada);
        fin = fechaActual.atTime(horaFinSeleccionada);
    }
             
         }else{
                         while (fechaInicio.getMonthValue() == fechaActual.getMonthValue()) {
    
        if (horas < 8 && horas >= 1) {
            LocalDateTime actual = inicio;
            while (actual.isBefore(fin)) {
                horarios.add(actual);
                actual = actual.plusHours(1);
            }
        } else {
            // Si la diferencia es mayor o igual a 8 horas, realizar alguna acción adicional
        }

        // Avanzar al siguiente día
        fechaActual = fechaActual.plusDays(1);
        inicio = fechaActual.atTime(horaInicioSeleccionada);
        fin = fechaActual.atTime(horaFinSeleccionada);
    }
         }
             
     }}


    // Imprimir o utilizar el arreglo de horarios
    for (LocalDateTime fechaHora : horarios) {
        LocalDate fecha = fechaHora.toLocalDate();
        LocalTime hora = fechaHora.toLocalTime();

        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);

        // Aquí puedes guardar la fecha y hora en tu estructura de datos o realizar cualquier otra acción necesaria
    }
    ConexionBD.crearHorarioMeds(horarios);
    System.out.println(horarios);
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
        nombreMedico = new javax.swing.JLabel();
        nombreMedico1 = new javax.swing.JLabel();
        nombreMedico2 = new javax.swing.JLabel();
        horaFin = new ComponentesUI.Combobox();
        diasLibres = new ComponentesUI.Combobox();
        botonCrearHorario = new ComponentesUI.Button();
        nombreMedico4 = new javax.swing.JLabel();
        nombreMedico5 = new javax.swing.JLabel();
        botonRegresar = new ComponentesUI.Button();
        jLabel1 = new javax.swing.JLabel();
        horaInicio = new ComponentesUI.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear nuevo horario");
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabeltitle.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabeltitle.setText("Crear horario");
        bg.add(jLabeltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 349, -1));

        nombreMedico.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        nombreMedico.setText("Hora fin: ");
        bg.add(nombreMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 80, -1));

        nombreMedico1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        nombreMedico1.setText("Cree su horario para el mes actual.");
        bg.add(nombreMedico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 300, -1));

        nombreMedico2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        nombreMedico2.setText("<html>Tenga en cuenta que sus proximos 2 dias libres en el mes se calculan 7 dias y 14 dias respectivamente a partir del primer dia que seleccione.</html>");
        bg.add(nombreMedico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 560, 40));

        horaFin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00", "" }));
        horaFin.setToolTipText("");
        horaFin.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        horaFin.setLabeText("");
        horaFin.setLineColor(new java.awt.Color(0, 153, 153));
        horaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaFinActionPerformed(evt);
            }
        });
        bg.add(horaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 100, 40));

        diasLibres.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        diasLibres.setToolTipText("");
        diasLibres.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        diasLibres.setLabeText("");
        diasLibres.setLineColor(new java.awt.Color(0, 153, 153));
        bg.add(diasLibres, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 100, 40));

        botonCrearHorario.setBackground(new java.awt.Color(78, 158, 185));
        botonCrearHorario.setForeground(new java.awt.Color(244, 240, 238));
        botonCrearHorario.setText("Crear horario");
        botonCrearHorario.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonCrearHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearHorarioActionPerformed(evt);
            }
        });
        bg.add(botonCrearHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 210, 48));

        nombreMedico4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        nombreMedico4.setText("Primer dia libre:");
        bg.add(nombreMedico4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 140, 20));

        nombreMedico5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        nombreMedico5.setText("Hora inicio: ");
        bg.add(nombreMedico5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 100, -1));

        botonRegresar.setBackground(new java.awt.Color(78, 158, 185));
        botonRegresar.setForeground(new java.awt.Color(244, 240, 238));
        botonRegresar.setText("Regresar");
        botonRegresar.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });
        bg.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 160, 48));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lineasFondo.png"))); // NOI18N
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 220, -1));

        horaInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00", "" }));
        horaInicio.setToolTipText("");
        horaInicio.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        horaInicio.setLabeText("");
        horaInicio.setLineColor(new java.awt.Color(0, 153, 153));
        bg.add(horaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearHorarioActionPerformed
    guardarHorario(); 
    MenuMedicos ventana = new MenuMedicos();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonCrearHorarioActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        MenuMedicos ventana = new MenuMedicos();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void horaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaFinActionPerformed

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
            java.util.logging.Logger.getLogger(CrearHorarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearHorarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearHorarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearHorarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearHorarioVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private ComponentesUI.Button botonCrearHorario;
    private ComponentesUI.Button botonRegresar;
    private ComponentesUI.Combobox diasLibres;
    private ComponentesUI.Combobox horaFin;
    private ComponentesUI.Combobox horaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabeltitle;
    private javax.swing.JLabel nombreMedico;
    private javax.swing.JLabel nombreMedico1;
    private javax.swing.JLabel nombreMedico2;
    private javax.swing.JLabel nombreMedico4;
    private javax.swing.JLabel nombreMedico5;
    // End of variables declaration//GEN-END:variables
}
