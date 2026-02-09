# Family Grocery List – Backend REST API

Backend REST API sviluppata con **Java Spring Boot** per la gestione di una **lista della spesa condivisa**.  
L’applicazione consente agli utenti di registrarsi, autenticarsi e gestire prodotti all’interno di una lista persistita su database **MySQL**.

Il progetto è pensato per approfondire lo sviluppo backend, la sicurezza con **JWT** e l’utilizzo di **Redis** per la gestione dei token.

---

##  🚀 Funzionalità

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

## 🛠️ Tecnologie utilizzate

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
./gradlew clean build -x test
```
```bash
docker-compose up --build
```
### 2. Registrazione utente
Registrare un nuovo utente tramite Postman:

**POST** http://localhost:8080/auth/register 

es struttura JSON:
```json
      {
      "username": "Mario123",
      "nickname": "Mario Rossi",
      "password": "123"
      }
```

### 3. Autenticazione
Dopo la registrazione, l’utente può autenticarsi ed effettuare richieste agli endpoint protetti.

Per i test tramite Postman:
  - Selezionare Auth → Basic Auth
  - Inserire username e password di un utente registrato
      
### 4. Gestione prodotti (CRUD)
- Visualizzare i prodotti **GET** `http://localhost:8080/products`
- Inserire un prodotto **POST** `http://localhost:8080/products/add`

    es struttura JSON:
 
```json  
       {
        "name": "prodotto1",
        "quantity": 4,
        "note": "esempio nota"
       }
```
- Modificare un prodotto **PUT** `http://localhost:8080/products/update/(ID)`

- Eliminare un prodotto **DELETE** `http://localhost:8080/products/delete/(ID)`


## 🗄️ Accesso al database

È possibile visualizzare i contenuti delle tabelle `products` e `users` accedendo direttamente al container MySQL.

```bash
docker exec -it progettolista-master-mysql-1 mysql -u user -p products
```
**Password configurata nel docker-compose**

### Tabella `products`
La tabella **products** mostra:
- ID del prodotto
- Il nome del prodotto (NOT NULL)
- La quantità di prodotto da acquistare
- La data attuale inserita automaticamente
- Una nota aggiunta dall'utente

### Tabella `users`
La tabella **users** mostra:
- Username univoco
- Nickname scelto a piacere dall'utente
- Password criptata
- Ruolo

---

## 🔮 Sviluppi futuri
- Miglioramento sicurezza JWT (refresh token)
- Gestione delle famiglie con invito di utenti
- Ruoli e permessi (admin / membro)
- Frontend in React per l’interazione con le API
- Refactoring e miglioramento della struttura del codice
