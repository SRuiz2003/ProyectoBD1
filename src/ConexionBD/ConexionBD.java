/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.LinkedList;

/**
 *
 * @author saimo
 */
public class ConexionBD {
    private int cedulaUsuario;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql:///CLINICAV2";
    private Statement statement;
    private Connection connection;
    
    public ConexionBD(){
    }

    public int getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(int cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }
    
    public int loginUsuario(int cedula, String contraseñaDada, boolean tipo){
    String laConsulta;
    String laContraseña = "";
    try{
            connection = DriverManager.getConnection( DATABASE_URL,"root","root" );
            statement = connection.createStatement();
            
            if(tipo){
            laConsulta = String.format(" SELECT contraseña FROM medicos WHERE cedula = %d ", cedula);
            }else{
            laConsulta = String.format(" SELECT contraseña FROM pacientes WHERE cedula = %d ", cedula);
            }
            
            ResultSet resultSet = statement.executeQuery( laConsulta );
           
            while(resultSet.next()){
            System.out.println( cedula );
            laContraseña = resultSet.getString(1);
         }
            if(laContraseña.equals(contraseñaDada)){
               cedulaUsuario = cedula;
               return cedula;
            }else{
            
                JOptionPane.showMessageDialog( null,
                "La contraseña o el usuario no coinciden","Error al ingresar sus datos",JOptionPane.ERROR_MESSAGE );
                return 0;
            }
            
            
            
        }
        catch( SQLException sqlException ){
            JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE );
            return 0;
        }
        finally {

         try {
            statement.close();
            connection.close();
            }

         // Maneja las excepciones que puedan ocurrir en el cierre
         catch ( SQLException sqlException ) {
            JOptionPane.showMessageDialog( null,
               sqlException.getMessage(), "Database Error",
               JOptionPane.ERROR_MESSAGE );

            System.exit( 1 );
                                            }
                }
            }
            
    public int agendarCita(int cedulaPaciente,String fechaCita, String horaCita,int cedulaDoctor) {
        
        try {
            Instant instant = Instant.now();
            
            long codigo = instant.getEpochSecond();
            connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
            // Preparar la consulta SQL para insertar la cita en la base de datos
            String sql1 =String.format("INSERT INTO citas (codigo, fecha, hora,cedula_paciente  ) VALUES (%d, '%s', '%s', %d)",codigo,fechaCita,horaCita, cedulaPaciente);
            String sql2 = String.format("UPDATE horarios SET codigo_cita = %d WHERE fecha = '%s' AND hora = '%s' AND cedula_medico = %d ", codigo, fechaCita,horaCita,cedulaDoctor);
            
            // Ejecutar la consulta
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            
            // Mostrar un mensaje de éxito al usuario
            JOptionPane.showMessageDialog(null, "Cita agendada correctamente");
            return 1;
            
        }catch(SQLException e){
            // Manejar cualquier error de base de datos
           JOptionPane.showMessageDialog( null,
               e.getMessage(), "Error al guardar la cita",
               JOptionPane.ERROR_MESSAGE );
           return 0;
        } finally {
            // Cerrar la conexión a la base de datos
            try {
            statement.close();
            connection.close();
            }

         // Maneja las excepciones que puedan ocurrir en el cierre
         catch ( SQLException sqlException ) {
            JOptionPane.showMessageDialog( null,
               sqlException.getMessage(), "Database Error",
               JOptionPane.ERROR_MESSAGE );

            System.exit( 1 );
                                            }
                }
            }
        }
    
    
    
    
    
    
