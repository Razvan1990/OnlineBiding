<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>

<!-- practic aici returneaza exact toate itemurile din lista, dupa ce le scoate pe toate
si ajunge la Controller care comunica cu front-endul si e numele din metoda de addObject din requestul de get(sus) -->
<section class="lattest-product-area pb-40 category-list">
    <div class="row">
        <c:forEach items="${itemList}" var="item">
            <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                    <div class="card-product__img">
                        <img class="card-img" src="/displayImage/?id=${item.id}" alt="" >
                        <ul class="card-product__imgOverlay">
                            <li>
                                <button><i class="ti-search"></i></button>
                            </li>
                            <li>
                                <button><i class="ti-shopping-cart"></i></button>
                            </li>
                            <li>
                                <button><i class="ti-heart"></i></button>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <p>${item.category}</p>
                        <h4 class="card-product__title"><a href="/account/item/${item.id}">${item.name}</a></h4>
                        <p class="card-product__price">$${item.currentPrice}</p>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>
</section>
<!-- End Best Seller -->

</body>
</html>