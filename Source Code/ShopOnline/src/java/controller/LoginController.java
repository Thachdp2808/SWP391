package controller;

import dal.MessengerDAO;
import dal.RoleDAO;
import dal.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Message;
import model.Role;
import model.User;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserDAO userDAO = new UserDAO();
        User u = null;
        if(username.contains("@")){
             u = userDAO.getUser(username, password);
        }else{
             u = userDAO.getUserbyUserName(username, password);
        }
        
        if (u != null) { // login successfully!
            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_user = new Cookie("username", username);
                Cookie c_pass = new Cookie("password", password);
                c_user.setMaxAge(3600 * 24 * 30);
                c_pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(c_pass);
                response.addCookie(c_user);
            }
                                        

            HttpSession session = request.getSession();
            session.setAttribute("userlogged", u);
            
            RoleDAO roledb = new RoleDAO();
            ArrayList<Role> getRoleList = roledb.getRoleList();
            ArrayList<Role> listRole = roledb.getRoleUser(String.valueOf(u.getUserid()));
            
            for (Role role : getRoleList) {                                   // xác nhận Admin có roleid là bao nhiêu 
                if(role.getNameRole().equalsIgnoreCase("Admin")){
                    session.setAttribute("roleadmin", role.getId());
                    response.getWriter().print(role.getId());
                    break;
                }
            }
            for (Role role : listRole) {                                    //get hightest role user(Admin,Customer,User)desc
                session.setAttribute("role", role.getId());
                if (!role.getNameRole().equals("User")) {                   
                    break;
                }

            }
//                 response.getWriter().print(session.getAttribute("role"));
            
            response.sendRedirect("home");
            
                  
        } else { //login fail
            request.setAttribute("ms1", "Check your account!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
