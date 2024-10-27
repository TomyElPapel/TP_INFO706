<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head>
    <title>Enregistrer colis</title>
</head>
<body>
    <h2>Creation coli</h2>
    <form action="enregistrer" method="post">

        <!-- Name Field -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="" required/>

        <!-- Submit Button -->
        <button type="submit">Submit</button>
    </form>
</body>
