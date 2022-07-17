<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin || Shop Online</title>
        <!-- Site Icons -->
        <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/Dashboard.css">
        <link rel="stylesheet" href="../css/Customers.css">
        <link rel="stylesheet" href="../css/profile.css">
        <script src="https://kit.fontawesome.com/a4edd5786f.js" crossorigin="anonymous"></script>

        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:set var="UserListActive" value="active"/>
        <%@include file="Topbar.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <%@include file="menuDashBoard.jsp" %>
                <div class="col-lg-9 main">
                    <div aria-label="breadcrumb" class="mb-3">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item">
                                <i class="fa-solid fa-globe fa-sm"></i>
                                <a href="dashboard">Dashboard</a>
                            </li>
                            <li class="breadcrumb-item active" aria-current="page">User List</li>
                        </ul>
                    </div>
                    <div class="container-fluid">
                        <div class="table-responsive cus-box">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>
                                            <input class="select-all" type="checkbox" value="deselect">
                                        </th>
                                        <th>ID</th>
                                        <th>Photo</th>
                                        <th>Fullname</th>
                                        <th>Email</th>
                                        <th>Province</th>
                                        <th>Status</th>
                                        <th>Date</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${userlist}" var="us">
                                        <tr class="customers">
                                            <td>
                                                <input class="form-check-input" type="checkbox" value="${us.user.userid}">
                                            </td>
                                            <td>
                                                <a href="#">#${us.user.userid}</a>
                                            </td>
                                            <td>
                                                <div class="avatar avatar-info">
                                                    <c:choose>
                                                        <c:when test="${us.user.photo ne null}">
                                                            <img src="../RetrieveImg?eaID=${us.user.userid}" class="rounded-circle">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span class="avatar-text rounded-circle">${us.user.lastname.charAt(0)}</span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </td>
                                            <td>${us.user.firstname} ${us.user.middlename} ${us.user.lastname}</td>
                                            <td>${us.user.email}</td>
                                            <td>${us.user_add.proID.name}</td>
                                            <td>
                                                <span class="badge bg-success">Active</span>
                                            </td>
                                            <td>
                                                <span class="badge bg-success">${us.user.dob}</span>
                                            </td>
                                            <td>
                                            <button id="myBtn" class="btn"><i class="fa-regular fa-pen-to-square"></i> Edit Profile</button>
                                            <button id="myBtn" class="btn"><i class="fa-regular"></i> Delete</button>
                                        </td>
                                            <td></td>
                                        </tr>
                                    </c:forEach>
                                    <!-- Edit Profile -->

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
                    
                    <script>
                        var checkArea = document.getElementById('check-err');
                        var passIn = document.getElementById('password');
                        var passCf = document.getElementById('password_confirmation');

                        passCf.onkeyup = () => {
                            var inP = passCf.value;

                            if (inP !== passIn.value) {
                                checkArea.innerHTML = '<i class="fa-solid fa-circle-xmark"></i>';
                                return false;
                            }

                            checkArea.innerHTML = '<i style="color: #2e8b57;" class="fa-solid fa-circle-check"></i>';
                            return true;
                        };



                    </script>
                    
                    <script src="../js/list-select.js"></script>
                </div>
            </div>
        </div>
    </body>
</html>