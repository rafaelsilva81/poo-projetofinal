## Projeto Final - Disciplina POO 2020.2
#### Universidade Federal do Ceará - Campus Quixadá 
#### Curso de Ciências da Computação

<img src="https://i.imgur.com/1kJzWfR.png" alt="Carfix Logo" width="400"/>

Sistema de Controle de estoque para oficinas mecânicas e outros nichos.
Desenvolvido para a disciplina de Programação Orientada a Objetos da Universidade Federal do Ceará Campus Quixada. (Semestre 2020.2)

### Desenvolvido por : 
- Rafael Galdino da Silva ([@rafaelsilva81](https://github.com/rafaelsilva81 "@rafaelsilva81"))
- Elias Dias de Araújo ([@Elias_Dias](https://github.com/Elias-Dias-De-Araujo "@Elias_Dias"))

## INSTRUÇÕES (Comandos) : 

<!--more-->

### Área de Login
- loginAdmin (usuario) (senha) : Para logar como um administrador/gerente
- loginWorker (usuario) (senha) : Para logar como um funcionário
- exit : Encerra a aplicação

### Área principal
- addProduct (nome_do_produto) (quantidade) (condição) (categoria) : Adiciona um novo produto ao estoque
- removeProduct (id) : Remove o produto do estoque
- editProduct (id) : Abre o menu de edição do produto especificado
- show : Exibe todo o estoque
- addWorker (usuario) (senha) : Cria um novo login de funcionário com usuário e senha especificados
- showWorkers : Lista todos os funcionários cadastrados
- removeWorker (usuario) (senha) : Remove o funcionário específicado, a senha é requerida para que haja maior segurança 
- logoff : Finaliza a sessão atual e retorna para a Área de Login
- exit : Encerra a aplicação

### Menu de edição
#### Este menu é acessado após utilizar a funcionalidade de editar um produto. 
#### Os comandos dessa área são dados no seguinte formato : (campo_a_ser_editado) (novo_valor). Também é possível utilizar o comando "parar" para finalizar a edição e retornar para a Área principal
#### Exemplo de Uso: 
` $editProduct 2 `
` PAINEL DE EDIÇÃO DE PRODUTO : `
`Produto Editado : Carburador`

`:.Digite o campo que deseja alterar e o novo valor desse campo.:`
`:.Ou digite "parar" para retornar ao painel principal.:`

`$quantidade 50`

`Alterado com sucesso!`




