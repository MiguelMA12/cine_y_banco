package Banco;

import javax.swing.JOptionPane;

public class ProgramaBanco {

    private static final String NOMBRE_BANCO = "BancoXYZ";
    private static final String DIRECCION_BANCO = "Calle Principal, Ciudad";
    private static final String TELEFONO_BANCO = "123456789";

    private static String nombreCliente;
    private static String numeroCuenta;

    private static double monto;
    private static boolean descuentoTarjeta;

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    abrirCuenta();
                    break;
                case 2:
                    mostrarDatosCuenta();
                    break;
                case 3:
                    realizarTransaccion();
                    break;
                case 4:
                    mostrarDatosBanco();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
//MAMM
    private int mostrarMenu() {
        String menu = "===== " + NOMBRE_BANCO + " =====\n"
                + "1. Abrir cuenta\n"
                + "2. Mostrar datos de la cuenta\n"
                + "3. Realizar transacción\n"
                + "4. Mostrar datos del banco\n"
                + "5. Salir";

        String opcionStr = JOptionPane.showInputDialog(menu);
        int opcion = Integer.parseInt(opcionStr);

        return opcion;
    }

    private void abrirCuenta() {
        nombreCliente = JOptionPane.showInputDialog("Ingrese su nombre:");
        numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");

        JOptionPane.showMessageDialog(null, "Cuenta abierta exitosamente.");
    }

    private void mostrarDatosCuenta() {
        String datosCuenta = "===== Datos de la cuenta =====\n"
                + "Cliente: " + nombreCliente + "\n"
                + "Número de cuenta: " + numeroCuenta;

        JOptionPane.showMessageDialog(null, datosCuenta);
    }

    private void realizarTransaccion() {
        String montoStr = JOptionPane.showInputDialog("Ingrese el monto de la transacción:");
        monto = Double.parseDouble(montoStr);

        String descuentoStr = JOptionPane.showInputDialog("¿Desea aplicar el descuento por tarjeta? (S/N):");
        descuentoTarjeta = descuentoStr.equalsIgnoreCase("S");

        // Realizar la transacción
        double montoTotal = calcularMontoTotal();

        // Imprimir el comprobante de la transacción
        imprimirComprobante(montoTotal);
    }

    private void mostrarDatosBanco() {
        String datosBanco = "===== Datos del Banco =====\n"
                + "Nombre: " + NOMBRE_BANCO + "\n"
                + "Dirección: " + DIRECCION_BANCO + "\n"
                + "Teléfono: " + TELEFONO_BANCO;

        JOptionPane.showMessageDialog(null, datosBanco);
    }

    private double calcularMontoTotal() {
        double montoTotal = monto;

        if (descuentoTarjeta) {
            montoTotal = montoTotal * 0.95;
        }

        return montoTotal;
    }

    private void imprimirComprobante(double montoTotal) {
        String comprobante = "========= COMPROBANTE =========\n"
                + NOMBRE_BANCO + "\n"
                + DIRECCION_BANCO + "\n"
                + "Teléfono: " + TELEFONO_BANCO + "\n"
                + "===============================\n"
                + "Cliente: " + nombreCliente + "\n"
                + "Cuenta: " + numeroCuenta + "\n"
                + "-----------------------------\n"
                + "Monto: $" + String.format("%.2f", monto) + "\n"
                + "Descuento por tarjeta: " + (descuentoTarjeta ? "Sí" : "No") + "\n"
                + "Monto Total: $" + String.format("%.2f", montoTotal) + "\n"
                + "===============================\n"
                + "¡Gracias por su transacción!";

        System.out.println(comprobante);
    }

    public static void main(String[] args) {
        new ProgramaBanco().iniciar();
    }
}
