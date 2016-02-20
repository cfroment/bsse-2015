/**
 * Created by BE07336 on 28-avril-15.
 */
var app = angular.module('bsse.controllers', []);

app.controller('IndexController', ['$scope', '$http', function ($scope, $http) {

}]);

app.controller('CandidatesController', ['$scope', '$http', function ($scope, $http) {

    $scope.loadCandidates = function () {
        $http.get('rest/candidates/all')
            .success(function (data, status, headers, config) {
                console.log("Trying to get candidates.");
                $scope.candidates = data;
            })
            .error(function (data, status, headers, config) {
                alert('Error loading candidates!');
            })
    }
}]);

app.controller('LoginController', ['$scope', '$http', function ($scope, $http) {
    $scope.login = function ($credentials) {
        console.log("Function login called with " + $credentials.userName + " " + $credentials.password);
        var postData = {"email": $credentials.userName, "password": $credentials.password};
        console.log(postData);
        $scope.returnedData = $http.post('rest/login', postData)
            .success(function (data, status, headers, config) {
                console.log('Login success, data returne: ' + data);
            })
            .error(function (data, status, headers, config) {
                console.log('Login failure: ' + status);
            })
    }
}]);

app.controller('EvaluationController', ['$scope', '$http', function ($scope, $http) {

    $scope.loadEvaluations = function () {
        $http.get('rest/evaluation/')
    }

}]);