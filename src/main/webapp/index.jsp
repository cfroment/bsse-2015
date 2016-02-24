<%--
  User: C
  Date: 2016-02-20
  Time: 21:56
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="bsseApp">
<head>
    <title>BSSE</title>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="bower_components/ng-table/dist/ng-table.css"/>
    <link rel="stylesheet" href="bower_components/angular-bootstrap/ui-bootstrap-csp.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-bootstrap/ui-bootstrap.js"></script>
    <script src="bower_components/angular-ui-router/release/angular-ui-router.js"></script>
    <script src="bower_components/ng-table/dist/ng-table.js"></script>
    <script src="js/app/app.js"></script>
    <script src="js/app/controllers/controllers.js"></script>
</head>
<body>
<div class="navbar navbar-default">
    <div class="navbar-header">
        <a class="navbar-brand" href="/home">BSSE 2015</a>
    </div>

    <div>
        <a class="navbar-right navbar-link" href="/login">Login</a>
    </div>
</div>
<div class="col-lg-2 col-md-2 cold-sm-6">
    <ul class="nav nav-pills nav-stacked">
        <li>
            <a href="#">Home</a>
        </li>
        <li>
            <a href="#">Candidates</a>
        </li>
    </ul>
</div>
<div col="col-lg-10 col-md-10 col-sm-6" ui-view></div>
</body>
</html>
