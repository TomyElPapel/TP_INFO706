<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ page import="fr.usbm.jee.colissimo.entities.Progress" %>
<%@ page import="fr.usbm.jee.colissimo.entities.Coli" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Enregistrer colis</title>
</head>

<%
    List<Coli> colis = (List<Coli>) request.getAttribute("colis");
%>

<body>
    <div>
        <h2>Creation coli</h2>
        <form action="enregistrer" method="post">

            <label for="weight">weight:</label>
            <input type="number" id="weight" name="weight" value="" required/>

            <label for="value">value:</label>
            <input type="number" id="value" name="value" value="" required/>
            
            <label for="origin">origin:</label>
            <input type="text" id="origin" name="origin" value="" required/>
            
            <label for="destination">destination:</label>
            <input type="text" id="destination" name="destination" value="" required/>

            <label for="latitude">latitude:</label>
            <input type="text" id="latitude" name="latitude" value="" required/>

            <label for="longitude">longitude:</label>
            <input type="text" id="longitude" name="longitude" value="" required/>

            <button type="submit">Submit</button>
        </form>
    </div>
    <div>
        <h2> liste colis : </h2>
        <% for (Coli coli : colis) { %>
            <form action="afficher?coliId=<%= coli.getId() %>" method="post">
                <button type="submit">
                    <div>
                        <p><%= coli.getId() %></p>
                        <p><%= coli.getOrigin() %></p>
                        <p><%= coli.getDestination() %></p>
                    </div>
                </button>
            </form>
        <% } %>
    </div>
</body>
