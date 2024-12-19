public class Heroe {

    String id;
    String nombre;
    String identidadSecreta;
    String descripcion;

    public Heroe(String id, String nombre, String identidadSecreta, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.identidadSecreta = identidadSecreta;
        this.descripcion = descripcion;
    }

    public boolean esMarvel(){
        return id.toUpperCase().startsWith("M");
    }
}
