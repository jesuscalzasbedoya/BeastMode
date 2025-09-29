Feature: Crear rutina de gimnasio

  Descripción:
  Como usuario que entrena en gimnasio
  Quiero poder crear una rutina con máquinas y pesas disponibles
  Para poder realizarla en el gimnasio

  Conversación:
  Para crear una rutina de gimnasio tengo que indicar que ejercicios quiero
  hacer, cuantas series, repeticiones y peso. La rutina tiene que empezar vacía.

  Criterios
  CA1: Dado el sistema de rutinas de gimnasio,
  Cuando creo una rutina,
  Entonces puedo elegir los ejercicio y cuantas seres y repeticiones de cada ejercicio
  CA2: Dado el sistema de rutinas de gimnasio,
  Cuando creo una rutina sin ejercicios
  Entonces recibo un mensaje de error "No has indicado ningun ejercicio"
  CA3: Dado el sistema de rutinas de gimnasio,
  Cuando creo una rutina con ejercicios pero hay alguno sin ninguna serie,
  Entonces recibo un mensaje de error "Hay algún ejercicio sin ninguna serie indicada"
  CA4: Dado el sistema de rutinas de gimnasio
  Cuando creo una rutina con ejercicios y series, pero hay alguna que no tiene indicado las reticiones o peso"
  Entonces recibo un mensaje de error "Hay alguna serie incompleta"


  Rule: Rutina completa
    Scenario: Rutina con ejercicios con series formadas por repeticiones y pesos
      Given crear una rutina de gimnasio con ejercicios con series formadas por repeticiones y pesos
      When crea la rutina de gimnasio correctamente
      Then se muestra un mensaje aceptacion: "Rutina creada"

  Rule: Rutina incompleta
    Scenario: Rutina de gimnasio vacía
      Given crear una rutina de gimnasio sin ejercicios
      When no se crea la rutina de gimnasio por falta de ejercicios
      Then se muestra un mensaje de error por falta de ejercicios: "No has indicado ningun ejercicio"

    Scenario: Rutina de gimnasio con ejercicios pero faltan series
      Given crear una rutina de gimnasio con ejercicios pero hay alguno que no tiene ninguna serie
      When  no se crea la rutina de gimnasio por falta de series
      Then se muestra un mensaje de error por falta de series: "Hay algún ejercicio sin ninguna serie indicada"

    Scenario: Rutina de gimnasio con ejercicios y series pero incompletas
      Given crear una rutina de gimnasio con ejercicios y series pero sin repeticiones o series
      When  no se crea la rutina de gimnasio por series incompletas
      Then se muestra un mensaje de error por series incompletas: "Hay alguna serie incompleta"