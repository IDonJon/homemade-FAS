Feature: COMO cliente
  QUIERO tener un registro de todos los servicios que haya solicitado
  PARA no tener que buscarlos otra vez

  Scenario: Lista de servicios
    Given el cliente quiere tener un registro de servicios
    When quiera revisar cuantos servicios ha solicitado
    Then deberá ingresar a su perfil

  Scenario: Detalles de servicio
    Given el cliente requiera ver detalles de los servicios reservados
    When ingresa a su perfil y tenga una lista de servicios
    Then tendrá que seleccionar el servicio para ver toda la información

  Scenario: Ver detalle del servicio solicitado
    Given el cliente visualiza el registro de servicios solicitados
    When seleccione la opción "Ver detalle" de un servicio en especifico
    Then se le mostrará la información completa relacionada a dicho servicio