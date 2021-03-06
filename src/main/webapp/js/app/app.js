var bsseApp = angular.module('bsseApp', [
    'ngTable',
    'ui.router',
    'ui.bootstrap'
]).config(['$stateProvider', '$urlRouterProvider', '$locationProvider', router]);


function router($stateProvier, $urlRouterProvider, $locationProvider) {
    $urlRouterProvider.otherwise('/home');
    //$locationProvider.html5Mode(true);
    $stateProvier
        .state('home', {
            url: '/home',
            templateUrl: 'views/home.html',
            controller: HomeController
        })
        .state('login', {
            url: '/login',
            templateUrl: 'views/login.html',
            controller: LoginController
        })
        .state('evaluators', {
            url: '/evaluators',
            templateUrl: "views/evaluators.html",
            controller: Controller
        })
        .state('candidates',{
            url:'/candidates',
            templateUrl:'views/candidates.html',
            controller: CandidatesController
        })
        .state('evaluation.candidate', {
            url: '/evaluate/:candidateId',
            templateUrl: 'views/evaluate.html',
            controller: EvaluateController,
        });
}

angular.module("bsseApp.controllers", []);
angular.module("bsseApp.services", []);
angular.module("bsseApp.directives", []);
angular.module("bsseApp.filters", []);
