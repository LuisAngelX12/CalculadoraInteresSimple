/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

/**
 *
 * @author Familia
 */

public class ConvertidorInversion extends JDialog {

    private JFormattedTextField txtValorNeto;
    private JFormattedTextField txtPeriodos;
    private JFormattedTextField txtResultado;
    private JButton btnCalcular;

    public ConvertidorInversion(JFrame parent) {
        super(parent, "Interés Neto Mensual", true);
        setSize(500, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        // Formato decimal español
        NumberFormat formato = NumberFormat.getNumberInstance(new Locale("es", "ES"));
        formato.setMaximumFractionDigits(2);
        formato.setMinimumFractionDigits(2);
        formato.setGroupingUsed(true);

        NumberFormatter formatterDecimal = new NumberFormatter(formato);
        formatterDecimal.setValueClass(Double.class);
        formatterDecimal.setMinimum(0.0);
        formatterDecimal.setAllowsInvalid(false);

        // Título
        JLabel lblTitulo = new JLabel("División de Interés Neto Total por Períodos", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel central con GridLayout 3 filas x 2 columnas
        JPanel panelCentral = new JPanel(new GridLayout(3, 2, 10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        txtValorNeto = new JFormattedTextField(formatterDecimal);
        txtPeriodos = new JFormattedTextField(new NumberFormatter(NumberFormat.getIntegerInstance()));
        txtResultado = new JFormattedTextField(formatterDecimal);
        txtResultado.setEditable(false);

        panelCentral.add(new JLabel("Valor neto total:"));
        panelCentral.add(txtValorNeto);

        panelCentral.add(new JLabel("Cantidad de períodos:"));
        panelCentral.add(txtPeriodos);

        panelCentral.add(new JLabel("Interés neto por período:"));
        panelCentral.add(txtResultado);

        add(panelCentral, BorderLayout.CENTER);

        // Botón calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(e -> calcular());

        JPanel panelInferior = new JPanel();
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelInferior.add(btnCalcular);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void calcular() {
    try {
        BigDecimal valorNeto = BigDecimal.valueOf(getDoubleValue(txtValorNeto));
        BigDecimal periodos = BigDecimal.valueOf(getDoubleValue(txtPeriodos));

        if (valorNeto.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("El valor neto total debe ser mayor que cero.");
        if (periodos.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("El número de períodos debe ser mayor que cero.");

        BigDecimal resultado = valorNeto.divide(periodos, 20, RoundingMode.DOWN);
        txtResultado.setValue(resultado.setScale(2, RoundingMode.DOWN)); // <--- Aquí se fija a 2 decimales sin redondear

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage() + "\nFormato correcto: 5.769,375 y 18",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private double getDoubleValue(JFormattedTextField field) {
        Object val = field.getValue();
        if (val instanceof Number number) {
            return number.doubleValue();
        }
        return 0;
    }
}