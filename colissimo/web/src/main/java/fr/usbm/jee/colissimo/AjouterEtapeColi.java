package fr.usbm.jee.colissimo;

import java.io.IOException;

import fr.usbm.jee.colissimo.entities.Coli;
import fr.usbm.jee.colissimo.entities.Progress;
import fr.usbm.jee.colissimo.entities.Status;
import fr.usbm.jee.colissimo.operationBeans.ColiOperation;
import fr.usbm.jee.colissimo.operationBeans.ProgressOperation;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@WebServlet("/ajouterEtape")
public class AjouterEtapeColi extends HttpServlet {

    @EJB
    private ColiOperation coliEJB;

    @EJB
    private ProgressOperation progressEJB;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int coliId = Integer.parseInt(req.getParameter("coliId"));

        Coli coli = coliEJB.findById(coliId);

        req.setAttribute("coli", coli);
        req.getRequestDispatcher("/EditerColi.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int coliId = Integer.parseInt(req.getParameter("coliId"));
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        String location = req.getParameter("location");
        Status status = Status.valueOf(req.getParameter("status"));

        Coli coli = coliEJB.findById(coliId);
        Progress progress = progressEJB.create(latitude, longitude, location, status);
        coliEJB.updateProgress(coli, progress);

        req.setAttribute("coli", coli);
        req.getRequestDispatcher("/EditerColi.jsp").forward(req, resp);
    }
}
