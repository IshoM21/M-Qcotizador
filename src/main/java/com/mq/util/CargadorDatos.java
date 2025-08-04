package com.mq.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class CargadorDatos {

    public static <T> List<T> leerDesdeCsv(String archivoCsv, Class<T> clazz) {
        List<T> objetos = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(archivoCsv))) {
            String[] cabeceras = csvReader.readNext(); // Leer la cabecera
            String[] fila;

            while ((fila = csvReader.readNext()) != null) {
                // Crear una nueva instancia de la clase
                T objeto = clazz.getDeclaredConstructor().newInstance();

                // Asignar valores a los campos de la clase
                for (int i = 0; i < cabeceras.length; i++) {
                    String nombreCampo = cabeceras[i];
                    Field campo = clazz.getDeclaredField(nombreCampo);
                    campo.setAccessible(true);

                    // Convertir el valor al tipo del campo
                    Object valor = convertirTipo(campo.getType(), fila[i]);
                    campo.set(objeto, valor);
                }
                objetos.add(objeto);
            }
        } catch (IOException | CsvValidationException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    private static Object convertirTipo(Class<?> tipo, String valor) {
        if (tipo == Long.class || tipo == long.class) {
            return Long.parseLong(valor);
        } else if (tipo == Integer.class || tipo == int.class) {
            return Integer.parseInt(valor);
        } else if (tipo == Double.class || tipo == double.class) {
            return Double.parseDouble(valor);
        } else if (tipo == Boolean.class || tipo == boolean.class) {
            return Boolean.parseBoolean(valor);
        } else {
            return valor; // Por defecto, devolver el string
        }
    }


}


