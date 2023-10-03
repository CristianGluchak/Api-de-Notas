# Controle de notas

## Regiões
O cadastro de regiões é um local geográfico, podendo ser uma cidade ou um agrupado de cidades. 
O objetivo é definir limites de gastos por região.

### Atributos
* Descrição
* Status (Ativo/Inativo)

### Requisitos funcionais
* Deve ser possível incluir uma nova região
* Deve ser possível alterar uma região
* Deve ser possível buscar uma região pelo ID
* Deve ser possível buscar uma lista de regiões
### Regras de negócio
* A descrição não pode ser nula
* A descrição deve ter ao entre 3 a 60 caracteres
* Não deve permitir cadastrar mais de uma região com a mesma descrição

## Cadastro de locais
O cadastro de locais representa o estabelecimento onde o funcionário gastou (ex: Restaurante, oficina, posto de combustível, etc.). Pode ser via cartão ou em dinheiro. 
### Atributos
* Descrição (Identificação do local)
* CNPJ
* Região

### Regras de negócio
*