/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculadoraInteresSimple;

import Funciones.OperacionInteres;
import Funciones.HistorialOperaciones;
import Herramientas.CalcularTiempoDecimal;
import Herramientas.ComparadorIntereses;
import Herramientas.ConvertidorInversion;
import Herramientas.ConvertidorTasas;
import Herramientas.FormulasExplicadas;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Familia
 */
public class CalculadoraInteresSimple extends JFrame {

    private final JFormattedTextField txtCapital, txtTasa, txtInteres, txtISR;
    private final JSpinner spnAños, spnMeses, spnDias;
    private final JTextField txtResultado, txtResultado2;
    private final JButton btnValorFuturo, btnValorActual, btnTasaInteres, btnTiempo, btnLimpiar;

    public CalculadoraInteresSimple() {
        setTitle("Calculadora de Interés Simple");

        ImageIcon icono = new ImageIcon(
                getClass().getResource("/CalculadoraInteresSimple/icono.png")
        );

        setIconImage(icono.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel panelConImagen = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource("/CalculadoraInteresSimple/fondo.png"));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        panelConImagen.setLayout(new BorderLayout(10, 10));
        setContentPane(panelConImagen);

        // MENU BARRA
        JMenuBar menuBar = new JMenuBar();
        JMenu menuHerramientas = new JMenu("Herramientas");

        JMenuItem itemTiempo = new JMenuItem("Convertir tiempo decimal");
        itemTiempo.addActionListener(e -> new CalcularTiempoDecimal(this));
        menuHerramientas.add(itemTiempo);

        JMenuItem itemConvertidor = new JMenuItem("Convertidor de Tasas de Interés");
        itemConvertidor.addActionListener(e -> new ConvertidorTasas(this));
        menuHerramientas.add(itemConvertidor);

        JMenuItem itemFormulas = new JMenuItem("Ver Fórmulas Explicadas");
        itemFormulas.addActionListener(e -> new FormulasExplicadas(this));
        menuHerramientas.add(itemFormulas);

        JMenuItem itemComparador = new JMenuItem("Comparador de Intereses");
        itemComparador.addActionListener(e -> new ComparadorIntereses(this));
        menuHerramientas.add(itemComparador);

        JMenuItem itemInversiones = new JMenuItem("Inversiones Anuales/Mensuales");
        itemInversiones.addActionListener(e -> new ConvertidorInversion(this));
        menuHerramientas.add(itemInversiones);

        menuBar.add(menuHerramientas);
        setJMenuBar(menuBar);

        JLabel lblTitulo = new JLabel("Calculadora de Interés Simple", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        panelConImagen.add(lblTitulo, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        contentPanel.setLayout(new GridLayout(7, 2, 10, 10));

        // Formato sin restricciones (para capital e interés generado)
        NumberFormat formato = NumberFormat.getNumberInstance(new Locale("es", "ES"));
        formato.setMaximumFractionDigits(2);
        NumberFormatter formatter = new NumberFormatter(formato);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(true);    // Permite escritura fluida
        formatter.setCommitsOnValidEdit(true); // Aplica el valor cuando es válido
        formatter.setMinimum(0.0);

        // Formato restringido entre 0% y 100% (para tasa e ISR)
        NumberFormat formatoPorcentaje = NumberFormat.getNumberInstance(new Locale("es", "ES"));
        formatoPorcentaje.setMaximumFractionDigits(2);
        NumberFormatter formatterPorcentaje = new NumberFormatter(formatoPorcentaje);
        formatterPorcentaje.setValueClass(Double.class);
        //formatterPorcentaje.setAllowsInvalid(false);
        formatterPorcentaje.setMinimum(0.0);
        formatterPorcentaje.setMaximum(100.0);

        txtCapital = new JFormattedTextField(formatter);
        txtTasa = new JFormattedTextField(formatterPorcentaje);
        txtInteres = new JFormattedTextField(formatter);
        txtISR = new JFormattedTextField(formatterPorcentaje);

        JPanel tiempoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        spnAños = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1)); // Valor inicial, Valor mínimo, Valor máximo, Secuencia ++ 
        spnMeses = new JSpinner(new SpinnerNumberModel(0, 0, 11, 1));
        spnDias = new JSpinner(new SpinnerNumberModel(0, 0, 359, 1));
        tiempoPanel.add(new JLabel("Años:"));
        tiempoPanel.add(spnAños);
        tiempoPanel.add(new JLabel("Meses:"));
        tiempoPanel.add(spnMeses);
        tiempoPanel.add(new JLabel("Días:"));
        tiempoPanel.add(spnDias);

        txtResultado = new JTextField();
        txtResultado.setEditable(false);

        txtResultado2 = new JTextField();
        txtResultado2.setEditable(false);

        contentPanel.add(new JLabel("Capital (C):"));
        contentPanel.add(txtCapital);
        contentPanel.add(new JLabel("Tasa de Interés (i%):"));
        contentPanel.add(txtTasa);
        contentPanel.add(new JLabel("Tiempo (Años/Meses/Días):"));
        contentPanel.add(tiempoPanel);
        contentPanel.add(new JLabel("Interés Generado (I):"));
        contentPanel.add(txtInteres);
        contentPanel.add(new JLabel("Impuesto sobre la Renta (ISR%):"));
        contentPanel.add(txtISR);
        contentPanel.add(new JLabel("Resultado:"));
        contentPanel.add(txtResultado);
        contentPanel.add(new JLabel("Periodos/Neto Mensual:"));
        contentPanel.add(txtResultado2);

        for (Component c : contentPanel.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(new Font("Segoe UI", Font.BOLD, 20));
            }
        }

        panelConImagen.add(contentPanel, BorderLayout.CENTER);

        JPanel botones = new JPanel(new GridLayout(2, 3, 10, 10));
        botones.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        btnValorFuturo = new JButton("Calcular Interés (I)");
        btnValorActual = new JButton("Calcular Capital (C)");
        btnTasaInteres = new JButton("Calcular Tasa de Interés (i%)");
        btnTiempo = new JButton("Calcular Tiempo (t)");
        btnLimpiar = new JButton("Limpiar Campos");

        btnValorFuturo.addActionListener(e -> validarYCalcularValorFuturo());
        btnValorActual.addActionListener(e -> validarYCalcularValorActual());
        btnTasaInteres.addActionListener(e -> validarYCalcularTasaInteres());
        btnTiempo.addActionListener(e -> validarYCalcularTiempo());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        botones.add(btnValorFuturo);
        botones.add(btnValorActual);
        botones.add(btnLimpiar);
        botones.add(btnTasaInteres);
        botones.add(btnTiempo);

        panelConImagen.add(botones, BorderLayout.SOUTH);

        Color fondo = new Color(230, 240, 255);
        getContentPane().setBackground(fondo);

        contentPanel.setBackground(fondo);
        botones.setBackground(fondo);
        tiempoPanel.setBackground(fondo);
        contentPanel.setOpaque(false);
        botones.setOpaque(false);
        tiempoPanel.setOpaque(false);

    }

    private double tiempoEnAños() {
        int Años = (int) spnAños.getValue();
        int meses = (int) spnMeses.getValue();
        int dias = (int) spnDias.getValue();

        int totalDias = (Años * 360) + (meses * 30) + dias;
        double t = totalDias / 360.0; // Tiempo financiero 

        return t; // Tiempo Real: Años + (meses / 12.0) + (dias / 365.0);
    }

    private void validarYCalcularValorFuturo() {
        boolean valido = true;
        resetColores();

        if (txtCapital.getValue() == null) {
            txtCapital.setBackground(Color.PINK);
            valido = false;
        }
        if (txtTasa.getValue() == null) {
            txtTasa.setBackground(Color.PINK);
            valido = false;
        }
        if (tiempoEnAños() == 0) {
            spnAños.getEditor().getComponent(0).setBackground(Color.PINK);
            spnMeses.getEditor().getComponent(0).setBackground(Color.PINK);
            spnDias.getEditor().getComponent(0).setBackground(Color.PINK);
            valido = false;
        }

        if (!valido) {
            JOptionPane.showMessageDialog(this,
                    "Para calcular el Interés (Bruto) necesitas: Capital, Tasa de interés y Tiempo (años/meses/días).",
                    "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        calcularValorFuturo();
    }

    private void validarYCalcularValorActual() {
        boolean valido = true;
        resetColores();

        if (txtInteres.getValue() == null) {
            txtInteres.setBackground(Color.PINK);
            valido = false;
        }
        if (txtTasa.getValue() == null) {
            txtTasa.setBackground(Color.PINK);
            valido = false;
        }
        if (tiempoEnAños() == 0) {
            spnAños.getEditor().getComponent(0).setBackground(Color.PINK);
            spnMeses.getEditor().getComponent(0).setBackground(Color.PINK);
            spnDias.getEditor().getComponent(0).setBackground(Color.PINK);
            valido = false;
        }

        if (!valido) {
            JOptionPane.showMessageDialog(this,
                    "Para calcular el Valor Actual necesitas: Interés generado, Tasa de interés y Tiempo (años/meses/días).",
                    "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        calcularValorActual();
    }

    private void validarYCalcularTasaInteres() {
        boolean valido = true;
        resetColores();

        if (txtInteres.getValue() == null) {
            txtInteres.setBackground(Color.PINK);
            valido = false;
        }
        if (txtCapital.getValue() == null) {
            txtCapital.setBackground(Color.PINK);
            valido = false;
        }
        if (tiempoEnAños() == 0) {
            spnAños.getEditor().getComponent(0).setBackground(Color.PINK);
            spnMeses.getEditor().getComponent(0).setBackground(Color.PINK);
            spnDias.getEditor().getComponent(0).setBackground(Color.PINK);
            valido = false;
        }

        if (!valido) {
            JOptionPane.showMessageDialog(this,
                    "Para calcular la Tasa de Interés necesitas: Interés generado, Capital y Tiempo (años/meses/días).",
                    "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        calcularTasaInteres();
    }

    private void validarYCalcularTiempo() {
        boolean valido = true;
        resetColores();

        if (txtInteres.getValue() == null) {
            txtInteres.setBackground(Color.PINK);
            valido = false;
        }
        if (txtCapital.getValue() == null) {
            txtCapital.setBackground(Color.PINK);
            valido = false;
        }
        if (txtTasa.getValue() == null) {
            txtTasa.setBackground(Color.PINK);
            valido = false;
        }

        if (!valido) {
            JOptionPane.showMessageDialog(this,
                    "Para calcular el Tiempo necesitas: Interés generado, Capital y Tasa de interés.",
                    "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        calcularTiempo();
    }

    private void calcularValorFuturo() {
        try {
            double C = ((Number) txtCapital.getValue()).doubleValue();
            double i = ((Number) txtTasa.getValue()).doubleValue() / 100;
            double t = tiempoEnAños();

            double I = C * i * t;

            // Leer ISR desde el NumberFormatter
            double porcentajeISR = txtISR.getValue() == null
                    ? 0
                    : ((Number) txtISR.getValue()).doubleValue();

            double isr = I * (porcentajeISR / 100);
            double interesNeto = I - isr;

            // Truncar a 2 decimales sin redondear
            double I_truncado = Math.floor(I * 100) / 100.0;
            double interesNeto_truncado = Math.floor(interesNeto * 100) / 100.0;

            int anios = (int) spnAños.getValue();
            int meses = (int) spnMeses.getValue();
            int dias = (int) spnDias.getValue();

            double periodosMensuales = anios * 12 + meses + (dias / 30.0);
            double periodos_truncado = Math.floor(periodosMensuales * 100) / 100.0;

            double interesMensual = interesNeto_truncado / periodos_truncado;
            double interesMensual_truncado = Math.floor(interesMensual * 100) / 100.0;

            DecimalFormat df = new DecimalFormat("#,##0.00");
            df.setDecimalFormatSymbols(
                    DecimalFormatSymbols.getInstance(new Locale("es", "ES"))
            );

            txtResultado.setText(
                    "Bruto: " + df.format(I_truncado)
                    + " | ISR: " + df.format(porcentajeISR) + "%"
                    + " | Neto: " + df.format(interesNeto_truncado)
            );

            txtResultado2.setText(
                    "Periodos: " + df.format(periodos_truncado)
                    + " | Neto mensual: " + df.format(interesMensual_truncado)
            );

            HistorialOperaciones.getInstancia().agregarOperacion(
                    new OperacionInteres(C, i, t, I, porcentajeISR)
            );

        } catch (Exception ex) {
            mostrarError();
        }
    }

    private void calcularValorActual() {
        try {
            txtResultado2.setText("");
            double I = ((Number) txtInteres.getValue()).doubleValue();       // Interés generado
            double i = ((Number) txtTasa.getValue()).doubleValue() / 100;    // Tasa en decimal
            double t = tiempoEnAños();                                       // Tiempo en años

            double C = I / (i * t); // Valor actual (capital)

            // Truncar a 2 decimales sin redondear
            double C_truncado = Math.floor(C * 100) / 100.0;

            DecimalFormat df = new DecimalFormat("#,##0.00");
            df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("es", "ES")));

            // Mostrar resultados
            txtResultado.setText("Valor Actual: " + df.format(C_truncado));

        } catch (Exception ex) {
            mostrarError();
        }
    }

    private void calcularTasaInteres() {
        try {
            txtResultado2.setText("");

            double I = ((Number) txtInteres.getValue()).doubleValue();
            double C = ((Number) txtCapital.getValue()).doubleValue();
            double t = tiempoEnAños();

            double i = (I / (C * t)) * 100; // tasa en porcentaje
            double i_truncado = Math.floor(i * 100) / 100.0;

            // Formato español (coma para decimales)
            DecimalFormat df = new DecimalFormat("#,##0.00");
            df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("es", "ES")));

            // Mostrar resultados
            txtResultado.setText("Tasa de Interés: " + df.format(i_truncado) + "%");

        } catch (Exception ex) {
            mostrarError();
        }
    }

    private void calcularTiempo() {
        try {
            txtResultado2.setText("");
            double I = ((Number) txtInteres.getValue()).doubleValue();
            double C = ((Number) txtCapital.getValue()).doubleValue();
            double i = ((Number) txtTasa.getValue()).doubleValue() / 100;
            double t = I / (C * i);

            int totalDias = (int) Math.round(t * 360);
            int Años = totalDias / 360;
            int meses = (totalDias % 360) / 30;
            int dias = (totalDias % 360) % 30;

            txtResultado.setText("Tiempo estimado: " + Años + " años, " + meses + " meses, " + dias + " días. (" + String.format("%.4f", t) + ")");

        } catch (Exception ex) {
            mostrarError();
        }
    }

    private void limpiarCampos() {
        txtCapital.setValue(null);
        txtTasa.setValue(null);
        txtInteres.setValue(null);
        txtISR.setValue(null);
        txtResultado.setText("");
        txtResultado2.setText("");
        spnAños.setValue(0);
        spnMeses.setValue(0);
        spnDias.setValue(0);
        resetColores();
    }

    public void setTiempo(int anios, int meses, int dias) {
        spnAños.setValue(anios);
        spnMeses.setValue(meses);
        spnDias.setValue(dias);
    }

    private void resetColores() {
        txtCapital.setBackground(Color.WHITE);
        txtTasa.setBackground(Color.WHITE);
        txtInteres.setBackground(Color.WHITE);
        spnAños.getEditor().getComponent(0).setBackground(Color.WHITE);
        spnMeses.getEditor().getComponent(0).setBackground(Color.WHITE);
        spnDias.getEditor().getComponent(0).setBackground(Color.WHITE);
    }

    private void mostrarError() {
        JOptionPane.showMessageDialog(this, "Por favor, complete los campos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraInteresSimple().setVisible(true));
    }
}
