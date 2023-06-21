/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco2;

/**
 *
 * @author ayeri
 */
import javax.swing.JOptionPane;

public class ProgramaBanco {
    // Variables para almacenar información del banco
    private static final String NOMBRE_BANCO = "BancoXYZ";
    private static final String DIRECCION_BANCO = "Calle Principal, Ciudad";
    private static final String TELEFONO_BANCO = "123456789";
    
    // Variables para almacenar información de la cuenta
    private static String nombreCliente;
    private static String numeroCuenta;
    private static double saldo;
    
    public static void main(String[] args) {
        new ProgramaBanco().iniciar();
    }
    
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
        String saldoStr = JOptionPane.showInputDialog("Ingrese el saldo inicial:");
        saldo = Double.parseDouble(saldoStr);
        
        JOptionPane.showMessageDialog(null, "Cuenta abierta exitosamente.");
    }
    
    private void mostrarDatosCuenta() {
        String datosCuenta = "===== Datos de la cuenta =====\n"
                + "Cliente: " + nombreCliente + "\n"
                + "Número de cuenta: " + numeroCuenta + "\n"
                + "Saldo: $" + String.format("%.2f", saldo);
        
        JOptionPane.showMessageDialog(null, datosCuenta);
    }
    
    private void realizarTransaccion() {
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
    
    private int mostrarMenuTransaccion() {
        String menu = "===== Realizar Transacción =====\n"
                + "1. Depósito\n"
                + "2. Retiro";
        
        String opcionStr = JOptionPane.showInputDialog(menu);
        int opcion = Integer.parseInt(opcionStr);
        
        return opcion;
    }
    
    private void depositar() {
        String montoStr = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
        double monto = Double.parseDouble(montoStr);
        
        saldo += monto;
        JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.");
    }
    
    private void retirar() {
        String montoStr = JOptionPane.showInputDialog("Ingrese el monto a retirar:");
        double monto = Double.parseDouble(montoStr);
        
        if (monto <= saldo) {
            saldo -= monto;
            JOptionPane.showMessageDialog(null, "Retiro realizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
        }
    }
    
    private void mostrarDatosBanco() {
        String datosBanco = "===== Datos del banco =====\n"
                + "Banco: " + NOMBRE_BANCO + "\n"
                + "Dirección: " + DIRECCION_BANCO + "\n"
                + "Teléfono: " + TELEFONO_BANCO;
        
        JOptionPane.showMessageDialog(null, datosBanco);
    }
    
    private static boolean validarNumero(String numero) {
        return numero.matches("\\d{10}"); // Verifica que el número tenga 10 dígitos
    }
}
