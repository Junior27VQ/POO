package com.krakedev.aliens.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Aliens;

public class TestPruebaFinalAI {
	private final double TOLERANCIA = 0.0001;

    @Test
    public void testConstructorYPrecioTotalInicial() {
        // 1. Validar que el constructor asigne precios base y el total inicie en 0
        // Tamaño 20 (Rango válido): 
        // Cuerpo: 20 * 0.20 = 4.0
        // Extremidad (unidad): 20 * 0.10 = 2.0
        // Ojos (unidad): 20 * 0.05 = 1.0
        Aliens alien = new Aliens(20, "Verde");

        assertEquals(20, alien.getTamanio());
        assertEquals(4.0, alien.getPrecioCuerpo(), TOLERANCIA);
        assertEquals(0.0, alien.getPrecioTotal(), TOLERANCIA, "El precio total debe iniciar en 0 hasta que se calcule");
    }

    @Test
    public void testPrecioTotalConExtremidadesYOjos() {
        // 1. Crear Alien tamaño 10
        // Precios base: Cuerpo=2.0, Extremidad=1.0, Ojos=0.5
        Aliens alien = new Aliens(10, "Azul");

        // 2. Agregar partes (Se dispara calcularPrecioTotal internamente)
        alien.agregarBrazos(2);   // 2 * 1.0 = 2.0
        alien.agregarPiernas(1);  // 1 * 1.0 = 1.0
        alien.agregarOjos(2);     // 2 * 0.5 = 1.0
        
        // 3. Validar Precio Total
        // Total = Cuerpo (2.0) + Extremidades (3 * 1.0) + Ojos (2 * 0.5)
        // Total = 2.0 + 3.0 + 1.0 = 6.0
        assertEquals(6.0, alien.getPrecioTotal(), TOLERANCIA, "El precio total con 3 extremidades y 2 ojos debería ser 6.0");
    }

    @Test
    public void testLimiteOjosSegunTamanioPequeno() {
        // Tamaño 5 a 10 permite máximo 3 ojos
        Aliens alien = new Aliens(8, "Gris");
        
        assertTrue(alien.agregarOjos(3), "Debería permitir agregar 3 ojos para tamaño 8");
        assertFalse(alien.agregarOjos(1), "No debería permitir un 4to ojo (límite es 3)");
        
        // Validar que el precio total solo sumó los 3 ojos permitidos
        // Cuerpo: 8*0.2=1.6 | Ojos: 3 * (8*0.05=0.4) = 1.2
        // Total: 1.6 + 1.2 = 2.8
        assertEquals(2.8, alien.getPrecioTotal(), TOLERANCIA);
    }

    @Test
    public void testLimiteOjosSegunTamanioGrande() {
        // Tamaño 21 a 30 permite máximo 7 ojos
        Aliens alien = new Aliens(30, "Rojo");
        
        assertTrue(alien.agregarOjos(7), "Debería permitir hasta 7 ojos para tamaño 30");
        assertFalse(alien.agregarOjos(1), "No debería permitir el ojo número 8");
        
        // Precio: Cuerpo (6.0) + Ojos (7 * 1.5) = 6.0 + 10.5 = 16.5
        assertEquals(16.5, alien.getPrecioTotal(), TOLERANCIA);
    }

    @Test
    public void testAjusteAutomaticoTamanioYPrecios() {
        // 1. Intentar tamaño inválido (40), debe ajustar a 25 automáticamente
        // Precios para tamaño 25: Cuerpo=5.0, Extremidad=2.5, Ojo=1.25
        Aliens alien = new Aliens(40, "Negro");
        
        assertEquals(25, alien.getTamanio(), "El tamaño debió ajustarse a 25");
        
        // 2. Agregar extremidades para verificar que usa el precio del tamaño ajustado
        alien.agregarBrazos(2); 
        
        // Total = Cuerpo (5.0) + 2 extremidades (2 * 2.5 = 5.0) = 10.0
        assertEquals(10.0, alien.getPrecioTotal(), TOLERANCIA, "El cálculo debe basarse en el tamaño ajustado de 25");
    }

    @Test
    public void testSumaExtremidadesCombinadas() {
        Aliens alien = new Aliens(20, "Amarillo");
        
        alien.agregarBrazos(5);
        boolean resultadoPiernas = alien.agregarPiernas(6); // Total sería 11
        
        assertFalse(resultadoPiernas, "No debe permitir más de 10 extremidades en total");
        assertEquals(5, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
        
        // Validar que el precio total solo incluya las extremidades que sí se agregaron (los 5 brazos)
        // Cuerpo: 4.0 | Brazos: 5 * 2.0 = 10.0 | Total = 14.0
        assertEquals(14.0, alien.getPrecioTotal(), TOLERANCIA);
    }

}
