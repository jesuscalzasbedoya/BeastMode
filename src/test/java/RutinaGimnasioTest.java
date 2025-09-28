import org.beastMode.EjercicioGimnasio;
import org.beastMode.RutinaGimnasio;
import org.beastMode.SerieGimnasio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RutinaGimnasioTest {

    private RutinaGimnasio rutina;

    @BeforeEach
    void setUp() {
        rutina = new RutinaGimnasio(1);
        rutina.setEjerciciosGimnasio(new ArrayList<>());
    }

    // CA1: Crear rutina con ejercicios, series, repeticiones y peso
    @Test
    void testCrearRutinaConEjercicios() {
        SerieGimnasio serie = new SerieGimnasio(1, 10, 50);
        ArrayList<SerieGimnasio> series = new ArrayList<>();
        series.add(serie);
        EjercicioGimnasio ejercicio = new EjercicioGimnasio("E1", series);
        rutina.agregarEjercicio(ejercicio);

        assertDoesNotThrow(() -> rutina.validarNumeroEjercicios());
        assertDoesNotThrow(() -> rutina.validarNumeroSeries());
        assertDoesNotThrow(() -> rutina.validarSeriesCompletas());
        assertEquals(1, rutina.getEjerciciosGimnasio().size());
    }

    // CA2: Crear rutina sin ejercicios
    @Test
    void testCrearRutinaSinEjercicios() {
        Exception exception = assertThrows(Exception.class, () -> rutina.validarNumeroEjercicios());
        assertEquals("No has indicado ningun ejercicio", exception.getMessage());
    }

    // CA3: Crear rutina con ejercicio sin series
    @Test
    void testCrearRutinaConEjercicioSinSeries() {
        EjercicioGimnasio ejercicio = new EjercicioGimnasio("E1", new ArrayList<>());
        rutina.agregarEjercicio(ejercicio);

        Exception exception = assertThrows(Exception.class, () -> rutina.validarNumeroSeries());
        assertEquals("Hay algún ejercicio sin ninguna serie indicada", exception.getMessage());
    }

    // CA4: Crear rutina con serie incompleta
    @Test
    void testCrearRutinaConSerieIncompleta() {
        SerieGimnasio serieIncompleta = new SerieGimnasio(1); // repeticiones y peso = 0
        ArrayList<SerieGimnasio> series = new ArrayList<>();
        series.add(serieIncompleta);
        EjercicioGimnasio ejercicio = new EjercicioGimnasio("E1", series);
        rutina.agregarEjercicio(ejercicio);

        Exception exception = assertThrows(Exception.class, () -> rutina.validarSeriesCompletas());
        assertEquals("Hay alguna serie incompleta", exception.getMessage());
    }
}
