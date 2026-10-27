//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    BilleteraVirtual billetera = new BilleteraVirtual("lucia.mp", 50000.0, 20000.0, "1234");

    System.out.println("Saldo inicial: $" + billetera.getSaldo());
    System.out.println("Límite diario: $" + billetera.getLimiteDiarioTransferencia());

    System.out.println("\n--- Transferencias ---");
    billetera.transferir(8000);     // exitosa
    billetera.transferir(10000);    // exitosa (total hoy: 18000)
    billetera.transferir(5000);     // rechazada: superaría el límite diario
    billetera.transferir(-100);     // rechazada: monto inválido
    billetera.transferir(90000);    // rechazada: saldo insuficiente

    System.out.println("\n--- Cambio de límite ---");
    billetera.actualizarLimite("0000", 100000.0);  // PIN incorrecto
    billetera.actualizarLimite("1234", 100000.0);  // exitoso
    billetera.transferir(5000);                    // ahora sí

    System.out.println("\n--- Estado final ---");
    System.out.println("Alias: " + billetera.getAlias());
    System.out.println("Saldo: $" + billetera.getSaldo());
    System.out.println("Transferido hoy: $" + billetera.getTransferidoHoy());

}
