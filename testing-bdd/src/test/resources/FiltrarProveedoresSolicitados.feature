Feature: COMO cliente
  QUIERO poder buscar servicios filtrados por proveedores más solicitados
  PARA hacer más eficiente la búsqueda

  Scenario: Buscar un servicio de acuerdo con la popularidad del proveedor
    Given el cliente quiere buscar un proveedor popular
    When busque un servicio
    Then deberá elegir la opción de filtrar los servicios por popularidad del proveedor en el aplicativo

  Scenario: Cancelar filtrado
    Given el cliente se haya equivocado
    When estaba filtrando proveedores solicitados
    Then deberá hacer clic en el mismo icono del "Filtrar" para filtrar por otra categoría

  Scenario: Seleccionar servicio por proveedores solicitados
    Given el cliente visualiza los servicios de acuerdo a la popularidad del proveedor
    When seleccione un servicio
    Then podrá gestionar la solicitud del servicio