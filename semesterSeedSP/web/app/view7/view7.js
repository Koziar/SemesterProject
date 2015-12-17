'use strict';

angular.module('myApp.view7', ['ngRoute'])
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view7/:flight', {
                    templateUrl: 'app/view7/view7.html',
                    controller: 'View7Ctrl',
                    controllerAs: 'ctrl'
                });
            }])
        .controller('View7Ctrl', function ($http, $scope, $routeParams, InfoFactory) {

            $scope.selectedFlight = JSON.parse($routeParams.flight);
          $scope.isAuthenticated = false;
            $scope.isError = false;
            $http({
                method: 'GET',
                url: 'api/demouser'
            }).then(function successCallback(res) {
                $scope.data = res.data.message;
                $scope.isAuthenticated = true;
            }, function errorCallback(res) {
                $scope.isAuthenticated = false;
                $scope.isError = true;
                $scope.errorMessage = "Please sign in before you book!";
            });
            $scope.isError = false;

            //$scope.flightId = $routeParams.flight.flightId;

            $scope.booking = {};
            $scope.booking.passengers = [];
            $scope.isPassengerCreated = true;//show or hide the passenger details form
            $scope.showPassengers = false;//show or hide the passenders table
            $scope.isOverview = false;//show or hide the overview div
            $scope.reservationConfirmation = {};
            $scope.finalPrice = 0;
            $scope.isReservationSuccessfull = false;
            //=====================================================================
            $scope.confirmBooking = function () {

                var bookingInfo = JSON.stringify($scope.booking);//create a JSON object of the booking data

                InfoFactory.bookFlight(bookingInfo)
                        .then(function (response) {

                            if (response.status == 200) {
                                $scope.isReservationSuccessfull = true;
                                $scope.reservationConfirmation = response.data;
                                console.log(reservationConfirmation);
                            }else{
                                $scope.isError = true;
                                $scope.errorMessage = response.data.message;
                            }
                        }, function (error) {});
            };
            //=====================================================================
//=========================================================================================
            $scope.showPassengerDetailsForm = function () {
                $scope.isPassengerCreated = false;
            }
//=============================================================================================
            //add new passenger
            $scope.addPassenger = function () {

//            $scope.booking.passenger = {};
                var newPassengerFirstName = $scope.booking.passenger.firstName;
                var newPassengerLastName = $scope.booking.passenger.lastName;

                var newPassenger = {
                    firstName: newPassengerFirstName,
                    lastName: newPassengerLastName
                };

                $scope.booking.passengers.push(newPassenger);
                $scope.isPassengerCreated = true;
                $scope.showPassengers = true;
            };
//========================================================================================            
            //show the overview of the booking info
            $scope.continueBooking = function () {
                $scope.isOverview = true;
                $scope.finalPrice = (($scope.selectedFlight.totalPrice) * ($scope.booking.passengers.length));
                //holds all the booking information
                $scope.booking = {
                    flightID: $scope.selectedFlight.flightId,
                    airline: $scope.selectedFlight.airline,
                    flightDate: $scope.selectedFlight.flightDate,
                    numberOfSeats: $scope.booking.passengers.length,
                    totalPrice: $scope.finalPrice,
                    travelTime: $scope.selectedFlight.travelTime,
                    origin: $scope.selectedFlight.origin,
                    destination: $scope.selectedFlight.destination,
                    ReserveeName: $scope.booking.reserveename,
                    ReserveeEmail: $scope.booking.reserveeemail,
                    ReserveePhone: $scope.booking.reserveephone,
                    Passengers: $scope.booking.passengers
                };
            };
        });