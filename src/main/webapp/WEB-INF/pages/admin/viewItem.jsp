<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--importul de spring form -->
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin home page</title>

    <link rel="stylesheet" href="/template/vendors/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/template/vendors/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="/template/vendors/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="/template/vendors/linericon/style.css">
    <link rel="stylesheet" href="/template/vendors/owl-carousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="/template/vendors/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="/template/vendors/nice-select/nice-select.css">
    <link rel="stylesheet" href="/template/vendors/nouislider/nouislider.min.css">

    <link rel="stylesheet" href="/template/css/style.css">

    <style>
        .bidForm input {
            width: 76px;
            border: 1px solid #eeeeee;
            border-radius: 3px;
            padding-left: 10px;
        }
    </style>
</head>

<body>


<div class="product_image_area">
    <div class="container">
        <div class="row s_product_inner">
            <div class="col-lg-6">
                <div class="owl-carousel owl-theme s_Product_carousel">
                    <div class="single-prd-item">
                        <img class="img-fluid" src="/displayImage/?id=${itemForm.id}" alt="">
                    </div>

                </div>
            </div>
            <div class="col-lg-5 offset-lg-1">
                <div class="s_product_text">
                    <h3>${itemForm.name}</h3>
                    <h2>Current price is $${itemForm.currentPrice}</h2>
                    <ul class="list">

                        <li><a class="active" href="#"><span>Category</span> ${itemForm.category}</a></li>

                        <li><a class="active" href="#"><span>Started at</span> ${itemForm.startingPrice}</a></li>

                        <li><a href="#"><span>Expires at</span> ${itemForm.endDate}</a></li>

                        <li><a href="#"><span>Owned by </span> ${itemForm.ownerName}</a></li>

                    </ul>
                    <p>${itemForm.description}</p>

                    <h2 style="color:red">${errorMessage}</h2>
                </div>
                <div class="card_area d-flex align-items-center">
                    <form:form method="get" action="/admin/home/">
                        <!--introducem un button care sa ne duca pe home-->
                        <button class="button button-header" type="submit">Home page</button>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script src="/template/vendors/jquery/jquery-3.2.1.min.js"></script>
<script src="/template/vendors/bootstrap/bootstrap.bundle.min.js"></script>
<script src="/template/vendors/skrollr.min.js"></script>
<script src="/template/vendors/owl-carousel/owl.carousel.min.js"></script>
<script src="/template/vendors/nice-select/jquery.nice-select.min.js"></script>
<script src="/template/vendors/jquery.ajaxchimp.min.js"></script>
<script src="/template/vendors/mail-script.js"></script>
<script src="/template/main.js"></script>
</body>

</html>