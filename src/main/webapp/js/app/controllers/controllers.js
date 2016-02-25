/**
 * Created by C on 2016-02-21.
 */
angular.module('bsseApp.controllers').controller('Controller', Controller);
Controller.$inject = ['$scope', '$http', 'NgTableParams', '$log'];
function Controller($scope, $http, NgTableParams, $log) {
    $log.debug('Controller created!');

    $scope.evaluatorsTable = new NgTableParams({
        // parameters
    }, {
        counts: [],
        // settings
        getData: function ($defer, params) {
            $http.get('rest/evaluators').then(function success(response) {
                $log.debug('Got your evaluators!', response.data);
                return $defer.resolve(response.data);
            }, function failure(response) {
                $log.error("Can't get evaluators");
            });
        }
    })
}

angular.module('bsseApp.controllers').controller('HomeController', HomeController);
HomeController.$inject = ['$log', '$scope'];
function HomeController($log, $scope) {
    $log.debug('HomeController created');

}

angular.module('bsseApp.controllers').controller('LoginController', LoginController);
LoginController.$inject = ['$log', '$scope'];
function LoginController($log, $scope) {
    $log.debug('LoginController created');
}

angular.module('bsseApp.controllers').controller('CandidatesController', CandidatesController);
CandidatesController.$inject = ['$log', '$scope', 'NgTableParams','$http'];
function CandidatesController($log, $scope, NgTableParams, $http) {
    $log.debug('CandidatesController created');
    $scope.candidatesTable = new NgTableParams({}, {
        getData: function ($defer, params) {
            $http.get('rest/candidates').then(function (successCallback) {
                $log.info('Successfully loaded candidates from backend.');
                var data = successCallback.data;
                $defer.resolve(data);
            }, function (failureCallback) {
                $log.error('Could not retrieve candidates from backend.', failureCallback.status, failureCallback.statusText);
            })
        }
    })
}

angular.module('bsseApp.controllers').controller('EvaluateController', EvaluateController);
EvaluateController.$inject = ['$log', '$scope', '$stateParams'];
function EvaluateController($log, $scope, $stateParams) {
    $log.debug('EvaluateController created for candidate', $stateParams.    candidateId);
}
