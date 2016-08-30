/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
var mod = ng.module("doctorModule", ["ngMessages"]);
mod.constant("doctorContext", "api/doctors");

mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/doctors/';
        $urlRouterProvider.otherwise("/");
        $stateProvider
        .state('doctorsList', {
            url:"/doctorsList",
            views: {
                'mainView': {
                    controller: 'doctorsCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'doctors.list.html'
                }
            }
        })
        .state('editDoctor', {
            url:"/editDoctor",
            views: {
                'mainView': {
                    controller: 'doctorsCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'doctors.edit.html'
                }
            }
        })
         .state('addDoctor', {
            url:"/addDoctor",
            views: {
                'mainView': {
                    controller: 'doctorsCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'doctors.create.html'
                }
            }
        });
        }]);
        
})(window.angular);