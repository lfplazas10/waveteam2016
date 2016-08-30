/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var mod = ng.module("citasModule", ["ui-router"]);

mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        $stateProvider.state('listaCitas', {
            url: "/listaCitas",views: {
                'mainView': {
                    controller: 'citasCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'citas.list.html'
                }
            }})
            
        .state('editCita', {
            url: "/editCita",
                views: {
                'mainView': {
                    controller: 'citasCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'citas.list.html'
                }
            }})
        .state('addCita', {
                        url: "/addCita",
                        templateUrl: basePath+"search.html",
                        controller: function ($scope) {
                            $scope.search = ["Por Id", "Por Día", "Por Doctor", "Por Paciente"];
                        }
                    });
}]);
        })(window.angular);