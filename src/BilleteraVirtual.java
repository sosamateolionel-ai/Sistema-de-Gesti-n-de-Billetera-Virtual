public class BilleteraVirtual {

    private String alias;
    private double saldo;
    private double limiteDiarioTransferencia;
    private double transferidoHoy;
    private String pin; // simula la validación de titularidad

    public BilleteraVirtual(String alias, double saldoInicial, double limiteDiario, String pin) {
        this.alias = alias;
        this.saldo = saldoInicial;
        this.limiteDiarioTransferencia = limiteDiario;
        this.transferidoHoy = 0;
        this.pin = pin;
    }

    public String getAlias() {
        return alias;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteDiarioTransferencia() {
        return limiteDiarioTransferencia;
    }

    public double getTransferidoHoy() {
        return transferidoHoy;
    }

    public boolean transferir(double monto) {

        if (monto <= 0) {
            System.out.println("Transferencia rechazada: el monto debe ser mayor a cero (" + monto + ").");
            return false;
        }

        if (monto > saldo) {
            System.out.println("Transferencia rechazada: saldo insuficiente (disponible: $" + saldo + ").");
            return false;
        }

        if (transferidoHoy + monto > limiteDiarioTransferencia) {
            System.out.println("Transferencia rechazada: supera el límite diario ($" + limiteDiarioTransferencia
                    + ", ya transferido hoy: $" + transferidoHoy + ").");
            return false;
        }

        saldo = saldo - monto;
        transferidoHoy = transferidoHoy + monto;
        System.out.println("Transferencia de $" + monto + " aprobada. Saldo: $" + saldo);
        return true;
    }

    public boolean actualizarLimite(String pinIngresado, double nuevoLimite) {

        if (!pin.equals(pinIngresado)) {
            System.out.println("Cambio de límite rechazado: no se pudo verificar la titularidad.");
            return false;
        }

        if (nuevoLimite <= 0) {
            System.out.println("Cambio de límite rechazado: el límite debe ser mayor a cero (" + nuevoLimite + ").");
            return false;
        }

        limiteDiarioTransferencia = nuevoLimite;
        System.out.println("Límite diario actualizado a $" + limiteDiarioTransferencia + ".");
        return true;
    }
}