<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html ng-app="loginApp">
<head>
    <script src="/js/jquery-2.1.3.min.js"></script>
    <script src="http://code.angularjs.org/1.0.6/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-route.js"></script>
    <script src="/js/controllers.js" ></script>
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body ng-controller="loginCtrl">

<div id="main">
    <div id="logForm">
        <form role="form" name="loginForm">
            <div class="form-group">
                <span ng-show="message">{{message}}</span><br/>
                <label>Логин:</label>
                <input type="text" class="form-control input-lg" ng-model="user.login" placeholder="Введите логин" required><br/>
                <label>Пароль:</label>
                <input type="password" class="form-control input-lg" ng-model="user.password" placeholder="Введите пароль" required><br/>
            </div>
        <br>

        <button id="regist" class="btn btn-default btn-lg" ng-click="registUser()">Регистрация</button>&emsp;&emsp;
        <button id="login" class="btn btn-default btn-lg" ng-click="loginUser()">Вход</button>

        </form>
    </div>

    <div id="regForm">
        <form role="form" name="registForm">
            <div class="form-group">
                <label>Логин:</label>
                <input type="text" class="form-control input-md" ng-model="reg.login" placeholder="Введите логин" required><br/>
                <label>Пароль:</label>
                <input type="password" class="form-control input-md" ng-model="reg.password" placeholder="Введите пароль" required><br/>
                <label>Имя:</label>
                <input type="text" class="form-control input-md" ng-model="reg.name" placeholder="Введите имя" required/><br/>
                <label>Фамилия:</label>
                <input type="text" class="form-control input-md" ng-model="reg.surname" placeholder="Введите фамилию" required/><br/>
                <label>Отчество:</label>
                <input type="text" class="form-control input-md" ng-model="reg.lastname" placeholder="Введите отчество" required/><br/>
                <label>Возраст:</label>
                <input type="number" name="age" class="form-control input-md" ng-model="reg.age" placeholder="Введите возраст" required/><br/>
                <label>Почта:</label>
                <input type="email" name="mail" class="form-control input-md" ng-model="reg.mail" ng-model-options="{updateOn: 'blur'}" placeholder="Введите почту" required/><br/>
            </div>
            <button class="btn btn-default btn-md" ng-click="registration()">Зарегистрироваться</button>&emsp;&emsp;
            <button class="btn btn-default btn-md" ng-click="enter()">Войти</button>
        </form>
    </div>
</div>
</body>
</html>