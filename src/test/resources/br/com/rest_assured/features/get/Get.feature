#language:pt

@GET
	Funcionalidade: Validar retorno da API para uma requisição de usuário
 		Como um usuário
 		Eu quero validar o retorno da API para alguma requisição

  @GETteste1 @Validado
  Cenário: Não deve acessar sem token
   Dado que acesso a rota "/contas"
   Então é retornado para a requisição o status code "401"

  @GETteste2 @Validado
  Cenário: Deve verificar o saldo da conta
   Dado que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token
   Quando verifico o saldo de "500.00" na conta com id "469575" na rota "/saldo"
   Então é retornado o status code "200"   