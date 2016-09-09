/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
var mod = ng.module("citasModule", ["ngMessages"]);
mod.constant("citasContext", "api/citas");

mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/citas/'; 
        $urlRouterProvider.otherwise("/");
        $stateProvider
        .state('listaCitas', {
            url: '/listaCitas',
            views: {
                'mainView': {
                    controller: 'citasCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'citas.list.html'
                }
            }})
            
        .state('editCita', {
            url: "/editCita",
            param: {'citaId':null},
            views: {
                'mainView': {
                    controller: 'citasCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'citas.edit.html'
                }
            }})
        .state('addCita', {                   
        
                        url: "/addCita", views: {
                        'mainView':{
                        controller:'citasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+"citas.create.html"
                        
                            
                    }}});
                    
       
}]);
        })(window.angular);