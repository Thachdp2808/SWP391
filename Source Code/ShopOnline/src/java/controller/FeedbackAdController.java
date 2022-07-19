package controller;

import dal.FeedbackDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MyFeedback;

/**
 *
 * @author anhvo
 */
public class FeedbackAdController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("act");
        switch (action) {
            case "favo":
                favo(request, response);
                view(request, response);
                break;
            case "status":
                status(request, response);
                view(request, response);
                break;
            case "del":
                delete(request, response);
                view(request, response);
                break;
            default:
                view(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    protected void view(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");
        FeedbackDAO db = new FeedbackDAO();
        
        if (page == null || page.isEmpty()) {
            page = "" + 1;
        }
        request.setAttribute("PAGE", page);
        int pageNumber = Integer.parseInt(page);

        int countPage = db.countPage();
        request.setAttribute("countPage", countPage);
        
        int task = db.CountTask();
        request.setAttribute("AllTask", task);
        
        int work = db.TaskWork(1);
        request.setAttribute("Done", work);
        
        int favorite = db.Favorite(1);
        request.setAttribute("Favorite", favorite);
        
        List<MyFeedback> list = db.ListAllFeedback(pageNumber);   
        request.setAttribute("fblist", list);
        
        request.getRequestDispatcher("FeedbackList.jsp").forward(request, response);
    }
    
    protected void favo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("fbID");
        String favo = request.getParameter("fv");
        
        FeedbackDAO db = new FeedbackDAO();
        
        db.feedbackFavor(Integer.parseInt(favo), Integer.parseInt(id));
    }
    
    protected void status(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("fbID");
        String status = request.getParameter("status");
        
        FeedbackDAO db = new FeedbackDAO();
        
        db.updateFbStatus(Integer.parseInt(status), Integer.parseInt(id));
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("fbID");
        FeedbackDAO db = new FeedbackDAO();
        
        db.deleFeedbackByID(Integer.parseInt(id));
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
