# CVDS LAB 3

**Integrantes:** Angie Natalia Mojica - Daniel Antonio Antanilla

## CLASES DE EQUIVALENCIA

---

## Crear un proyecto Maven

Creamos un proyecto maven usando el comando

```console
mvn archetype:generate
```

Luego de esto tomamos las configuraciones indicadas en el laboratorio

```console
Define value for property 'groupId': edu.eci.cvds
Define value for property 'artifactId': ClasesEquivalencia
Define value for property 'version' 1.0-SNAPSHOT: :
Define value for property 'package' edu.eci.cvds: : edu.eci.cvds.tdd
```

## Actualizar y crear dependencias del proyecto

Buscaremos en el [repositorio central de maven](https://mvnrepository.com/) el artefacto **JUnit** y agregaremos la dependecia al `pom.xlm` y cambiaremos la version del compilador a 8.

```xml
<properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
</properties>

<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Compilar y Ejecutar

Para compilar el proyecto usamos el comando:

```console
mvn package
```

Para ejecutar los test usaremos el comando:

```console
mvn test
```

Y observamos como el comando ejecuta las pruebas y estas se ejecutan exitosamente.

```console
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running edu.eci.cvds.tdd.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.13 s - in edu.eci.cvds.tdd.AppTest
```

## Ejercicio "Registraduria"

Realizamos el esqueleto de la aplicacion indicada en el laboratorio y ejecutamos las pruebas que se indican en el esqueleto. \
Se agregan los siguientes casos de prueba.

* Cuando una persona esta muerta.
* Cuando una persona es menor de edad.
* Cuando una persona es votante (mayor de edad).
* Cuando hay edades invalidas (edades negativas).
* Cuando hay Id's duplicados.

Compilamos y ejecutamos los test con `mvn test`.

```console
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running edu.eci.cvds.tdd.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.124 s - in edu.eci.cvds.tdd.AppTest
[INFO] Running edu.eci.cvds.tdd.registry.RegistryTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s - in edu.eci.cvds.tdd.registry.RegistryTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
```
