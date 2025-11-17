# HibernatePF

Proyecto Java con Gradle que utiliza **Hibernate ORM** y **MySQL** para gestionar entidades como usuarios, artículos, ventas, pagos y valoraciones. Está pensado como proyecto de práctica final para trabajar con mapeo objeto‑relacional (ORM) en Java.

## Tecnologías
- Java (toolchain configurado a `Java 24`)
- Gradle (módulo `app`)
- Hibernate ORM (`hibernate-core:7.1.5.Final`)
- MySQL Connector/J (`mysql-connector-j:9.5.0`)
- Jakarta Persistence API (`jakarta.persistence-api:3.1.0`)

## Estructura del proyecto
- `app/src/main/java/com/example/HibernatePF` → código principal (entidades, DAOs, clase `App`)
- `app/src/main/resources/hibernate.cfg.xml` → configuración de Hibernate y conexión a la base de datos
- `app/src/test/java/com/example/HibernatePF` → tests con JUnit

## Requisitos previos
- JDK 24 instalado (o un JDK compatible configurado en tu IDE)
- MySQL en ejecución y una base de datos creada acorde a la configuración de `hibernate.cfg.xml`
- Gradle (se puede usar el wrapper `gradlew` incluido)

## Cómo compilar y ejecutar

Desde la raíz del proyecto:

```bash
./gradlew :app:run
```

En Windows (CMD/PowerShell):

```bash
gradlew.bat :app:run
```

## Cómo ejecutar los tests

```bash
./gradlew test
```

o en Windows:

```bash
gradlew.bat test
```

## Cómo subir este proyecto a GitHub

1. Crea un repositorio vacío en GitHub (sin README, sin .gitignore) desde la web.  
2. En una terminal, desde la carpeta del proyecto (`HibernatePF`), ejecuta:

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/TU_REPO.git
git push -u origin main
```

Sustituye `TU_USUARIO` y `TU_REPO` por tu usuario y el nombre del repositorio que crees en GitHub.

