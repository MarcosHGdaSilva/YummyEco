# YummyEco

## Requisitos

- [ ] CRUD Usuários
- [ ] CRUD Pratos
- [ ] Menu
- [ ] Autenticação

## Endpoints

### Pratos

`GET` /menu

Lista todas as opções cadastradas no menu.

`200` sucesso

---

`GET` /menu/{id}

Retorna os detalhes de um prato com o `id` informado.

**códigos de status**

`200` sucesso
`404` id não encontrado

---
`POST` /menu

Cadastrar um novo prato.

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|nome|string|✅|Um nome curto para identificar o prato
|valor|float|✅|o custo do prato



**códigos de status**

`201` criado com sucesso
`400` validação falhou

---

`DELETE` /prato/{id} 

Apaga o prato com o `id` informado.

**códigos de status**

`204` apagado com sucesso
`404` id não encontrado

---

`PUT` /prato/{id} 

Altera a catagoria com o `id` informado.

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|nome|string|✅|Novo nome curto para identificar o prato
|valor|float|✅|o custo do prato

**códigos de status**

`200` sucesso
`404` id não encontrado
`400` validação falhou

---

**Schema**

```js
{
    "id": 1,
    "nome": "fettuccine",
    "valor": 32,00
}

```

### Usuarios


`GET` /usuario/{id}

Retorna os detalhes de um prato com o `id` informado.

**códigos de status**

`200` sucesso
`404` id não encontrado

---
`POST` /menu

Cadastrar um novo prato.

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|nome|string|✅|Um nome curto para identificar o prato
|rg|string|✅|Número do documento



**códigos de status**

`201` criado com sucesso
`400` validação falhou

---

`DELETE` /usuario/{id} 

Apaga o usuario com o `id` informado.

**códigos de status**

`204` apagado com sucesso
`404` id não encontrado

---

`PUT` /usuario/{id} 

Altera os dados do usuario com o `id` informado.

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|nome|string|✅|Novo nome curto para identificar o prato
|rg|string|✅|Número do documento

**códigos de status**

`200` sucesso
`404` id não encontrado
`400` validação falhou

---

**Schema**

```js
{
    "id": 1,
    "nome": "Alfredo",
    "rg": "123456789"
}

```
