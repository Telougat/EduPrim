<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:pageWithoutLogo>
    <jsp:body>
        <p:prefabody>
            <jsp:body>
                <form action="">
                    <h3 class="text-gris font-bold text-3xl">Création d'une classe</h3>
                    <div class="mt-3">
                        <p class="text-gris font-bold text-xl mb-1">Nom de la classe</p>
                        <input class="w-full border-2 border-gris rounded-lg py-2 px-1" type="text" id="nomClasse" name="nomClasse":>
                    </div>
                </form>
            </jsp:body>
        </p:prefabody>
    </jsp:body>
</p:pageWithoutLogo>