Feature: COMO cliente
  QUIERO poder registrar mi tarjeta
  PARA realizar los pagos del servicio solicitado

  Scenario: Registrar tarjeta
    Given el cliente quiere poder registrar su tarjeta para realizar los pagos del servicio
    When seleccione su perfil podra seleccionar la opción "Pagar Servicio"
    Then se visualizará una ventana con alternativas de pago

  Scenario: Completar datos
    Given el cliente ingresó a la opción "Pagar servicio"
    When seleccione la opción "Visa/MasterCard"
    Then tendrá que ingresar los datos correspondientes y de manera correcta

  Scenario: Error al ingresar datos de la tarjeta
    Given el cliente quiera registrar su tarjeta
    When registre con los datos inválidos
    Then se le mostrará un mensaje "Error al registrar los datos de su tarjeta"