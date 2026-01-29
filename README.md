# Family Grocery List – Backend REST API

Backend REST API sviluppata con **Java Spring Boot** per la gestione di una **lista della spesa condivisa**.  
L’applicazione consente agli utenti di registrarsi, autenticarsi e gestire prodotti all’interno di una lista persistita su database **MySQL**.

Il progetto è pensato per approfondire lo sviluppo backend, la sicurezza con **JWT** e l’utilizzo di **Redis** per la gestione dei token.

---

##  Funzionalità

- Registrazione e login utente tramite username e password
- Autenticazione e autorizzazione tramite **JWT**
- CRUD dei prodotti della lista della spesa
  - Creazione
  - Lettura
  - Modifica
  - Eliminazione
- Persistenza dei dati tramite **MySQL**
- Gestione dei token JWT con **Redis** *(in fase di integrazione)*

---

## Tecnologie utilizzate

- **Java**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **JPA / Hibernate**
- **MySQL**
- **Redis**
- **Gradle**
- **Git / GitHub**

---

## Struttura del progetto

-src
 └── main
     ├── java
     │   └── com.example.grocerylist
     │       ├── controller      # gestisce le richieste (REST API)
     │       ├── dto         
     │       ├── repository      # interfaccia con il database (JPA)
     │       ├── model           # entità / oggetti (User, Product, ecc.)
     │       └── security        # gestione JWT, filtri, autenticazione
     └── resources    
         └── application.properties  # configurazioni database, Redis, JWT

*(la struttura può variare in base all’evoluzione del progetto)*

---

## 🔐 Autenticazione

L’autenticazione avviene tramite **JWT** *(work in progress)*:

1. L’utente effettua il login
2. Il server genera un token JWT
3. Il token viene utilizzato per accedere agli endpoint protetti
4. I token vengono gestiti tramite **Redis** per migliorare sicurezza e controllo delle sessioni

---

## 🗄️ Database

Il database utilizzato è **MySQL**.  
Le entità principali includono:
- User
- Product
- (Family – in sviluppo)

La persistenza è gestita tramite **JPA / Hibernate**.

---

## ▶️ Avvio del progetto

### 1. Avvio dei servizi
Avviare l’applicazione e i servizi necessari tramite Docker Compose:
```bash
docker-compose up --build
```
###2. Registrazione utente
Registrare un nuovo utente tramite Postman:

POST http://localhost:8080/auth/register
```bash
  es struttura JSON:
      {
      "username": "Mario123",
      "nickname": "Mario Rossi",
      "password": "123"
      }
```

###3. Autenticazione
Dopo la registrazione, l’utente può autenticarsi ed effettuare richieste agli endpoint protetti.

Per i test tramite Postman:
  - Selezionare Auth → Basic Auth
  - Inserire username e password di un utente registrato
      
###4.Gestione prodotti (CRUD)
```bash
 **GET http://localhost:8080/products** 
 **POST http://localhost:8080/products/add**
```   
```bash
  es struttura JSON:
       {
        "name": "prodotto1",
        "quantity": 4,
        "note": "esempio nota"
       }
```    
 ```bash
**http://localhost:8080/products/update/(ID)**
 **http://localhost:8080/products/delete/(ID)**
```

         
