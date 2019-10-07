<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Item page</title>

    <link rel="stylesheet" type="text/css" href="/css/item.css">
    <link rel="icon" href="http://www.clementsauctiongallery.com/wp-content/uploads/2017/11/auction.jpg">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8="
            crossorigin="anonymous"></script>

    <script src="/js/item.js"></script>
</head>
<body>
<div class="ItemPage">

    <h2>Item page</h2>
    <form:form method="POST" action="item" modelAttribute="itemForm" id="myForm" onSubmit="return validations()"
               enctype="multipart/form-data">
        <!--specifica cum sa fie codata data cand se da sumbit spre server -> practic se foloseste doar la POST -->
        <label for="name">Item name</label>
        <br>
        <form:input path="name" id="name" type="text" class="normalItem" placeholder="ItemName"/>
        <!-- erau form:errors -->
        <p class="error"><form:errors path="name"/></p>
        <label for="description">Short description</label>
        <br>

        <form:input path="description" id="description" type="text" class="normalItem" maxlength="50"
                    placeholder="description"/>
        <p class="error"><form:errors path="description"/></p>

        <label for="category">Category</label>
        <br>

        <form:input path="category" id="category" type="text" class="normalItem" maxlength="50"
                    placeholder="category"/>
        <p class="error"><form:errors path="category"/></p>

        <label for="startingPrice">Price</label>
        <form:input path="startingPrice" id="startingPrice" type="number" class="normalItem" placeholder="price"
                    step="5"
                    min="0"/>
        <p class="error"><form:errors path="startingPrice"/></p>

        <label for="startDate">StartDate</label>
        <form:input path="startDate" id="startDate" type="date" class="normalItem" placeholder="startDate"/>
        <p class="error"><form:errors path="startDate"/></p>

        <label for="endDate">EndDate</label>
        <form:input path="endDate" id="endDate" type="date" class="normalItem" placeholder="endDate"/>
        <p class="error"><form:errors path="endDate"/></p>
        <form:input path="multipartFile" type="file" name="multipartFile"/>
        <p class="error"><form:errors path="multipartFile"/> </p>

        <input type="submit" id="button" value="Send"/>
        <h2 style="color:darkred">${successMessage2}</h2>

        <ul class=ItemList>
            <li><a href="/admin/home">Home</a></li>
        </ul>
    </form:form>
</div>

</body>
</html>


