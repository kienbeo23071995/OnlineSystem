/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SliderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Slider;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "DeleteUrl", urlPatterns = {"/DeleteUrl"})
public class DeleteUrl extends HttpServlet {

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
            out.println("<title>Servlet DeleteUrl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteUrl at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        String delete = (String) request.getSession().getAttribute("delete_url");
        final int PAGE_SIZE = 3;
        int page = 1;
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int totalSearch = new SliderDAO().getTotalSlider();
        int totalPage = totalSearch / PAGE_SIZE;
        if (totalSearch % PAGE_SIZE != 0) {
            totalPage += 1;
        }

        if (delete.startsWith("delete_slider")) {
            int sliderId = Integer.parseInt(request.getParameter("id"));
            boolean status = new SliderDAO().getStatusBySliderId(sliderId);
            if (status) {
                new SliderDAO().updateSliderHide(sliderId);
            } else {
                new SliderDAO().updateSliderShow(sliderId);
            }
            List<Slider> listSliders = new SliderDAO().getAllSliders();
            List<Slider> listSlidersByPagging = new SliderDAO().getListSlidersByPagging(page, PAGE_SIZE);

            request.getSession().setAttribute("listSliders", listSliders);
            request.getSession().setAttribute("listSlidersByPagging", listSlidersByPagging);
            request.getSession().setAttribute("status", status);

            request.getRequestDispatcher("slider-list").forward(request, response);
        }
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
//        processRequest(request, response);
        String delete = (String) request.getSession().getAttribute("delete_url");

        if (delete.startsWith("delete_slider")) {
            int sliderId = Integer.parseInt(request.getParameter("id"));
            boolean status = new SliderDAO().getStatusBySliderId(sliderId);
            if (status) {
                new SliderDAO().updateSliderHide(sliderId);
            } else {
                new SliderDAO().updateSliderShow(sliderId);
            }
            request.getSession().setAttribute("status", status);

            request.getRequestDispatcher("SliderList.jsp").forward(request, response);
        }
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
