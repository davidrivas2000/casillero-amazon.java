public class Casillero {

    private int id;              
    private String destinatario;  
    private String fecha;         

    public Casillero(int id) {
        this.id = id;
        this.destinatario = null;
        this.fecha = null;
    }

    public void asignarPaquete(String destinatario, String fecha) {
        this.destinatario = destinatario;
        this.fecha = fecha;
    }

    public void liberarCasillero() {
        this.destinatario = null;
        this.fecha = null;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getFecha() {
        return fecha;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        if (destinatario != null) {
            return "[ID: " + id + " | Destinatario: " + destinatario + " | Fecha: " + fecha + "]";
        } else {
            return "[ID: " + id + " | Libre]";
        }
    }

    public static int contarDisponibles(Casillero[][] casilleros) {
        int contador = 0;
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (casilleros[i][j].getDestinatario() == null) { 
                    contador++;
                }
            }
        }
        return contador;
    }

    public static void mostrarOcupados(Casillero[][] casilleros) {
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                if (casilleros[i][j].getDestinatario() != null) { 
                    System.out.println(casilleros[i][j]);
                }
            }
        }
    }

    public static void mostrarEstado(Casillero[][] casilleros) {
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                System.out.print(casilleros[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
