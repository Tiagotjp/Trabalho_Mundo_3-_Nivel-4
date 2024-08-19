<%@page import="cadastroee.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Created on : 2024 Aug 17, 18:33:08
    Author     : Tiago J P Furtado
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Cadastro de Produtos </title> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>
    <body class="container">
        <%
            Produto produto = (Produto) request.getAttribute("produto");
            String acao = produto != null ? "alterar" : "incluir";
        %>

        <h1 class="header-section text-center"><%=acao == "alterar" ? "Alteração" : "Cadastro"%> de Produtos</h1>
        <a class="btn btn-secondary" href="ServletProdutoFC?acao=listar">Voltar</a>
        <br><br> 
        <div>
            <form class="form" action="ServletProdutoFC" method="post">
                <input type="hidden" name="acao" value="<%=acao%>">
                <% if (produto != null) {%>
                <input type="hidden" name="id" value="<%=produto.getIdProduto()%>">
                <% }%>
                <div class="mb-3">
                    <label class="form-label" for="idProduto">ID:</label>
                    <input class="form-control" type="text" id="idProduto" name="idProduto" required>
                </div>

                <div class="mb-3">
                    <label class="form-label" for="nome">Nome:</label>
                    <input class="form-control" type="text" name="nome" value="<%=produto != null ? produto.getNome() : ""%>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label" for="quantidade">Quantidade:</label>
                    <input class="form-control" type="text" name="quantidade" value="<%=produto != null ? produto.getQuantidade() : ""%>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label" for="precoVenda">Preço de Venda:</label>
                    <input class="form-control" type="text" name="precoVenda" value="<%=produto != null ? produto.getPrecoVenda() : ""%>" required>
                </div>

                <div>
                    <input class="btn btn-primary" type="submit" value="<%=acao == "incluir" ? " Adicionar Produto" : "Alterar Produto"%>">
                </div>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
