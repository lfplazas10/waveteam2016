/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var mod = ng.module("citasModule", ["ui-router"]);

mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        $stateProvider.state('citas', {
            url: "/citas",
            templateUrl: basePath+"citas.html"
        })
        .state('business.search', {
                        url: "/search",
                        templateUrl: basePath+"search.html",
                        controller: function ($scope) {
                            $scope.search = ["Por Id", "Por Día", "Por Doctor", "Por Paciente"];
                        }
                    })
}]);