package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.LessonDAO;
import dao.PostDAO;
import dao.SliderDAO;
import dao.SubjectDAO;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Lesson;
import model.Post;
import model.Slider;
import model.Subject;

/**
 *
 * @author ADMIN
 */
public class HomeController extends HttpServlet {

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
        List<Subject> listSubjects = new SubjectDAO().getAllSubjects();
        List<Slider> listSliders = new SliderDAO().getAllSlidersShow();
        List<Post> list3FirstPosts = new PostDAO().getList3FirstPosts();
        int minSliderId = new SliderDAO().getMinSliderId();
        int totalSliderShow = new SliderDAO().getTotalSliderShow();
        List<Lesson> listLessons = new LessonDAO().getAllLessons();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        request.getSession().setAttribute("listLessons", listLessons);
        request.setAttribute("totalSliderShow", totalSliderShow);
        request.setAttribute("listSubjects", listSubjects);
        request.getSession().setAttribute("listSlider", listSliders);
        request.getSession().setAttribute("minSliderId", minSliderId);
        request.getSession().setAttribute("currentYear", year);
        request.setAttribute("list3FirstPosts", list3FirstPosts);
//        request.getSession().setAttribute("ChekckLogin", "NotLogin");

        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
