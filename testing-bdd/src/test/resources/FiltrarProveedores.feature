Feature: COMO cliente
  QUIERO poder buscar servicios filtrados por proveedor
  PARA para hacer más eficiente la búsqueda

  Scenario: Buscar un servicio por proveedor
    Given el cliente quiere encontrar un proveedor
    When busque un servicio determinado
    Then deberá elegir la opción de filtrar servicios por proveedor en el buscador del aplicativo

  Scenario: Visualización de nombres comunes
    Given el cliente ha filtrado por proveedores
    When ingresa el nombre del proveedor
    Then se muiestra una página con todos los nombres coincidentes del nombre buscado

  Scenario: Visualización del proveedor buscado
    Given el cliente ha encontrado una relación de nombres comunes acerca del proveedor que desea buscar
    When encuentra a la persona y la selecciona
    Then se mostrará una pagina con la información del proveedor