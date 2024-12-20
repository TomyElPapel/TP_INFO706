package fr.usbm.jee.colissimo;

import java.io.IOException;
import java.util.List;

import fr.usbm.jee.colissimo.entities.Coli;
import fr.usbm.jee.colissimo.operationBeans.ColiOperation;
import fr.usbm.jee.colissimo.operationBeans.ProgressOperation;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/enregistrer")
public class EnregisterColi extends HttpServlet {
    
    @EJB
    private ColiOperation coliEJB;

    @EJB
    private ProgressOperation progressEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Coli> colis = coliEJB.findAll();

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/EnregistrementColi.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float weight = Float.parseFloat(req.getParameter("weight"));
        float value = Float.parseFloat(req.getParameter("value"));
        String origin = req.getParameter("origin");
        String destination = req.getParameter("destination");
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
    
        
        coliEJB.create(weight, value, origin, destination,latitude, longitude);

        List<Coli> colis = coliEJB.findAll();

        req.setAttribute("colis", colis);
        req.getRequestDispatcher("/EnregistrementColi.jsp").forward(req, resp);
    }
}
