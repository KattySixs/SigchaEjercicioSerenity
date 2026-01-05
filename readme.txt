INSTRUCCIONES DE EJECUCIÓN - Proyecto SerenityBDD (paso a paso)

Resumen
- Propósito: ejecutar la suite de pruebas Serenity BDD + Screenplay para el ejemplo SauceDemo incluido.
- Archivos importantes:
  - Features: src/test/resources/features/
  - Steps / Glue: src/test/java/automationtest/glue/
  - Tasks: src/main/java/automationtest/tasks/
  - Page Objects / Targets: src/main/java/automationtest/userinterfaces/
  - Credenciales: src/test/resources/credentials.properties
  - Runner principal: automationtest.runners.WebRunnerTest
  - Reportes Serenity: target/site/serenity (o build/serenity según configuración)

Versiones recomendadas (especificar exactamente):
- Java JDK 21
- Gradle 8.7 (usar wrapper incluido `gradlew`)
- Serenity BDD: 4.1.14 (definido en build.gradle)
- Lombok: 1.18.34
- Chrome (última estable) o Firefox según preferencia
- chromedriver correspondiente a la versión de Chrome (si no usas autodownload)
- IntelliJ IDEA (recomendado): 2023.2.4 con plugins Gherkin / Cucumber for Java

Preparación del entorno
1) Clona el repositorio (si aún no lo hiciste):

```powershell
git clone <url_del_repositorio>
cd sqa-aut-portalpagos-serenitybdd
```

2) Asegura JDK 21 como JAVA_HOME o en tu IDE.
3) Revisa `serenity.properties` para seleccionar driver. Por defecto el proyecto trae:

```properties
webdriver.driver=chrome
webdriver.autodownload=true
serenity.browser.maximized=true
headless.mode=false
```

4) Verifica que exista el archivo de credenciales:

`src/test/resources/credentials.properties`

Ejemplo ya incluido (no para producción):
```
username=standard_user
password=secret_sauce
```

Si quieres usar variables de entorno en lugar de archivo, puedes modificar `EstablecerDatos.conCredencialesDesdeArchivo()` para leer `System.getenv(...)`.

Paso a paso - ejecución local (PowerShell, Windows)

1) Limpiar y compilar el proyecto:

```powershell
.\gradlew clean assemble
```

Salida esperada: compilación sin errores; si hay errores, revisar logs en consola y corregir import o dependencias.

2) Ejecutar la suite completa:

```powershell
.\gradlew clean test
```

3) Ejecutar el runner principal (filtrado por el runner configurado):

```powershell
.\gradlew test --tests "automationtest.runners.WebRunnerTest" -Dwebdriver.driver=chrome
```

4) Ejecutar un runner en modo headless (útil para CI):

```powershell
.\gradlew test --tests "automationtest.runners.WebRunnerTest" -Dwebdriver.driver=chrome -Dheadless=true
```

5) Ejecutar un test/runner específico (por clase o método):

```powershell
.\gradlew test --tests "automationtest.runners.WebRunnerTest" --tests "automationtest.glue.LoginSauceDemo"
```

6) Limpiar outputs y reportes:

```powershell
.\gradlew clean; Remove-Item -Recurse -Force .\target, .\build
```

Ver reportes Serenity
- Ruta: target/site/serenity/index.html (abre en el navegador local). Si no está allí, busca en build o build/serenity.

Comprobaciones y troubleshooting rápido
- Si aparecen errores de compilación: ejecutar `.
gradlew assemble --stacktrace` y revisar el stack; comúnmente son imports faltantes o incompatibilidades de versiones.
- Si WebDriver falla (ej. session not created): verificar la versión de chromedriver con la versión de Chrome. O usa `webdriver.autodownload=true`.
- Si un elemento no se encuentra (NoSuchElement / Timeout): verificar selector en el DOM (usar DevTools); preferir selectores estables como atributos `data-test`.
- Si steps Cucumber no se mapean: verificar que la cadena del step en el feature coincida exactamente con la anotación en la clase glue.

Notas importantes sobre cambios implementados
- El step de login ya no espera parámetros desde el feature. Ahora `LoginSauceDemo` llama a `EstablecerDatos.conCredencialesDesdeArchivo()` y éste lee `src/test/resources/credentials.properties`.
- El selector de confirmación de compra se actualizó a: `h2[data-test='complete-header']` en `CheckoutPageObject.java`.
- Se añadió `ConfirmacionCompra` como Question para validar el texto de confirmación.

Buenas prácticas recomendadas
- No almacenar credenciales en repositorios públicos; usar variables de entorno o secret managers en CI.
- Mantener selectores estables con `data-test` cuando estén disponibles.
- Añadir esperas explícitas (WaitUntil) antes de leer elementos dinámicos si hay inestabilidad.
- Añadir una tarea/step que recupere screenshots y logs en fallos para facilitar debugging en CI.

Siguientes pasos sugeridos
- Parametrizar lectura de credenciales para admitir variables de entorno (útil para CI).
- Añadir tests unitarios para Questions y para la lógica no UI.
- Ejecutar la suite en modo headless en CI y revisar los reportes HTML.

Contacto / ayuda
- Si quieres, puedo ejecutar la suite de prueba aquí (indica navegador: chrome/firefox y si lo quieres headless).
