# Sistema de Gestión Inmobiliaria - ICI2241
Bienvenido al repositorio del proyecto semestral de Programación Avanzada sobre un Sistema de Gestión Inmobiliaria. Esta aplicación de escritorio ha sido diseñada con el objetivo de ofrecer una solución integral para la administración y gestión de propiedades en el contexto inmobiliario.

## Características Principales
1. Gestión de Edificios y Departamentos: Permite registrar, editar y eliminar edificios y sus respectivos departamentos, manteniendo un control sobre detalles como ubicación, tipo, número de habitaciones, entre otros.

2. Búsqueda Avanzada: Facilita la búsqueda de propiedades específicas, ofreciendo opciones avanzadas para encontrar tanto edificios como departamentos según criterios determinados.

3. Generación de Reportes: Con la capacidad de generar reportes en formato XLSX, se facilita la extracción de datos relevantes de las propiedades registradas.

4. Manejo de Excepciones: El sistema está diseñado para gestionar y notificar al usuario sobre posibles errores o inconsistencias de manera clara y eficiente.

5. Interfaz Gráfica Amigable: A través de una interfaz gráfica intuitiva, se garantiza una experiencia de usuario fluida y eficiente.

## Estructura del Código
El proyecto se estructura en varios paquetes y clases, entre las que destacan:

- Modelo: Contiene las clases Edificio y Departamento, que representan las entidades principales del dominio del problema.

- Controladores: Incluye los controladores asociados a las vistas, como AgEdificioController, AgregarDepartamentoController y otros que gestionan la lógica de interacción con el usuario.

- Excepciones: Define excepciones personalizadas como ArgumentoIlegalException y FaltaDatosException para gestionar situaciones específicas.

- Utilidades: La clase GeneradorXLSX se encarga de generar reportes en formato XLSX.

- Sistema: La clase Sistema actúa como un punto central para la gestión y almacenamiento de edificios y departamentos.

Requisitos
- Java SE (versión 8 o superior).
- Librería JavaFX para la interfaz gráfica.
- Apache POI para la generación de reportes en formato XLSX.
