'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', []).
        factory('InfoFactory', function ($http) {

            var flights = {};

            function getAllFlightsFrom(from, date, numTickets) {

                return $http.get('api/flightinfo/' + from + '/' + date + '/' + numTickets)

//                        .then(function (response) {
//                            flights = response;
//                            return flights;
//                        }, function (error) {
//
//                            console.log("Error in InfoFactory while getAllFlightsFrom(from, date, numTickets)");
//                        });
            };
            function getAllFlightsFromTo(from, to, date, numTickets) {

                return $http.get('api/flightinfo/' + from + '/' + to + '/' + date + '/' + numTickets)

//                        .then(function (response) {
//                            flights = response;
//                            return flights;
//
//                        }, function (error) {
//
//                            console.log("Error in InfoFactory while getAllFlightsFromTo(from, to, date, numTickets)");
//                        });
            };
            return {
                getAllFlightsFrom: getAllFlightsFrom,
                getAllFlightsFromTo: getAllFlightsFromTo
            };


        });