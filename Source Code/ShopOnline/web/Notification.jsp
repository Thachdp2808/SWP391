<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${sessionScope.userlogged.username} Order || Shop Online</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/Dashboard.css">
        <link rel="stylesheet" href="css/Customers.css">
        <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="topbar.jsp" %>
        <%@include file="header.jsp" %>
        <div class="main">
            
            <div class="container my-5">
                <table  class="table table-striped">               
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Date</th>
                            <th>Content</th>
                           
                        </tr>
                    </thead>
                    <tbody>
                        
                        <c:forEach items="${list}" var="u">
                                    <tr>
                                        <td>${u.orderID}</td>

                                        <td>${u.orderDate}</td>
                                        
                                        <c:choose>
                                            <c:when test="${u.status eq 'completed'}">
                                                <td>Your order has been confirmed at ${u.requireDate}</td>
                                            </c:when>
                                            <c:when test="${u.status eq 'shipped'}">
                                                <td>Your order has been successfully delivered ${u.shippedDate}</td>
                                            </c:when>
                                                
                                            <c:otherwise>
                                                <td>
                                                    
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                    </tbody>
                </table>
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#"><i class="fa-solid fa-angles-left"></i></a>
                    </li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#"><i class="fa-solid fa-angles-right"></i></a>
                    </li>
                </ul>
            </div>
        </div>
        <script src="js/list-select.js"></script>
    </div>
</div>
</div>
</body>
</html>
<%@include file="footer.jsp" %>

