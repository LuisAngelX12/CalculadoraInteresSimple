/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Familia
 */

public class FormulasExplicadas extends JDialog {

    private JTextArea txtContenido;
    private JComboBox<String> comboOpciones;

    public FormulasExplicadas(JFrame parent) {
        super(parent, "Fórmulas Explicadas", true);
        setSize(700, 500);
        setLocationRelativeTo(parent);

        String[] opciones = {
                "Todas las fórmulas",
                "Interés generado (I)",
                "Valor actual (C)",
                "Tasa de interés (i)",
                "Tiempo (t)",
                "Interpretación general"
        };

        comboOpciones = new JComboBox<>(opciones);
        comboOpciones.addActionListener(this::cambiarContenido);

        txtContenido = new JTextArea();
        txtContenido.setEditable(false);
        txtContenido.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtContenido.setText(getTodas());

        setLayout(new BorderLayout(10, 10));
        add(comboOpciones, BorderLayout.NORTH);
        add(new JScrollPane(txtContenido), BorderLayout.CENTER);

        setVisible(true);
    }

    private void cambiarContenido(ActionEvent e) {
        String seleccion = (String) comboOpciones.getSelectedItem();

        switch (seleccion) {
            case "Interés generado (I)" -> txtContenido.setText(getInteres());
            case "Valor actual (C)" -> txtContenido.setText(getValorActual());
            case "Tasa de interés (i)" -> txtContenido.setText(getTasa());
            case "Tiempo (t)" -> txtContenido.setText(getTiempo());
            case "Interpretación general" -> txtContenido.setText(getInterpretacion());
            default -> txtContenido.setText(getTodas());
        }
    }

    private String getInteres() {
        return "Interés generado (I):\n"
                + "\tI = C × i × t\n\n"
                + "Ejemplo:\n"
                + "\tC = 1,000.00\n"
                + "\ti = 5% (0.05)\n"
                + "\tt = 2\n"
                + "\tI = 1000 × 0.05 × 2 = 100.00\n";
    }

    private String getValorActual() {
        return "Valor actual (C):\n"
                + "\tC = I / (i × t)\n\n"
                + "Ejemplo:\n"
                + "\tI = 120.00\n"
                + "\ti = 6% (0.06)\n"
                + "\tt = 1.5\n"
                + "\tC = 120 / (0.06 × 1.5) = 1333.33\n";
    }

    private String getTasa() {
        return "Tasa de interés (i):\n"
                + "\ti = I / (C × t)\n\n"
                + "Ejemplo:\n"
                + "\tI = 150.00\n"
                + "\tC = 2,500.00\n"
                + "\tt = 2\n"
                + "\ti = 150 / (2500 × 2) = 0.03 = 3%\n";
    }

    private String getTiempo() {
        return "Tiempo (t):\n"
                + "\tt = I / (C × i)\n\n"
                + "Ejemplo:\n"
                + "\tI = 180.00\n"
                + "\tC = 3,000.00\n"
                + "\ti = 6% (0.06)\n"
                + "\tt = 180 / (3000 × 0.06) = 1\n";
    }

    private String getInterpretacion() {
        return "Variables:\n"
                + "\tC: Capital\n"
                + "\ti: Tasa de interés en decimal\n"
                + "\tt: Tiempo en años\n"
                + "\tI: Interés generado\n\n"
                + "Aplicación:\n"
                + "\t- Préstamos\n"
                + "\t- Inversiones\n"
                + "\t- Ahorros\n"
                + "\t- Descuentos\n";
    }

    private String getTodas() {
        return getInteres() + "\n" + getValorActual() + "\n" + getTasa() + "\n" + getTiempo() + "\n" + getInterpretacion();
    }
}