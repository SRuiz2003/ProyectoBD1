package Fuentes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author scorg
 */
public class Fuente {

    public static void aplicarFuente(JFrame frame) {
        try {
            // Obtener la ruta relativa del archivo de fuente en el paquete "fuentes"
            String rutaFuente = "/fuentes/InstrumentSans.ttf";

            // Cargar la fuente personalizada desde el archivo
            InputStream inputStream = Fuente.class.getResourceAsStream(rutaFuente);
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            Font buttonFont = customFont.deriveFont(Font.BOLD, 15);
            Font mediumFont = customFont.deriveFont(Font.PLAIN, 20);
            Font textFont = customFont.deriveFont(Font.PLAIN, 16);
            

            // Recorrer todos los componentes del JFrame
            for (Component component : frame.getContentPane().getComponents()) {
                // Verificar si el componente es un JButton
                if (component instanceof JButton){
                    JButton boton = (JButton) component;
                    boton.setFont(textFont);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
