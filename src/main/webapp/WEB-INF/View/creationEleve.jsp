<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:pageWithoutLogo>
    <jsp:body>
        <p:prefabody>
            <jsp:body>
                <form action="" class="mb-32">
                    <h3 class="text-gris font-bold text-4xl text-center">Création d'un élève</h3>
                    <div class="mt-3 grid grid-cols-2 col-gap-3">
                        <div>
                            <p class="text-gris font-bold text-xl mb-1">Nom</p>
                            <input class="w-full border-2 border-gris rounded-lg p-2" type="text" id="nom" name="nom"/>
                        </div>
                        <div>
                            <p class="text-gris font-bold text-xl mb-1">Prénom</p>
                            <input class="w-full border-2 border-gris rounded-lg p-2" type="text" id="prenom" name="prenom"/>
                        </div>
                    </div>
                    <div class="mt-6 grid grid-cols-2 col-gap-3">
                        <div>
                            <p class="text-gris font-bold text-xl mb-1">Date de naissance</p>
                            <input class="w-full border-2 border-gris rounded-lg p-2" type="text" id="naissance" name="naissance"/>
                        </div>
                        <div>
                            <p class="text-gris font-bold text-xl mb-1 invisible">Classe</p>
                            <select name="classe" id="classe" class="w-full appearance-none border-2 border-gris rounded-lg p-2 text-gris text-opacity-50">
                                <option value="null">Classe</option> <%--TODO: foreach into class list--%>
                            </select>
                        </div>
                    </div>
                    <div class="mt-6">
                        <p class="text-gris font-bold text-xl mb-1">Mail du responsable</p>
                        <input class="w-full border-2 border-gris rounded-lg p-2" type="text" id="mail" name="mail"/>
                    </div>
                    <div class="mt-6">
                        <p class="text-gris font-bold text-xl mb-1">Adresse du responsable</p>
                        <input class="w-full border-2 border-gris rounded-lg p-2" type="text" id="adresse" name="adresse"/>
                    </div>
                    <div class="mt-6">
                        <p class="text-gris font-bold text-xl mb-1">Téléphone du responsable</p>
                        <input class="w-full border-2 border-gris rounded-lg p-2" type="text" id="telephone" name="telephone"/>
                    </div>
                    <input class="appearance-none text-center w-full bg-violet mt-6 rounded-lg py-2 text-blanc font-bold" type="submit" value="Créer l'élève"/>
                </form>
            </jsp:body>
        </p:prefabody>
    </jsp:body>
</p:pageWithoutLogo>