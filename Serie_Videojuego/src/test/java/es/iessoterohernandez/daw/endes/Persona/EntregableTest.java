package es.iessoterohernandez.daw.endes.Persona;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ejerciciosUnitarias.Serie;
import ejerciciosUnitarias.Videojuego;

public class EntregableTest {

    @Test
    public void testEntregarYDevolverVideojuego() {
        var videojuego = new Videojuego("Fortnite", 50, "Acción", "Epic Games");

        // Verificar que el videojuego no está entregado inicialmente
        assertFalse(videojuego.isEntregado());

        // Entregar el videojuego y verificar que está entregado
        videojuego.entregar();
        assertTrue(videojuego.isEntregado());

        // Devolver el videojuego y verificar que no está entregado
        videojuego.devolver();
        assertFalse(videojuego.isEntregado());
    }

    @Test
    public void testEntregarYDevolverSerie() {
        Serie serie = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");

        // Verificar que la serie no está entregada inicialmente
        assertFalse(serie.isEntregado());

        // Entregar la serie y verificar que está entregada
        serie.entregar();
        assertTrue(serie.isEntregado());

        // Devolver la serie y verificar que no está entregada
        serie.devolver();
        assertFalse(serie.isEntregado());
    }

    @Test
    public void testCompararVideojuegosPorHorasEstimadas() {
        var videojuego1 = new Videojuego("The Witcher 3", 120, "RPG", "CD Projekt");
        var videojuego2 = new Videojuego("Skyrim", 80, "RPG", "Bethesda");

        // Verificar que videojuego1 tiene más horas estimadas que videojuego2
        assertEquals(Videojuego.MAYOR, videojuego1.compareTo(videojuego2));

        // Verificar que videojuego2 tiene menos horas estimadas que videojuego1
        assertEquals(Videojuego.MENOR, videojuego2.compareTo(videojuego1));

        // Verificar que dos videojuegos con las mismas horas estimadas son iguales
        Videojuego videojuego3 = new Videojuego("Fallout 4", 120, "RPG", "Bethesda");
        assertEquals(Videojuego.IGUAL, videojuego1.compareTo(videojuego3));
    }

    @Test
    public void testCompararSeriesPorNumeroTemporadas() {
        var serie1 = new Serie("Game of Thrones", 8, "Fantasy", "David Benioff");
        var serie2 = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");

        // Verificar que serie1 tiene más temporadas que serie2
        assertEquals(Serie.MAYOR, serie1.compareTo(serie2));

        // Verificar que serie2 tiene menos temporadas que serie1
        assertEquals(Serie.MENOR, serie2.compareTo(serie1));

        // Verificar que dos series con el mismo número de temporadas son iguales
        Serie serie3 = new Serie("Stranger Things", 8, "Sci-Fi", "Duffer Brothers");
        assertEquals(Serie.IGUAL, serie1.compareTo(serie3));
    }
}