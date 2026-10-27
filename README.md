# Sistema de Gestión de Billetera Virtual

## Descripción

Este proyecto implementa una clase `BilleteraVirtual` en Java que simula una billetera digital con saldo disponible y límites diarios de transferencia. Permite realizar transferencias controladas y actualizar el límite diario mediante una validación de titularidad con PIN.

## Funcionamiento

El programa crea una billetera virtual con un alias, un saldo inicial de $50.000, un límite diario de $20.000 y un PIN de seguridad. Luego realiza distintas operaciones para comprobar las reglas del sistema.

* **Consulta de información:** permite obtener el alias, el saldo, el límite diario y el total transferido durante el día.
* **Transferencias:** descuenta dinero del saldo y actualiza el acumulado diario cuando la operación es válida.
* **Validación de montos:** rechaza transferencias iguales o inferiores a cero.
* **Control de saldo:** impide transferir un monto superior al saldo disponible.
* **Control del límite diario:** rechaza transferencias que superen el límite, considerando también las transferencias anteriores del día.
* **Actualización del límite:** permite modificar el límite diario únicamente cuando el PIN ingresado es correcto y el nuevo límite es mayor que cero.
* **Protección del saldo:** no existe un método setter para modificarlo directamente.

## Clases principales

### `BilleteraVirtual`

Representa una billetera digital y contiene los atributos y métodos necesarios para administrar el saldo y controlar las transferencias.

**Atributos:**

* `alias`: identificador de la billetera.
* `saldo`: dinero disponible.
* `limiteDiarioTransferencia`: monto máximo que se puede transferir durante el día.
* `transferidoHoy`: acumulado de transferencias realizadas.
* `pin`: código utilizado para simular la verificación de titularidad.

**Métodos principales:**

* `getAlias()`: devuelve el alias.
* `getSaldo()`: devuelve el saldo actual.
* `getLimiteDiarioTransferencia()`: devuelve el límite diario.
* `getTransferidoHoy()`: devuelve el total transferido durante el día.
* `transferir(double monto)`: valida y ejecuta una transferencia si se cumplen las condiciones.
* `actualizarLimite(String pinIngresado, double nuevoLimite)`: verifica el PIN y actualiza el límite si el nuevo valor es válido.

### `Main`

Contiene el método `main`, crea una billetera virtual y ejecuta pruebas de transferencias válidas e inválidas, cambios de límite y consultas del estado final.

## Conceptos de programación utilizados

* **Programación orientada a objetos (POO):** representación de una billetera mediante una clase.
* **Encapsulamiento:** uso de atributos privados para proteger la información.
* **Validación de datos:** comprobación de montos, saldo disponible y límites.
* **Métodos con retorno booleano:** indican si una transferencia o modificación fue exitosa.
* **Condiciones lógicas:** permiten aplicar varias reglas antes de ejecutar una operación.
* **Acumulación de valores:** registro del total transferido durante el día.
* **Control de acceso:** verificación del PIN antes de modificar el límite diario.
* **Integridad de los datos:** el saldo solo cambia mediante transferencias aceptadas.

## Tecnologías utilizadas

* Java
* IntelliJ IDEA
* Git y GitHub

## Ejecución

<img width="935" height="540" alt="image" src="https://github.com/user-attachments/assets/01a37ef2-a14c-457e-9259-fbf1d6135ba0" />

## Resultado esperado

La billetera comienza con un saldo de $50.000 y un límite diario de $20.000.

* Las transferencias de $8.000 y $10.000 son aprobadas.
* La transferencia de $5.000 es rechazada inicialmente porque supera el límite diario restante.
* Los montos negativos y las transferencias superiores al saldo disponible son rechazados.
* El cambio de límite con un PIN incorrecto es rechazado.
* El cambio de límite con el PIN correcto permite establecer un nuevo máximo de $100.000.
* La transferencia posterior de $5.000 es aprobada.

Al finalizar, el saldo esperado es de **$27.000** y el total transferido durante el día es de **$23.000**.

## Objetivo del ejercicio

Aplicar los principios de encapsulamiento, validación y control de acceso en Java mediante una clase que gestione transferencias monetarias y límites diarios, manteniendo la consistencia de los datos y evitando operaciones no permitidas.







