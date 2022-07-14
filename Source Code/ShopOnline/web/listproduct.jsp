  <%@page import="java.util.List"%>
<%@page import="model.Slide"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop Online</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/HomePage.css">
        <link rel="stylesheet" href="css/responsive.css">

        <script src="js/fontAwesome.js"></script>
        <script src="js/message.js"></script>
        
        <!-- Bootstrap 5 -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    </head>
    <body>
        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>
        <div class="container my-5">
            <a href="listproduct?action=add" class="btn btn-success my-5">Add new product</a>
            <select class="form-select form-control my-5" id="selectBox" onchange="goPage()">
                <option selected>Sort Product</option>
                <option value="ASC">Price from low to high</option>
                <option value="DESC">Price from high to low</option>
                <option value="">Original order</option>
            </select>


            <form method="GET" class="mb-3">
                <input type="hidden" name="action" value="search">
                <input type="text" class="form-control mb-3" name="search" value="${param.search}">
                <input type="submit" class="btn btn-success" value="Search" />
            </form>

            <table class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Description</th>
                        <th scope="col">Image</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>  <a class="link-profile" href="DetailProductcontroller?idproduct=${product.id}">${product.name} </a> </td>
                            <td>${product.price}</td>
                            <td>${product.description}</td>
                            <td>
                                <img src="${product.img}" style="width: 100px !important; height: 100px !important;" class="img-thumbnail">
                            </td>
                            <td>
                                <a class="btn btn-success" href="listproduct?action=edit&id=${product.id}">Edit</a>
                                <a class="btn btn-danger" href="#" onclick="deleteProduct('${product.id}')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <c:if test="${countPage != null}">
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <c:forEach begin="1" end="${countPage}" var="p">
                            <li class="page-item ${p == PAGE ? "active":""}"><a class="page-link" href="?page=${p}&sort=${sort}">${p}</a></li>
                            </c:forEach>
                    </ul>
                </nav>
                <!--END PAGING-->
            </c:if>


        </div>


        <!-- Start Footer  -->
        <%@include file="footer.jsp" %>

        <!-- End copyright  -->

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

        <!-- ALL JS FILES -->
        
        <script src="js/custom.js"></script>
        <script type="text/javascript">
                function goPage() {
                    var selectBox = document.getElementById("selectBox");
                    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                    window.location.href = "listproduct?sort=" + selectedValue;
                }
                function deleteProduct(id) {
                    var option = confirm("Delete product with id: " + id + " ?");
                                                if (option === true) {
                                                    window.location.href = 'listproduct?action=delete&id='+id;
                                                }
}
        </script>
    </body>
</html>
