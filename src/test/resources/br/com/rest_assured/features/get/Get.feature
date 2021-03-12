#language:pt

@GET
	Funcionalidade: Validar retorno da API para uma requisição de usuário
 		Como um usuário
 		Eu quero validar o retorno da API para alguma requisição

  @GETteste1 @Validado
  Cenário: Não deve acessar sem token
   Dado que acesso a rota "/contas"
   Então é retornado para a requisição o status code "401"
