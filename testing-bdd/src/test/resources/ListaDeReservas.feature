Feature: COMO cliente
  QUIERO poder visualizar cuantos servicios me solicitan
  PARA brindar promociones a los clientes frecuentes

  Scenario: Visualizar reservas
    Given el proveedor quiere visualizar las reservas
    When quiera ver cuantas reservas tiene
    Then deberá ingresar a su perfil donde podrá ver la lista de servicios que haya sido reservados, se indica la información del cliente, asi como también la fecha

  Scenario: Cambiar de filtro
    Given el proveedor quiera cancelar alguna reserva
    When verifique en la información que no puede cumplir por diferentes motivos
    Then deberá hacer clic en el icono de bote de basura de color rojo

  Scenario: Agregar promociones
    Given el proveedor quiera agregar algún descuento a sus clientes
    When presione el botón "Agregar una promoción"
    Then mostrará una ventana para que pueda colocar el descuento respectivo