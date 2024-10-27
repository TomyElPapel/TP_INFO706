package fr.usbm.jee.colissimo;

import java.io.IOException;
import java.io.PrintWriter;

import fr.usbm.jee.colissimo.entities.Coli;
import fr.usbm.jee.colissimo.operationBeans.ColiOperation;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/EnregistrementColi.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        
        if (name == null) {
            resp.sendError(400, "name not set");
            return;
        }

        if (name == "") {
            resp.sendError(400, "name empty");
            return;
        }

        Coli coli = coliEJB.create(name);

        PrintWriter out = resp.getWriter();
        out.print(coli.toString());
    }
}
