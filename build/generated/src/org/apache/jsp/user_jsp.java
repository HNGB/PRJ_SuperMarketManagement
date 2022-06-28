package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import sample.product.ProductDTO;
import sample.user.UserDTO;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("US")) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        
      out.write("\n");
      out.write("        <h1> Welcome User: ");
      out.print( loginUser.getFullName());
      out.write("</h1>\n");
      out.write("        <h1 style=\"text-align:center\">Supermarket</h1>\n");
      out.write("\n");
      out.write("        <a href=\"MainController?action=Search&search=\">Home</a></BR>\n");
      out.write("\n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            Search<input type=\"text\" name=\"search\" required=\"\" value=\"");
      out.print(search);
      out.write("\"/>\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Search\"/>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        
      out.write("\n");
      out.write("        <h1>");
      out.print( message);
      out.write("</h1>\n");
      out.write("\n");
      out.write("        ");

            List<ProductDTO> listProduct = (List<ProductDTO>) request.getAttribute("LIST_PRODUCT");
            if (listProduct != null) {
                if (listProduct.size() > 0) {
        
      out.write("  \n");
      out.write("        <form action=\"MainController\">\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"View\"/>\n");
      out.write("        </form></BR>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>No</th>\n");
      out.write("                    <th>Product ID</th>\n");
      out.write("                    <th>Product Name</th>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Price ($)</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Category ID</th>\n");
      out.write("                    <th>Import Date</th>\n");
      out.write("                    <th>Using Date</th>\n");
      out.write("                    <th>Quantity To Cart</th>\n");
      out.write("                    <th>Add To Cart</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    int count = 1;
                    for (ProductDTO product : listProduct) {
                
      out.write("\n");
      out.write("            <form action=\"MainController\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( count++);
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"text-align: center\" type=\"text\" name=\"productID\" value=\"");
      out.print( product.getProductID());
      out.write("\" readonly=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"text-align: center\" type=\"text\" name=\"productName\" value=\"");
      out.print( product.getProductName());
      out.write("\" readonly=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <img src=\"");
      out.print( product.getImage());
      out.write("\" style=\"width:60px;height:60px;\" readonly=\"\"/></td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"text-align: center\" type=\"number\" name=\"price\" value=\"");
      out.print( product.getPrice());
      out.write("\" readonly=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"text-align: center\" type=\"number\" name=\"quantity\" value=\"");
      out.print( product.getQuantity());
      out.write("\" readonly=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"text-align: center\" type=\"text\" name=\"categoryID\" value=\"");
      out.print( product.getCategoryID());
      out.write("\" readonly=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"text-align: center\" type=\"date\" name=\"importDate\" value=\"");
      out.print( product.getImportDate());
      out.write("\" readonly=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"text-align: center\" type=\"date\" name=\"usingDate\" value=\"");
      out.print( product.getUsingDate());
      out.write("\" readonly=\"\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input style=\"text-align: center\" type=\"number\" min=\"1\" name=\"quantity_add\" value=\"1\"/>\n");
      out.write("                    </td>\n");
      out.write("                    <td style=\"text-align: center\">\n");
      out.write("                        <input  type=\"submit\" name=\"action\" value=\"Add\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("            </form>                         \n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    ");

        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }
    
      out.write("\n");
      out.write("    ");
      out.print( error);
      out.write("\n");
      out.write("    ");
                }
        }
    
      out.write("\n");
      out.write("    \n");
      out.write("    <form action=\"MainController\" method=\"POST\" >\n");
      out.write("        <input type=\"submit\" name=\"action\" value=\"Logout\"/>\n");
      out.write("    </form>\n");
      out.write("</body>\n");
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
