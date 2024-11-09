<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ page import="fr.usbm.jee.colissimo.entities.Progress" %>
<%@ page import="fr.usbm.jee.colissimo.entities.Coli" %>
<%@ page import="fr.usbm.jee.colissimo.entities.Status" %>
<html>
<head>
    <title>Editer coli</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" >
</head>

<% 
    Coli coli = (Coli) request.getAttribute("coli");
    Progress progress = coli.getCurrentProgress();
%>


<body>
    <div>
        <h1> Coli : </h1>

        <p>id : <%= coli.getId() %></p>
        <p>weight : <%= coli.getWeight() %></p>
        <p>value : <%= coli.getValue() %></p>
        <p>destination : <%= coli.getDestination() %></p>
        <p>origin : <%= coli.getOrigin() %></p>

        <h2> Progress : </h2>

        <p>latitude : <%= progress.getLatitude() %></p>
        <p>longitude : <%= progress.getLongitude() %></p>
        <p>location : <%= progress.getLocation() %></p>
        <p>status : <%= progress.getStatus() %></p>


        <% if (coli.getPreviousProgress() != null && !coli.getPreviousProgress().isEmpty()) { %>
            <h3> previous progress : </h3>
            <% for (Progress p : coli.getPreviousProgress()) { %>
                <p>latitude : <%=  p.getLatitude() %></p>
                <p>longitude : <%= p.getLongitude() %></p>
                <p>location : <%= p.getLocation() %></p>
                <p>status : <%= p.getStatus() %></p>
                <br/>
            <% } %>
        <% } %>
    </div>
    <div>
        <h2>Ajouter etape</h2>
        <form action="ajouterEtape?coliId=<%= coli.getId() %>" method="post">

            <label for="location">location:</label>
            <input type="text" id="location" name="location" value="" required/>

            <label for="latitude">latitude:</label>
            <input type="text" id="latitude" name="latitude" value="" required/>
            
            <label for="longitude">longitude:</label>
            <input type="text" id="longitude" name="longitude" value="" required/>
            
            <label for="status">status:</label>
            <select name="status" id="status">
                <% for (Status status : Status.values()) {  %>
                    <option value="<%= status.name() %>">
                        <%= status.name() %>
                    </option>
                <% } %>
            </select>

            <button type="submit">Submit</button>
        </form>
    </div>
</body>