<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/08/2020
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<p:page>
    <jsp:body>
            <div class="flex items-center justify-center w-full p-2 m-2">
                    <span class="w-3/5 flex items-center justify-center border-b-2 border-rose border-opacity-75 pb-3">
                        <h1 class="text-3xl text-violet font-bold tracking-widest">ÉDITION</h1>
                    </span>
            </div>
            <!-- student card -->
            <div class="flex bg-blanc shadow-2xl rounded-lg mx-4 md:mx-auto w-3/5 border border-gris border-1 pr-4 pl-4">
                <div class="flex items-start px-4 py-6 w-full ml-2">
                    <div class="w-full md:w-1/2 bg-red-200 p-1 h-full">
                        <div class="flex flex-wrap w-full">
                            <div class="md:w-1/2 w-full">
                                <p class="font-semibold text-violet mb-1">Nom :</p>
                                <input class=" border border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg w-5/6 border-opacity-50" id="name"  placeholder="${Name}">
                            </div>
                            <div class="w-1/2">
                                <p class="font-semibold text-violet mb-1">Prénom :</p>
                                <p class="text-rose">${firstName}</p>
                                <input class="border border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg w-5/6 border-opacity-50" id="firstName"  placeholder="${firstName}">
                            </div>
                        </div>
                        <br>
                        <div class="my-3">
                            <p class="font-semibold text-violet mb-1">Date de naissance :</p>
                            <input class="border border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg border-opacity-50" id="birthDate"  placeholder="${birthDate}">
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet mb-1">Adresse du responsable :</p>
                            <p class="text-rose">${address}</p>
                            <input class="border border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg border-opacity-50" id="address"  placeholder="${address}">
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet mb-1">Adresse mail du responsable :</p>
                            <input class="border border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg border-opacity-50" id="mail"  placeholder="${mail}">
                        </div>
                        <div class="my-3">
                            <p class="font-semibold text-violet mb-1">Téléphone du responsable :</p>
                            <input class="border border-gris rounded-lg p-2 focus:text-violet focus:border-rose focus:shadow-2xl shadow-lg border-opacity-50" id="phone"  placeholder="${phone}">
                        </div>
                    </div>
                    <div class="flex flex-col items-center justify-center md:w-1/2 h-full p-1 hidden md:flex">
                        <div class="w-64">
                        <img src="${pageContext.request.contextPath}/ressources/images/user.png" alt="user logo">
                            <br>
                        <button class="bg-violet text-blanc font-bold w-full p-1 rounded-lg  hover:shadow-2xl  hover:bg-rose text-white border-b-4 border-rose ">Modifier</button>
                        </div>
                    </div>
                </div>
            </div>
    </jsp:body>
</p:page>
