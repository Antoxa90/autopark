var loginApp = angular.module('loginApp', []);

loginApp.controller('loginCtrl', function ($scope, $http, $browser){
    $('#regForm').hide();
    $http.get('/autopark/users.json').success(function(data) {
        $scope.users = data;
    });

    $scope.message = '';
    $scope.user = {};
    $scope.loginUser = function() {
        for(var i in $scope.users) {
            if($scope.users[i].login === $scope.user.login) {
                if($scope.users[i].password === $scope.user.password) {
                    $scope.message = '';
                    alert("Вы топ!");
                    var currentUser = JSON.stringify({
                        idUser: $scope.users[i].idUser,
                        login: $scope.users[i].login,
                        password: $scope.users[i].password
                    });
                    localStorage.setItem("currentUser", currentUser);
                    $browser.url("/view/main.jsp");
                    break;
                }
                else {
                    $scope.message = 'Неверный логин/пароль!';
                }
            } else {
                $scope.message = 'Неверный логин/пароль!';

            }
        }

    };

    $scope.registUser = function() {
        $('#logForm').hide();
        $('#regForm').show();
    };

    $scope.enter = function() {
        $('#regForm').hide();
        $('#logForm').show();
    };

    $scope.reg = {};
    $scope.registration = function() {
        var id = 0;
        for(var i in $scope.users) {
            if($scope.users[i].idUser > id) {
                id = $scope.users[i].idUser;
            }
        }

        $scope.id = id + 1;

        var jsonAnswer = JSON.stringify({
            login: $scope.reg.login,
            password: $scope.reg.password
        });

        $http.post('/autopark/user', jsonAnswer).success(function(data) {

            var jsonAnswer2 = JSON.stringify({
                idUser: {
                    idUser: $scope.id,
                    login: $scope.reg.login,
                    password: $scope.reg.password
                },
                name: $scope.reg.name,
                surname: $scope.reg.surname,
                lastname: $scope.reg.lastname,
                age: $scope.reg.age,
                main: $scope.reg.mail
            });

            console.log(jsonAnswer2);

            var jsonAnswer3 = {
                idUser: $scope.id,
                login: $scope.reg.login,
                password: $scope.reg.password
            };

            $scope.users.splice(-1, 0, jsonAnswer3);

            $http.post('/autopark/driver', jsonAnswer2).success(function(data) {

            });
        });

        $('#regForm').hide();
        $('#logForm').show();

    };

});

