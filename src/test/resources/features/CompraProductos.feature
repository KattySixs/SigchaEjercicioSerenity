@SauceDemo
Feature: Agregar productos al carrito
  Scenario Outline: Comprar 2 productos
    Given que el usuario inicia sesión correctamente en SauceDemo con "<usuario>" y "<contrasena>"
    When Agrega 2 productos al carrito
    And visualizar los productos en carrito de compras
    And Completar el formulario de compra con "<nombre>", "<apellido>" y "<cpostal>"
    Then Visualizar la confirmacion de la compra

    Examples:
        | usuario        | contrasena | nombre | apellido | cpostal |
        | standard_user | secret_sauce | Katherine   | Sigcha    | 12345   |