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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

/**
 * Panel donde se pinta el tri�ngulo.
 */
@SuppressWarnings("serial")
public class PanelTriangulo extends JPanel {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicaci�n.
     */
    private InterfazTriangulo principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se inicializ� el panel.
     *
     * @param pPrincipal Interfaz principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelTriangulo(InterfazTriangulo pPrincipal) {
        principal = pPrincipal;
        setBackground(Color.WHITE);
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo para pintar el plano cartesiano.
     *
     * @param pLienzo Lienzo donde se va a pintar el plano cartesiano. pLienzo != null.
     */
    private void pintarPlanoCartesiano(Graphics pLienzo) {
        Graphics2D g2d = (Graphics2D) pLienzo;

        int anchoCuadricula = 1 + getWidth() / 50;
        int altoCuadricula = 1 + getHeight() / 50;

        // Pinta las cordenadas.
        g2d.setColor(Color.GRAY);
        g2d.drawString("0", 2, 12);
        for (int n = 1; n < anchoCuadricula; n++) {
            g2d.drawLine(50 * n, 0, 50 * n, getHeight());
            g2d.drawString("" + 50 * n, 50 * n + 1, 12);
        }
        for (int m = 1; m < altoCuadricula; m++) {
            g2d.drawLine(0, 50 * m, getWidth(), 50 * m);
            g2d.drawString("" + 50 * m, 2, 50 * m + 12);
        }

        // Pinta los ejes.
        g2d.setColor(Color.GRAY);
        g2d.drawLine(0, 0, getWidth(), 0);
        g2d.drawLine(1, 1, getWidth(), 1);
        g2d.drawLine(0, 0, 0, getHeight());
        g2d.drawLine(1, 1, 1, getHeight());
    }

    /**
     * M�todo para pintar el tri�ngulo.
     *
     * @param pLienzo Lienzo donde se va a pintar el tri�ngulo. pLienzo != null.
     */
    protected void paintComponent(Graphics pLienzo) {
        super.paintComponent(pLienzo);
        pintarPlanoCartesiano(pLienzo);
        Graphics2D g2d = (Graphics2D) pLienzo;

        // Crea un pol�gono y lo pinta
        Polygon poligono = new Polygon();
        poligono.addPoint((int) principal.darTriangulo().darPunto1().darX(), (int) principal.darTriangulo().darPunto1().darY());
        poligono.addPoint((int) principal.darTriangulo().darPunto2().darX(), (int) principal.darTriangulo().darPunto2().darY());
        poligono.addPoint((int) principal.darTriangulo().darPunto3().darX(), (int) principal.darTriangulo().darPunto3().darY());

        // Pinta el fondo
        g2d.setColor(new Color(principal.darTriangulo().darColorRelleno().darRojo(), principal.darTriangulo().darColorRelleno().darVerde(), principal.darTriangulo().darColorRelleno().darAzul()));
        g2d.fill(poligono);

        // Pinta el borde
        g2d.setColor(new Color(principal.darTriangulo().darColorLineas().darRojo(), principal.darTriangulo().darColorLineas().darVerde(), principal.darTriangulo().darColorLineas().darAzul()));
        g2d.draw(poligono);

        // Pinta nombres de los puntos
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("default", Font.BOLD, 14));
        double anguloOpuesto = principal.darTriangulo().calcularAnguloOpuesto(principal.darTriangulo().darPunto1().darX(), principal.darTriangulo().darPunto1().darY(), principal.darTriangulo().darPunto2().darX(),
                principal.darTriangulo().darPunto2().darY(), principal.darTriangulo().darPunto3().darX(), principal.darTriangulo().darPunto3().darY());
        g2d.drawString("P1", (int) (principal.darTriangulo().darPunto1().darX() - 7 + 15 * Math.cos(anguloOpuesto)), (int) (principal.darTriangulo().darPunto1().darY() + 5 + 10 * Math.sin(anguloOpuesto)));

        anguloOpuesto = principal.darTriangulo().calcularAnguloOpuesto(principal.darTriangulo().darPunto2().darX(), principal.darTriangulo().darPunto2().darY(), principal.darTriangulo().darPunto1().darX(),
                principal.darTriangulo().darPunto1().darY(), principal.darTriangulo().darPunto3().darX(), principal.darTriangulo().darPunto3().darY());
        g2d.drawString("P2", (int) (principal.darTriangulo().darPunto2().darX() - 7 + 15 * Math.cos(anguloOpuesto)), (int) (principal.darTriangulo().darPunto2().darY() + 5 + 10 * Math.sin(anguloOpuesto)));

        anguloOpuesto = principal.darTriangulo().calcularAnguloOpuesto(principal.darTriangulo().darPunto3().darX(), principal.darTriangulo().darPunto3().darY(), principal.darTriangulo().darPunto2().darX(),
                principal.darTriangulo().darPunto2().darY(), principal.darTriangulo().darPunto1().darX(), principal.darTriangulo().darPunto1().darY());
        g2d.drawString("P3", (int) (principal.darTriangulo().darPunto3().darX() - 7 + 15 * Math.cos(anguloOpuesto)), (int) (principal.darTriangulo().darPunto3().darY() + 5 + 10 * Math.sin(anguloOpuesto)));

    }
}
