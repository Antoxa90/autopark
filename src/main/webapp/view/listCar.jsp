<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html ng-app="listCarApp">
<head>
    <script src="http://code.angularjs.org/1.0.6/angular.min.js"></script>
    <script>
        var listUserApp = angular.module('listCarApp', []);
        listUserApp.controller('listCarCtrl', function ($scope, $http){
            $http.get('/autopark/cars.json').success(function(data) {
                $scope.cars = data;
            });
        });
    </script>
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
</head>
<body ng-controller="listCarCtrl">

<div id="carList">
    <table>
        <tr>
            <td>ID машины</td>
            <td ng-click="driver()">ID водителя</td>
            <td>Марка машины</td>
            <td>Гос. номер</td>
            <td>Год выпуска</td>
        </tr>
        <tr ng-repeat="car in cars">
            <td>{{car.idCar}}</td>
            <td>{{car.idDriver.idDriver}}</td>
            <td>{{car.marka}}</td>
            <td>{{car.gosNumber}}</td>
            <td>{{car.yearMake}}</td>
        </tr>
    </table>
</div>

</body>
</html>