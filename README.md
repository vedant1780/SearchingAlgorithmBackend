# 🔎 Backend Search Engine with TF-IDF Ranking

A custom backend search engine built using **Spring Boot** that performs keyword-based search with relevance ranking using the **TF-IDF algorithm**, without relying on Elasticsearch.

---

## 🚀 Features

- 🔍 Keyword-based document search  
- 📊 TF-IDF relevance ranking  
- 🗂 Inverted Index implementation  
- 💾 Persistent storage using H2 Database  
- 🔄 Automatic indexing on application startup  
- 🌐 RESTful APIs for search and document management  
- 📄 CRUD operations for documents  

---

## 🛠 Tech Stack

- Java  
- Spring Boot  
- Spring Data JPA  
- H2 Database  
- Maven  

---

## 🧠 How It Works

1. Documents are stored in the H2 database.
2. On application startup, documents are indexed.
3. An inverted index maps words to document IDs.
4. When a search query is entered:
   - Term Frequency (TF) is calculated.
   - Inverse Document Frequency (IDF) is calculated.
   - TF-IDF score determines ranking.
5. Results are returned in descending order of relevance.

---

## 📂 Project Structure

```
src/main/java
 ├── controller     → REST Controllers
 ├── service        → Search & Indexing Logic
 ├── repository     → JPA Repository
 ├── model          → Entity Classes
 └── config         → Startup Indexing
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/backend-search-engine.git
cd backend-search-engine
```

### 2️⃣ Configure Application

Update `src/main/resources/application.properties`:

```properties
spring.application.name=demo
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main class from your IDE.

---

## 📡 API Endpoints

### ➕ Add Document

```
POST /documents
```

### 📄 Get All Documents

```
GET /documents
```

### 🔍 Search Documents

```
GET /search?query=keyword
```

Example:

```
GET /search?query=spring
```

---

## 🧪 H2 Database Console

After running the application:

```
http://localhost:8080/h2-console
```

Use the following JDBC URL:

```
jdbc:h2:mem:testdb
```

---

## 📈 Future Improvements

- Stop-word filtering  
- Stemming support  
- Pagination for search results  
- Performance optimization for large datasets  
- JWT-based authentication  

---

## 👨‍💻 Author

**Vedant Verma**  
Java Backend Developer  
Bangalore, India  

---

## ⭐ Why This Project?

This project demonstrates:

- Strong understanding of backend architecture  
- Knowledge of search engine fundamentals  
- Implementation of ranking algorithms  
- Practical use of Spring Boot & JPA  
- Clean REST API design  

---

If you found this project useful, consider giving it a ⭐ on GitHub!
