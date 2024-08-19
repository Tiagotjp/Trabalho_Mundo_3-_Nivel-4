package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import cadastroee.model.Produto;

public final class ProdutoDados_jsp extends org.glassfish.wasp.runtime.HttpJspBase
    implements org.glassfish.wasp.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("X-Powered-By", "JSP/3.0");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title >Cadastro de Produtos </title> \n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        ");

            Produto produto = (Produto) request.getAttribute("produto");
            String acao = produto != null ? "alterar" : "incluir";
        
      out.write("\n");
      out.write("\n");
      out.write("        <h1 class=\"header-section text-center\">");
      out.print(acao == "alterar" ? "Alteração" : "Cadastro");
      out.write(" de Produtos</h1>\n");
      out.write("        <a class=\"btn btn-secondary\" href=\"ServletProdutoFC?acao=listar\">Voltar</a>\n");
      out.write("        <br><br> \n");
      out.write("        <div>\n");
      out.write("            <form class=\"form\" action=\"ServletProdutoFC\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"acao\" value=\"");
      out.print(acao);
      out.write("\">\n");
      out.write("                ");
 if (produto != null) {
      out.write("\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print(produto.getIdProduto());
      out.write("\">\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                    <label class=\"form-label\" for=\"idProduto\">ID:</label>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" id=\"idProduto\" name=\"idProduto\" required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                    <label class=\"form-label\" for=\"nome\">Nome:</label>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"nome\" value=\"");
      out.print(produto != null ? produto.getNome() : "");
      out.write("\" required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                    <label class=\"form-label\" for=\"quantidade\">Quantidade:</label>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"quantidade\" value=\"");
      out.print(produto != null ? produto.getQuantidade() : "");
      out.write("\" required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                    <label class=\"form-label\" for=\"precoVenda\">Preço de Venda:</label>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"precoVenda\" value=\"");
      out.print(produto != null ? produto.getPrecoVenda() : "");
      out.write("\" required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div>\n");
      out.write("                    <input class=\"btn btn-primary\" type=\"submit\" value=\"");
      out.print(acao == "incluir" ? " Adicionar Produto" : "Alterar Produto");
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
