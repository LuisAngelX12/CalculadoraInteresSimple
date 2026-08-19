# Matemáticas Financieras - Interés Simple

Aplicación desarrollada en **Java** para realizar cálculos relacionados con las **matemáticas financieras**, con un enfoque específico en operaciones de **interés simple**.

El proyecto integra diferentes herramientas para calcular intereses, tasas, tiempos, conversiones y otros valores utilizados en ejercicios financieros. Además, cuenta con un sistema de consulta del historial de operaciones y una sección de fórmulas explicadas.

## Descripción

**MatemáticasFinancierasInteresSimple** es una aplicación orientada al aprendizaje y a la resolución de ejercicios financieros mediante una interfaz gráfica.

El sistema permite realizar diversas operaciones relacionadas con el interés simple, proporcionando herramientas auxiliares que facilitan los cálculos, la interpretación de resultados y la comprensión de las fórmulas utilizadas.

## Características principales

* Cálculo de interés simple.
* Cálculo de tiempo a partir de valores financieros.
* Comparación de tasas de interés.
* Conversión de inversiones.
* Conversión de tasas.
* Consulta del historial de operaciones.
* Visualización y explicación de fórmulas financieras.
* Realización de operaciones mediante una interfaz gráfica.
* Organización del código mediante paquetes y clases.
* Aplicación de principios de programación orientada a objetos.

## Tecnologías utilizadas

* **Java**
* **Java Swing** para el desarrollo de la interfaz gráfica.
* **NetBeans** como entorno de desarrollo y estructura del proyecto.
* **Programación Orientada a Objetos (POO)**.

## Estructura del proyecto

```text
MatematicasFinancierasInteresSimple/
│
├── Source Packages/
│   │
│   ├── CalculadoraInteresSimple/
│   │   ├── CalculadoraInteresSimple.java
│   │   ├── Fondo.png
│   │   └── Icono.png
│   │
│   ├── Funciones/
│   │   ├── HistorialOperaciones.java
│   │   └── Operaciones.java
│   │
│   └── Herramientas/
│       ├── CalcularTiempoDecimal.java
│       ├── ComparadorIntereses.java
│       ├── ConvertidorInversion.java
│       ├── ConvertidorTasas.java
│       └── FormulasExplicadas.java
│
├── Test Packages/
│
├── Libraries/
│
└── Test Libraries/
```

## Descripción de los paquetes

### `CalculadoraInteresSimple`

Contiene los componentes principales de la aplicación, incluyendo la clase encargada de iniciar y gestionar la calculadora, así como los recursos gráficos utilizados en la interfaz.

**`CalculadoraInteresSimple.java`**

Es la clase principal de la aplicación. Se encarga de proporcionar la interfaz gráfica y las funcionalidades principales relacionadas con el cálculo de interés simple.

**Recursos gráficos:**

* `Fondo.png`
* `Icono.png`

### `Funciones`

Contiene funcionalidades generales utilizadas por el sistema.

**`HistorialOperaciones.java`**

Gestiona la consulta y visualización del historial de operaciones realizadas por el usuario.

**`Operaciones.java`**

Contiene las operaciones y cálculos financieros utilizados por las diferentes funcionalidades de la aplicación.

### `Herramientas`

Agrupa las herramientas complementarias destinadas a realizar cálculos y consultas financieras específicas.

**`CalcularTiempoDecimal.java`**

Permite realizar cálculos relacionados con el tiempo expresado en formato decimal.

**`ComparadorIntereses.java`**

Permite comparar diferentes valores o escenarios relacionados con tasas e intereses.

**`ConvertidorInversion.java`**

Realiza conversiones relacionadas con valores de inversión.

**`ConvertidorTasas.java`**

Permite convertir diferentes tipos de tasas utilizadas en cálculos financieros.

**`FormulasExplicadas.java`**

Contiene información y explicaciones de las principales fórmulas utilizadas en las operaciones de matemáticas financieras.

## Interés simple

El **interés simple** es un método de cálculo en el que los intereses generados durante cada período se calculan únicamente sobre el capital inicial.

La fórmula principal es:

```text
I = C × i × t
```

Donde:

* `I` = Interés generado.
* `C` = Capital inicial.
* `i` = Tasa de interés.
* `t` = Tiempo.

El monto final de la operación puede calcularse mediante:

```text
M = C + I
```

O, de forma equivalente:

```text
M = C × (1 + i × t)
```

La aplicación facilita este tipo de cálculos, reduciendo la necesidad de realizar operaciones manuales repetitivas y proporcionando resultados de manera rápida y organizada.

## Instalación y ejecución

### Requisitos

Para ejecutar correctamente el proyecto se recomienda contar con:

* **JDK de Java** instalado.
* Un IDE compatible con proyectos Java, como **NetBeans**.
* Las bibliotecas necesarias incluidas en el proyecto.

### Procedimiento

1. Descargar o clonar el proyecto.
2. Abrir **NetBeans**.
3. Seleccionar **File → Open Project**.
4. Localizar la carpeta `MatematicasFinancierasInteresSimple`.
5. Abrir el proyecto.
6. Compilar la aplicación.
7. Ejecutar la clase principal:

```text
CalculadoraInteresSimple.java
```

## Uso de la aplicación

Al iniciar la aplicación, el usuario puede acceder a las diferentes opciones disponibles para realizar cálculos financieros.

Según la operación seleccionada, se introducen los valores correspondientes y el sistema procesa la información para mostrar el resultado.

Entre las principales herramientas disponibles se encuentran:

* Conversión de tasas.
* Cálculo de tiempo.
* Comparación de intereses.
* Conversión de inversiones.
* Consulta de fórmulas financieras.
* Consulta del historial de operaciones.
* Cálculo de interés simple.

## Objetivo académico

El objetivo principal del proyecto es aplicar conceptos de **matemáticas financieras** mediante el desarrollo de una aplicación funcional en **Java**.

Asimismo, el proyecto permite poner en práctica diferentes conceptos fundamentales de programación, entre ellos:

* Programación Orientada a Objetos.
* Organización del código mediante paquetes.
* Creación y utilización de clases y métodos.
* Desarrollo de interfaces gráficas.
* Manejo de eventos.
* Validación de datos.
* Reutilización de código.
* Separación y organización de funcionalidades.

## Autor

Luis Ángel Hernández Monge

## Licencia

Este proyecto fue desarrollado exclusivamente con **fines educativos y académicos**.
