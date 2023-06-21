package Banco;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class ProgramaBanco {
    private String nombreBanco = "BBVA";
    private String direccionBanco = "Av independencia 52";
    private String telefonoBanco = "7121718384";

    private String nombreCliente;
    private String numeroCuenta;
    private double saldo;

    public static void main(String[] args) {
        ProgramaBanco programaBanco = new ProgramaBanco();
        programaBanco.iniciar();
    }

    public void iniciar() {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

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

        scanner.close();
    }

    public int mostrarMenu() {
        String menu = "===== " + nombreBanco + " =====\n"
                + "1. Abrir cuenta\n"
                + "2. Mostrar datos de la cuenta\n"
                + "3. Realizar transacción\n"
                + "4. Mostrar datos del banco\n"
                + "5. Salir";

        String opcionStr = JOptionPane.showInputDialog(menu);
        int opcion = Integer.parseInt(opcionStr);

        return opcion;
    }

    public void abrirCuenta() {
        nombreCliente = JOptionPane.showInputDialog("Ingrese su nombre:");
        numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
        String saldoStr = JOptionPane.showInputDialog("Ingrese el saldo inicial:");
        saldo = Double.parseDouble(saldoStr);

        JOptionPane.showMessageDialog(null, "Cuenta abierta exitosamente.");

        imprimirComprobante("Apertura de cuenta", saldo);
    }

    public void mostrarDatosCuenta() {
        String datosCuenta = "===== Datos de la cuenta =====\n"
                + "Cliente: " + nombreCliente + "\n"
                + "Número de cuenta: " + numeroCuenta + "\n"
                + "Saldo: $" + String.format("%.2f", saldo);

        JOptionPane.showMessageDialog(null, datosCuenta);
    }

    public void realizarTransaccion() {
        int opcion = mostrarMenuTransaccion();

        switch (opcion) {
            case 1:
                depositar();
                break;
            case 2:
                retirar();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                break;
        }
    }

    public int mostrarMenuTransaccion() {
        String menu = "===== Realizar Transacción =====\n"
                + "1. Depósito\n"
                + "2. Retiro";

        String opcionStr = JOptionPane.showInputDialog(menu);
        int opcion = Integer.parseInt(opcionStr);

        return opcion;
    }

    public void depositar() {
        String montoStr = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
        double monto = Double.parseDouble(montoStr);

        saldo += monto;
        JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.");

        imprimirComprobante("Depósito", monto);
    }

    public void retirar() {
        String montoStr = JOptionPane.showInputDialog("Ingrese el monto a retirar:");
        double monto = Double.parseDouble(montoStr);

        if (monto <= saldo) {
            saldo -= monto;
            JOptionPane.showMessageDialog(null, "Retiro realizado exitosamente.");

            imprimirComprobante("Retiro", monto);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        }
    }

    public void mostrarDatosBanco() {
        String datosBanco = "===== Datos del banco =====\n"
                + "Banco: " + nombreBanco + "\n"
                + "Dirección: " + direccionBanco + "\n"
                + "Teléfono: " + telefonoBanco;

        JOptionPane.showMessageDialog(null, datosBanco);
    }

    public boolean validarNumero(String numero) {
        return numero.matches("\\d{10}");
    }

    public void imprimirComprobante(String tipoTransaccion, double monto) {
        String comprobante = "===== Comprobante de Transacción =====\n"
                + "Tipo de transacción: " + tipoTransaccion + "\n"
                + "Cliente: " + nombreCliente + "\n"
                + "Número de cuenta: " + numeroCuenta + "\n"
                + "Monto: $" + String.format("%.2f", monto) + "\n"
                + "Saldo actual: $" + String.format("%.2f", saldo);

        System.out.println(comprobante);
    }
}
