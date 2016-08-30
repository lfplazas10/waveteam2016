/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng){
    var mod = ng.module("consultorioModule", ['ui-router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
        var basePath = 'src/modules/consultorio/';
        $urlRouterProvider.otherwise("/");
        $stateProvider.state('getConsultorios',{
            url:"/consultorios",
            views: {
                'mainView':{
                    controller:'consultoriosCtrl',
                    controllerAs:'ctrl',
                    templateUrl:basePath+'consultorios.get.html'
                }
            }

        }).state('crearConsultorio',{
            url:"/consultorios/crear",
            views: {
                'mainView':{
                    controller:'consultoriosCtrl',
                    controllerAs:'ctrl',
                    templateUrl:basePath+'consultorios.create.html'
                }
            }
        }).state('actualizarConsultorio',{
            url:"/consultorios/actualizar",
            views: {
                'mainView':{
                    controller:'consultoriosCtrl',
                    controllerAs:'ctrl',
                    templateUrl:basePath+'consultorios.actualizar.html'
                }
            }
        });
    }]);

})(window.angular);