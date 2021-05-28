Feature: COMO cliente
  QUIERO buscar determinados servicios tanto como públicos o privados
  PARA poder contactarme con el ofertante

  Scenario: Servicios Publicos
    Given el cliente quiere buscar proveedores publicos
    When busque un servicio
    Then debera elegir el filtro de proveedores publicos cuando ingrese al buscador

  Scenario: Servicios Privados
    Given el cliente quiere buscar proveedores privados
    When busque un servicio
    Then deberá elegir el filtro de proveedores privados cuando ingrese al buscador

  Scenario: Contacto con el ofertante
    Given el cliente eligió el filtro de proveedores públicos o privados
    When le de clic a un servicio
    Then podrá visualizar los datos del ofertante y contactarse con el