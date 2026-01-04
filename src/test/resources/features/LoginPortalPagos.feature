@HappyPath
Feature: Login a SouceDemo


  @id_1
  Scenario: Login correcto a SauceDemo
    Given que el usuario abre el portal de login SauceDemo
    When ingresa su usuario "standard_user" y contraseña "secret_sauce" correctamente
    Then Visualiza la página de productos
    