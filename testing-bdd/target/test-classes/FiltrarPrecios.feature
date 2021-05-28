Feature: COMO cliente 
QUIERO poder buscar servicios filtrados por rango de precio 
PARA hacer más eficiente la búsqueda.

Scenario: Buscar servicio de acuerdo al presupuesto
  Given El cliente quiere buscar un servicio de acuerdo a su presupuesto 
  When busque un servicio determinado
  Then deberá elegir la opción de "Filtrar precios" en el buscador del aplicativo.

Scenario: Visualización de los servicios de acuerdo al presupuesto
  Given El cliente ha filtrado los servicios por el precio 
  When elige la opción de "Filtrar precios" en el buscador del aplicativo 
  Then se muestra una vista con todos los servicios con el precio de acuerdo al presupuesto ingresado. 

Scenario: Seleccionar servicio de acuerdo al presupuesto 
  Given El cliente visualiza los servicios de acuerdo al presupuesto 
  When selecciona el servicio requerido 
  Then podrá gestionar la solicitud de reserva.

