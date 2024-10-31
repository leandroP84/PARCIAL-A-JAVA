import java.util.ArrayList;

class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;


    public Alumno(String nombreCompleto, long legajo) {
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.notas = new ArrayList<Nota>();
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }
    public double calcularPromedio() {
        double suma = 0;
        for (Nota nota : notas) {
            suma += nota.getNotaExamen();
        }
        return (notas.size() > 0) ? suma / notas.size() : 0;
    }
}