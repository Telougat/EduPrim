<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.eduprim.beans.Livre" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 27/08/2020
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emprunt de livres</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css" />
</head>
<body>
    <div class="container">
        <table class="w-full table-fixed border-2 border-rose px-8 py-2">
            <thead class="w-full">
                <tr class="flex w-full mb-4 text-violet border-b-2 border-rose">
                    <th class="p-4 w-1/3">Titre</th>
                    <th class="p-4 w-1/4">Auteur</th>
                    <!--<th class="p-4 w-1/4">Genre</th>-->
                    <!--<th class="p-4 w-1/2">Résumé</th>-->
                    <th class="p-4 w-1/4">Statut</th>
                    <th class="p-4 w-1/4">Emprunteur</th>
                </tr>
            </thead>
            <tbody class="w-full items-center justify-between overflow-y-scroll" style="height: 50vh">
                <c:forEach items="${livres}" var="livre">
                    <tr class="w-full flex mb-4 border-b-2 border-rose">
                        <td class="p-4 w-1/3">${livre.getTitre()}</td>
                        <td class="p-4 w-1/4">${livre.getAuteur()}</td>
                        <td class="p-4 w-1/4">${livre.getReference()}</td>
                        <td class="p-4 w-1/4">Personne</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <button class="bg-violet rounded text-blanc font-bold py-2 px-4" type="button">Ajouter</button>
        </div>
    </div>
</body>
</html>
