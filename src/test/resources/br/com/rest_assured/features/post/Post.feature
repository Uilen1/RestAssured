#language:pt

@POST
	Funcionalidade: Validar a inserção de informações na API por usuário
 		Como um usuário
 		Eu quero validar a inserção de dados na API

  @POSTteste1 @Validado
  Cenário: Deve incluir conta com sucesso
   Dado que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token
   Quando insiro uma conta com nome "conta Exemplo2" na rota "/contas"
   Então é retornado para a inserção de dados o status code "201"
   
   @POSTteste2 
  Cenário: Não deve incluir conta com nome repetido
   Dado que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token
   Quando insiro uma conta com nome "conta Exemplo2" na rota "/contas"
   Então é retornado para a inserção de dados já existentes o status code "400" com a mensagem de erro "Já existe uma conta com esse nome!"
