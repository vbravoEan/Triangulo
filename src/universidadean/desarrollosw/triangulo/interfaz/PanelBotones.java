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

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel con la opciones para modificar el tri�ngulo.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para cambiar los punto del tri�ngulo.
     */
    private static final String PUNTOS = "PUNTOS";

    /**
     * Constante para cambiar el color del tri�ngulo.
     */
    private static final String COLOR_TRIANGULO = "COLOR_TRIANGULO";

    /**
     * Constante para cambiar el fondo de color de las l�neas del tri�ngulo.
     */
    private static final String COLOR_LINEAS = "COLOR_LINEAS";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazTriangulo principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n cambio de puntos.
     */
    private JButton btnPuntos;

    /**
     * Bot�n cambio color de la l�neas.
     */
    private JButton btnColorLinea;

    /**
     * Bot�n cambio color del tri�ngulo.
     */
    private JButton btnColorTriangulo;

    /**
     * Etiqueta con el �rea del tri�ngulo.
     */
    private JLabel etiquetaArea;

    /**
     * Etiqueta con la altura del tri�ngulo.
     */
    private JLabel etiquetaAltura;

    /**
     * Etiqueta con el per�metro.
     */
    private JLabel etiquetaPerimetro;

    /**
     * Campo de texto para el �rea del tri�ngulo.
     */
    private JTextField txtArea;

    /**
     * Campo de texto para la altura del tri�ngulo.
     */
    private JTextField txtAltura;

    /**
     * Campo de texto para el per�metro del tri�ngulo.
     */
    private JTextField txtPerimetro;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se inicializ� el panel.
     *
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelBotones(InterfazTriangulo pPrincipal) {
        principal = pPrincipal;
        setLayout(new GridLayout(2, 1));

        // Panel Modificaciones
        JPanel panelModificaciones = new JPanel(new GridLayout(3, 1));
        panelModificaciones.setBorder(new TitledBorder("Modificaciones"));

        btnPuntos = new JButton("Cambiar puntos");
        btnPuntos.setActionCommand(PUNTOS);
        btnPuntos.addActionListener(this);
        panelModificaciones.add(btnPuntos);

        btnColorLinea = new JButton("Cambiar l�neas");
        btnColorLinea.setActionCommand(COLOR_LINEAS);
        btnColorLinea.addActionListener(this);
        panelModificaciones.add(btnColorLinea);

        btnColorTriangulo = new JButton("Cambiar color tri�ngulo");
        btnColorTriangulo.setActionCommand(COLOR_TRIANGULO);
        btnColorTriangulo.addActionListener(this);
        panelModificaciones.add(btnColorTriangulo);

        // Panel Datos
        JPanel panelInformacion = new JPanel(new GridLayout(3, 2));
        panelInformacion.setBorder(new TitledBorder("Medidas en pixeles"));

        etiquetaPerimetro = new JLabel("Per�metro: ");
        etiquetaPerimetro.setFont(etiquetaPerimetro.getFont().deriveFont(Font.PLAIN));
        panelInformacion.add(etiquetaPerimetro);

        txtPerimetro = new JTextField(8);
        txtPerimetro.setEditable(false);
        txtPerimetro.setText(formatearValor(0) + " px");
        panelInformacion.add(txtPerimetro);

        etiquetaArea = new JLabel("�rea: ");
        etiquetaArea.setFont(etiquetaArea.getFont().deriveFont(Font.PLAIN));
        panelInformacion.add(etiquetaArea);

        txtArea = new JTextField(8);
        txtArea.setEditable(false);
        txtArea.setText(formatearValor(0) + " px");
        panelInformacion.add(txtArea);

        etiquetaAltura = new JLabel("Altura: ");
        etiquetaAltura.setFont(etiquetaAltura.getFont().deriveFont(Font.PLAIN));
        panelInformacion.add(etiquetaAltura);

        txtAltura = new JTextField(8);
        txtAltura.setEditable(false);
        txtAltura.setText(formatearValor(0) + " px");
        panelInformacion.add(txtAltura);

        add(panelModificaciones);
        add(panelInformacion);
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cambia la informaci�n del tri�ngulo.
     *
     * @param pPerimetro Nuevo per�metro del tri�ngulo. pPerimetro > 0.
     * @param pArea      Nueva �rea del tri�ngulo. pArea > 0.
     * @param pAltura    Nueva altura del tri�ngulo. pAltura > 0.
     */
    public void cambiarInformacion(double pPerimetro, double pArea, double pAltura) {
        txtArea.setText(formatearValor(pArea) + " px");
        txtPerimetro.setText(formatearValor(pPerimetro) + " px");
        txtAltura.setText(formatearValor(pAltura) + " px");
    }

    /**
     * Manejo de los eventos de los botones.
     *
     * @param pEvento Evento de click sobre un bot�n. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        if (PUNTOS.equals(pEvento.getActionCommand())) {
            principal.mostrarDialogoCambiarPuntos();
        }
        else if (COLOR_TRIANGULO.equals(pEvento.getActionCommand())) {
            principal.cambiarColorFondo();
        }
        else if (COLOR_LINEAS.equals(pEvento.getActionCommand())) {
            principal.cambiarColorLineas();
        }
    }

    /**
     * Formatea un valor num�rico para presentar en la interfaz.
     *
     * @param pValor Valor num�rico a ser formateado. pValor > 0.
     * @return Retorna un string con el valor formateado con puntos y signos.
     */
    private String formatearValor(double pValor) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(pValor);
    }

}
