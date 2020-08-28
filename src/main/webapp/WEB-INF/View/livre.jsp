<%@ page import="com.eduprim.beans.Livre" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 27/08/2020
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:page>
    <jsp:body>

        <div class="flex justify-center pt-10">
            <div class="container flex justify-center">
                <table class="w-full table-fixed border-2 border-rose px-8 py-2">
                    <thead class="w-full">
                        <tr class="flex w-full mb-4 text-violet font-bold border-b-2 border-rose">
                            <th class="p-4 w-1/3">Titre</th>
                            <th class="p-4 w-1/4">Auteur</th>
                            <th class="p-4 w-1/4">Référence</th>
                            <!--<th class="p-4 w-1/4">Genre</th>-->
                            <!--<th class="p-4 w-1/2">Résumé</th>-->
                            <th class="p-4 w-1/4">Statut</th>
                            <th class="p-4 w-1/4">Emprunteur</th>
                        </tr>
                    </thead>
                    <tbody class="w-full h-full items-center justify-between overflow-y-scroll" style="height: 50vh">
                        <c:forEach items="${livres}" var="livre">
                            <tr class="w-full flex mb-4 border-b-2 border-rose">
                                <td class="p-4 w-1/3">${livre.getTitre()}</td>
                                <td class="p-4 w-1/4">${livre.getAuteur()}</td>
                                <td class="p-4 w-1/4">${livre.getReference()}</td>
                                <td class="p-4 w-1/4">Disponible</td>
                                <td class="p-4 w-1/4"><div>Personne</div><div>logo</div></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div x-data="{ open: false }" class="pl-10" style="visibility: ${visibility}">
                <button class="bg-violet rounded text-blanc font-bold py-2 px-4" type="button"@click="open = true">Ajouter un livre</button>

                <div
                        x-show="open"
                        @click.away="open = false"
                >
                    <div  style="margin-top:20em" class=" absolute z-1000 flex flex-col items-center justify-center font-sans bg-blanc">
                        <div style="width: 50em; height:30em" v-if="modal.visible" @click.self="modal.visible = false" class="absolute flex items-center justify-center bg-blanc pt-15 border-2 border-violet">
                            <div class="bg-blanc w-3/4 rounded shadow p-8 m-4 max-w-xs max-h-full text-center pt-10 border-2 border-rose">
                                <h1 class="text-violet">Informations du livre</h1><br/>
                                <form method="get">
                                    <div class="mb-8">
                                        <p class="text-violet pb-4"> Titre :  &nbsp; <input type="text" name="titre"></p>
                                        <p class="text-violet pb-4">Auteur :  &nbsp; <input type="text" name="auteur"></p>
                                        <p class="text-violet">Référence :  &nbsp; <input type="text" name="reference"></p>
                                    </div>
                                    <div class="flex justify-center">
                                        <button class="flex-no-shrink text-blanc py-2 px-4 rounded bg-violet" type="submit" @click="open = false">Valider</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</p:page>
