package com.krakedev.aliens.testJUnit;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Aliens;

public class TestPruebasAI {
	private final double TOLERANCIA = 0.0001;

    @Test
    public void testConstructorRangoValido() {
        // Caso: El tamaño está dentro del rango permitido (5 a 30)
        // Valores esperados:
        // precioCuerpo = 10 * 0.20 = 2.0
        // precioExtremidad = 10 * 0.10 = 1.0
        // precioOjos = 10 * 0.05 = 0.5
        Aliens alien = new Aliens(10, "Verde");

        assertEquals(10, alien.getTamanio(), "El tamaño debería ser 10");
        assertEquals("Verde", alien.getColor(), "El color debería ser Verde");
        assertEquals(2.0, alien.getPrecioCuerpo(), TOLERANCIA, "Precio cuerpo incorrecto para tamaño 10");
        assertEquals(1.0, alien.getPrecioExtremidad(), TOLERANCIA, "Precio extremidad incorrecto para tamaño 10");
        assertEquals(0.5, alien.getPrecioOjos(), TOLERANCIA, "Precio ojos incorrecto para tamaño 10");
    }

    @Test
    public void testConstructorLimiteInferior() {
        // Caso: El tamaño es exactamente el límite inferior (5)
        // Precios: Cuerpo: 5 * 0.2 = 1.0, Extr: 0.5, Ojos: 0.25
        Aliens alien = new Aliens(5, "Azul");

        assertEquals(5, alien.getTamanio(), "Debe aceptar el tamaño límite inferior de 5");
        assertEquals(1.0, alien.getPrecioCuerpo(), TOLERANCIA);
        assertEquals(0.5, alien.getPrecioExtremidad(), TOLERANCIA);
        assertEquals(0.25, alien.getPrecioOjos(), TOLERANCIA);
    }

    @Test
    public void testConstructorLimiteSuperior() {
        // Caso: El tamaño es exactamente el límite superior (30)
        // Precios: Cuerpo: 30 * 0.2 = 6.0, Extr: 3.0, Ojos: 1.5
        Aliens alien = new Aliens(30, "Rojo");

        assertEquals(30, alien.getTamanio(), "Debe aceptar el tamaño límite superior de 30");
        assertEquals(6.0, alien.getPrecioCuerpo(), TOLERANCIA);
        assertEquals(3.0, alien.getPrecioExtremidad(), TOLERANCIA);
        assertEquals(1.5, alien.getPrecioOjos(), TOLERANCIA);
    }

    @Test
    public void testConstructorFueraDeRangoMenor() {
        // Caso: Tamaño menor al permitido (4)
        // Debería asignar el tamaño por defecto: 25
        // Precios para 25: Cuerpo: 5.0, Extr: 2.5, Ojos: 1.25
        Aliens alien = new Aliens(4, "Gris");

        assertEquals(25, alien.getTamanio(), "Si el tamaño es < 5, debe asignar 25 por defecto");
        assertEquals(5.0, alien.getPrecioCuerpo(), TOLERANCIA);
        assertEquals(2.5, alien.getPrecioExtremidad(), TOLERANCIA);
        assertEquals(1.25, alien.getPrecioOjos(), TOLERANCIA);
    }

    @Test
    public void testConstructorFueraDeRangoMayor() {
        // Caso: Tamaño mayor al permitido (31)
        // Debería asignar el tamaño por defecto: 25
        Aliens alien = new Aliens(31, "Purpura");

        assertEquals(25, alien.getTamanio(), "Si el tamaño es > 30, debe asignar 25 por defecto");
        assertEquals(5.0, alien.getPrecioCuerpo(), TOLERANCIA);
    }

    @Test
    public void testAtributosPorDefecto() {
        // Caso: Validar que el constructor no altera ojos, brazos o pies si no se le pide
        // Según la clase, estos campos no se inicializan en el constructor, deben ser 0
        Aliens alien = new Aliens(20, "Amarillo");

        assertEquals(0, alien.getNumeroOjos(), "El número de ojos debe iniciar en 0");
        assertEquals(0, alien.getNumeroBrazos(), "El número de brazos debe iniciar en 0");
        assertEquals(0, alien.getNumeroPies(), "El número de pies debe iniciar en 0");
    }
}
