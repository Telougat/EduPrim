<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:page>
    <jsp:body>
            <!-- student card -->
            <div class="flex bg-blanc shadow-2xl rounded-lg mx-4 md:mx-auto my-12 w-3/5 border border-gris border-1 pr-4 pl-4">
                <div class="flex items-start px-4 py-6 w-full ml-2">
                    <div class="w-full md:w-1/2 bg-red-200 p-1 h-full">
                        <div class="flex flex-wrap w-full">
                            <div class="md:w-1/2 w-full">
                                <p class="font-semibold text-violet">Nom :</p>
                                <p class="text-rose">${student.getNom()}</p>
                            </div>
                            <div class="w-1/2">
                                <p class="font-semibold text-violet">Prénom :</p>
                                <p class="text-rose">${student.getPrenom()}</p>
                            </div>
                        </div>
                        <br>
                        <div class="my-3">
                            <p class="font-semibold text-violet">Date de naissance :</p>
                            <p class="text-rose">${student.getDateDeNaissance()}</p>
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet">Adresse du responsable :</p>
                            <p class="text-rose">${student.getAdresse()}</p>
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet">Adresse mail du responsable :</p>
                            <p class="text-rose">${student.getMailParent()}</p>
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet">Téléphone du responsable :</p>
                            <p class="text-rose">${student.getTelephoneParent()}</p>
                        </div>
                    </div>
                    <div class="flex flex-col items-center justify-center md:w-1/2 h-full p-1 hidden md:flex">
                        <div class="w-64">
                        <img src="${pageContext.request.contextPath}/ressources/images/user.png" alt="user logo">
                            <br>
                               <a href="${pageContext.request.contextPath}/edition?id=${student.getID()}">
                                <button class="uppercase tracking-widest  bg-violet text-blanc font-bold w-full p-1 rounded-lg  shadow-lg">
                                    Modifier
                                </button>
                               </a>
                        </div>
                    </div>
                </div>
            </div>
    </jsp:body>
</p:page>
