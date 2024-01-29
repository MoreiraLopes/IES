**Guião Lab2**

**Nome:** Gonçalo Rafael Correia Moreira lopes <br>
**Nmec:** 107572 <br>
**email:** goncalorcml@ua.pt

# Exercício 2.3
## Introduction to web apps with a full-featured framework (Spring Boot)

Sprint Boot - Getting Started: https://spring.io/projects/spring-boot

### O que é o Spring Boot?
- É uma plataforma de desenvolvimento rápido de aplicações construída sobre a popular Spring Framework.
- Torna mais fácil criar aplicações autónomas baseadas em Spring que é apenas necessário correr.
- Não é necessário descarregar ficheiros .War.
- Não é necessário gerar código nem requer uma configuração XML.

Utilizou-se o *[Spring Initializr](https://start.spring.io/)* para criar um projeto destinado a uma aplicação web, e adicionou-se a dependência Spring Web. O Spring Initializr disponibiliza modelos que incluem todas as dependências necessárias para iniciar uma funcionalidade, o que simplifica significativamente a configuração do ficheiro POM (Project Object Model).

Após o download é possível criar a aplicação usando os comandos:
```
- ./mvnw clean
- ./mvnw package
- ./mvnw spring-boot:run
```
No browser é possível visualizar uma página de erro gerada pelo Spring Boot, em http://localhost:8080/ <br>

**NOTA:**  ter em atenção se as portas já estão a ser utilizadas!
Para alterar a porta em uso, no ficheiro **application.properties** deve acrescentar:

```
server.port=9090
```

Em *Spring* os pedidos HTTP são tratados por um **controller**. <br>
O controller é identificado através da anotação **@Controller**. <br>

```java
@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
```
A anotação **@GetMapping** assegura que os pedidos HTTP GET para **/greeting** são mapeados para o método **greeting()**.<br>

A anotação **@RequestParam** associa o valor do parâmetro da string de consulta **name** ao parâmetro **name** do método **greeting()**. Este parâmetro de string de consulta não é obrigatório. Se estiver ausente no pedido, é utilizado o valor predefinido *"World"*. O valor do parâmetro "name" é adicionado a um objeto **Model**, tornando-o, por fim, acessível ao modelo de vista.<br>

A implementação do corpo do método depende de uma tecnologia de visualização (neste caso, Thymeleaf) para realizar a renderização no lado do servidor do HTML. O Thymeleaf analisa o modelo *greeting.html* e avalia a expressão **th:text** para renderizar o valor do parâmetro **${name}** que foi definido no controlador.<br>

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'Hello, ' + ${name} + '!'" />
</body>
</html>
```

**NOTA:** A implementação do *Spring MVC* depende do mecanismo *Servlets*, no entanto, você não precisa "visualizá-lo". As camadas de abstração disponíveis fornecerão ao desenvolvedor interfaces mais convenientes e de nível mais elevado.

No final o projeto foi extendido para criar um **REST endpoint** que ouve pedidos *HTTP* e responde com um resultado **JSON**. <br>

Construção de um Serviço Web RESTful: https://spring.io/guides/gs/rest-service/

Em vez de um @Controller, agora foi usado um **@RestController**

```java
@RestController
public class RestGreetingController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/api/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
```