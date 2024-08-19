<%@ page import="java.text.DecimalFormat" %>
<%@ page import="cadastroee.model.Produto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%-- 
    Created on : 2024 Aug 17, 18:33:08
    Author     : Tiago J P Furtado
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Listagem de Produtos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style2.css" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <div class="header-section text-center">
                <h1>Listagem de Produtos</h1>
            </div>

            <div class="card">
                <div class="card-body">


                    <table class="table table-striped table-bordered table-responsive">
                        <thead>
                            <tr class="table-dark">
                                <th>ID</th>
                                <th>Produto</th>
                                <th>Quantidade</th>
                                <th>Preço</th>
                                <th>Ações</th>
                            </tr>
                        </thead>

                        <%
                            DecimalFormat df = new DecimalFormat("#,##0.00");
                            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");

                            if (produtos != null && !produtos.isEmpty()) {
                                for (Produto produto : produtos) {
                        %>
                        <tr>
                            <td class="text-center"><%=produto.getIdProduto()%></td>
                            <td class="text-center"><%=produto.getNome()%></td>
                            <td class="text-center"><%=produto.getQuantidade()%></td>
                            <td class="text-center">R$ <%=df.format(produto.getPrecoVenda())%></td>
                            <td class="text-end">
                                <a class="btn btn-primary btn-sm" href="ServletProdutoFC?acao=formAlterar&id=<%=produto.getIdProduto()%>">Alterar</a>
                                <a class="btn btn-danger btn-sm" href="ServletProdutoFC?acao=excluir&id=<%=produto.getIdProduto()%>">Excluir</a>
                            </td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="5">Nenhum produto encontrado.</td>
                        </tr>
                        <%
                            }
                        %>
                    </table>

                    <div class="text-end mb-3">
                        <a class="btn btn-primary" href="ServletProdutoFC?acao=formIncluir">Novo Produto</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>