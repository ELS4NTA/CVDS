# CVDS - LABORATORIO 5 - INTRODUCCIÓN A PROYECTOS WEB

## INTEGRANTES

Angie Natalia Mojica - Daniel Antonio Santanilla

## RESPUESTAS

### Parte I - JUGANDO A SER UN CLIENTE HTTP

1. Abra una terminal Linux o consola de comando Windows
2. Realice una conexión síncronica TCP/IP a través de Telnet al siguiente servidor
    - Host: www.escuelaing.edu.co
    - Puerto: 80

    ```bash
    telnet www.escuelaing.edu.co 80
    ```

3. Revisar el resultado obtenido solicitando el recurso `/sssss/abc.html` usando la version 1.0 de HTTP
        ![Telnetconection](./imgs/telnet1.png)
        - ¿Qué código de error sale?\
        El código de error que sale es 301 Moved Permanetly
        - ¿Qué otros códigos de error existen? ¿En qué casos se manejarán?
        1. 1xx Informational response\
            Indica que la solicitud fue recibida y atendida.
        2. 2xx Success\
            Indica que la solicitud fue recibida por el cliente fue recibida, entendida y aceptada.
        3. 3xx Redirection\
            Indica que el cliente debe realizar una acción adicional para completar la solicitud.
        4. 4xx Client errors\
            Indica las situaciones en las que el error parece haber sido causado por el cliente.
        5. 5xx Server errors\
            Indica que el servidor no pudo cumplir con una solicitud.
        [Códigos de estado HTTP](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
4. Realice una nueva conexión telnet y solicite el recurso  `/html`, esta vez a:
    - Host: www.httpbin.org
    - Puerto: 80
    - Versión HTTP/1.1
    ![Telnetconection2](./imgs/telnet2.png)
5. Seleccione elcontenido HTML de la respuesta y copielo al portapapeles `CTRL-SHIFT-C`. Ejecute elcomando `wc` (word count) para contar palabras con la
opción `-c` para contar el número de caracteres:

    ```bash
    wc -c bodyhtml.txt
    ```

    ![WordCountTelnet](./imgs/telnetWC.png)\
    ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?
    - **GET** se utiliza para solicitar datos de un recurso específico a un servidor web.
    - **POST** se utiliza para enviar datos a un servidor web para procesarlos, se utiliza comúnmente para enviar información confidencial o datos que son demasiado largos para ser enviados a través del método GET.
    - **Otras peticiones**
        - **PUT**
            Se utiliza para actualizar un recurso existente en un servidor web con un nuevo conjunto de datos.
        - **DELETE**
            Se utiliza para eliminar un recurso existente en un servidor web.
        - **HEAD**
            Se utiliza para solicitar sólo la información de encabezado de una respuesta HTTP, sin incluir el cuerpo del mensaje.
        - **OPTIONS**
            Se utiliza para obtener información sobre los métodos HTTP que son compatibles con un recurso en particular en un servidor web.
        - **PATCH**
            Se utiliza para actualizar parcialmente un recurso en un servidor web con un conjunto específico de cambios.
        - **TRACE**
            Se utiliza para obtener una respuesta de retorno de un mensaje que incluye la secuencia de cambios realizados por cualquier servidor intermedio en el camino entre el cliente y el servidor final.
6. En la practica no se utiliza  `telnet` para hacer peticiones a sitios web sino el comando `curl` con ayuda de la linea de comandos: `curl www.httpbin.org`, utilice el parámetro `-v`y el parámetro `-i`\
    ![ParametroV](./imgs/curlv.png)\
    ![ParametroI](./imgs/curli.png)
    ¿Cuáles son las difernecias con los diferentes parámetros?
    - **VERBOSE (-v):**
    Indica la información detallada sobre la comunicación que se está llevando a cabo entre el cliente y el servidor.
    - **INCLUDE (-i):**
    Incluye los encabezados de respuesta en la salida, además del cuerpo de la respuesta, es útil para asegurar que todo este funcionando correctamente.

### Parte II - JUGANDO A SER UN CLIENTE HTTP

Cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar `maven-archetype-webapp` y realice lo que se encuentra en la guía de laboratorio:

01. Revise la clase SampleServlet incluida a continuacion, e identifique qué hace:

    ```bash
    mvn archetype:generate
    ```

02. En el pom.xml, modifique la propiedad "packaging"con el valor "war". Agregue la siguiente dependencia:

    ```xml
    <packaging>war</packaging>
    <dependency>
      <groupId>javax</groupId>
      <artifactId>javaee-web-api</artifactId>
      <version>7.0</version>
      <scope>provided</scope>
    </dependency>
    ```

03. Revise en el pom.xml para qué puerto TCP/IP está configurado elservidor embebido de Tomcat (versección de plugins).

    El puerto esta configurado para que use el 8080

    ```xml
    <plugin>
      <groupId>org.apache.tomcat.maven</groupId>
      <artifactId>tomcat7-maven-plugin</artifactId>
      <version>2.2</version>
      <configuration>
        <port>8080</port>
        <path>/</path>
      </configuration>
    </plugin>
    ```

04. Compile y ejecute la aplicación en elservidor embebido Tomcat, a través de Maven con:

    ```bash
    mvn package
    mvn tomcat7:run
    ```

05. Abra un navegador, y en la barra de direcciones ponga la URL con la cualse le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá como host ‘localhost’, como puerto, elconfigurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo.

    En el navegador poner lo siguiente `localhost:8080/helloServlet`\
    ![PeticionSampleServlet](./imgs/tomcatservlet.png)

06. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando un parámetro GET (si no sabe como hacerlo, revise la documentación en [](http://www.w3schools.com/tags/ref_httpmethods.asp).

    En el navegador ponemos lo siguiente `http://localhost:8080/helloServlet?name=%20AngieDaniel`\
    ![PeticionSampleServletParametros](./imgs/tomcatparametros.png)

07. Busque el artefacto `gson` en el repositorio de maven y agregue la dependencia.

    Agregamos al `pom.xml` la dependencia `gson`

    ```xml
    <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.10</version>
    </dependency>
    ```

08. En el navegador revise la dirección [](https://jsonplaceholder.typicode.com/todos/1). Intente cambiando diferentes números al final del path de la url.

    Consultamos los números 1 y 200\
    ![Consulta1](./imgs/consultaen1.png)\
    ![Cosulta2](./imgs/consultaen200.png)

09. Basado en la respuesta que le da elservicio del punto anterior,cree la clase edu.eci.cvds.servlet.model.Todo con un constructor vacío y los métodos getter y setter para las propiedades de los "To Dos" que se encuentran en la url indicada.

    Se crea la clase `Todo` como se indica en la guía de laboratorio en el paquete `edu.eci.cvds.servlet.model`

10. Utilice la siguiente clase para construir el servicio que se encuentra en la dirección url del punto anterior.

    Se crea la clase `Service` como se indica en la guía de laboratorio en el paquete `edu.eci.cvds.servlet`

11. Cree una clase que herede de la clase HttpServlet (similar a SampleServlet), y para la misma sobrescriba el método heredado doGet. Incluya la anotación `@Override` para verificar –en tiempo de compilación- que efectivamente se esté sobreescribiendo un método de lassuperclases.

    Se crea la clase `Servlet` como se indica en la guía de laboratorio en el paquete `edu.eci.cvds.servlet`

12. Para indicar en qué URL el servlet interceptará las peticiones GET, agregue al método la anotación `` @WebServlet`, y en dicha anotación, defina la propiedad urlPatterns, indicando la URL (que usted defina) a la cualse asociará elservlet.

    En la clase `Servlet` indicamos la URL

    ```java
    @WebServlet(
        urlPatterns = "/AngieDanielServlet"
    )
    ```

13. Teniendo en cuenta los siguientes métodos disponibles en los objetos ServletRequest y ServletResponse recibidos por el método doGet:

    Crear el método como se indica en la guía de laboratorio.

14. Una vez hecho esto, verifique el funcionamiento de la aplicación, recompile y ejecute la aplicación.

    ```bash
    mvn package
    mvn tomcat7:run
    ```

15. Intente hacer diferentesconsultas desde un navegador Web para probar las diferentesfuncionalidades.

    Consultando cuando el item existe\
    ![ItemExistente](./imgs/servletencontrado.png)

    Consultando cuando el item no es un entero\
    ![ItemNoEntero](./imgs/servletnoentero.png)

    Consultando cuando el item no existe\
    ![ItemNoEncontrado](./imgs/servletnoencontrado.png)

    Consultando cuando no se indicaron parámetros\
    ![NoParametro](./imgs/servletsinparametro.png)

### Parte III - CONTINUACION

1. En su servlet,sobreescriba el método doPost, y haga la misma implementación del doGet.

    Se sobreescribe el método `doPost` con la misma implementación que `doGet` en la clase `Servlet`

2. Cree el archivo index.html en el directorio src/main/webapp/index.html de la siguiente manera:

    Se crea el archivo `index.html` en el directorio `src/main/webapp/`

3. En la página anterior, cree un formulario que tenga un campo para ingresar un número (si no ha manejado html antes, revise [](http://www.w3schools.com/html/)) y un botón. El formulario debe usar como método ‘POST’, y como acción, la ruta relativa del último servlet creado (es decir la URL pero excluyendo ‘<http://localhost:8080/>’).

    ```html
    <form method="POST" action="AngieDanielServlet">
      <label for="id">Ingresa el número de ID:</label>
      <input type="number" id="id" name="id" required>
      <button type="submit" onclick="myFunction()">Enviar</button>
    </form>
    ```

4. Revise este [ejemplo de validación de formularios con javascript](https://www.w3schools.com/js/js_validation.asp) y agruéguelo a su formulario, de manera que -al momento de hacer ‘submit’- desde el browser se valide que el valor ingresado es un valor numérico.

    ```javascript
    function myFunction() {
        var id = document.getElementById("id").value;
        if (isNaN(id)) {
            alert("El valor ingresado no es un numero");
        }
    }
    ```

5. Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada. Ingrese los datos y verifique losresultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?

    Formulario\
    ![Formulario](./imgs/formulario.png)

    Ingresando los datos con el formulario en POST\
    ![FormularioPOST](./imgs/formularioPost.png)

    Ingresando los datos con el formulario en GET\
    ![FormularioGET](./imgs/formularioGet.png)

    La diferencia que se observa es en la visualizacion de la url, usando GET indica el parámetro que fue enviado y en POST no indica ningún parámetro y la consulta es la misma.

6. ¿Qué se está viendo? Revise cómo están implementados los métodos de la clase Service.java para entender el funcionamiento interno.

    Se muestra una tabla con información de una tarea específica que se selecciona mediante un formulario que solicita una ID. La tabla se crea utilizando la clase Service, que obtiene la información de la tarea mediante el método `getTodo(int id)`. Luego, se utiliza el método `todosToHTMLTable(List todoList)` para crear la tabla a partir de una lista de tareas.

### PARTE IV. - FRAMEWORKS WEB MVC – JAVA SERVER FACES / PRIME FACES

En este ejercicio, usted va a desarrollar una aplicación Web basada en el marco JSF, y en una de susimplementaciones más usadas: PrimeFaces. Se trata de un juego en línea para adivinar un número, en el que el ganador,si atina en la primera oportunidad, recibe $100.000. Luego, porcada intento fallido, el premio se reduce en $10.000.

1. Al proyecto Maven, debe agregarle las dependencias mas recientes de `javax.javaee-api`, `com.sun.faces.jsf-api`, `com.sun.faces.jsf-impl`, `javax.servlet.jstl` y `Primefaces` (en el archivo `pom.xml`).

   ```xml
   <!-- https://mvnrepository.com/artifact/javax/javaee-api -->
   <dependency>
      <groupId>javax</groupId>
      <artifactId>javaee-api</artifactId>
      <version>8.0.1</version>
      <scope>provided</scope>
   </dependency>
   <!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-api -->
   <dependency>
      <groupId>com.sun.faces</groupId>
      <artifactId>jsf-api</artifactId>
      <version>2.2.20</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-impl -->
   <dependency>
      <groupId>com.sun.faces</groupId>
      <artifactId>jsf-impl</artifactId>
      <version>2.2.20</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.primefaces/primefaces -->
   <dependency>
      <groupId>org.primefaces</groupId>
      <artifactId>primefaces</artifactId>
      <version>12.0.0</version>
   </dependency>
   ```

2. Para que configure automáticamente el descriptor de despliegue de la aplicación (archivo `web.xml`), de manera que el framework JSF se active al inicio de la aplicación, en el archivo `web.xml` agregue la siguiente configuración:

   ```xml
   <servlet>
      <servlet-name>Faces Servlet</servlet-name>
      <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
      <load-on-startup>1</load-on-startup>
   </servlet>
   <servlet-mapping>
      <servlet-name>Faces Servlet</servlet-name>
      <url-pattern>/faces/*</url-pattern>
   </servlet-mapping>
   <welcome-file-list>
      <welcome-file>faces/index.jsp</welcome-file>
   </welcome-file-list>
   ```

3. Revise cada una de las configuraciones agregadas anteriormente para saber qué hacen y por qué se necesitan. Elimine las que no se necesiten.

4. Ahora, va a crear un Backing-Bean de sesión, el cual, para cada usuario, mantendrá de lado del servidor las siguientes propiedades:
   a. El número que actualmente debe adivinar (debe ser un número aleatorio).
   b. El número de intentos realizados.
   c. El premio acumulado hasta el momento.
   d. El estado del juego, que sería una cadena de texto que indica si ya ganó o no, y si ganó de cuanto es el premio.

5. Cree una página XHTML, de nombre `guess.xhtml` (debe quedar en la ruta `src/main/webapp`). Revise en la página [13 del manual de PrimeFaces](https://www.primefaces.org/docs/guide/primefaces_user_guide_5_2.pdf), qué espacios de nombres XML requiere una página de PrimeFaces y cuál esla estructura básica de la misma.

    La estructura básica de una página de PrimeFaces

    ```xhtml
    <!DOCTYPE html>
    <html xmlns="http://www.w3c.org/1999/xhtml"
          xmlns:h="http://xmlns.jcp.org/jsf/html"
          xmlns:p="http://primefaces.org/ui">
      <h:head></h:head>
      <h:body>
        <p:editor />
      </h:body>
    </html>
    ```

6. Con base en lo anterior, agregue un formulario con identificador `guess_form` con el siguiente contenido básico:

    Se realizó la implementación indicada en el laboratorio

    ```xhtml
    <h:body>
      <h:form id="guess_form">
      </h:form>
    </h:body>
    ```

7. Al formulario, agregue los elementos indicados en la guía de laboratorio:

    Se agregaron los siguientes elementos:

    - `<p:outputLabel>` para el número que se debe adivinar,sin embargo, este elemento se debe ocultar.
    - `<p:inputText>` para que el usuario ingrese su número.
    - `<p:outputLabel>` para mostrar el número de intentosrealizados.
    - `<p:outputLabel>` para mostrar el estado del juego.
    - `<p:outputLabel>` para mostrar en cuanto va el premio.

8. Al formulario, agregue dos botones de tipo `<p:commandButton>`, uno para enviar el número ingresado y ver si se atinó, y otro para reiniciar el juego.

    Se agregó un botón para adivinar y otro para reiniciar el juego con las propiedades:

    - El botón de envío de adivinanza debe tener asociado a su propiedad update el nombre del formulario en el que se agregaron los campos antes descritos, de manera que al hacer clic,se ejecute un ciclo de JSF y se refresque la vista.
    - Debe tener también una propiedad actionListener con la cual e le indicará que, al hacer clic,se ejecutará el método guess,creado en el backing-bean de sesión:

9. Para verificar el funcionamiento de la aplicación, agregue el plugin tomcat-runner dentro de los plugins de la fase de construcción (build). Tenga en cuenta que en la configuración del plugin se indica bajo que ruta quedará la aplicación:

    Se compiló el proyecto y se vizualizó en [](http://localhost:8080/faces/guess.xhtml)

10. Si todo funcionó correctamente, realice las siguientes pruebas:

    - Abra la aplicación en un explorador. Realice algunas pruebascon el juego e intente adivinar el número.\
        ![Intento](./imgs/pruebaintento.png)\
        ![Ganador](./imgs/pruebaganador.png)
    - Abra la aplicación en dos computadores diferentes. Si no dispone de uno, hágalo en dos navegadores diferentes(por ejemplo Chrome y Firefox; incluso se puede en un único navegador usando una ventana normal y una ventana de incógnito / privada). Haga cinco intentos en uno, y luego un intento en el otro. ¿Qué valor tiene cada uno?\
        Cada uno obtiene el mismo valor que el otro, y en uno se obtuvo un intendo de más\
        ![Computadores](./imgs/pruebacomputadores.png)
    - Aborte el proceso de Tomcat-runner haciendo `Ctrl+C` en la consola, y modifique el código del backing-bean de manera que use la anotación @SessionScoped en lugar de @ApplicationScoped. Reinicie la aplicación y repita el ejercicio anterior. ¿Coinciden los valores del premio?.
        Los valores en cada computador son diferentes por lo que no coinciden en el premio\
        ![Computadores2](./imgs/pruebacomputadores2.png)

        Dado la anterior, ¿Cuál es la diferencia entre los backing-beans de sesión y los de aplicación?

        - Un backing bean de sesión se crea una sola vez por usuario durante toda la sesión de la aplicación, es decir, Los datos almacenados en el backing bean de sesión estarán disponibles para el usuario durante toda la sesión.
        - Un backing bean de aplicación se crea una sola vez durante el arranque de la aplicación y se comparte entre todos los usuarios de l aplicación, es decir, Los datos almacenados en un backing bean de aplicación serán los mismos para todos los usuarios de la aplicación.
    - Por medio de las herramientas de desarrollador del explorador (Usando la tecla "F12" en la mayoría de exploradores): Busque el elemento oculto, que contiene el número generado aleatoriamente. En la sección de estilos, deshabilite el estilo que oculta el elemento para que sea visible.\
    ![Visible](./imgs/devtools.png)

11. Para facilitar losintentos del usuario, se agregará una lista de los últimos intentos fallidos realizados:

    - Agregue en el `Backing-Bean`, una propiedad que contenga una lista de intentados realizados.
    - Agregue cada intento a la lista, cuando se ejecute el método `guess`.
    - Cuando se reinicie el juego, limpie el contenido de la lista.
    - Busque cómo agregar una tabla a la página, cuyo contenido sea los últimos intentos realizados.

    ![Tablet](./imgs/pruebacontabla.png)
