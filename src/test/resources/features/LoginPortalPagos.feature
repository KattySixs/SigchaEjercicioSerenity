@SauceDemo
Feature: Login a SouceDemo


  @id_1
  Scenario: Login correcto a SauceDemo
    Given que el usuario abre el portal de login SauceDemo
    When ingresa sus credenciales correctamente
    Then Visualiza la página de productos

    