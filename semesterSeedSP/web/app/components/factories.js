'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', []).
        factory('InfoFactory', function ($http) {

            function bookFlight(bookingInfo){
                return $http.post("api/flightreservation", bookingInfo);
            };

            function getAllFlightsFrom(from, date, numTickets) {
                return $http.get('api/flightinfo/' + from + '/' + date + '/' + numTickets)
            };
            
            function getAllFlightsFromTo(from, to, date, numTickets) {
                return $http.get('api/flightinfo/' + from + '/' + to + '/' + date + '/' + numTickets)
            };
            
            return {
                getAllFlightsFrom: getAllFlightsFrom,
                getAllFlightsFromTo: getAllFlightsFromTo,
                bookFlight: bookFlight
            };

        });