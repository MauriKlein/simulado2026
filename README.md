# Simulado: Desafio Loja de Jogos

## Descrição

Desenvolva uma API REST para gerenciamento de jogos cadastrados em uma game store.

---

# Entidade Principal

## Jogo

| Campo                   | Tipo       | Regras                           |
| ----------------------- | ---------- | -------------------------------- |
| id                      | Long       | Gerado automaticamente           |
| titulo                  | String     | Obrigatório, mínimo 3 caracteres |
| preco                   | BigDecimal | Deve ser maior ou igual a 0      |
| estoque                 | Integer    | Deve ser maior ou igual a 0      |
| classificacaoIndicativa | Integer    | Deve ser maior ou igual a 0      |
| codigoInterno           | String     | Gerado automaticamente           |
| disponivel              | Boolean    | Gerado de acordo com o estoque   |

---

# DTOs

## JogoRequestDTO

Utilizado para cadastro e atualização de jogos.

Deve conter apenas os seguintes campos:

| Campo                   | Tipo       |
| ----------------------- | ---------- |
| titulo                  | String     |
| preco                   | BigDecimal |
| estoque                 | Integer    |
| classificacaoIndicativa | Integer    |

### Regras

* O id e o código interno não devem ser enviados pelo cliente.
* O status `disponivel` deve ser gerado a partir do estoque:

  * “True” quando estoque > 0
  * “False” quando estoque = 0

* Utilize validações com:

  * `@Size`
  * `@Positive`
  * `@NotNull`

---

## JogoResponseDTO

Utilizado para retorno da API.

Deve conter os seguintes campos:

| Campo                   | Tipo       |
| ----------------------- | ---------- |
| id                      | Long       |
| titulo                  | String     |
| preco                   | BigDecimal |
| classificacaoIndicativa | Integer    |
| disponivel              | Boolean    |

### Regras

* O estoque não deve ser retornado.
* O código interno não deve ser retornado.

---

# Endpoints Obrigatórios

## 1. Cadastrar jogo

### POST `/jogos`

### Recebe:

`JogoRequestDTO`

### Retorna:

`JogoResponseDTO`

### Regras:

* Todos os campos devem ser validados.

---

## 2. Buscar todos os jogos

### GET `/jogos`

### Retorna:

Lista de `JogoResponseDTO`

---

## 3. Buscar jogo por ID

### GET `/jogos/{id}`

### Retorna:

`JogoResponseDTO`

### Regras:

* Retornar erro caso o ID não exista.

---

## 4. Atualizar jogo

### PUT `/jogos/{id}`

### Recebe:

`JogoRequestDTO`

### Retorna:

`JogoResponseDTO`

### Regras:

* Validar os dados recebidos.
* Retornar erro caso o ID não exista.

---

## 5. Remover jogo

### DELETE `/jogos/{id}`

### Regras:

* Retornar erro caso o ID não exista.

---

# Estrutura Esperada

```text
controller
service
repository
entity
dto
handler
```

---

# Tratamento de Erros

Implemente tratamento global de exceções utilizando:

* `@ControllerAdvice`
* `@ExceptionHandler`

A API deve retornar mensagens claras de erro.

