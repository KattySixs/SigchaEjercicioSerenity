# Readme del ejercicio 1: Compra SauceDemo E2E Serenity
Ejecutar la suite de pruebas Serenity BDD + Screenplay para el ejemplo SauceDemo. La prueba cubre un flujo de compra en la página SauceDemo: https://www.saucedemo.com/, donde se agregan 2 productos al carrito, se visualizan el carrito, se completa el formulario de compra y se finaliza la compra con éxito.

## Versiones de tecnologías usadas
	- Gradle (wrapper): 9.0.0
	- JUnit (BOM): 5.10.0
	- Windows PowerShell: v5.1
	- Java version: 21
	- Serenity BDD: 4.1.14
	- Lombok: 1.18.34
	- IntelliJ IDEA (recomendado): 2023.2.4 con plugins Gherkin / Cucumber for Java

## Requisitos Previos
	- Obtener el proyecto "SigchaEjercicioSerenity" e importarlo desde la herramienta IntelliJ

## Ubicación de archivos:Revisar que los archivos de la prueba se encuentren en las rutas especificadas
	- Features: src/test/resources/features/
	- Glue: src/test/java/automationtest/glue/
	- Tasks: src/main/java/automationtest/tasks/
	- Interfaces: src/main/java/automationtest/userinterfaces/
	- Questions: src/main/java/automationtest/questions/
	- Credenciales: src/test/resources/credentials.properties
	- Runner principal: automationtest/runners/WebRunnerTest
	- Reportes Serenity: target/site/serenity

## Para la ejecución
	- Abrir el archivo "WebRunnerTest": automationtest/runners/WebRunnerTest
	- Dar clic en el icono "play" en la parte superior de la pantalla.
	- esperar que inicie y ver el flujo de login, ver la lista de productos, ver que agrega al carrito los dos productos, ver el carrito, ver como completa el formulario y ver el mensaje de confirmación "THANK YOU FOR YOUR ORDER”

## Interpretación de resultados
	- Revisar que se tenga el resultado: tests passed
	- Ver los resultados satisfactorios en la consola
	- Dar clic en el enlace que entrega para ver el reporte, ejemplo: Main report: file:///C:/SerenityBDD/SigchaEjercicioSerenity/target/site/serenity/index.html
	- En la página visualizada del reporte ver el "summary"
	- Dar clic en "Test Results" y dirigirse a la tabla "Automated Scenarios"
	- Dar clic en cualquiera de los "escenarios" listados
	- Revisar todos los escenarios por los que pasó la prueba con sus respectivos prints.
