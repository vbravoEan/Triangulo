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

import universidadean.desarrollosw.triangulo.mundo.Triangulo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.Line2D;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Ventana principal de la aplicaci�n.
 */
@SuppressWarnings("serial")
public class InterfazTriangulo extends JFrame {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Triangulo triangulo;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de los botones.
     */
    private PanelBotones panelBotones;

    /**
     * Panel para la visualizaci�n del tri�ngulo.
     */
    private PanelTriangulo panelTriangulo;

    /**
     * Panel con la opciones de la aplicaci�n.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con el encabezado.
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana principal de la aplicaci�n. <br>
     * <b>post: </b> Se inicializ� la interfaz principal y sus paneles.
     */
    public InterfazTriangulo() {
        setTitle("Tri�ngulo");
        setSize(600, 490);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        triangulo = new Triangulo();

        getContentPane().setLayout(new BorderLayout());

        panelImagen = new PanelImagen();
        getContentPane().add(panelImagen, BorderLayout.NORTH);

        panelBotones = new PanelBotones(this);
        getContentPane().add(panelBotones, BorderLayout.WEST);

        panelTriangulo = new PanelTriangulo(this);
        getContentPane().add(panelTriangulo, BorderLayout.CENTER);

        panelOpciones = new PanelOpciones(this);
        getContentPane().add(panelOpciones, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setResizable(false);

        actualizar();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Devuelve el tri�ngulo del mundo.
     *
     * @return Tri�ngulo.
     */
    public Triangulo darTriangulo() {
        return triangulo;
    }

    /**
     * Cambia el valor de un punto del tri�ngulo.
     *
     * @param pPunto Punto del que se quiere cambiar el valor. pPunto > 0 && pPunto < 4.
     * @param pX     Coordenada X del nuevo punto. pX > 0.
     * @param pY     Coordenada Y del nuevo punto. pY > 0.
     */
    public void cambiarPunto(int pPunto, double pX, double pY) {
        if (pPunto == 1) {
            triangulo.cambiarPunto1(pX, pY);
        }
        else if (pPunto == 2) {
            triangulo.cambiarPunto2(pX, pY);
        }
        else if (pPunto == 3) {
            triangulo.cambiarPunto3(pX, pY);
        }
    }

    /**
     * Cambia el color del fondo del tri�ngulo. <br>
     * <b>post: </b> Se cambi� el color del fondo del tri�ngulo y se actualiz� la interfaz.
     */
    public void cambiarColorFondo() {
        Color colorActual = new Color(triangulo.darColorRelleno().darRojo(), triangulo.darColorRelleno().darVerde(), triangulo.darColorRelleno().darAzul());
        Color nuevoColor = JColorChooser.showDialog(this, "Color fondo", colorActual);
        if (nuevoColor != null) {
            // Cambia los valores
            triangulo.cambiarColorRelleno(nuevoColor.getRed(), nuevoColor.getGreen(), nuevoColor.getBlue());
        }
        actualizar();
    }

    /**
     * Cambia el color de las l�neas del tri�ngulo. <br>
     * <b>post: </b> Se cambi� el color de las l�neas del tri�ngulo y se actualiz� la interfaz.
     */
    public void cambiarColorLineas() {
        Color colorActual = new Color(triangulo.darColorLineas().darRojo(), triangulo.darColorLineas().darVerde(), triangulo.darColorLineas().darAzul());
        Color nuevoColor = JColorChooser.showDialog(this, "Color l�neas", colorActual);
        if (nuevoColor != null) {
            // Cambia los valores
            triangulo.cambiarColorLineas(nuevoColor.getRed(), nuevoColor.getGreen(), nuevoColor.getBlue());
        }
        actualizar();
    }

    /**
     * Verifica si 3 puntos son colineales.
     *
     * @param p1x Valor X punto 1. p1x >= 0.
     * @param p1y Valor Y punto 1. p1y >= 0.
     * @param p2x Valor X punto 2. p2x >= 0.
     * @param p2y Valor Y punto 2. p2y >= 0.
     * @param p3x Valor X punto 3. p3x >= 0.
     * @param p3y Valor Y punto 3. p3y >= 0.
     * @return True si los tres puntos dados son colineales. False en caso contrario.
     */
    public boolean colineales(double p1x, double p1y, double p2x, double p2y, double p3x, double p3y) {
        // Verifica usando un Line2D
        Line2D linea = new Line2D.Double(p1x, p1y, p2x, p2y);
        return (linea.ptLineDist(p3x, p3y) == 0);

    }

    /**
     * Muestra el di�logo para cambiar los puntos del tri�ngulo.
     */
    public void mostrarDialogoCambiarPuntos() {
        DialogoPuntos dialogoPuntos = new DialogoPuntos(this);
        dialogoPuntos.setVisible(true);
    }

    /**
     * Repinta el tri�ngulo y los valores. <br>
     * <b>post: </b> Se actualiz� el tri�ngulo y sus valores en la interfaz.
     */
    public void actualizar() {
        panelTriangulo.repaint();
        panelBotones.cambiarInformacion(triangulo.darPerimetro(), triangulo.darArea(), triangulo.darAltura());
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensi�n 1.
     */
    public void reqFuncOpcion1() {
        String resultado = triangulo.tipo();
        actualizar();
        JOptionPane.showMessageDialog(this, "El tri�ngulo es " + resultado, "Tipo de tri�ngulo", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Ejecuta el punto de extensi�n 2.
     */
    public void reqFuncOpcion2() {
        double angulo1 = triangulo.angulo1();
        double angulo2 = triangulo.angulo2();
        double angulo3 = triangulo.angulo3();

        String resultado = String.format("Angulo entre lado 1 y lado 2 = %.2f\nAngulo entre lado 2 y lado 3 = %.2f\nAngulo entre lado 1 y lado 3 = %.2f",
                angulo1, angulo2, angulo3);
        actualizar();
        JOptionPane.showMessageDialog(this, resultado, "�ngulos", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicaci�n.
     *
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
     */
    public static void main(String[] pArgs) {
        try {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            InterfazTriangulo interfaz = new InterfazTriangulo();
            interfaz.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
