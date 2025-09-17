import java.util.Scanner;

public class EjecutarCasillero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

   
        Casillero[][] casilleros = new Casillero[3][3];
        int id = 1;
        for (int i = 0; i < casilleros.length; i++) {
            for (int j = 0; j < casilleros[i].length; j++) {
                casilleros[i][j] = new Casillero(id++);
            }
        }

        int opcion;
        do {
            System.out.println("\n--- MENU CASILLEROS AMAZON ---");
            System.out.println("1. Registrar paquete en un casillero");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Ver información de casilleros ocupados");
            System.out.println("4. Mostrar estado general");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese fila (0-2): ");
                    int fila = sc.nextInt();
                    System.out.print("Ingrese columna (0-2): ");
                    int col = sc.nextInt();
                    sc.nextLine();

                    if (fila < 0 || fila >= casilleros.length || col < 0 || col >= casilleros[fila].length) {
                        System.out.println(" Posición inválida.");
                        break;
                    }

                    Casillero c = casilleros[fila][col];
                    if (c.getDestinatario() != null) {
                        System.out.println(" Casillero ya ocupado.");
                    } else {
                        System.out.print("Ingrese destinatario: ");
                        String destinatario = sc.nextLine();
                        System.out.print("Ingrese fecha: ");
                        String fecha = sc.nextLine();
                        c.asignarPaquete(destinatario, fecha);
                        System.out.println(" Paquete registrado en casillero [" + fila + "][" + col + "]");
                    }
                    break;

                case 2:
                    System.out.println("Casilleros disponibles: " + Casillero.contarDisponibles(casilleros));
                    break;

                case 3:
                    System.out.println("--- CASILLEROS OCUPADOS ---");
                    Casillero.mostrarOcupados(casilleros);
                    break;

                case 4:
                    System.out.println("--- ESTADO GENERAL DE CASILLEROS ---");
                    Casillero.mostrarEstado(casilleros);
                    break;

                case 5:
                    System.out.println("Aplicación cerrada.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
