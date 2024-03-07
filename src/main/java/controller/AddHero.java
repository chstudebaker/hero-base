package controller;

import com.example.model.Hero;
import com.example.service.HeroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addHero")
public class AddHeroController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the add hero form page
        request.getRequestDispatcher("/WEB-INF/addHero.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve hero details from the form
        String codeName = request.getParameter("codeName");
        String powers = request.getParameter("powers");
        String bio = request.getParameter("bio");
        String alignment = request.getParameter("alignment");
        String realName = request.getParameter("realName");

        // Create a new Hero object
        Hero newHero = new Hero(codeName, powers, bio, alignment, realName);

        // Add the new hero to the database or perform other business logic
        heroService.addHero(newHero);

        // Redirect to a success page or display a success message
        response.sendRedirect(request.getContextPath() + "results.jsp");
    }
}
