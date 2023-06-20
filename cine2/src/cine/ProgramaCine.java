package cine;

import javax.swing.JOptionPane;

public class ProgramaCine {

    // Variables para almacenar información del cine
    private static final String NOMBRE_CINE = "CineXYZ";
    private static final String DIRECCION_CINE = "Calle Principal, Ciudad";
    private static final String TELEFONO_CINE = "123456789";

    private static String nombrePelicula;
    private static String tipoSala;

    private static int cantidadBoletos;
    private static boolean promocion2x1;
    private static boolean descuentoTarjeta;

    private static boolean[][] asientosDisponibles = {
        {true, true, true, true},
        {true, true, true, true},
        {true, true, true, true},
        {true, true, true, true}
    };

    public static void main(String[] args) {
        new ProgramaCine().iniciar();
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    comprarBoletos();
                    break;
                case 2:
                    mostrarCartelera();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    private int mostrarMenu() {
        String menu = "===== " + NOMBRE_CINE + " =====\n"
                + "1. Compra de boletos\n"
                + "2. Cartelera\n"
                + "3. Salir";

        String opcionStr = JOptionPane.showInputDialog(menu);
        int opcion = Integer.parseInt(opcionStr);

        return opcion;
    }

    private void comprarBoletos() {
        nombrePelicula = JOptionPane.showInputDialog("Ingrese el nombre de la película:");
        mostrarTiposSala();
        tipoSala = JOptionPane.showInputDialog("Ingrese el tipo de sala:");

        String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad de boletos:");
        cantidadBoletos = Integer.parseInt(cantidadStr);

        String promocionStr = JOptionPane.showInputDialog("¿Desea aplicar la promoción 2x1 los viernes y domingos? (S/N):");
        promocion2x1 = promocionStr.equalsIgnoreCase("S");

        String descuentoStr = JOptionPane.showInputDialog("¿Desea aplicar el descuento del 15% pagando con tarjeta? (S/N):");
        descuentoTarjeta = descuentoStr.equalsIgnoreCase("S");

        mostrarAsientosDisponibles();

        for (int i = 0; i < cantidadBoletos; i++) {
            String filaStr = JOptionPane.showInputDialog("Ingrese la fila del asiento " + (i + 1) + ":");
            int fila = Integer.parseInt(filaStr);

            String columnaStr = JOptionPane.showInputDialog("Ingrese la columna del asiento " + (i + 1) + ":");
            int columna = Integer.parseInt(columnaStr);

            // Marcar el asiento como ocupado
            asientosDisponibles[fila][columna] = false;
        }

        // Generar y mostrar el ticket
        generarTicket();
    }

    private void mostrarTiposSala() {
        String tiposSala = "Tipos de Sala:\n"
                + "1. Tradicional\n"
                + "2. Premium\n"
                + "3. VIP";

        JOptionPane.showMessageDialog(null, tiposSala);
    }

    private void mostrarCartelera() {
        String cartelera = "===== Cartelera =====\n"
                + "Película 1 (2D)\n"
                + "Película 2 (3D)\n"
                + "Película 3 (2D)\n"
                + "Próximamente:\n"
                + "Película 4 (3D)\n";

        JOptionPane.showMessageDialog(null, cartelera);
    }

    private void mostrarAsientosDisponibles() {
        StringBuilder asientosDisponiblesStr = new StringBuilder("===== Asientos Disponibles =====\n");
        asientosDisponiblesStr.append("  A B C D\n");

        for (int i = 0; i < asientosDisponibles.length; i++) {
            asientosDisponiblesStr.append(i + 1).append(" ");

            for (int j = 0; j < asientosDisponibles[i].length; j++) {
                char asiento = asientosDisponibles[i][j] ? 'O' : 'X';
                asientosDisponiblesStr.append(asiento).append(" ");
            }

            asientosDisponiblesStr.append("\n");
        }

        JOptionPane.showMessageDialog(null, asientosDisponiblesStr);
    }

    private void generarTicket() {
        // Calcular el precio del boleto
        double precioBoleto = obtenerPrecioBoleto();

        // Aplicar promoción 2x1 si corresponde
        if (promocion2x1 && (esViernes() || esDomingo())) {
            cantidadBoletos = cantidadBoletos * 2;
        }

        // Aplicar descuento por tarjeta si corresponde
        if (descuentoTarjeta) {
            precioBoleto = precioBoleto * 0.85;
        }

        // Calcular el monto total
        double montoTotal = cantidadBoletos * precioBoleto;

        // Imprimir el ticket
        String ticket = "========= TICKET =========\n"
                + NOMBRE_CINE + "\n"
                + DIRECCION_CINE + "\n"
                + "Teléfono: " + TELEFONO_CINE + "\n"
                + "==========================\n"
                + "Película: " + nombrePelicula + "\n"
                + "Tipo de Sala: " + tipoSala + "\n"
                + "--------------------------\n"
                + "Cantidad de boletos: " + cantidadBoletos + "\n"
                + "Promoción 2x1: " + (promocion2x1 ? "Sí" : "No") + "\n"
                + "Descuento por tarjeta: " + (descuentoTarjeta ? "Sí" : "No") + "\n"
                + "Monto Total: $" + String.format("%.5f", montoTotal) + "\n"
                + "==========================\n"
                + "¡Gracias por su compra!";

        System.out.println(ticket);
    }

    private double obtenerPrecioBoleto() {
        double precioBoleto = 0.0;

        if (tipoSala.equalsIgnoreCase("Tradicional")) {
            precioBoleto = 100.0;
        } else if (tipoSala.equalsIgnoreCase("Premium")) {
            precioBoleto = 150.0;
        } else if (tipoSala.equalsIgnoreCase("VIP")) {
            precioBoleto = 200.0;
        }

        return precioBoleto;
    }

    private boolean esViernes() {
        // Lógica para determinar si es viernes
        return false;
    }

    private boolean esDomingo() {
        // Lógica para determinar si es domingo
        return false;
    }
}
