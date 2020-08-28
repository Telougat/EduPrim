<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:page>
    <jsp:body>

        <c:if test="${ cde }">
            <div class="flex items-center justify-center w-full p-2 m-2">
                    <span class="w-3/5 text-violet font-bold flex items-center justify-center border-2 border-violet border-opacity-75 p-3 rounded-full">
                        <div class="flex items-start w-1/6">
                            <svg class="w-6" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                 viewBox="0 0 477.867 477.867" style="enable-background:new 0 0 477.867 477.867;" xml:space="preserve">
                                <g><g><path d="M238.933,0C106.974,0,0,106.974,0,238.933s106.974,238.933,238.933,238.933s238.933-106.974,238.933-238.933
                                            C477.726,107.033,370.834,0.141,238.933,0z M370.466,165.666L199.799,336.333c-6.665,6.663-17.468,6.663-24.132,0l-68.267-68.267
                                            c-6.78-6.548-6.968-17.352-0.42-24.132c6.548-6.78,17.352-6.968,24.132-0.42c0.142,0.138,0.282,0.277,0.42,0.42l56.201,56.201
                                            l158.601-158.601c6.78-6.548,17.584-6.36,24.132,0.419C376.854,148.567,376.854,159.052,370.466,165.666z"/></g></g><g></g><g></g><g></g><g></g><g></g><g></g></svg>
                       </div>
                        <div class="w-5/6 flex items-center justify-center">
                            <p>Les modifications ont bien été prises en compte !</p>
                        </div>
                    </span>
            </div>
        </c:if>

        <c:if test="${ cde != '-1' }">
            <div class="flex items-center justify-center w-full p-2 m-2">
                    <span class="w-3/5 text-violet font-bold flex items-center justify-center border-2 border-violet border-opacity-75 p-3 rounded-full">
                        <div class="flex items-start w-1/6">
                            <svg class="w-6" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                 viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
                                    <path d="M501.609,384.603L320.543,51.265c-13.666-23.006-37.802-36.746-64.562-36.746c-26.76,0-50.896,13.74-64.562,36.746
                                        c-0.103,0.176-0.19,0.352-0.293,0.528L10.662,384.076c-13.959,23.491-14.223,51.702-0.719,75.457
                                        c13.535,23.769,37.919,37.948,65.266,37.948h360.544c27.347,0,52.733-14.179,66.267-37.948
                                        C515.524,435.779,515.261,407.566,501.609,384.603z M225.951,167.148c0-16.586,13.445-30.03,30.03-30.03
                                        c16.586,0,30.03,13.445,30.03,30.03v120.121c0,16.584-13.445,30.03-30.03,30.03s-30.03-13.447-30.03-30.03V167.148z
                                         M255.981,437.421c-24.839,0-45.046-20.206-45.046-45.046c0-24.839,20.206-45.045,45.046-45.045
                                        c24.839,0,45.045,20.206,45.045,45.045C301.027,417.214,280.821,437.421,255.981,437.421z"/>
                            </svg>
                       </div>
                       <div class="w-5/6 flex items-center justify-center">
                            <p>Un problème est survenu, veuillez réessayer.</p>
                        </div>
                    </span>
            </div>
        </c:if>

            <div class="flex items-center justify-center w-full p-2 m-2">
                    <span class="w-3/5 flex items-center justify-center border-b-2 border-rose border-opacity-75 pb-3">
                        <h1 class="text-3xl text-violet font-bold tracking-widest">ÉDITION</h1>
                    </span>
            </div>
            <!-- student card -->
            <div class="flex bg-blanc shadow-2xl rounded-lg mx-4 md:mx-auto w-3/5 border border-gris border-1 pr-4 pl-4">
                <form method="post">
                <div class="flex items-start px-4 py-6 w-full ml-2">
                    <div class="w-full md:w-1/2 bg-red-200 p-1 h-full">
                        <div class="flex flex-wrap w-full">
                            <div class="md:w-1/2 w-full">
                                <p class="font-semibold text-violet mb-1">Nom :</p>
                                <input name="name"  class=" border text-gris border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg w-5/6 border-opacity-50" id="name"  value="${student.getNom()}">
                            </div>
                            <div class="w-1/2">
                                <p class="font-semibold text-violet mb-1">Prénom :</p>
                                <input  name="firstName" class="border text-gris border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg w-5/6 border-opacity-50" id="firstName"  value="${student.getPrenom()}">
                            </div>
                        </div>
                        <br>
                        <div class="my-3">
                            <p class="font-semibold text-violet mb-1">Date de naissance :</p>
                            <input name="date" class="border text-gris border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg border-opacity-50" id="birthDate"  value="${student.getDateDeNaissance()}">
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet mb-1">Adresse du responsable :</p>
                            <input name="address" class="border text-gris border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg border-opacity-50" id="address"  value="${student.getAdresse()}">
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet mb-1">Adresse mail du responsable :</p>
                            <input name="mail" class="border text-gris border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg border-opacity-50" id="mail"  value="${student.getMailParent()}">
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet mb-1">Téléphone du responsable :</p>
                            <input name="phone" class="border border-gris text-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg border-opacity-50" id="phone"  value="${student.getTelephoneParent()}">
                        </div>

                        <div class="my-3 hidden">
                            <input name="id"  value="${student.getID()}">
                        </div>
                    </div>
                    <div class="flex flex-col items-center justify-center md:w-1/2 h-full p-1 hidden md:flex">
                        <div class="w-64">
                        <img src="${pageContext.request.contextPath}/ressources/images/user.png" alt="user logo">
                            <br>
                        <button id="UpdateBtn" type="submit" class="bg-violet text-blanc font-bold w-full p-1 rounded-lg  hover:shadow-2xl  hover:bg-rose text-white border-b-4 border-rose ">Valider</button>
                        </div>
                    </div>
                </div>
               </form>
            </div>
    </jsp:body>
</p:page>
