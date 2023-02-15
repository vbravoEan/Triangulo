/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento Tecnolog�as de la Informaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudio: Desarrollo de Software
 * Ejercicio: Triangulo
 * Fecha: Agosto 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.triangulo.interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel de la imagen del t�tulo.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel {

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se inicializ� el panel.
     */
    public PanelImagen() {
        JLabel imagen = new JLabel();
        ImageIcon icono = new ImageIcon("data/titulo.png");
        imagen = new JLabel("");
        imagen.setIcon(icono);
        add(imagen);
    }

}
