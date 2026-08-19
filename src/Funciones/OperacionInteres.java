/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Familia
 */

public class OperacionInteres {
    public double capital;
    public double tasa;      // en decimal, ej. 0.075
    public double tiempo;
    public double interes;   // interés bruto
    public double isr;       // ISR en porcentaje, ej. 7.5

    public OperacionInteres(double capital, double tasa, double tiempo, double interes, double isr) {
        this.capital = capital;
        this.tasa = tasa;
        this.tiempo = tiempo;
        this.interes = interes;
        this.isr = isr;
    }

    // Constructor anterior (por compatibilidad)
    public OperacionInteres(double capital, double tasa, double tiempo, double interes) {
        this(capital, tasa, tiempo, interes, 0);
    }

    // Formateador con coma como separador decimal y punto para miles
    private static final DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("es", "ES")));

    @Override
    public String toString() {
        return "Capital: " + df.format(capital) +
             " | Tasa: " + df.format(tasa * 100) + "%" +
             " | Tiempo: " + df.format(tiempo) + " años" +
             " | Interés: " + df.format(interes) +
             " | ISR: " + df.format(isr) + "%";
    }
}