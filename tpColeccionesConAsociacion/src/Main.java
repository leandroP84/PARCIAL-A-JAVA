import java.util.ArrayList;
import java.util.Scanner;

class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        System.out.print("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = scanner.nextInt();
        for (int i = 0; i < cantidadAlumnos; i++) {
            scanner.nextLine();
            System.out.print("Ingrese el nombre completo del alumno: ");
            String nombreCompleto = scanner.nextLine();
            System.out.print("Ingrese el legajo del alumno: ");
            long legajo = scanner.nextLong();
            Alumno alumno = new Alumno(nombreCompleto, legajo);
            System.out.print("Ingrese la cantidad de notas del alumno (debe ser al menos 1): ");
            int cantidadNotas;
            do {
                cantidadNotas = scanner.nextInt();
                if (cantidadNotas < 1) {
                    System.out.println("Debe ingresar al menos una nota.");
                }
            } while (cantidadNotas < 1);
             for (int j = 0; j < cantidadNotas; j++) {
                 scanner.nextLine(); // Limpiar buffer
                 System.out.print("Ingrese el nombre de la cátedra: ");
                 String catedra = scanner.nextLine();
                 System.out.print("Ingrese la nota del examen: ");
                 double notaExamen = scanner.nextDouble();
                 Nota nota = new Nota(catedra, notaExamen);
                 alumno.agregarNota(nota);
             }
             alumnos.add(alumno);
        }
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombreCompleto() + " - Legajo: " + alumno.getLegajo());
            System.out.println("Notas:");
            for (Nota nota : alumno.getNotas()) {
                System.out.println("Cátedra: " + nota.getCatedra() + " - Nota: " + nota.getNotaExamen());
            }
            System.out.println("Promedio: " + alumno.calcularPromedio());
            System.out.println();
        }
        scanner.close();
    }
}