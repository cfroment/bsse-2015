/**
 * Created by C on 2016-02-21.
 */
angular.module('bsseApp.controllers').controller('Controller', Controller);
Controller.$inject = ['$scope', '$http', 'NgTableParams', '$log'];
function Controller($scope, $http, NgTableParams, $log) {
    $log.info('Controller created!');

    $scope.evaluatorsTable = new NgTableParams({
        // parameters
    }, {
        counts: [],
        // settings
        getData: function ($defer, params) {
            $http.get('rest/evaluators').then(function success(response) {
                $log.info('Got your evaluators!', response.data);
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
    $log.info('HomeController created');

}
