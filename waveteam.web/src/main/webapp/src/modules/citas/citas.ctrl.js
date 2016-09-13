    /* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng){
    var mod = ng.module("citasModule");
    
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
                if(!$scope.id || !$scope.fecha || !$scope.hora || !$scope.duracion || !$scope.medico || !$scope.paciente) alert ("No puede dejar ningún campo vacio.");
                
                if (isNaN($scope.hora)) alert("La Hora debe ser numérica.");
                if (isNaN($scope.duracion)) alert("La Duración debe ser numérica.");
                 
                else{
                    console.log($scope.idMedico + " : " + $scope.idPaciente)
                    var cita = {
                        "id" :  $scope.id,    
                        "fecha" : $scope.fecha,      
                        "hora" : $scope.hora,        
                        "duracion" : $scope.duracion,
                        "medico": $scope.medico,
                        "paciente": $scope.paciente
                    };
                    cita = JSON.stringify(cita);
                    console.log(cita);
                    return $http.post(context, cita.toString())
                            .then(function(){
                                $state.go('listaCitas');
                    }, responseError)
                }
                
            }
            
           
            this.editCitaFinal = function () {
                if (!$scope.id || !$scope.fecha || !$scope.hora || !$scope.duracion || !$scope.medico || !$scope.paciente ){
                    alert("No puede dejar ningún campo vacio.");
                    return;
                }
                if (isNaN($scope.fecha)){
                    alert("La fecha debe ser numérica.");
                    return;
                }
                if (isNaN($scope.hora)){
                    alert("La hora debe ser un numérica.");
                    return;
                }
                if (isNaN($scope.duracion)){
                    alert("La duracion debe ser numérica.");
                    return;
                }
              
                else{
                    console.log("Se va a editar la cita" + $scope.id);
                    var cita = 
                    {
                        "id" :  $scope.id,    
                        "fecha" : $scope.fecha,      
                        "hora" : $scope.hora,    
                        "duracion" : $scope.duracion,
                        "medico" : $scope.medico,
                        "paciente" : $scope.paciente
                    };
                    cita = JSON.stringify(cita);
                    console.log(cita);
                    return $http.put(context+"/"+$stateParams.citaId, cita.toString())
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
