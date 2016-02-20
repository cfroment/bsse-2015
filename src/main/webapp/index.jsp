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
    <link rel="stylesheet" href="css/style.css"/>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/ng-table/dist/ng-table.js"></script>
    <script src="app/app.js"></script>
</head>
<body>
<div class="navbar navbar-default">
    <div class="navbar-header">
        <a class="navbar-brand" href="index.xhtml">BSSE 2015</a>
    </div>

    <div>
        <a href="#/login" >Login</a>
    </div>
</div>
<div class="row">
    <div class="col-lg-2 col-md-4 cold-sm-6">
        <ul class="nav nav-pills nav-stacked">
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                <a href="#/candidates">Candidates</a>
            </li>
        </ul>
    </div>
    <div ng-view></div>
</div>
</body>
</html>
