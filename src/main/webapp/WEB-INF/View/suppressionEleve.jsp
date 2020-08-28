<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:pageWithoutLogo>
    <jsp:body>
        <p:prefabody>
            <jsp:body>
                <form action="">
                    <h3 class="text-gris font-bold text-3xl text-center">Suppression de l'élève : #ELEVE#</h3>
                    <p class="text-2xl font-bold text-rose text-center">Souhaitez-vous vraiment<br>supprimer cette élève ?</p>
                    <div class="grid grid-cols-2 col-gap-3">
                        <button class="appearance-none text-center w-full bg-violet mt-3 rounded-lg py-2 text-blanc font-bold">Annuler</button>
                        <input class="appearance-none border border-violet text-center w-full bg-blanc mt-3 rounded-lg py-2 text-violet font-bold" type="submit" value="Supprimer"/>
                    </div>
                </form>
            </jsp:body>
        </p:prefabody>
    </jsp:body>
</p:pageWithoutLogo>