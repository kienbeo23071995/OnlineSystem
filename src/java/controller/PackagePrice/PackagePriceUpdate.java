/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.PackagePrice;

import controller.PricePackage.*;
import dao.DimensionDAO;
import dao.PricePackageDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dimension;
import model.PricePackage;

/**
 *
 * @author Dell
 */
@WebServlet(name = "PricePackageUpdate", urlPatterns = {"/PricePackageUpdateInSubject"})
public class PackagePriceUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PricePackageUpdate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PricePackageUpdate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        int priceId = Integer.parseInt(request.getParameter("priceId"));
//        Dimension dim = new DimensionDAO().getDimensionById(dimId);
        PricePackage pricePack = new PricePackageDAO().getPricePackageById(priceId);
//        request.setAttribute("dim", dim);
        request.setAttribute("pricePack", pricePack);
        request.getRequestDispatcher("EditPricePackage.jsp").forward(request, response);
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
//                int dimId = Integer.parseInt(request.getParameter("dimId"));
//        String type = request.getParameter("typeId");
//        String name = request.getParameter("name");
//        String description = request.getParameter("description");
//        
//        Dimension dim = new Dimension(dimId, type, name, description);
//        new DimensionDAO().updateDimension(dim);
//        response.sendRedirect("subject-detail?id="+dimId);
        int subjectId =  (int) request.getSession().getAttribute("subId");
        int priceId = Integer.parseInt(request.getParameter("priceId"));
        String name = request.getParameter("name");
        int acess = Integer.parseInt(request.getParameter("acessDuration"));
        float price = Float.parseFloat(request.getParameter("price"));
        float salePrice = Float.parseFloat(request.getParameter("salePrice"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String description = request.getParameter("description");
        ArrayList<Dimension> listDimension = new DimensionDAO().getAllDimensionBySubjectId(subjectId);
        ArrayList<PricePackage> listPricePackage = new PricePackageDAO().getAllPricePackageBuSubjectId(subjectId);
        request.setAttribute("listDimension", listDimension);
        request.setAttribute("id", subjectId);
        request.setAttribute("listPricePackage", listPricePackage);
        PricePackage pricePack = new PricePackageDAO().updatePricePackage(priceId, name, acess, price, salePrice, status, description);
        response.sendRedirect("DispatchServlet?btAction=EditSubject&id="+subjectId);
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
