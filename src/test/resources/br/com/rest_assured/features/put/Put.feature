#language:pt

@PUT
	Funcionalidade: Validar a alteração de informações na API por usuário
 		Como um usuário
 		Eu quero validar a alteração de dados na API
 		
 	Contexto:
	 Dado que todoas as massas estão iniciadas 
	 E que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token

  @PUTteste1 @Validado
  Cenário: Deve alterar conta com sucesso
   Quando altero uma conta pelo nome "conta Exemplo alterada" através do id "469575" na rota "/contas"
   Então é retornado para a alteração de dados o status code "200"
