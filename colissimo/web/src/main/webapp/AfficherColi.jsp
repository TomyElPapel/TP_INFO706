<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ page import="fr.usbm.jee.colissimo.entities.Progress" %>
<%@ page import="fr.usbm.jee.colissimo.entities.Coli" %>
<html>
<head>
    <title>Afficher colis</title>
</head>

<% 
    Coli coli = (Coli) request.getAttribute("coli");
    Progress progress = coli.getCurrentProgress();
%>


<body>
    <h1> Coli : </h1>

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
        <% } %>
    <% } %>
</body>