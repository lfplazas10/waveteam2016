/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var mod = ng.module("doctorModule", ["ui-router"]);

mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
$stateProvider
        .state('doctors', {
            url:"/doctors",
            templateUrl: basePath+"doctors.html",
        })
         .state('doctors.smthng', {
            url:"/doctors",
            templateUrl: basePath+"doctors.html",
            controller: function ($scope){
                
            }
        });
        

}]);