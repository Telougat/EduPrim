<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:pageWithoutLogo>
    <jsp:body>
        <p:prefabody>
            <jsp:body>
                <form method="POST">
                    <h3 class="text-gris font-bold text-3xl">Création d'une classe</h3>
                    <div class="mt-3">
                        <p class="text-gris font-bold text-xl mb-1">Nom de la classe</p>
                        <input class="w-full border-2 border-gris rounded-lg p-2" type="text" id="nomClasse" name="nomClasse"/>
                    </div>
                    <input class="appearance-none text-center w-full bg-violet mt-3 rounded-lg py-2 text-blanc font-bold" type="submit" value="Créer la classe"/>
                </form>
            </jsp:body>
        </p:prefabody>
    </jsp:body>
</p:pageWithoutLogo>