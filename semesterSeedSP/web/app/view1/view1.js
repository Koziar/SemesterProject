'use strict';

angular.module('myApp.view1', ['ngRoute'])
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'app/view1/view1.html',
                    controller: 'View1Ctrl',
                    controllerAs: 'ctrl'
                });
            }])
        .controller('View1Ctrl', function ($http, $scope, InfoFactory) {

            $scope.flights = [];
            $scope.depDate = new Date();
            $scope.flyFrom = '';
            $scope.flyTo = '';
            $scope.seats = 0;

            $scope.showSpinner = false;
            $scope.isError = false;
            $scope.errorMessage = "";

            $scope.searchFlights = function () {

                if ($scope.flyTo == '') {
                    $scope.getAllFlightsFrom();
                } else {
                    $scope.getAllFlightsFromTo();
                }
            };

            $scope.getAllFlightsFrom = function () {
                $scope.showSpinner = true;
                $scope.isError = false;
                $scope.flights = [];//clear the flights

                //convert the data 
                var year = $scope.depDate.getFullYear();
                var month = $scope.depDate.getMonth();
                var day = $scope.depDate.getDate();

                var rawDate = new Date(year, month, day, 24);

                var dateJSON = JSON.stringify(rawDate);//Convert into a JSON-string
                var dateStr = JSON.parse(dateJSON);//Convert back into JavaScript

                InfoFactory.getAllFlightsFrom($scope.flyFrom, dateStr, $scope.seats)

                        .then(function (response) {

                            if (response.status != 200) {
                                //show the error bar
                                $scope.isError = true;
                                //get the error message from the server Response
                                $scope.errorMessage = response.data.message;
                            } else {
                                //take all the flight data
                                $scope.flights = response.data;
                            }
                            $scope.showSpinner = false;//hide the spinner after gettting the flights
                        }, function (error) {
                        });
            };
            $scope.getAllFlightsFromTo = function () {
                $scope.showSpinner = true;
                $scope.isError = false;//hide the error bar
                $scope.flights = [];//clear the flights

                //convert the data 
                var year = $scope.depDate.getFullYear();
                var month = $scope.depDate.getMonth();
                var day = $scope.depDate.getDate();

                var rawDate = new Date(year, month, day, 1);

                var dateJSON = JSON.stringify(rawDate);//Convert into a JSON-string
                var dateStr = JSON.parse(dateJSON);//Convert back into JavaScript

                InfoFactory.getAllFlightsFromTo($scope.flyFrom, $scope.flyTo, dateStr, $scope.seats)

                        .then(function (response) {
                            if (response.status != 200) {
                                $scope.isError = true;
                                $scope.errorMessage = response.data.message;
                            } else {
                                $scope.flights = response.data;
                            }
                            $scope.showSpinner = false;
                        }, function (error) {
                        });
            };
        });