@LoginSauceDemo
Feature: Login a SouceDemo

  @id_1
  Scenario Outline: Login correcto a SauceDemo
    Given que el usuario abre el portal de login SauceDemo
    When ingresa usuario "<usuario>" y contraseña "<contrasena>"
    Then Visualiza la página de productos

    Examples:
      | usuario        | contrasena    |
      | standard_user  | secret_sauce  |