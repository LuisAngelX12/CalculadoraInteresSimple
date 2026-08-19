/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 *
 * @author Familia
 */

public class ConvertidorTasas extends JDialog {

    private JTextField txtValor;
    private JComboBox<String> comboOrigen, comboDestino;
    private JLabel lblResultado;

    public ConvertidorTasas(JFrame parent) {
        super(parent, "Convertidor de Tasas de Interés", true);
        setSize(450, 280);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        // Título
        JLabel lblTitulo = new JLabel("Convertidor de Tasas Equivalentes", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel central
        JPanel centro = new JPanel(new GridLayout(3, 2, 10, 10));
        centro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        String[] opciones = {"Anual", "Mensual", "Trimestral", "Cuatrimestral", "Semestral"};

        txtValor = new JTextField();
        comboOrigen = new JComboBox<>(opciones);
        comboDestino = new JComboBox<>(opciones);

        centro.add(new JLabel("Tasa de Interés (%):"));
        centro.add(txtValor);
        centro.add(new JLabel("Convertir de:"));
        centro.add(comboOrigen);
        centro.add(new JLabel("A:"));
        centro.add(comboDestino);

        add(centro, BorderLayout.CENTER);

        // Panel inferior (botón + resultado)
        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.addActionListener(e -> convertir());

        lblResultado = new JLabel(" ", JLabel.CENTER);
        lblResultado.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelInferior.add(btnConvertir, BorderLayout.NORTH);
        panelInferior.add(lblResultado, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void convertir() {
        try {
            double tasa = Double.parseDouble(txtValor.getText()) / 100.0;
            int nOrigen = periodos(comboOrigen.getSelectedItem().toString());
            int nDestino = periodos(comboDestino.getSelectedItem().toString());

            double tasaEquivalente = Math.pow(1 + tasa / nOrigen, (double) nOrigen / nDestino) - 1;
            double tasaFinal = tasaEquivalente * 100.0;

            DecimalFormat df = new DecimalFormat("#.####");
            lblResultado.setText("Tasa equivalente: " + df.format(tasaFinal) + "%");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingresa un valor válido para la tasa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int periodos(String tipo) {
        return switch (tipo) {
            case "Anual" -> 1;
            case "Mensual" -> 12;
            case "Trimestral" -> 4;
            case "Cuatrimestral" -> 3;
            case "Semestral" -> 2;
            default -> 1;
        };
    }
}