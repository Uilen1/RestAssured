#language:pt

@DELETE
	Funcionalidade: Validar retorno da API para uma deleção de usuário
 		Como um usuário
 		Eu quero validar a exclusão de um usuário

  @DELETEteste1 @Validado
  Cenário: Não há conteúdo retornado quando deleta-se um usuário
   Dado que acesso a rota "/api/users/"
   E deleto pelo ID do usuário "2"
   Então é retornado para a deleção o status code "204"
