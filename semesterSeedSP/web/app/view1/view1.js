'use strict';

angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'app/view1/view1.html',
                    controller: 'View1Ctrl',
                    controllerAs: 'ctrl'
                });
            }])

        .controller('View1Ctrl', function ($http, $scope) {

            $scope.flightsFrom = [];
            $scope.depDate = '';
            $scope.flyFrom = '';
            $scope.flyTo = '';
            $scope.seats = '';

            //                        var preparedURL = 'api/flightinfo/' + $scope.flyFrom + '/' + $scope.depDate + '/' + $scope.seats;
            //

            $scope.getflightskurwa = function() {

                var preparedURL = 'http://angularairline-plaul.rhcloud.com/api/flightinfo/CPH/2016-01-03T00:00:00.000Z/2';
                $http({
                    method: 'GET',
                    url: preparedURL
                }).then(function successCallback(response) {
                    $scope.flightsFrom = response.data;
                }, function errorCallback(response) {

                });
            }


        });