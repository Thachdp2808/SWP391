<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sneaker Store</title>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/card.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/fontAwesome.js"></script>
    
    <!-- Bootstrap 5 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
<body>
    <%@include file="topbar.jsp" %>
    <%@include file="header.jsp" %>
    
    <!-- Start Shop Page  -->
    <div class="shop-box-inner">
        <div class="container">
            <div class="all-title-box" style="margin-top: 60px;">
                <div aria-label="breadcrumb">
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="home">Home</a></li>
                        <li class="breadcrumb-item"><a href="CartController?userID=${sessionScope.userlogged.userid}">Cart</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Cart Contact</li>
                    </ul>
                </div>
            </div>

            <!-- Start Cart  -->
            <div class="cart-box-main">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-5 col-lg-5 mb-3">
                            <div class="checkout-address">
                                <div class="title-top">
                                    <h4>Billing address</h4>
                                </div>
                                <form action="">
                                    <div class="mb-3 mt-3">
                                        <label for="fullName">Full name *</label>
                                        <input type="text" class="form-control" id="firstName" name="name_receiver" value="" required>
                                        <div class="invalid-feedback"> Valid full name is required. </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="phone">Phone Number *</label>
                                        <input type="tel" class="form-control" id="phone" name="phone" required>
                                        <div class="invalid-feedback" style="width: 100%;"> Your phone is required. </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="email">Email Address *</label>
                                        <input type="email" class="form-control" id="email" name="email" required>
                                        <div class="invalid-feedback"> Please enter a valid email address for shipping updates. </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="address">Address *</label>
                                        <input type="text" class="form-control" id="address" name="address" placeholder="" required>
                                        <div class="invalid-feedback"> Please enter your shipping address. </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="address">Note </label>
                                        <input type="text" class="form-control" id="address" name="address" placeholder="" required>
                                        <div class="invalid-feedback"> Please enter your shipping address. </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-sm-7 col-lg-7 mb-3">
                            <div class="order-box">
                                <div class="title-top">
                                    <h4>Your order</h4>
                                </div>
                                <div class="order-ls" style="margin-top: 20px;">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <td>Product</td>
                                                <td>Quantity</td>
                                                <td>Price</td>
                                                <td></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${carts}" var="carts">
                                                <tr>
                                                    <td class="d-flex flex-row me-3">
                                                        <div class="image">
                                                            <img src="${carts.product.img}" alt="" class="img-fluid">
                                                        </div>
                                                        <div class="d-flex flex-column">
                                                            <span><strong>${carts.product.name}</strong></span>
                                                            <span>Color</span>
                                                            <span>Size</span>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <input type="text" value="${carts.quantity}" disabled>
                                                    </td>
                                                    <td>
                                                        <fmt:formatNumber value="${carts.product.price*carts.quantity}" type="currency"/>
                                                    </td>
                                                    <td><input type="hidden" name="item" value="${carts.itemId}"></td>
                                                </tr>     
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="payment-box mt-4">
                                <div class="title-top">
                                    <h5>Payment</h5>
                                </div>
                                <div class="row payment">
                                    <div class="col-lg-5 payment-ls">
                                        <p><small>Select a payment method</small></p>
                                        <ul class="d-flex flex-wrap">
                                            <li id="pm-sl">
                                                <img src="images/payment-icon/cod.png" class="image">
                                                <i class="fa-solid fa-circle-check mark-icon"></i>
                                            </li>
                                            <li>
                                                <a href="">
                                                    <img src="images/payment-icon/visa.png" class="image">
                                                </a>
                                            </li>
                                            <li>
                                                <a href="">
                                                    <img src="images/payment-icon/jcb.png" class="image">
                                                </a>
                                            </li>
                                            <li>
                                                <a href="">
                                                    <img src="images/payment-icon/master.png" class="image">
                                                </a>
                                            </li>
                                            <li>
                                                <a href="">
                                                    <img src="images/payment-icon/PayPal.png" class="image">
                                                </a>
                                            </li>
                                            <li>
                                                <a href="">
                                                    <img src="images/payment-icon/citibank.png" class="image">
                                                </a>
                                            </li>
                                        </ul>
                                        <script>
                                            var mark = document.querySelector(".mark-icon");
                                            var selectBtn = document.querySelector("#pm-sl");

                                            selectBtn.addEventListener("click", () => {
                                                mark.classList.toggle("check");
                                            })
                                        </script>
                                    </div>
                                    <div class="col-lg-7">
                                        <form action="CartContact" method="POST">
                                            <div class="input-group">
                                                <input type="hidden" name="userID" value="${sessionScope.userlogged.userid}">
                                                <input type="text" name="code" class="form-control" placeholder="Enter discount code">
                                                <button class="btn btn-danger" type="submit">Apply</button>
                                            </div>
                                        </form>
                                        <ul class="d-flex align-items-center justify-content-between mt-3 mb-0 p-0">
                                            <li style="color: #d33b33; font-size: 20px; font-weight: 600;">Total:</li>
                                            <li id="total-price" style="font-weight: 700; font-size: 18px;">
                                                <fmt:formatNumber value="${sum}" type="currency"/>
                                            </li>
                                        </ul>
                                        <div class="add-comp why-text">
                                            <a href="CartCompletion?cartID=${sessionScope.userlogged.userid}&sum=${sum}" class="ms-auto btn">Place Order</a>
                                            <a href="CartController?userID=${sessionScope.userlogged.userid}" class="ml-auto btn">Change</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Cart -->
        </div>
    </div>
    <!-- End Shop Page -->
    
    <%@include file="footer.jsp" %>
</body>
</html>
