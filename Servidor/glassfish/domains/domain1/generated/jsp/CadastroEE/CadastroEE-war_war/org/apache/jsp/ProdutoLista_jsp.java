package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.text.DecimalFormat;
import cadastroee.model.Produto;
import java.util.List;

public final class ProdutoLista_jsp extends org.glassfish.wasp.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Listagem de Produtos</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/style2.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"header-section text-center\">\n");
      out.write("                <h1>Listagem de Produtos</h1>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <table class=\"table table-striped table-bordered table-responsive\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr class=\"table-dark\">\n");
      out.write("                                <th>ID</th>\n");
      out.write("                                <th>Produto</th>\n");
      out.write("                                <th>Quantidade</th>\n");
      out.write("                                <th>Preço</th>\n");
      out.write("                                <th>Ações</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("\n");
      out.write("                        ");

                            DecimalFormat df = new DecimalFormat("#,##0.00");
                            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");

                            if (produtos != null && !produtos.isEmpty()) {
                                for (Produto produto : produtos) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"text-center\">");
      out.print(produto.getIdProduto());
      out.write("</td>\n");
      out.write("                            <td class=\"text-center\">");
      out.print(produto.getNome());
      out.write("</td>\n");
      out.write("                            <td class=\"text-center\">");
      out.print(produto.getQuantidade());
      out.write("</td>\n");
      out.write("                            <td class=\"text-center\">R$ ");
      out.print(df.format(produto.getPrecoVenda()));
      out.write("</td>\n");
      out.write("                            <td class=\"text-end\">\n");
      out.write("                                <a class=\"btn btn-primary btn-sm\" href=\"ServletProdutoFC?acao=formAlterar&id=");
      out.print(produto.getIdProduto());
      out.write("\">Alterar</a>\n");
      out.write("                                <a class=\"btn btn-danger btn-sm\" href=\"ServletProdutoFC?acao=excluir&id=");
      out.print(produto.getIdProduto());
      out.write("\">Excluir</a>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        } else {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"5\">Nenhum produto encontrado.</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                    <div class=\"text-end mb-3\">\n");
      out.write("                        <a class=\"btn btn-primary\" href=\"ServletProdutoFC?acao=formIncluir\">Novo Produto</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
