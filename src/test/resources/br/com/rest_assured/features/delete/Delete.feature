#language:pt

@DELETE
	Funcionalidade: Validar retorno da API para uma deleção de usuário
 		Como um usuário
 		Eu quero validar a exclusão de algum recurso do usuário

  @DELETEteste1 @Validado
  Cenário: Não deve remover conta com movimentações
   Dado que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token
   Quando removo a conta com id "469575" na rota "/contas"
   Então é retornado o status code "500"   
   
  @DELETEteste2 @Validado
  Cenário: Deve remover movimentações
   Dado que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token
   Quando removo a movimentação com id "435223" na rota "/transacoes"
   Então é retornado o status code "204"   