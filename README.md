# TicketManager API

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.6-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Container-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Compiler](https://img.shields.io/badge/Compiler--Werror-NASA_Discipline-red?style=for-the-badge&logo=nasa&logoColor=white)

---

### 🚀 Descripción del proyecto
Una API REST que está diseñada para administrar tareas académicas y tickets de soporte técnico. El proyecto está enfocado principalmente en: garantizar un desacoplamiento estricto de capas mediante DTOs, persistir de forma segura los datos para ofrecer una API consistente y confiable.

### ⚡ Cómo probar el proyecto
Paso 1:
```
git clone https://github.com/DevNeno/TicketManager.git
cd TicketManager
./mvnw clean package -DskipTests
docker compose up --build
```
Paso 2:\
Ir a la [documentación interactiva de la API](http://localhost:8080/swagger-ui/index.html).

### 🧠 Buenas Prácticas y Calidad de Código
Este proyecto se desarrolló bajo normas estrictas:

* **Advertencias como errores (`-Werror`):** Todo el código compila sin advertencias. Cualquier advertencia del compilador se trata directamente como un error, lo que impulsa la mitigación de fallas de lógica antes de la implementación.
* **Desacoplamiento de capas (DTOs):** Uso estricto de Objetos de Transferencia de Datos para separar la persistencia de la capa de los controladores.
* **Manejo global de excepciones:** Uso de Manejador global de excepciones(`Global Exception Handler`) para poder retornar un mensaje personalizado en caso de ocurrir excepciones.

### 🛠️ Tecnologías
* **Backend:** Java 21, Spring Boot 4.0.6
* **Database:** MySQL

### 📊 Diagrama de Arquitectura

```mermaid
classDiagram
    direction LR
    class TicketController {
        +addTicket(TicketRequest ticket) ResponseEntity~TicketResponse~
        +modifyTicket(Long id, TicketRequest ticket) ResponseEntity~TicketResponse~
        +getAllTickets() ResponseEntity~List~TicketResponse~~
        +getTicketById(Long id) ResponseEntity~TicketResponse~
        +deleteTicket(Long id) ResponseEntity~Void~
    }
    class TicketService {
        +addTicket(TicketRequest ticketRequest) TicketResponse
        +modifyTicket(Long id, TicketRequest) TicketResponse
        +getAllTickets() List~TicketResponse~
        +getTicket(Long id) TicketResponse
        +deleteTicket(Long id) void
    }
    class TicketRepository {
        +save(Ticket ticket) Ticket
        +findAll() List~Ticket~
        +findById(Long id) Optional~Ticket~
        +deleteById(Long id)
    }
    TicketController --> TicketService : Pasa Request DTO
    TicketService --> TicketRepository : Persiste Ticket
    note for TicketService "Al recibir un Request se procesa y se genera un Ticket"

```

