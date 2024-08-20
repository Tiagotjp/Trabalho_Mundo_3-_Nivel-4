# Missão Prática | Nível 4 | Mundo 3

## RPG0017  - Vamos integrar sistemas

## Implementação de sistema cadastral com interface Web, baseado nas tecnologias de Servlets, JPA e JEE

### Objetivos da prática

* Implementar persistência com base em JPA.
* Implementar regras de negócio na plataforma JEE, através de EJBs.
* Implementar sistema cadastral Web com   base em Servlets e JSPs.
* Utilizar a biblioteca Bootstrap para melhoria do design.
* No final do exercício, o aluno terá criado todos os elementos necessários
  para exibição e entrada de dados na plataforma Java Web, tornando-se
  capacitado para lidar com contextos reais de aplicação.

## Materiais necessários para a prática
* SQL Server, com o banco de dados gerado em prática anterior (loja).
* JDK e IDE NetBeans.
* Navegador para Internet, como o Chrome.
* Banco de dados SQL Server com o Management Studio.
### Equipamentos:

- Computador com acesso à Internet.

- JDK e IDE NetBeans.

- Banco de dados SQL Server.

- Navegador de Internet instalado no computador.

## Desenvolvimento da prática

## 👉 1º Procedimento | Camadas de Persistência e Controle

1 - Configurar a conexão com SQL Server via NetBeans e o pool de conexões no GlassFish Server 6.2.1:

a - Na aba de Serviços, divisão Banco de Dados, clique com o botão
direito em Drivers e escolha Novo Driver.

![000011111](https://github.com/user-attachments/assets/b3d7d97c-47ba-4b4a-9f1b-ed8c6ea6628c)

 b - Na janela que se abrirá, clicar em Add (Adicionar), selecionar o
    arquivo mssql-jdbc-12.2.0.jre8.jar, que é parte do arquivo zip encontrado
    no endereço seguinte, e finalizar com Ok.
    
https://learn.microsoft.com/pt-br/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16

 c - O reconhecimento será automático, e podemos definir uma conexão
    com o clique do botão direito sobre o driver e escolha de Conectar Utilizando.

![000022222](https://github.com/user-attachments/assets/a4c8a726-0f61-4c5c-b8ab-6207c60d4666)

d - Para os campos database, user e password, utilizar o valor loja, de
    acordo com os elementos criados em exercício anterior sobre a criação do
    banco de dados de exemplo, marcando também a opção Lembrar Senha.

e - Para o campo JDBC URL deve ser utilizada a seguinte expressão:

jdbc:sqlserver://localhost:1433;databaseName=loja;encrypt=true;trustServerCertificate=true;

f - Clicar em Testar Conexão e, estando tudo certo, Finalizar.

g - Na divisão Servidores, verificar se o GlassFish 6.2.1 (ou posterior)
    está instalado, e caso não esteja, adicionar o servidor, via clique com o
    botão direito e escolha da opção Add Server, efetuando o download a partir
    da própria janela que se abrirá.

![00000003333333](https://github.com/user-attachments/assets/ab8fa625-cadd-4304-b562-3fc95cd8de39)

h - Copiar o arquivo mssql-jdbc-12.2.0.jre8.jar para o subdiretório lib, a partir do diretório de base do GlassFish.

i - Iniciar o servidor GlassFish a partir do NetBeans.

j - Através da linha de comando, executar o comando asadmin, no diretório bin do GlassFish.

k - No prompt do asadmin, executar o comando apresentado a seguir:

create-jdbc-connection-pool --datasourceclassname com.microsoft.sqlserver.jdbc.SQLServerDataSource --restype javax.sql.DataSource --property driverClass=com.microsoft.sqlserver.jdbc.SQLServerDriver:portNumber=1433:password=loja:user=loja:serverName=localhost:databaseName=Loja:trustServerCertificate=true:URL="jdbc\\:sqlserver\\://localhost\\:1433\\;databaseName\\=loja\\;encrypt\\=true\\;trustServerCertificate\\=true\\;"
 
i - Será solicitado o identificador do pool, que será SQLServerPool.

m - Testar o pool de conexões através do comando apresentado a seguir:

  ping-connection-pool SQLServerPool

n - Obtendo sucesso na operação, criar o registro JNDI, ainda no asadmin, através do comando apresentado a seguir:

  create-jdbc-resource --connectionpoolid SQLServerPool jdbc/loja

o - Atualizar o servidor no ambiente do NetBeans e verificar se tudo foi
    gerado corretamente:

![0000004444444](https://github.com/user-attachments/assets/766217dc-3c87-4470-9128-d6032aca012b)

2 - Criar o aplicativo corporativo no NetBeans:

a - Criar um projeto do tipo Ant..Java Enterprise..Enterprise Application.

![000000555555555](https://github.com/user-attachments/assets/47883b0f-b8be-4e41-b01c-3a10f24f694d)

b - Adotar o nome CadastroEE, com escolha do servidor GlassFish, além de plataforma Jakarta JEE 8.

c - Serão gerados três projetos, onde o principal encapsula o arquivo EAR, tendo os outros dois, CadastroEE-ejb e CadastroEE-war, como projetos dependentes, relacionados aos elementos JPA, JEE e Web.

![00000066666666666](https://github.com/user-attachments/assets/8b93e998-924f-4cd1-b3cc-82be491e1a69)

3 - Definir as camadas de persistência e controle no projeto CadastroEE-ejb.

a - Criar as entidades JPA através de New Entity Classes from Database.

b - Selecionar jdbc/loja como Data Source, e selecionar todas as tabelas.

![0000000077777777777777](https://github.com/user-attachments/assets/fcba40b3-8d82-408f-97c0-2ab20feba4c6)

c - No passo seguinte, definir o pacote como cadastroee.model, além de marcar a opção para criação do arquivo persistence.xml.

d - Em seguida, adicionar os componentes EJB ao projeto, através da opção New Session Beans for Entity Classes.

e - Selecionar todas as entidades, marcar a geração da interface local, além de definir o nome do pacote como cadatroee.controller.

f - Serão gerados todos os Session Beans, com o sufixo Facade, bem como as interfaces, com o sufixo FacadeLocal.

4 - Efetuar pequenos acertos no projeto, para uso do Jakarta:

a - Adicionar a biblioteca Jakarta EE 8 API ao projeto CadatroEE-ejb.

b - Criados os componentes e ajustadas as bibliotecas, o projeto deverá ficar como apresentado a seguir:

![0000000088888888888](https://github.com/user-attachments/assets/8c95ab17-5434-4e00-bd67-a034042224c8)

c - Modificar TODAS as importações de pacotes javax para jakarta, em todos os arquivos do projeto CadastroEE-ejb.

![0000000999999999999](https://github.com/user-attachments/assets/6631a396-4414-409f-9d72-538748d7e813)

d - Na entidade Produto, mudar o tipo do atributo precoVenda para Float no lugar de BigDecimal.

e - Modificar o arquivo persistence.xml para o que é apresentado a seguir:

![image](https://github.com/user-attachments/assets/0efa5478-981d-4ba2-b474-885192da13e4)

5 - Criar um Servlet de teste no projeto CadastroEE-war

a - Utilizar o clique do botão direito e escolha da opção New..Servlet

b - Definir o nome do Servlet como ServletProduto, e nome do pacote como cadastroee.servlets

c - Marcar opção Add information to deployment descriptor, algo que ainda é necessário quando o GlassFish 6 é utilizado

d - Adicionar, no código do Servlet, a referência para a interface do EJB
    @EJB
    ProdutoFacadeLocal facade;

e - Modificar a resposta do Servlet, utilizando o facade para recuperar os dados e apresentá-los na forma de lista HTML
    
6 - Efetuar novos acertos no projeto, para uso do Jakarta:

a - Adicionar a biblioteca Jakarta EE Web 8 API ao projeto CadatroEE-war

b - Criado o Servlet e ajustadas as bibliotecas, o projeto deverá ficar como apresentado a seguir:

![0000000100000000000111](https://github.com/user-attachments/assets/7dab8fa9-e7a9-4b66-a11f-3cbdd2adef52)

c - Modificar TODAS as importações de pacotes javax para jakarta, em todos os arquivos do projeto CadastroEE-war

d - Modificar o arquivo web.xml para o que é apresentado a seguir:

![image](https://github.com/user-attachments/assets/e9733927-9fc1-4021-8d3c-680091edc6f2)

7 - Executar o projeto:

a - A execução deve ser efetuar com o uso de Run ou Deploy no projeto
    principal (CadastroEE), simbolizado por um triângulo

b - Acessar o endereço a seguir, para testar o Servlethttp://
    localhost:8080/CadastroEE-war/ServletProduto

c - Tendo alimentado a base via SQL Server Management Studio, ou pela
    aba de serviços do NetBeans, deve ser obtida uma saída como a
    seguinte:

![00000001000000000002222](https://github.com/user-attachments/assets/d7d41e7a-25b4-4d38-a156-fac95c4fd89b)


## 👉 2º Procedimento | Interface Cadastral com Servlet e JSPs

1 - Criar um Servlet com o nome ServletProdutoFC, no projeto CadastroEE-war:
a - Utilizar o padrão Front Controller

b - Adicionar uma referência para ProdutoFacadeLocal, utilizando o nome
    facade para o atributo

c - Apagar o conteúdo interno do método processRequest, e efetuar nele
    as modificações seguintes

d - Capturar o parâmetro acao a partir do request, o qual poderá assumir
    os valores listar, incluir, alterar, excluir, formIncluir e formAlterar

e - Definir a variável destino, contendo o nome do JSP de apresentação,
    que terá os valores ProdutoDados.jsp, para acao valendo formAlterar
    ou formIncluir, ou ProdutoLista.jsp, para as demais opções

f - Para o valor listar, adicionar a listagem de produtos como atributo da
    requisição (request), com a consulta efetuada via facade

g - Para o valor formAlterar, capturar o id fornecido como parâmetro do
    request, consultar a entidade via facade, e adicioná-la como atributo
    da requisição (request)

h - Para o valor excluir, capturar o id fornecido como parâmetro do
    request, remover a entidade através do facade, e adicionar a listagem
    de produtos como atributo da requisição (request)

i - Para o valor alterar, capturar o id fornecido como parâmetro do
    request, consultar a entidade através do facade, preencher os demais
    campos com os valores fornecidos no request, alterar os dados via
    facade e adicionar a listagem de produtos como atributo da
    requisição (request)

j - Para o valor incluir, instanciar uma entidade do tipo Produto,
    preencher os campos com os valores fornecidos no request, inserir via
    facade e adicionar a listagem de produtos como atributo da
    requisição (request)

k - Ao final redirecionar para destino via RequestDispatcher, obtido a
    partir do objeto request

2 - Criar a página de consulta, com o nome ProdutoLista.jsp

a - Incluir um link para ServletProdutoFC, com acao formIncluir, voltado
    para a abertura do formulário de inclusão.

b - Definir uma tabela para apresentação dos dados.

c - Recuperar a lista de produtos enviada pelo Servlet.

d - Para cada elemento da lista, apresentar id, nome, quantidade e preço
    como células da tabela.

e - Criar, também, de forma dinâmica, links para alteração e exclusão,
    com a chamada para ServletProdutoFC, passando as ações corretas e
    o id do elemento corrente.

f - Organizar o código para obter uma página como a seguinte.


![ffffffffffff](https://github.com/user-attachments/assets/843d2f24-326f-4a29-8d84-2c2555bf28b9)

3 - Criar a página de cadastro, com o nome ProdutoDados.jsp

a - Definir um formulário com envio para ServletProdutoFC, modo post.

b - Recuperar a entidade enviada pelo Servlet.

c - Definir a variável acao, com valor incluir, para entidade nula, ou
    alterar, quando a entidade é fornecida.

d - Incluir um campo do tipo hidden, para envio do valor de acao.

e - Incluir um campo do tipo hidden, para envio do id, apenas quando o
    valor de acao for alterar.

f - Incluir os campos para nome, quantidade e preço de venda,
    preenchendo os dados quando a entidade é fornecida.

g - Concluir o formulário com um botão de envio, com o texto adequado
    para as situações de inclusão ou alteração de dados .

f - Organizar o código para obter uma página como a seguinte.

![ggggggggggggggg](https://github.com/user-attachments/assets/70fbdddb-1738-454a-b398-c7fc2975cf47)

4 - Testar as funcionalidades do sistema:

a - Listar os produtos com a chamada para o endereço seguinte: http://
    localhost:8080/CadastroEE-war/ServletProdutoFC?acao=listar

b - Efetuar uma inclusão a partir do link da tela de listagem

c - Efetuar uma alteração a partir do link dinâmico da listagem

d - Efetuar uma exclusão a partir do link dinâmico da listagem


## 👉 3º Procedimento | Melhorando o Design da Interface


1 - Incluir as bibliotecas do framework Bootstrap nos arquivos
    ProdutoLista.jsp e ProdutoDados.jsp
    
a - Visitar o site do BootStrap, no endereço https://getbootstrap.com/

b - Rolar para baixo até encontrar a inclusão via CDN

![ppppppppppppppp](https://github.com/user-attachments/assets/42d5e3bb-f2ac-49e2-b443-3da0be45a398)

c - Clicar no botão para cópia do link CSS e colar na divisão head de
    cada uma das páginas JSP.

d - Clicar no botão para cópia do link para a biblioteca Java Script e colar
    na divisão head de cada uma das páginas JSP

2 - Modificar as características de ProdutoLista.jsp

a - Adicionar a classe container ao body.

b - Adicionar as classes btn, btn-primary e m-2 no link de inclusão.

c - Adicionar as classes table e table-striped na tabela.

d - Adicionar a classe table-dark ao thead.

e - Adicionar as classes btn, btn-primary e btn-sm no link de alteração.

f - Adicionar as classes btn, btn-danger e btn-sm no link de exclusão.

g - Ajustar as características para obter o design apresentado a seguir.

![hhhhhhhhhhhhhhh](https://github.com/user-attachments/assets/c6fbc40a-c0f5-45f1-9506-eb3cb618c419)

3 - Modificar as características de ProdutoDados.jsp

a - Adicionar a classe container ao body.

b - Encapsule cada par label / input em div com classe mb-3.

c - Adicionar a classe form ao formulário.

d - Adicionar a classe form-label em cada label.

e - Adicionar a classe form-control em cada input.

f - Adicionar as classes btn e btn-primary ao botão de inclusão.

g - Ajustar as características para obter o design apresentado a seguir.

![hjjjjjjjjjjjjjjjjjjjj](https://github.com/user-attachments/assets/12d50099-0e7a-480d-ad13-c0ff1a8ce67c)

<img width="527" alt="0popdos" src="https://github.com/user-attachments/assets/4ad02866-bbc8-4845-a446-9c5b34d15eac">


