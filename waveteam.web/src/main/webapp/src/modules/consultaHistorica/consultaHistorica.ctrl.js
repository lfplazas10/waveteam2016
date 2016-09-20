/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("consultaHistoricaModule");

    mod.controller("consultaHistoricaCtrl", ['$scope', '$state', '$stateParams', '$http', 'consultaHistoricaContext', function ($scope, $state, $stateParams, $http, context) {

            $scope.records = [];
            $http.get(context).then(function(response){
                $scope.records = response.data;    
            }, responseError);


            if ($stateParams.especialidad.nombre !== null && $stateParams.especialidad.nombre !== undefined) {
                especialidad = $stateParams.especialidad;
                
                $http.get(context + "/" + especialidad.nombre)
                    .then(function (response) {
                        $scope.currentRecord = response.data;
                    }, responseError);
            } 
            else
            {
                $scope.currentRecord = {
                    especialidad: undefined ,
                    numeroDoctores: '',
                    numeroCitas: '',
                    promedioDuracion: '',
                    citasLibres: '',
                    citasCanceladas: '',
                    citasTerminadas: ''
                };
              
                $scope.alerts = [];
            }


            this.saveRecord = function (especialidad) {
                currentRecord = $scope.currentRecord;
                
                if (especialidad==null) {  
                    return $http.post(context, especialidad)
                        .then(function () {
                            $state.go('especialidadList');
                        }, responseError);
                } 
                else {
                    return $http.put(context + "/" + especialidad.nombre, especialidad)
                        .then(function () {
                            $state.go('especialidadList');
                        }, responseError);
                };
            };
            



            // -----------------------------------------------------------------
            // Funciones para manejra los mensajes en la aplicación


            //Alertas
            this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };
            
            function showMessage(msg, type) {
                var types = ["info", "danger", "warning", "success"];
                if (types.some(function (rc) {
                    return type === rc;
                })) {
                    $scope.alerts.push({type: type, msg: msg});
                }
            }

            this.showError = function (msg) {
                showMessage(msg, "danger");
            };

            this.showSuccess = function (msg) {
                showMessage(msg, "success");
            };

            var self = this;
            function responseError(response) {

                self.showError(response.data);
            }
        }]);

})(window.angular);

