package fr.usbm.jee.colissimo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import fr.usbm.jee.colissimo.entities.Coli;
import fr.usbm.jee.colissimo.operationBeans.ColiOperation;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coli")
public class ColiServlet extends HttpServlet {
    
    @EJB
    private ColiOperation coliEJB;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Coli> colis = coliEJB.findAll();

        PrintWriter out = resp.getWriter();

        out.print(colis.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
