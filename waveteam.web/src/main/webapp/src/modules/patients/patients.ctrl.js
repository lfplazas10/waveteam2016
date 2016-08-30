(function (ng) {
    var mod = ng.module("patientModule");
    var docIdDeleted = -1;
    mod.controller("patientsCtrl", ['$scope', '$state', '$stateParams', '$http', 'patientContext', function ($scope, $state, $stateParams, $http, context) {

           loadDocs = function (){
                $http.get(context).then(function(response){
                    $scope.patients = response.data;    
                    }, responseError);
            }
            
            loadDocs();

            this.deleteRecord = function (doc){
                return $http.delete(context+"/"+doc.id)
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
                    var doc = 
                    {
                        "name" :  $scope.nombre,    
                        "id" : $scope.documento,      
                        "edad" : $scope.edad,    
                        "sexo" : $scope.sexo,
                        "tipoSangre" : $scope.tipoSangre,
                        "eps" : $scope.eps
                    };
                    doc = JSON.stringify(doc);
                    console.log(doc);
                    return $http.post(context, doc.toString())
                        .then(function () {
                            $state.go('patientsList');
                        }, responseError)
                }
            }
            
            this.editDoc = function(doc) {
                $state.go('editPatient');
                docIdDeleted = doc.id;
                $scope.tit = "Editar " + doc.name;
            }
            
            this.editPacienteFinal = function () {
                if (!$scope.nombre || !$scope.id || !$scope.sexo || !$scope.edad || !$scope.tipoSangre || !$scope.eps ) alert("No puede dejar ningún campo vacio.");
                if (isNaN($scope.documento)) alert("La cédula debe ser numérica.");
                if (isNaN($scope.edad)) alert("La edad debe ser un numérica.");
                if (isNaN($scope.sexo)) alert("El sexo no puede ser numérico.");
                if (isNaN($scope.tipoSangre)) alert("El tipo de Sangre no puede ser numérico.");
                if (isNaN($scope.eps)) alert("La EPS no puede ser numérica.");
                else{
                    var doc = 
                    {
                        "name" :  $scope.nombre,    
                        "id" : $scope.documento,      
                        "edad" : $scope.edad,    
                        "sexo" : $scope.sexo,
                        "tipoSangre" : $scope.tipoSangre,
                        "eps" : $scope.eps
                    };
                    doc = JSON.stringify(doc);
                    console.log(doc);
                    return $http.put(context+"/"+docIdDeleted, doc.toString())
                        .then(function () {
                            $state.go('patientsList');
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