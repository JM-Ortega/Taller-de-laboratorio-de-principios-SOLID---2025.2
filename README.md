# Taller de laboratorio de Principios SOLID – 2025.2

Aplicación de **escritorio** en Java (monolítica) para el módulo de **usuarios** del sistema _Gestión del Proceso de Trabajo de Grado – FIET_.
Incluye **registro**, **inicio de sesión** y **tablero por rol** (estudiante/docente), aplicando **SOLID** y el patrón de **Inversión de Dependencias (DIP)** tal como se pide en el taller y basado en el ejemplo 5 visto en clase.&#x20;

> Este taller se inspira en el proyecto de clase “Gestión del Proceso de Trabajo de Grado – FIET”, tomando el contexto de roles y proceso, pero limitado al módulo de usuarios para esta entrega.&#x20;

---

## 🎯 Objetivo

Aplicar **principios SOLID** y **DIP** en una app Java de escritorio, con **SQLite** como base de datos y contraseñas **hasheadas**.

---

## ✨ Funcionalidades

- **Registro** de usuarios (estudiante/docente) con los campos requeridos y validaciones:

  - nombres, apellidos, **celular (opcional)**, **programa** (Sistemas, Electrónica y Telecomunicaciones, Automática Industrial, Tecnología en Telemática), **rol**, **email institucional** y **contraseña**.
  - Contraseña: **mínimo 6**, **≥1 dígito**, **≥1 mayúscula** y **≥1 caracter especial**; se almacena **hasheada**.&#x20;

- **Login** y tablero según rol:

  - **Estudiante**: ver estado del TG / iniciar TG.
  - **Docente**: ver/evaluar anteproyectos y monografías.&#x20;

> El proyecto de curso contiene el proceso completo (Formato A, evaluaciones, sustentación, etc.); este taller entrega la primera pieza (usuarios/tablero) manteniendo coherencia para crecer luego.&#x20;

---

## 🛠 Tecnologías

- Java **21** (LTS)
- **Swing** (NetBeans Matisse para UI)
- **SQLite** (archivo local)
- **Argon2id** para hash de contraseñas (`de.mkammerer:argon2-jvm`)
- **Maven** (build)
- **JUnit 5** (pruebas del dominio/servicios)

---

## ▶️ Ejecución

1. **Clonar** este repositorio.
2. Abrir en **NetBeans** (o IntelliJ).
3. Verificar **Java 17** y Maven.
4. Ejecutar la clase `MainApp` desde el IDE.
5. La base de datos SQLite se crea/usa en `./app.db` (DDL auto en el arranque).

---

## ✅ Cumplimiento del taller

- App **de escritorio** en Java (monolítica) con **SQLite**.&#x20;
- **SOLID** aplicado (SRP/ISP/DIP; OCP/LSP según sea pertinente).
- **DIP** basado en **Ejemplo 5** (servicios → interfaces; repos concretos inyectados).&#x20;
- **Contraseñas hasheadas** (Argon2id).
- **Pruebas unitarias** del dominio/servicios (20% de la rúbrica).&#x20;

---

## 📚 Contexto de curso

- **Laboratorio de Ingeniería de Software II** – Universidad del Cauca – 2025.2
- Taller basado en el enunciado oficial.&#x20;
- Coherente con el **Proyecto de clase FIET** (módulo de usuarios).&#x20;

---

## 👥 Autores

<div style="text-align: center;">
<table border="0" style="border:none;">
  <tr>
    <td align="center" style="border:none;">
      <a href="https://github.com/MaryuriFernandez">
        <img src="https://images.weserv.nl/?url=github.com/MaryuriFernandez.png&h=100&w=100&fit=cover&mask=circle" alt="Maryuri Fernández Salazar"/>
        <br />
        <sub><b>Maryuri Fernández Salazar</b></sub>
      </a>
    </td>
    <td align="center" style="border:none;">
      <a href="https://github.com/LauraMolano">
        <img src="https://images.weserv.nl/?url=github.com/LauraMolano.png&h=100&w=100&fit=cover&mask=circle" alt="Laura Isabel Molano Bermúdez"/>
        <br />
        <sub><b>Laura Isabel Molano Bermúdez</b></sub>
      </a>
    </td>
    <td align="center" style="border:none;">
      <a href="https://github.com/JM-Ortega">
        <img src="https://images.weserv.nl/?url=github.com/JM-Ortega.png&h=100&w=100&fit=cover&mask=circle" alt="Juan Manuel Ortega Narvaez"/>
        <br />
        <sub><b>Juan Manuel Ortega Narvaez</b></sub>
      </a>
    </td>
  </tr>
</table>
</div>
