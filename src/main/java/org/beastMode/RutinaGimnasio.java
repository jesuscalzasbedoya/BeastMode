package org.beastMode;

import java.util.ArrayList;

public class RutinaGimnasio {
    private int id;
    private ArrayList<EjercicioGimnasio> ejerciciosGimnasio;

    public RutinaGimnasio(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<EjercicioGimnasio> getEjerciciosGimnasio() {
        return ejerciciosGimnasio;
    }

    public void setEjerciciosGimnasio(ArrayList<EjercicioGimnasio> ejerciciosGimnasio) {
        this.ejerciciosGimnasio = ejerciciosGimnasio;
    }

    public void agregarEjercicio(EjercicioGimnasio ejercicio){
        this.ejerciciosGimnasio.add(ejercicio);
    }

    public void validarNumeroEjercicios() throws Exception{
        if (ejerciciosGimnasio == null || ejerciciosGimnasio.isEmpty()) {
            throw new Exception("No has indicado ningun ejercicio");
        }
    }

    public void validarNumeroSeries() throws Exception {
        for (EjercicioGimnasio e : this.ejerciciosGimnasio) {
            if (e.getSeriesGimnasio().isEmpty()) {
                throw new Exception("Hay algún ejercicio sin ninguna serie indicada");
            }
        }
    }

    public void validarSeriesCompletas() throws Exception {
        for (EjercicioGimnasio e : this.ejerciciosGimnasio) {
            if (!e.ejercicioCompleto()) {
                throw new Exception("Hay alguna serie incompleta");
            }
        }
    }
}
