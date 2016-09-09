    /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng){
    var mod = ng.module("citasModule");
    var citaElim = -1;
    mod.controller("citasCtrl", ['$scope', '$state', '$stateParams', '$http', 'citasContext', function ($scope, $state, $stateParams,$http, context ){
            load = function(){
            $http.get(context).then(function(response){
                $scope.citas = response.data;  
                 console.log(response.data);
            }, responseError);
        }
            
            load();
            
            this.deleteRecord = function(cita){
                return $http.delete(context+"/"+cita.id)
                        .then(function(){
                            load();
                }, responseError)
            }
            
            this.saveCita = function(){
                if(!$scope.id || !$scope.fecha || !$scope.hora || !$scope.duracion || !$scope.idMedico || !$scope.idPaciente) alert ("No puede dejar ningún campo vacio.");
                if (isNaN($scope.fecha)) alert("La fecha debe ser numérica.");
                if (isNaN($scope.hora)) alert("La Hora debe ser numérica.");
                if (isNaN($scope.duracion)) alert("La Duración debe ser numérica.");
                if (isNaN($scope.cedula)) alert("La cédula debe ser numérica.");
                else{
                    var cita = {
                        "id" :  $scope.id,    
                        "fecha" : $scope.fecha,      
                        "hora" : $scope.hora,        
                        "duracion" : $scope.duracion,
                        "idMedico": $scope.idMedico,
                        "idPaciente":$scope.idPaciente
                    };
                    cita = JSON.stringify(cita);
                    console.log(cita);
                    return $http.post(context, cita.toString())
                            .then(function(){
                                $state.go('listaCitas');
                    }, responseError)
                }
                
            }
            
            this.editCita = function(cita){
                $state.got('editCita');
                citaElim = cita.id;
                $scope.tit = "Editar " + cita.id;
            }
            
            this.editCitaFinal = function () {
                if (!$scope.id || !$scope.fecha || !$scope.hora || !$scope.duracion || !$scope.idMedico || !$scope.idPaciente ) alert("No puede dejar ningún campo vacio.");
                if (isNaN($scope.fecha)) alert("La fecha debe ser numérica.");
                if (isNaN($scope.hora)) alert("La hora debe ser un numérica.");
                if (isNaN($scope.duracion)) alert("La duracion debe ser numérica.");
              
                else{
                    var cita = 
                    {
                        "id" :  $scope.id,    
                        "fecha" : $scope.fecha,      
                        "hora" : $scope.hora,    
                        "duracion" : $scope.duracion,
                        "idMedico" : $scope.idMedico,
                        "idPaciente" : $scope.idPaciente
                    };
                    doc = JSON.stringify(cita);
                    console.log(cita);
                    return $http.put(context+"/"+citaElim, cita.toString())
                        .then(function () {
                            $state.go('listaCitas');
                        }, responseError)
                }
            } 
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
