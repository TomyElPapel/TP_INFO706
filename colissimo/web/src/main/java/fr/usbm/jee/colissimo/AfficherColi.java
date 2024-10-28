package fr.usbm.jee.colissimo;

import java.io.IOException;

import fr.usbm.jee.colissimo.entities.Coli;
import fr.usbm.jee.colissimo.operationBeans.ColiOperation;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/afficher")
public class AfficherColi extends HttpServlet {
    
    @EJB
    private ColiOperation coliEJB;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int coliId = Integer.parseInt(req.getParameter("coliId"));

        Coli coli = coliEJB.findById(coliId);

        req.setAttribute("coli", coli);
        req.getRequestDispatcher("/AfficherColi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
