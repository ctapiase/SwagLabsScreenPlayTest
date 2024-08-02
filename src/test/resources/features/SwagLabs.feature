Feature: : Comprar un producto en Swag Labs
  Como usuario
  Quiero comprar un producto en la aplicación móvil Swag Labs
  Para verificar el plsroceso exitoso de compra

  Background:
    Given que "SOL" ha iniciado sesión con el usuario "standard_user" y la contraseña "secret_sauce"

  Scenario: Compra exitosa de un producto
    When "SOL" quiere comprar un producto "Mochila Sauce Labs"
    And  realiza el pago del producto
    Then debería ver la confirmación del pedido con el mensaje "GRACIAS POR SU ORDEN"

  @MultipleProducto
  Scenario: Agregar al carrito multiples productos
    When "Sol" Quiere agregar varios productos al carrito
      | products                    |
      | Camisa Sauce Labs Bolt      |
      | Luz de bicicleta Sauce Labs |
      | Chamarra Sauce Labs         |
    And Realiza el proceso de CheckIn
    Then debería ver la confirmación del pedido con el mensaje "GRACIAS POR SU ORDEN"
