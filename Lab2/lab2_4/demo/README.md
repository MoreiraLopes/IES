**Guião Lab2**

**Nome:** Gonçalo Rafael Correia Moreira lopes <br>
**Nmec:** 107572 <br>
**email:** goncalorcml@ua.pt

**Exercício 2.4**<br>
**Creating a Web Service (REST API)**<br>

O *Java Enterprise* permite a criação de aplicações complexas e robustas para cenários exigentes. Muitas vezes, não precisamos de um servidor de aplicação completo, mas sim de recursos suficientes para executar aplicações web/serviços web. Vários servidores oferecerão uma versão "reduzida" associada a um "Perfil Web" que é apropriado, por exemplo, para implantar uma API sobre HTTP, como exemplificado no guião anterior sobre REST.<br>

Neste exercício foi criado um serviço web (REST API) para fornecer quotes aleatórias de filmes/séries.
| Method | Path | Description |
| :---: | :---: | :---: |
| GET | api/quote | Returns a random quote (show not specified).
| GET | api/shows | List of all available shows (for which some quote exists). For
convenience, a show should have some identifier/code.
| GET | api/quotes?show=<show_id> | Returns the existing quotes for the specified show/film.

Fazer:
```
- ./mvnw clean
- ./mvnw package
- ./mvnw spring-boot:run
```

**NOTA:**  ter em atenção se as portas já estão a ser utilizadas!
Para alterar a porta em uso, no ficheiro **application.properties** deve acrescentar:

```
server.port=5050
```

Depois aceder aos links():<br>
http://localhost:5050/api/quote <br>
http://localhost:5050/api/shows <br>

Mostrar para o filme com id 1 por exemplo:
http://localhost:5050/api/quotes?show=1 <br>
