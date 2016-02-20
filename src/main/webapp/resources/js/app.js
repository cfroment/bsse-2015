/**
 * Created by BE07336 on 29-avril-15.
 */

angular.module('bsse', ['ngRoute', 'bsse.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/login', {templateUrl: 'login.xhtml', controller: 'LoginController'})
            .when('/index', {templateUrl: 'home.xhtml', controller: 'IndexController'})
            .when('/candidates', {templateUrl: 'candidates.xhtml', controller: 'CandidatesController'})
            .when('/evaluation/:evaluatorId/:candidateId', {
                templateUrl: 'evaluate.xhtml',
                controller: 'EvaluationController'
            })
            .otherwise({templateUrl: 'home.xhtml', controller: 'IndexController'})
    }]);
