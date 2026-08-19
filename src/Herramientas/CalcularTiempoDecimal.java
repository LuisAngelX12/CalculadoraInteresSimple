/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

import CalculadoraInteresSimple.CalculadoraInteresSimple;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Familia
 */
public class CalcularTiempoDecimal extends JDialog {

    public CalcularTiempoDecimal(CalculadoraInteresSimple parent) {
        super(parent, "Convertir tiempo decimal", true);
        setSize(400, 250);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField txtDecimal = new JTextField();
        JLabel lblResultado = new JLabel("Resultado:");
        JButton btnConvertir = new JButton("Convertir");
        JButton btnAplicar = new JButton("Aplicar al formulario");
        btnAplicar.setEnabled(false); // solo se activa tras una conversión válida

        final int[] valores = new int[3]; // años, meses, días

        btnConvertir.addActionListener(e -> {
            try {
                String texto = txtDecimal.getText().trim();

                if (texto.isEmpty()) {
                    throw new NumberFormatException("Entrada vacía");
                }

                // Aceptar tanto 12,2 como 12.2
                texto = texto.replace(",", ".");

                double t = Double.parseDouble(texto);

                if (t < 0) {
                    throw new NumberFormatException("El tiempo no puede ser negativo");
                }

                int totalDias = (int) Math.round(t * 360);

                int anios = totalDias / 360;
                int meses = (totalDias % 360) / 30;
                int dias = (totalDias % 360) % 30;

                lblResultado.setText(
                        "≈ " + anios + " años, "
                        + meses + " meses, "
                        + dias + " días."
                );

                valores[0] = anios;
                valores[1] = meses;
                valores[2] = dias;

                btnAplicar.setEnabled(true);

            } catch (NumberFormatException ex) {
                lblResultado.setText("Entrada no válida");
                btnAplicar.setEnabled(false);
            }
        });

        btnAplicar.addActionListener(e -> {
            parent.setTiempo(valores[0], valores[1], valores[2]);
            dispose();
        });

        JPanel centro = new JPanel(new GridLayout(2, 1, 5, 5));
        centro.add(txtDecimal);
        centro.add(btnConvertir);

        panel.add(new JLabel("Tiempo en años decimales:"), BorderLayout.NORTH);
        panel.add(centro, BorderLayout.CENTER);
        panel.add(lblResultado, BorderLayout.SOUTH);
        panel.add(btnAplicar, BorderLayout.EAST);

        add(panel);
        setVisible(true);
    }
}
