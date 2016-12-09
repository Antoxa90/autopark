<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html ng-app="mainApp">
<head>
    <script src="/js/jquery-2.1.3.min.js"></script>
    <script src="http://code.angularjs.org/1.0.6/angular.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="http://bootstrap-ru.com/204/assets/js/bootstrap-tab.js"></script>
    <script src="http://bootstrap-ru.com/204/assets/js/bootstrap-dropdown.js"></script>

    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
    <script src="/js/main.js"></script>
    <script>
        $(document).ready(function() {
            $('#newCar').hide();
            $('#button').click(function() {
                $('#newCar').show();
            });
        });
    </script>

</head>
<body ng-controller="mainCtrl">

<div class="tabs">
<ul id="myTab" class="nav nav-tabs nav-justified">
    <li class="active"><a href="#carList" data-toggle="tab">Список машин</a></li>
    <li><a href="#listDriver" data-toggle="tab" ng-click="new()">Список водителей</a></li>
    <li><a href="#masters" data-toggle="tab" ng-click="repair()">Мастерская</a></li>
    <li><a href="#private" data-toggle="tab" ng-click="new()">Личный кабинет</a></li>
</ul>

<div class="tab-content">
    <div class="tab-pane active" id="carList">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th ng-click="sortBy('idCar')">ID машины
                        <span class="sortorder" ng-class="{reverse: reverse}"></span>
                    </th>
                    <th ng-click="sortBy('idDriver')">ID водителя
                        <span class="sortorder" ng-class="{reverse: reverse}"></span>
                    </th>
                    <th ng-click="sortBy('marka')">Марка машины
                        <span class="sortorder" ng-class="{reverse: reverse}"></span>
                    </th>
                    <th ng-click="sortBy('gosNumber')">Гос. номер
                        <span class="sortorder" ng-class="{reverse: reverse}"></span>
                    </th>
                    <th ng-click="sortBy('yearMake')">Год выпуска
                        <span class="sortorder" ng-class="{reverse: reverse}"></span>
                    </th>
                    <th>Удаление</th>
                </tr>
            </thead>
            <tbody>
                <tr ng-repeat="car in cars | orderBy:propertyName:reverse">
                    <td scope="row">{{car.idCar}}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu+car.idCar" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                {{car.idDriver.idDriver}}
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu+car.idCar">
                                <li><a href="#">{{car.idDriver.surname}}</a></li>
                                <li><a href="#">{{car.idDriver.name}}</a></li>
                                <li><a href="#">{{car.idDriver.lastname}}</a></li>
                            </ul>
                        </div>
                    </td>
                    <td>{{car.marka}}</td>
                    <td>{{car.gosNumber}}</td>
                    <td>{{car.yearMake}}</td>
                    <td><input class="btn btn-default btn-md" type="button" ng-click="delCar(car.idCar)" value="Удалить"/></td>
                </tr>
            <tbody>
        </table>
        <input id="button" class="btn btn-default btn-md" type="button" ng-click="new()" value="Добавить машину" />
        <div id="newCar">
            <form role="form">
                <label>Выберете водителя:</label>
                <select class="form-control" name="drive" ng-model="dat.drive">
                    <option ng-repeat="driver in drivers" value="{{driver.idDriver}}">ID: {{driver.idDriver}}, {{driver.surname}} {{driver.name}}</option>
                </select>
                <label>Марка:</label>
                <input type="text" class="form-control input-md" ng-model="dat.marka" />
                <label>Гос. номер:</label>
                <input type="text" class="form-control input-md" ng-model="dat.gosNumber" />
                <label>Год выпуска:</label>
                <input type="text" class="form-control input-md" ng-model="dat.yearMake" /><br/>
                <input class="btn btn-default btn-md" type="button" ng-click="newCars()" value="OK" />
            </form>
        </div>
    </div>

    <div class="tab-pane" id="listDriver">
        <table class="table table-hover">
            <thead>
            <tr>
                <th ng-click="sortBy('idDriver')">ID водителя
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th ng-click="sortBy('name')">Имя
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th ng-click="sortBy('surname')">Фамилия
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th ng-click="sortBy('lastname')">Отчество
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th ng-click="sortBy('age')">Возраст
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th ng-click="sortBy('main')">Почта
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="driver in drivers | orderBy:propertyName:reverse">
                <td scope="row">{{driver.idDriver}}</td>
                <td>{{driver.name}}</td>
                <td>{{driver.surname}}</td>
                <td>{{driver.lastname}}</td>
                <td>{{driver.age}}</td>
                <td>{{driver.main}}</td>
            </tr>
            <tbody>
        </table>
    </div>

    <div class="tab-pane" id="masters">
        <table class="table table-hover">
            <thead>
            <tr>
                <th ng-click="sortBy('idPark')">ID
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th ng-click="sortBy('idCar')">ID машины
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th ng-click="sortBy('countTrip')">Количество поездок <br/>после ремонта
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th ng-click="sortBy('countRepair')">Количество ремонтов
                    <span class="sortorder" ng-class="{reverse: reverse}"></span>
                </th>
                <th>Отправить в поезку</th>
                <th>Отремонтировать машину</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="park in parks | orderBy:propertyName:reverse">
                <td scope="row">{{park.idPark}}</td>
                <td>
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu+park.idPark+10" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            {{park.idCar.idCar}}
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu+park.idPark+10">
                            <li><a href="#">{{park.idCar.marka}}</a></li>
                            <li><a href="#">{{park.idCar.gosNumber}}</a></li>
                            <li><a href="#">{{park.idCar.yearMake}} год выпуска</a></li>
                        </ul>
                    </div>
                </td>
                <td>{{park.countTrip}}</td>
                <td>{{park.countRepair}}</td>
                <td><input class="btn btn-default btn-md" type="button" ng-click="out(park.idPark)" ng-disabled="park.countTrip >= 5" value="Отправить"/></td>
                <td><input class="btn btn-default btn-md" type="button" ng-click="repairs(park.idPark)" value="Отремонтировать"/></td>
            </tr>
            <tbody>
        </table>
    </div>

    <div class="tab-pane" id="private">
        <div id="infoUser">
            <h2>Личные данные:</h2>
            <span class="label label-info lb-lg">Логин: {{current.login}}</span> <br/><br/>
            <span class="label label-info lb-lg">Имя: {{currentDriver.name}}</span> <br/><br/>
            <span class="label label-info lb-lg">Фамиия: {{currentDriver.surname}}</span> <br/><br/>
            <span class="label label-info lb-lg">Отчество: {{currentDriver.lastname}}</span> <br/><br/>
            <span class="label label-info lb-lg">Возраст: {{currentDriver.age}}</span> <br/><br/>
            <span class="label label-info lb-lg">Почта: {{currentDriver.main}}</span> <br/><br/>
            <input class="btn btn-default btn-lg" type="button" ng-click="logout()" value="Выйти" />
        </div>
    </div>
</div>
</div>

</body>
</html>
