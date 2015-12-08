'use strict';

angular.module('myApp.view6', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view6', {
                    templateUrl: 'app/view6/view6.html',
                    controller: 'View6Ctrl'
                });
            }])

        .controller('View6Ctrl', function ($http, $scope) {

            $scope.newuser = {};
            $scope.newuser.firstname = "";
            $scope.newuser.lastname = "";
            $scope.newuser.email = "";
            $scope.newuser.username = "";
            $scope.newuser.password = "";

            $scope.isSignedUp = false;

            $scope.registerUser = function () {

                $scope.newuser = {
                    firstname: $scope.newuser.firstname,
                    lastname: $scope.newuser.lastname,
                    email: $scope.newuser.email,
                    username: $scope.newuser.username,
                    password: $scope.newuser.password
                };
                var jsonUser = JSON.stringify($scope.newuser);
                $http.post('api/register', jsonUser)
                        .success(function (data, status, headers, config) {
                            $scope.isSignedUp = true;
                            $scope.data = data;
                        })
                        .error(function (data, status, headers, config) {
                            alert("error");
                            //$scope.isSignedUp = false;
                        });
                $scope.newuser.firstname = "";
                $scope.newuser.lastname = "";
                $scope.newuser.email = "";
                $scope.newuser.username = "";
                $scope.newuser.password = "";
                $scope.isSignedUp = false;
            };
        });