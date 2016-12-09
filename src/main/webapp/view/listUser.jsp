<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html ng-app = "listUserApp">
<head>
    <meta charset="UTF-8">
    <script src="http://code.angularjs.org/1.0.6/angular.min.js"></script>
    <script>
        var listUserApp = angular.module('listUserApp', []);
        listUserApp.controller('userCtrl', function ($scope, $http){
            $http.get('/autopark/users.json').success(function(data) {
                $scope.users = data;
            });
        });
    </script>
</head>
<body ng-controller="userCtrl">
    <div id="userList">
    <table>
        <tr>
            <td>ID пользователя</td>
            <td>Логин</td>
            <td>Пароль</td>
        </tr>
        <tr ng-repeat="user in users">
            <td>{{user.idUser}}</td>
            <td>{{user.login}}</td>
            <td>{{user.password}}</td>
        </tr>
    </table>
    </div>
</body>
</html>