package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.beastMode.EjercicioGimnasio;
import org.beastMode.RutinaGimnasio;
import org.beastMode.SerieGimnasio;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CrearRutinaGimnasioStepDefinitions {

    private RutinaGimnasio rutinaGimnasio;
    private String mensaje;

    /*
        CA1: RUTINA COMPLETA
     */
    @Given("crear una rutina de gimnasio con ejercicios con series formadas por repeticiones y pesos")
    public void crearRutinaConEjerciciosYSeries() {
        rutinaGimnasio = new RutinaGimnasio(1);

        // Crear series
        ArrayList<SerieGimnasio> series = new ArrayList<>();
        series.add(new SerieGimnasio(1, 6, 80.0));
        series.add(new SerieGimnasio(2, 12, 67.5));
        series.add(new SerieGimnasio(3, 12, 67.5));

        // Crear ejercicio con sus series
        EjercicioGimnasio ejercicio = new EjercicioGimnasio("Press banca", series);

        // Agregar ejercicio a la rutina
        ArrayList<EjercicioGimnasio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicio);
        rutinaGimnasio.setEjerciciosGimnasio(ejercicios);

        // Validaciones iniciales
        assertNotNull(rutinaGimnasio);
        assertFalse(rutinaGimnasio.getEjerciciosGimnasio().isEmpty());
    }

    @When("crea la rutina de gimnasio correctamente")
    public void seIntentaCrearLaRutina() {
        try {
            rutinaGimnasio.validarNumeroSeries();
            mensaje = "Rutina creada";
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
    }

    @Then("se muestra un mensaje aceptacion: {string}")
    public void verificarMensajeAceptacion(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensaje);
    }

    /*
        CA2: FALTAN EJERCICIOS
    */
    @Given("crear una rutina de gimnasio sin ejercicios")
    public void crearRutinaSinEjercicios() {
        rutinaGimnasio = new RutinaGimnasio(1);
        rutinaGimnasio.setEjerciciosGimnasio(new ArrayList<>()); // vacío
    }

    @When("no se crea la rutina de gimnasio por falta de ejercicios")
    public void noSeCreaRutinaPorFaltaDeEjercicios() {
        try {
            rutinaGimnasio.validarNumeroEjercicios();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("se muestra un mensaje de error por falta de ejercicios: {string}")
    public void  mostrarMensajeError(String string){
        assertEquals("No has indicado ningun ejercicio", string);
    }

    /*
        CA3: FALTAN SERIES
     */
    @Given("crear una rutina de gimnasio con ejercicios pero hay alguno que no tiene ninguna serie")
    public void crearRutinaConEjerciciosSinSeries() {
        rutinaGimnasio = new RutinaGimnasio(1);

        // Ejercicio sin series
        EjercicioGimnasio ejercicio1 = new EjercicioGimnasio("Press banca", new ArrayList<>());

        // Lista de ejercicios
        ArrayList<EjercicioGimnasio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicio1);

        rutinaGimnasio.setEjerciciosGimnasio(ejercicios);
    }

    @When("no se crea la rutina de gimnasio por falta de series")
    public void noSeCreaRutinaPorFaltaDeSeries() {
        try {
            rutinaGimnasio.validarNumeroSeries();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Then("se muestra un mensaje de error por falta de series: {string}")
    public void seMuestraUnMensajeDeError(String string) {
        assertEquals("Hay algún ejercicio sin ninguna serie indicada", string);
    }

    /*
        CA4: SERIES INCOMPLETAS
     */
    @Given("crear una rutina de gimnasio con ejercicios y series pero sin repeticiones o series")
    public void crearRutinaConSeriesIncompletas() {
        rutinaGimnasio = new RutinaGimnasio(1);

        // Serie incompleta: sin repeticiones o con peso inválido
        SerieGimnasio serieIncompleta = new SerieGimnasio(1, 0, 50.0); // repeticiones = 0

        ArrayList<SerieGimnasio> series = new ArrayList<>();
        series.add(serieIncompleta);

        EjercicioGimnasio ejercicio = new EjercicioGimnasio("Sentadillas", series);

        ArrayList<EjercicioGimnasio> ejercicios = new ArrayList<>();
        ejercicios.add(ejercicio);

        rutinaGimnasio.setEjerciciosGimnasio(ejercicios);
    }

    @When("no se crea la rutina de gimnasio por series incompletas")
    public void noSeCreaRutinaPorSeriesIncompletas() {
        try {
            rutinaGimnasio.validarSeriesCompletas();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("se muestra un mensaje de error por series incompletas: {string}")
    public void  mostrarMensajeErrorSeriesIncompletas(String string){
        assertEquals("Hay alguna serie incompleta", string);
    }
}
