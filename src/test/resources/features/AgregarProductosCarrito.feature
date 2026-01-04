@AgregarProd
Feature: Agregar productos al carrito
  Scenario: Agregar 2 productos
    Given que el usuario inicia sesion en saucedemo con "standard_user" y contraseña "secret_sauce"
    When Agrega 2 productos al carrtio
    And visualizar los productos en carrito de compras
    ##And Completar el formulario de compra
    ##Then Visualizar la confirmacion de la compra