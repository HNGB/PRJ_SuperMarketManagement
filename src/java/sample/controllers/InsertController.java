/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.ProductDAO;
import sample.product.ProductDTO;
import sample.product.ProductError;

/**
 *
 * @author lehad
 */
@WebServlet(name = "InsertController", urlPatterns = {"/InsertController"})
public class InsertController extends HttpServlet {

    private static final String ERROR = "insert.jsp";
    private static final String SUCCESS = "insert.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String productID = request.getParameter("productID");
            String productName = request.getParameter("productName");
            String image = request.getParameter("image");
            Float price = Float.parseFloat(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String categoryID = request.getParameter("categoryID");
            Date importDate = Date.valueOf(request.getParameter("importDate"));
            Date usingDate = Date.valueOf(request.getParameter("usingDate"));
            
            ProductDAO dao = new ProductDAO();
            ProductError productError = new ProductError();
            boolean checkValidation= true;
            boolean checkDuplicate= dao.checkDuplicate(productID);
            
            if(checkDuplicate){
                checkValidation= false;
                productError.setProductIDError("Duplicate!!");
            }
            if(productID.length()<1 || productID.length()>20){
                checkValidation= false; 
                productError.setProductIDError("ProductID must be [1,20]");
            }
            if(productName.length()<2 || productName.length()>30){
                checkValidation= false; 
                productError.setProductNameError("ProductName must be [2,30]");
            }
            if (categoryID.length() < 2 || categoryID.length() > 3) {
                checkValidation = false;
                productError.setCategoryIDError("CategoryID must be in [2,3]");
            }
            if(checkValidation){
                ProductDTO product = new ProductDTO(productID, productName, image, price , quantity, categoryID, importDate, usingDate);
                boolean checkInsert = dao.insert(product);
                if(checkInsert){
                    request.setAttribute("MESSAGE","Insert Successfully");
                    url= SUCCESS;
                }
            }else{
                request.setAttribute("PRODUCT_ERROR", productError);
            }
            
        } catch (Exception e) {
            log("Error at CreateController: "+ e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
