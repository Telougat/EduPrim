<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:pageAdmin>
    <jsp:body>
        <div>
            <div class="flex justify-center mt-16">
                <h1 class="uppercase text-4xl text-xl text-violet relative">
                    Liste des professeurs<br/>
                    <hr class="absolute w-full border-t border-rose bottom-0 -mb-2">
                </h1>
            </div>
            <div class="grid grid-cols-1 gap-12 xl:gap-24 mt-16 mx-12 xl:mx-24">
                <select name="select2" size="3">
                    <c:forEach items="${classes}" var="classe">
                        <option class="w-11/12 md:w-3/5 text-center text-3xl text-violet focus:bg-rose focus:text-blanc border border-gris py-6 cursor-pointer shadow bordures-arrondies mx-auto">
                            <c:out value="${classe.getNom()}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </jsp:body>
</p:pageAdmin>
