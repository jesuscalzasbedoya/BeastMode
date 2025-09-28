package org.beastMode;

import java.util.ArrayList;

public class EjercicioGimnasio {
    private String id;
    private ArrayList<SerieGimnasio> seriesGimnasio;

    public EjercicioGimnasio(String id) {
        this.id = id;
    }

    public EjercicioGimnasio(String id, ArrayList<SerieGimnasio> seriesGimnasio) {
        this.id = id;
        this.seriesGimnasio = seriesGimnasio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<SerieGimnasio> getSeriesGimnasio() {
        return seriesGimnasio;
    }

    public void setSeriesGimnasio(ArrayList<SerieGimnasio> seriesGimnasio) {
        this.seriesGimnasio = seriesGimnasio;
    }

    public boolean ejercicioCompleto(){
        boolean completo=true;
        for (SerieGimnasio s: this.seriesGimnasio){
            if(!s.serieCompleta()){
                completo=false;
            }
        }
        return completo;
    }
}
