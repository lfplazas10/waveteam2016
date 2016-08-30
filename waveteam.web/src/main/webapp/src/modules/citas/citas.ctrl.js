/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng){
    var mod = ng.module("citasModule");
    mod.controller("citaCtrl", ['$scope', '$state', '$stateParams', '$http', 'citasContext', function ($scope, $state, $stateParams,$http, context ){
            $scope.records = {};
            $http.get(context).then(function(response){
                $scope.records = response.data;    
            }, responseError);
            
            if ($stateParams.citaId !== null && $stateParams.citaId !== undefined) {
                
                id = $stateParams = citaId;
                
                $http.get(context + "/" + id)
                    .then(function (response) {
                        $scope.currentRecord = response.data;
                    }, responseError);
            } 
    }])
})
