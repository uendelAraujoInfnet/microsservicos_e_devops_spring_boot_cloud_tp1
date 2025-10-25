# Microsserviços com Spring Boot e Spring Cloud - TP1

## 🧩 Visão Geral

Este projeto demonstra a criação de **dois microsserviços** desenvolvidos com **Spring Boot** e **Spring Cloud OpenFeign**, onde os serviços se comunicam entre si.

### Serviços criados
- **Catalog Service (porta 8081)** – fornece uma API REST com produtos.
- **Order Service (porta 8082)** – consome o Catalog Service via Feign e calcula pedidos.

---

## 🚀 Ferramentas e Tecnologias

- Java 21+
- Spring Boot 3.5.7
- Spring Cloud 2025.0
- Spring Web
- Spring Boot Actuator
- Spring Cloud OpenFeign
- Bean Validation (Jakarta)
- Maven Wrapper (`./mvnw`)
- IntelliJ IDEA 

---

## ⚙️ Estrutura do Projeto

```
├── catalog-service/
│   ├── pom.xml
│   └── src/main/java/com/example/catalog/...
└── order-service/
    ├── pom.xml
    └── src/main/java/com/example/order/...
```

---

## 🧪 Testes via cURL

1. **Suba o catálogo**
   ```bash
   cd catalog-service
   ./mvnw spring-boot:run
   ```

2. **Suba o order**
   ```bash
   cd order-service
   ./mvnw spring-boot:run
   ```

3. **Teste as APIs**

   **Catalog Service**
   ```bash
   curl -i http://localhost:8081/api/products/1
   ```

   **Order Service**
   ```bash
   curl -i -X POST http://localhost:8082/api/orders      -H "Content-Type: application/json"      -d '{ "productId": 1, "quantity": 3 }'
   ```

   **Resposta esperada:**
   ```json
   {
     "productId": 1,
     "productName": "Teclado Mecânico",
     "quantity": 3,
     "unitPrice": 299.9,
     "total": 899.7
   }
   ```

---

## 🧰 Próximos Passos que tenho em mente para o futuro

- Adicionar **Eureka Discovery Server** (remoção de URLs fixas)  
- Incluir **Spring Cloud Gateway** (roteamento centralizado)  
- Implementar **Resilience4j** (circuit breaker)  
- Dockerizar e usar **Docker Compose** para subir ambos com 1 comando  
- Adicionar testes automatizados (JUnit + MockMvc)

---

## Criado e desenvolvido por 
© 2025 – Desenvolvido por *Uendel Ives de Araujo*.
