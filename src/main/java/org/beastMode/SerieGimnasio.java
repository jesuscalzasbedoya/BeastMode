package org.beastMode;

public class SerieGimnasio {
    private int id;
    private int repeticiones;
    private double peso;

    public SerieGimnasio(int id, int repeticiones, double peso) {
        this.id = id;
        this.repeticiones = repeticiones;
        this.peso = peso;
    }

    public SerieGimnasio(int id) {
        this.id = id;
        this.repeticiones = 0;
        this.peso = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean serieCompleta(){
        return this.repeticiones>0 && this.peso>0;
    }
}
