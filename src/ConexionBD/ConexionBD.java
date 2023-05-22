/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;



/**
 *
 * @author saimo
 */
public class ConexionBD {
    private static int cedulaUsuario;
    private static String nombreUsuario;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql:///CLINICAV2";
    private static Statement statement;
    private static Connection connection;
    
    public ConexionBD(){
    }

    public int getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(int cedulaUsuario) {
        ConexionBD.cedulaUsuario = cedulaUsuario;
    }
    
    public static int validate(int cedula,String ps, char[] pass) {
    String password = new String(pass);

    if (ps.equals(password)){
    cedulaUsuario = cedula;
    return 1;
            }else{
                return 0;
            }
    }
   
    public static int loginUsuario(int cedula, char[] contraseñaDada, boolean tipo){
    String laConsulta;
    String nombreDado = null;
    String laContraseña = "";
    try{
            connection = DriverManager.getConnection( DATABASE_URL,"root","root" );
            statement = connection.createStatement();
            
            if(tipo){
            laConsulta = String.format(" SELECT contraseña, nombre FROM medicos WHERE cedula = %d ", cedula);
            }else{
            laConsulta = String.format(" SELECT contraseña, nombre FROM pacientes WHERE cedula = %d ", cedula);
            }
            
            ResultSet resultSet = statement.executeQuery( laConsulta );
           
            while(resultSet.next()){
            System.out.println( cedula );
            laContraseña = resultSet.getString(1);
            nombreDado = resultSet.getString(2);
         }
            int test = validate(cedula,laContraseña,contraseñaDada);
            if (test == 1){
            nombreUsuario  = nombreDado;    
            return 1;
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
            
    public static int agendarCita(String fechaCita, String horaCita,int cedulaDoctor) {
        
        try {
            Instant instant = Instant.now();
            
            long codigo = instant.getEpochSecond();
            connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
            statement = connection.createStatement();
            // Preparar la consulta SQL para insertar la cita en la base de datos
            String sql1 =String.format("INSERT INTO citas (codigo, fecha, hora,cedula_paciente  ) VALUES (%d, '%s', '%s', %d)",codigo,fechaCita,horaCita, cedulaUsuario);
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
            
    public static String consultarCita(Long codigoCita) {
            
        try {
            String res;
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
            // Preparar la consulta SQL para obtener la información de la cita
            String sql = String.format("SELECT codigo, fecha, hora, descripcion, estado, tipo FROM citas WHERE codigo = %d AND cedula_paciente = %d ", codigoCita,cedulaUsuario);
            statement = connection.createStatement();
            

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                // Obtener la información de la cita
                String codigo = resultSet.getString("codigo");
                Date fecha = resultSet.getDate("fecha");
                Time hora = resultSet.getTime("hora");
                String descripcion = resultSet.getString("descripcion");
                String estado = resultSet.getString("estado");
                String tipo = resultSet.getString("tipo");
                // Pasar fecha y hora a String
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat timeAtter = new SimpleDateFormat("HH-mm-ss");
                // Mostrar la información de la cita en el área de texto
                return res = "Código: " + codigo + "\n"
                        + "Fecha: " + formatter.format(fecha) + "\n"
                        + "Hora: " + timeAtter.format(hora) + "\n"
                        + "Descripción: " + descripcion + "\n"
                        + "Estado: " + estado + "\n"
                        + "Tipo: " + tipo ;
            } else {
                // No se encontró la cita con el código proporcionado
                return res = "Cita no encontrada";
            }
        } catch (SQLException e) {
            // Manejar cualquier error de base de datos
            JOptionPane.showMessageDialog( null,
               e.getMessage(), "Error",
               JOptionPane.ERROR_MESSAGE );
            return "Error";
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
    
    public static ArrayList consultarAllCitas(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<String[]> lasCitas = new ArrayList<>();

        try{            
            connection = DriverManager.getConnection( DATABASE_URL,"root","root" );
            statement = connection.createStatement();
                     
            String laConsulta = " SELECT codigo,fecha,hora,descripcion,estado,tipo,aceptado FROM citas" ;
            ResultSet resultSet = statement.executeQuery( laConsulta );
           
            while(resultSet.next()){
            String elCodigo = Integer.toString(resultSet.getInt(1));
            String laFecha = dateFormat.format(resultSet.getDate(2));
            String laHora = resultSet.getTime(3).toString() ;
            String laDescripcion = resultSet.getString(4) ;
            String elEstado = resultSet.getString(5);
            String elTipo = resultSet.getString(6) ;
            boolean Acep = resultSet.getBoolean(7) ;
            String elAceptado;
            if(Acep){
            elAceptado = "Si";
            }else{
            elAceptado = "Pendiente";
            }
            String [] cita = {elCodigo,laFecha,laHora,laDescripcion,elEstado,elTipo,elAceptado};
            lasCitas.add(cita);
         }
              
            return lasCitas; 
            }
           
        catch( SQLException sqlException ){
            System.out.println(sqlException);
            JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE );
             return lasCitas;
        }
        finally {

         try {
            statement.close();
            connection.close();
            }

         // Maneja las excepciones que puedan ocurrir en el cierre
         catch ( SQLException sqlException ) {
            System.out.println(sqlException);
            JOptionPane.showMessageDialog( null,
               sqlException.getMessage(), "Database Error",
               JOptionPane.ERROR_MESSAGE );

            System.exit( 1 );
                                            }
                }
    }
    
    public static int cancelarCita(long codigoCita) {
    try {
        connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
        statement = connection.createStatement();
        // Preparar la consulta SQL para cancelar la cita en la base de datos
        String sql1 = String.format("DELETE FROM citas WHERE codigo = %d", codigoCita);
        String sql2 = String.format("UPDATE horarios SET codigo_cita = NULL WHERE codigo_cita = %d",codigoCita);
        
        // Ejecutar la consulta
        statement.executeUpdate(sql2);
        statement.executeUpdate(sql1);
        
        // Mostrar un mensaje de éxito al usuario
        JOptionPane.showMessageDialog(null, "Cita cancelada correctamente");
        return 1;
    } catch (SQLException e) {
        // Manejar cualquier error de base de datos
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error al cancelar la cita", JOptionPane.ERROR_MESSAGE);
        System.out.println(e);
        return 0;
    } finally {
        // Cerrar la conexión a la base de datos
        try {
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
} 
    
    public static void crearMedico(int cedula,String nombre, String apellido, String contraseña, int telefono, String especialidad, String correo, float tarifa) {
        
        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
            statement = connection.createStatement();

            // Preparar la consulta SQL para insertar el médico en la base de datos
            String sql = String.format("INSERT INTO medicos (nombre, apellido, cedula, telefono, correo_electronico, especialidad, contraseña, tarifa_hora) VALUES ('%s','%s',%d, %d, '%s', '%s', '%s', %f)", nombre,apellido,cedula,telefono,correo,especialidad,contraseña,tarifa);            
            // Ejecutar la consulta
            statement.executeUpdate(sql);
            // Mostrar un mensaje de éxito al usuario
            JOptionPane.showMessageDialog(null, "Médico creado correctamente");

        } catch (SQLException e) {
            // Manejar cualquier error de base de datos
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al crear el médico");
        } finally {
            // Cerrar la conexión a la base de datos
            try {
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        }
    }
    
    public static void crearPaciente(String nombre, String apellidos, int cedula, int telefono, String correo, String fechaNacimiento, boolean tieneEnfermedadesPreexistentes, boolean tieneAlergias, String grupoSanguineo, String direccion, String contraseña, File historialMedico) throws IOException {
   

    try {
        // Establecer la conexión a la base de datos
        connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
        statement = connection.createStatement();

        // Preparar la consulta SQL para insertar el paciente en la base de datos
        String sql = String.format("INSERT INTO pacientes ( cedula, nombre, contraseña, apellido, telefono, direccion, correo_electronico, grupo_sanguineo, alergias, enfermedades_preexistentes,fecha_nacimiento) VALUES (%d, '%s', '%s', '%s', %d, '%s', '%s', '%s' , %b, %b, '%s')", 
                                                                cedula, nombre, contraseña, apellidos, telefono,direccion,correo,grupoSanguineo,tieneAlergias,  tieneEnfermedadesPreexistentes, fechaNacimiento);
        
        
        statement.executeUpdate(sql);
        
        if(historialMedico != null){
        String path = historialMedico.getAbsolutePath();
        byte[] historyBytes = Files.readAllBytes(Paths.get(path));
        StringBuilder hexString = new StringBuilder();  
        for (byte b : historyBytes) {  
            hexString.append(Integer.toHexString(b));  
            }
            System.out.println(hexString);//TBD
            String sql2 = String.format("UPDATE pacientes SET historial_medico = x'%s' WHERE cedula = %d ", hexString,cedula);
            statement.executeUpdate(sql2);
        }
        // Ejecutar la consulta
        
        // Mostrar un mensaje de éxito al usuario
        JOptionPane.showMessageDialog(null, "Paciente creado correctamente");
    } catch (SQLException e) {
        // Manejar cualquier error de base de datos
        JOptionPane.showMessageDialog(null, "Error al crear el paciente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
            // Cerrar la conexión a la base de datos
            try {
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
   
    public static String[] consultarMedicos(){
    String[] res = null;
        try{
            
            ArrayList<String> losNombres = new ArrayList<>();
            connection = DriverManager.getConnection( DATABASE_URL,"root","root" );
            statement = connection.createStatement();
                     
            String laConsulta = " SELECT nombre,apellido FROM medicos" ;
            ResultSet resultSet = statement.executeQuery( laConsulta );
           
            while(resultSet.next()){
            String nombreComp = resultSet.getString(1) + " " + resultSet.getString(2);
            losNombres.add(nombreComp);
         }
        Object[] nomOb = losNombres.toArray();
        String[] nomArr = Arrays.copyOf(nomOb, nomOb.length, String[].class);
                    
            res = nomArr;
            return res; 
            }
           
        catch( SQLException sqlException ){
            JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE );
             return res;
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
 
    public static int cedulaMedico(String nombre){
        int res = 0;
        try{
            
            connection = DriverManager.getConnection( DATABASE_URL,"root","root" );
            statement = connection.createStatement();
                     
            String laConsulta = String.format("SELECT cedula FROM medicos WHERE nombre = '%s'",nombre) ;
            ResultSet resultSet = statement.executeQuery( laConsulta );
           
            while(resultSet.next()){
            res = resultSet.getInt(1);
            }                    
          
            return res; 
            }
           
        catch( SQLException sqlException ){
            JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE );
             return res;
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
    
    public static String[] consultarHorario(String nombre , String fechaCita){
        String[] words = nombre.split("\\s+");
        int laCedula = cedulaMedico(words[0]);
        String[] res = {"El medico seleccionado", "No dispone de horario para esta fecha"};
        try{
            
            ArrayList<String> losHorarios = new ArrayList<>();
            connection = DriverManager.getConnection( DATABASE_URL,"root","root" );
            statement = connection.createStatement();
            String laConsulta = String.format("SELECT hora FROM horarios WHERE cedula_medico = %d AND fecha ='%s' AND codigo_cita IS NULL",laCedula,fechaCita);
            ResultSet resultSet = statement.executeQuery( laConsulta );
            while(resultSet.next()){
            Time horaCita = resultSet.getTime(1);
            losHorarios.add(horaCita.toString());
         }
        Object[] nomOb = losHorarios.toArray();
        String[] nomArr = Arrays.copyOf(nomOb, nomOb.length, String[].class);
            
            if(nomArr.length < 1){
                String[] existingArray = {"El medico seleccionado", "No dispone de horario para esta fecha"};
                res =  existingArray;
            }else{
            res = nomArr;}
            return res; 
            }
           
        catch( SQLException sqlException ){
            JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE );
             return res;
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
    
    public static String[] consultarCitas(){
    String[] res = {"No hay","citas a cancelar"};
    Date now = Date.valueOf(LocalDate.now());
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String fecha = dateFormat.format(now);
        try{           
            ArrayList<String> lasCitas = new ArrayList<>();
            connection = DriverManager.getConnection( DATABASE_URL,"root","root" );
            statement = connection.createStatement();
                     
            String laConsulta = String.format("SELECT codigo, fecha, tipo FROM citas WHERE cedula_paciente = %d AND fecha > '%s'",cedulaUsuario,fecha);
            ResultSet resultSet = statement.executeQuery( laConsulta );      
            while(resultSet.next()){
            String nombreComp = "Cod:"+ Integer.toString(resultSet.getInt(1)) + ", " + dateFormat.format(resultSet.getDate(2))+ ", " +resultSet.getString(3);
            lasCitas.add(nombreComp);
         }
        Object[] citOb = lasCitas.toArray();
        String[] citArr = Arrays.copyOf(citOb, citOb.length, String[].class);
            if(citArr.length>1){        
            res = citArr;
            }
            return res; 
            }
           
        catch( SQLException sqlException ){
            JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database Error", JOptionPane.ERROR_MESSAGE );
             return res;
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
        
        
    
    
}




    

   

    
    
    
    
    
    
