🔎 Backend Search Engine with TF-IDF Ranking

A custom backend search engine built using Spring Boot that performs keyword-based search with relevance ranking using the TF-IDF algorithm, without relying on Elasticsearch.

🚀 Features

🔍 Keyword-based document search

📊 TF-IDF relevance ranking

🗂 Inverted Index implementation

💾 Persistent storage using H2 Database

🔄 Automatic indexing on application startup

🌐 RESTful APIs for search and document management

📄 CRUD operations for documents

🛠 Tech Stack

Java

Spring Boot

Spring Data JPA

H2 Database

Maven

🧠 How It Works

Documents are stored in the H2 database.

On application startup, documents are indexed.

An inverted index maps words to document IDs.

When a search query is entered:

Term Frequency (TF) is calculated.

Inverse Document Frequency (IDF) is calculated.

TF-IDF score determines ranking.

Results are returned in descending order of relevance.

📂 Project Structure
src/main/java
 ├── controller     → REST Controllers
 ├── service        → Search & Indexing Logic
 ├── repository     → JPA Repository
 ├── model          → Entity Classes
 └── config         → Startup Indexing
⚙️ Setup & Installation
1️⃣ Clone Repository
git clone https://github.com/your-username/backend-search-engine.git
cd backend-search-engine
2️⃣ Configure Application

In src/main/resources/application.properties:

spring.application.name=demo
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=update
3️⃣ Run the Application

Using Maven:

mvn spring-boot:run

Or run the main class from your IDE.

📡 API Endpoints
➕ Add Document
POST /documents
📄 Get All Documents
GET /documents
🔍 Search Documents
GET /search?query=keyword
🧪 H2 Database Console

After running the application:

http://localhost:8080/h2-console

JDBC URL:

jdbc:h2:mem:testdb
📈 Future Improvements

Stop-word filtering

Stemming support

Pagination for search results

Performance optimization for large datasets

JWT-based authentication
