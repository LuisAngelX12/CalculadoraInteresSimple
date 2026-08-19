/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

import Funciones.HistorialOperaciones;
import Funciones.OperacionInteres;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Familia
 */

public class ComparadorIntereses extends JDialog {

    private JTable tabla;
    private DefaultTableModel modelo;
    private List<OperacionInteres> historial;

    public ComparadorIntereses(JFrame parent) {
        super(parent, "Comparador de Intereses", true);
        setSize(800, 400);
        setLocationRelativeTo(parent);

        historial = HistorialOperaciones.getInstancia().getHistorial();

        modelo = new DefaultTableModel(new Object[]{
            "#", "Capital", "Tasa (%)", "Tiempo (años)", "Interés Bruto (I)", "ISR", "Interés Neto", "Periodos (meses)", "Rentabilidad (%)"
        }, 0);

        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        for (int i = 0; i < historial.size(); i++) {
            OperacionInteres op = historial.get(i);

            double interesBruto = op.capital * op.tasa * op.tiempo;
            double isr = interesBruto * (op.isr / 100);
            double interesNeto = interesBruto - isr;
            double periodos = op.tiempo * 12;
            double rentabilidad = (interesNeto / op.capital) * 100;

            modelo.addRow(new Object[]{
                i + 1,
                op.capital,
                op.tasa * 100,
                op.tiempo,
                redondear(interesBruto),
                redondear(isr),
                redondear(interesNeto),
                redondear(periodos),
                redondear(rentabilidad)
            });
        }

        JButton btnComparar = new JButton("Mostrar más rentable");
        JLabel lblResultado = new JLabel(" ");

        btnComparar.addActionListener(e -> {
            if (historial.isEmpty()) {
                lblResultado.setText("No hay operaciones registradas.");
                return;
            }

            OperacionInteres mejor = historial.get(0);
            double mejorRentabilidad = calcularRentabilidad(mejor);

            for (OperacionInteres op : historial) {
                double rent = calcularRentabilidad(op);
                if (rent > mejorRentabilidad) {
                    mejor = op;
                    mejorRentabilidad = rent;
                }
            }

            lblResultado.setText("Más rentable: C=" + mejor.capital + ", i=" + (mejor.tasa * 100) + "% t=" + mejor.tiempo + ", Rentabilidad=" + redondear(mejorRentabilidad) + "%");
        });

        JPanel abajo = new JPanel(new BorderLayout());
        abajo.add(btnComparar, BorderLayout.WEST);
        abajo.add(lblResultado, BorderLayout.CENTER);

        add(scrollPane, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);

        setVisible(true);
    }

    private double calcularRentabilidad(OperacionInteres op) {
        double interesBruto = op.capital * op.tasa * op.tiempo;
        double isr = interesBruto * (op.isr / 100);
        double interesNeto = interesBruto - isr;
        return (interesNeto / op.capital) * 100;
    }

    private String redondear(double valor) {
        return String.format("%.2f", valor);
    }
}
