<%@ page import="com.eduprim.beans.Livre" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:page>
    <jsp:body>
        <div class="flex justify-center pt-10">
            <div class="container flex justify-center">
                <table class="w-full table-fixed border-2 border-rose px-8 py-2">
                    <thead class="w-full bg-violet">
                        <tr class="flex w-full pb-2 text-blanc border-b-2 border-rose text-left">
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
                            <tr class="w-full flex py-1 border-b-2 border-rose">
                                <td class="p-4 w-1/3">${livre.getTitre()}</td>
                                <td class="p-4 w-1/4">${livre.getAuteur()}</td>
                                <td class="p-4 w-1/4">${livre.getReference()}</td>
                                <td class="p-4 w-1/4">Personne</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div x-data="{ open: false }" class="pl-10">
                <button class="bg-violet rounded text-blanc font-bold py-2 px-4" type="button"@click="open = true">Ajouter un livre</button>

                <div
                        x-show="open"
                        @click.away="open = false"
                >
                    <div class=" absolute z-1000 flex flex-col items-center justify-center font-sans bg-blanc">
                        <div v-if="modal.visible" @click.self="modal.visible = false" class="h-screen w-full absolute flex items-center justify-center bg-modal">
                            <div class="bg-white rounded shadow p-8 m-4 max-w-xs max-h-full text-center overflow-y-scroll pt-10">
                                <h1>Informations du livre</h1>
                                <div class="mb-8">
                                    Titre :   <input type="text">
                                    Auteur :   <input type="text">
                                </div>
                                <div class="flex justify-center">
                                    <button class="flex-no-shrink text-white py-2 px-4 rounded bg-teal hover:bg-teal-dark" type="submit">Valider</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</p:page>
