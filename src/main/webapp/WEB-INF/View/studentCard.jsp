<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/08/2020
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fiche Élèves</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css" />
</head>
<p:page>
    <jsp:body>
        <body>
            <!-- student card -->
            <div class="flex bg-blanc shadow-2xl rounded-lg mx-4 md:mx-auto my-56 w-3/5 border border-gris border-1 pr-4 pl-4">
                <div class="flex items-start px-4 py-6 w-full ml-2">
                    <div class="w-full md:w-1/2 bg-red-200 p-1 h-full">
                        <div class="flex flex-wrap w-full">
                            <div class="md:w-1/2 w-full">
                                <p class="font-semibold text-violet">Nom :</p><br>
                                <p class="text-rose">${Name}</p>
                            </div>
                            <div class="w-1/2">
                                <p class="font-semibold text-violet">Prénom :</p><br>
                                <p class="text-rose">${firstName}</p>
                            </div>
                        </div>
                        <br>
                        <div class="my-3">
                            <p class="font-semibold text-violet">Date de naissance :</p><br>
                            <p class="text-rose">${birthDate}</p>
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet">Adresse du responsable :</p><br>
                            <p class="text-rose">${address}</p>
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet">Adresse mail du responsable :</p><br>
                            <p class="text-rose">${mail}</p>
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet">Téléphone du responsable :</p><br>
                            <p class="text-rose">${phone}</p>
                        </div>
                    </div>
                    <div class="flex flex-col items-center justify-center md:w-1/2 h-full p-1 hidden md:flex">
                        <div class="w-64">
                        <img src="${pageContext.request.contextPath}/ressources/images/user.png" alt="user logo">
                            <br>
                        <button class="bg-violet text-blanc font-bold w-full p-1 rounded-lg  shadow-lg">Modifier</button>
                        </div>
                    </div>
                </div>
            </div>
        </body>
    </jsp:body>
</p:page>
