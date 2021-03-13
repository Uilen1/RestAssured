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
   
  @POSTteste2 @Validado
  Cenário: Não deve incluir conta com nome repetido
   Dado que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token
   Quando insiro uma conta com nome "conta Exemplo2" na rota "/contas"
   Então é retornado para a inserção de dados já existentes o status code "400" com a mensagem de erro "Já existe uma conta com esse nome!"

  @POSTteste3 @Validado
  Cenário: Deve iserir movimentação com sucesso
   Dado que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token
   Quando insiro uma movimentação pelo id "469575", descrição "descriçãoMov", envolvido "envolvidoMov",tipo "REC", data transação "01/12/2020", data pagamento "01/01/2021", valor "100" e status "true" na rota "/transacoes"
   Então é retornado para a inserção de dados o status code "201"
   
  @POSTteste4
  Cenário: Deve validar campos obrigatórios
   Dado que acesso a rota "/signin"
   E logo com email "uilen@hotmail.com" e senha "123456"
   E extraio o token
   Quando não insiro nenhum campo obrigatório na rota "/transacoes"
   Então valido todas as mensagens obrigatórias e o status code "400"   
   
   