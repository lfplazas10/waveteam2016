(function (ng) {
    var mod = ng.module("patientModule");
    var docIdDeleted = -1;
    mod.controller("patientCtrl", ['$scope', '$state', '$stateParams', '$http', 'patientContext', function ($scope, $state, $stateParams, $http, context){

           loadDocs = function (){
                $http.get(context).then(function(response){
                    $scope.patient = response.data;    
                    }, responseError);
            }
            
            loadDocs();

            this.deleteRecord = function (ptn){
                return $http.delete(context+"/"+ptn.id)
                        .then(function () {
                            loadDocs();
                        }, responseError)
            }
            
            this.savePatient = function () {
                if (!$scope.nombre || !$scope.id || !$scope.sexo || !$scope.edad || !$scope.tipoSangre || !$scope.eps ) alert("No puede dejar ningún campo vacio.");
                if (isNaN($scope.documento)) alert("La cédula debe ser numérica.");
                if (isNaN($scope.edad)) alert("La edad debe ser un numérica.");
                if (isNaN($scope.sexo)) alert("El sexo no puede ser numérico.");
                if (isNaN($scope.tipoSangre)) alert("El tipo de Sangre no puede ser numérico.");
                if (isNaN($scope.eps)) alert("La EPS no puede ser numérica.");
                
                else{
                    var ptn = 
                    {
                        "name" :  $scope.nombre,    
                        "id" : $scope.documento,      
                        "edad" : $scope.edad,    
                        "sexo" : $scope.sexo,
                        "tipoSangre" : $scope.tipoSangre,
                        "eps" : $scope.eps
                    };
                    ptn = JSON.stringify(ptn);
                    console.log(ptn);
                    return $http.post(context, ptn.toString())
                        .then(function () {
                            $state.go('patientList');
                        }, responseError)
                }
            }
            
            this.editPatient = function(ptn) {
                $state.go('editPatient');
                patientIdDeleted = ptn.id;
                $scope.tit = "Editar " + ptn.name;
            }
            
            this.editFinalPatient = function () {
                if (!$scope.nombre || !$scope.id || !$scope.sexo || !$scope.edad || !$scope.tipoSangre || !$scope.eps ) alert("No puede dejar ningún campo vacio.");
                if (isNaN($scope.documento)) alert("La cédula debe ser numérica.");
                if (isNaN($scope.edad)) alert("La edad debe ser un numérica.");
                if (isNaN($scope.sexo)) alert("El sexo no puede ser numérico.");
                if (isNaN($scope.tipoSangre)) alert("El tipo de Sangre no puede ser numérico.");
                if (isNaN($scope.eps)) alert("La EPS no puede ser numérica.");
                else{
                    var ptn = 
                    {
                        "name" :  $scope.nombre,    
                        "id" : $scope.documento,      
                        "edad" : $scope.edad,    
                        "sexo" : $scope.sexo,
                        "tipoSangre" : $scope.tipoSangre,
                        "eps" : $scope.eps
                    };
                    ptn = JSON.stringify(ptn);
                    console.log(ptn);
                    return $http.put(context+"/"+ptnIdDeleted, ptn.toString())
                        .then(function () {
                            $state.go('patientList');
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