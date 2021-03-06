<%--
  Created by IntelliJ IDEA.
  User: xxtyo
  Date: 11/1/2020
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Deck</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h1>Deck Detail</h1>
    <p>
        <a href="/decks" class="btn btn-primary">Back To Deck List</a>
    </p>
    <table cellpadding="10px">
        <tr>
            <td>Deck ID:</td>
            <td>${deck.getDeckId()}</td>
        </tr>
        <tr>
            <td>Deck Name:</td>
            <td>${deck.getDeckName()}</td>
        </tr>
        <tr>
            <td>Deck Price:</td>
            <td>${deck.getDeckPrice()}</td>
        </tr>
        <tr>
            <td>Deck Type:</td>
            <td>${deck.getTypeId().typeName}</td>
        </tr>
        <tr>
            <td>Deck Brand:</td>
            <td>${deck.getBrandId().brandName}</td>
        <tr>
            <td>Deck Price:</td>
            <td>${deck.getDeckSize()}</td>
        </tr>
        <tr>
            <td>Deck Description:</td>
            <td>${deck.getDeckDescription()}</td>
        </tr>
        <tr>
            <td>Deck Image:</td>
            <td><img src="${deck.getDeckImage()}" alt="Image" width="100px" height="100px"></td>
        </tr>
    </table>
</center>
</body>
<style>
    body {
        font-family: Arial;
        font-size: larger;
    }

    tr td:nth-child(1) {
        font-weight: bold;
        font-size: large;
    }

    tr th:nth-child(1) {
        font-size: 50px;
    }
</style>
</html>
