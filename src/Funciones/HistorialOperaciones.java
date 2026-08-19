/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Familia
 */

public class HistorialOperaciones {
    private static HistorialOperaciones instancia = new HistorialOperaciones();
    private List<OperacionInteres> historial = new ArrayList<>();

    private HistorialOperaciones() {}

    public static HistorialOperaciones getInstancia() {
        return instancia;
    }

    public void agregarOperacion(OperacionInteres op) {
        historial.add(op);
    }

    public List<OperacionInteres> getHistorial() {
        return historial;
    }

    public void limpiar() {
        historial.clear();
    }
}