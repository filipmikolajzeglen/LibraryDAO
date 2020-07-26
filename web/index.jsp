<%--
  Created by IntelliJ IDEA.
  User: Filip Żegleń
  Date: 26.07.2020
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
  <link rel="stylesheet prefetch" href="main.css">
  <link href="https://fonts.googleapis.com/css2?family=Cuprum&amp;display=swap" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Library Viewer</title>
</head>
<body>

<div class="borderStyle">
  <div class="tabHeader">
<h1>Biblioteka viewer</h1>
  </div>

  <div class="tabContent">
<form action="BookServlet" method="post">
  <div class="dataStyle">
  <input placeholder="ISBN" type="text" name="isbn" class="inputStyle">
  <br>
  <input placeholder="Tytuł" type="text" name="title" class="inputStyle">
  <br>
  <input placeholder="Opis" type="text" name="description" class="inputStyle">
    <br><br>
  <div class="choiceStyle">
  Szukaj: <input type="radio" name="option" value="search"><br>
  Dodaj: <input type="radio" name="option" value="add"><br>
  Modyfikuj: <input type="radio" name="option" value="update"><br>
  Usuń: <input type="radio" name="option" value="delete"><br>
  </div>
  <br>
  <input type="submit" value="Wyślij" class="buttonStyle">
  </div>
</form>
  </div>
</div>

<div class="foot">project by Filip Żegleń</div>

</body>
</html>