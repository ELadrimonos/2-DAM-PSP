public class Profesional {
    private final String nombre;
    private final int edad;
    private final char genero;
    private final int tipoProfesional;

    Profesional(String nombre, int edad, char genero, int tipoProfesional) {
        if (genero != 'm' && genero != 'f') throw new IllegalArgumentException("Género invalido, ¿has introducido el valor en minuscula?");
        if (edad < 0) throw new IllegalArgumentException("La edad no puede ser menor que 0, ¿qué haces?");
        if (tipoProfesional < 0 || tipoProfesional > 3) throw new IllegalArgumentException("Tipo de profesional es invalido.");

        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.tipoProfesional = tipoProfesional;
    }

    public char getGenero() {
        return genero;
    }

    public int getTipoProfesional() {
        return tipoProfesional;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
