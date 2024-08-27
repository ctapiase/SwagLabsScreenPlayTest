Feature: : Comprar un producto en Swag Labs
  Como usuario
  Quiero comprar un producto en la aplicación móvil Swag Labs
  Para verificar el plsroceso exitoso de compra

  Background:
    Given que "SOL" ha iniciado sesión con el usuario "standard_user" y la contraseña "secret_sauce"

  @AProduct
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

  @EliminarProducto
  Scenario: Eliminar un producto del carrito
    When SOL ha agregado variios producto al carrito
      | products                    |
      | Camisa Sauce Labs Bolt      |
      | Chamarra Sauce Labs         |
      | Luz de bicicleta Sauce Labs |
    And elimina el producto "Chamarra Sauce Labs" del carrito
    Then el total del carrito se actualiza correctamente

  @VerifyPrices
  Scenario: Verificar que los precios individuales y el total de la compra se calculan y muestran correctamente
    Given que Sol ha añadido los siguientes productos al carrito:
      | products                          |
      | Camisa Test.allTheThings() (Roja) |
     # | Camisa Sauce Labs Bolt            |
    When el Sol procede al resumen de la compra
    Then los precios individuales se muestran correctamente:
      | products                          | price |
      | Camisa Test.allTheThings() (Roja) | 15.99 |
    #  | Camisa Sauce Labs Bolt            | 15.99 |
    And el total de la compra se calcula y muestra correctamente como 35.54
