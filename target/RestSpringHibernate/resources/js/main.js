var mainApp = angular.module('mainApp', []);
mainApp.controller('mainCtrl', function ($scope, $http, $browser){

    $scope.current = JSON.parse(localStorage.getItem("currentUser"));

    $http.get('/autopark/cars.json').success(function(data) {
        $scope.cars = data;
        var id = 0;
        for(var i in data) {
            if(data[i].idCar > id) {
                id = data[i].idCar;
            }
        }
        $scope.id = id;
    });

    $scope.new = function() {
        $http.get('/autopark/drivers.json').success(function(data) {
            $scope.drivers = data;
            for(var i in $scope.drivers) {
                if($scope.drivers[i].idUser.idUser == $scope.current.idUser) {
                    $scope.currentDriver = $scope.drivers[i];
                }
            }
        });
    };

    $scope.repair = function() {
        $http.get('/autopark/parks.json').success(function(data) {
            $scope.parks = data;
        });
    };

    function user(driverID) {
        for(var i in $scope.cars) {
            if($scope.cars[i].idDriver.idDriver == driverID) {
                return i;
            }
        }
    }


    function park(current) {
        var jsonAnswer = JSON.stringify({
            idCar: {
                idCar: $scope.id,
                idDriver: {
                    idDriver: $scope.cars[current].idDriver.idDriver,
                    idUser: {
                        idUser: $scope.cars[current].idDriver.idUser.idUser,
                        login: $scope.cars[current].idDriver.idUser.login,
                        password: $scope.cars[current].idDriver.idUser.password
                    },
                    name: $scope.cars[current].idDriver.name,
                    surname: $scope.cars[current].idDriver.surname,
                    lastname: $scope.cars[current].idDriver.lastname,
                    age: $scope.cars[current].idDriver.age,
                    main: $scope.cars[current].idDriver.main
                },
                marka: $scope.dat.marka,
                gosNumber: $scope.dat.gosNumber,
                yearMake: +$scope.dat.yearMake
            },
            countTrip: 0,
            countRepair: 0,
            access: 1
        });

        console.log(jsonAnswer);
        $http.post('/autopark/park', jsonAnswer).success(function(data) {
        });
    }


    $scope.dat = {};
    $scope.newCars = function() {
        var current = user($scope.dat.drive);
        var jsonAnswer = JSON.stringify({
            idDriver: {
                idDriver: $scope.cars[current].idDriver.idDriver,
                idUser: {
                    idUser: $scope.cars[current].idDriver.idUser.idUser,
                    login: $scope.cars[current].idDriver.idUser.login,
                    password: $scope.cars[current].idDriver.idUser.password
                },
                name: $scope.cars[current].idDriver.name,
                surname: $scope.cars[current].idDriver.surname,
                lastname: $scope.cars[current].idDriver.lastname,
                age: $scope.cars[current].idDriver.age,
                main: $scope.cars[current].idDriver.main
            },
            marka: $scope.dat.marka,
            gosNumber: $scope.dat.gosNumber,
            yearMake: +$scope.dat.yearMake
        });

        $scope.id += 1;
        var jsonAns = {
            idCar: $scope.id,
            idDriver: {
                idDriver: $scope.cars[current].idDriver.idDriver,
                idUser: {
                    idUser: $scope.cars[current].idDriver.idUser.idUser,
                    login: $scope.cars[current].idDriver.idUser.login,
                    password: $scope.cars[current].idDriver.idUser.password
                },
                name: $scope.cars[current].idDriver.name,
                surname: $scope.cars[current].idDriver.surname,
                lastname: $scope.cars[current].idDriver.lastname,
                age: $scope.cars[current].idDriver.age,
                main: $scope.cars[current].idDriver.main
            },
            marka: $scope.dat.marka,
            gosNumber: $scope.dat.gosNumber,
            yearMake: +$scope.dat.yearMake
        };

        $scope.cars.splice(-1, 0, jsonAns);
        console.log(jsonAnswer);
        $http.post('/autopark/car', jsonAnswer).success(function(data) {
            alert('Добавлено!');
            park(current);
        });

        $scope.dat.marka = '';
        $scope.dat.gosNumber = '';
        $scope.dat.yearMake = '';
        $('#newCar').hide();

    };

    $scope.propertyName = 'idCar';
    $scope.reverse = false;
    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };

    $scope.delCar = function(idCar) {
        var j;
        for(var i in $scope.cars) {
            if($scope.cars[i].idCar == idCar) {
                j = i;
            }
        }
        $scope.cars.splice(j, 1);
        $http.delete('/autopark/car/' + idCar).success(function(data) {
        });
    };


    $scope.out = function(idPark) {
        var j;
        for(var i in $scope.parks) {
            if($scope.parks[i].idPark == idPark) {
                j = i;
            }
        }

        var access = 1;
        if(+$scope.parks[j].countTrip + 1 < 5) {
            access = 0;
        }


        var jsonAnswer = JSON.stringify({
            idPark: idPark,
            idCar: {
                idCar: $scope.parks[j].idCar.idCar,
                idDriver: {
                    idDriver: $scope.parks[j].idCar.idDriver.idDriver,
                    idUser: {
                        idUser: $scope.parks[j].idCar.idDriver.idUser.idUser,
                        login: $scope.parks[j].idCar.idDriver.idUser.login,
                        password: $scope.parks[j].idCar.idDriver.idUser.password
                    },
                    name: $scope.parks[j].idCar.idDriver.name,
                    surname: $scope.parks[j].idCar.idDriver.surname,
                    lastname: $scope.parks[j].idCar.idDriver.lastname,
                    age: $scope.parks[j].idCar.idDriver.age,
                    main: $scope.parks[j].idCar.idDriver.main
                },
                marka: $scope.parks[j].idCar.marka,
                gosNumber: $scope.parks[j].idCar.gosNumber,
                yearMake: $scope.parks[j].idCar.yearMake
            },
            countTrip: $scope.parks[j].countTrip + 1,
            countRepair: $scope.parks[j].countRepair,
            access: access
        });

        console.log(jsonAnswer);
        $http.put('/autopark/park/' + idPark, jsonAnswer).success(function(data) {
            alert("Изменено!")
        });

        $scope.parks[j].countTrip += 1;
    };


    $scope.repairs = function(idPark) {
        var j;
        for(var i in $scope.parks) {
            if($scope.parks[i].idPark == idPark) {
                j = i;
            }
        }

        var jsonAnswer = JSON.stringify({
            idPark: idPark,
            idCar: {
                idCar: $scope.parks[j].idCar.idCar,
                idDriver: {
                    idDriver: $scope.parks[j].idCar.idDriver.idDriver,
                    idUser: {
                        idUser: $scope.parks[j].idCar.idDriver.idUser.idUser,
                        login: $scope.parks[j].idCar.idDriver.idUser.login,
                        password: $scope.parks[j].idCar.idDriver.idUser.password
                    },
                    name: $scope.parks[j].idCar.idDriver.name,
                    surname: $scope.parks[j].idCar.idDriver.surname,
                    lastname: $scope.parks[j].idCar.idDriver.lastname,
                    age: $scope.parks[j].idCar.idDriver.age,
                    main: $scope.parks[j].idCar.idDriver.main
                },
                marka: $scope.parks[j].idCar.marka,
                gosNumber: $scope.parks[j].idCar.gosNumber,
                yearMake: $scope.parks[j].idCar.yearMake
            },
            countTrip: 0,
            countRepair: $scope.parks[j].countRepair + 1,
            access: 1
        });

        console.log(jsonAnswer);
        $http.put('/autopark/park/' + idPark, jsonAnswer).success(function(data) {
        });

        $scope.parks[j].countTrip = 0;
        $scope.parks[j].countRepair += 1;
    };

    $scope.logout = function() {
        localStorage.removeItem("currentUser");
        $browser.url("/view/login.jsp");
    };

});