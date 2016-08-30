(function (ng) {
    var mod = ng.module("doctorModule");
    var docIdDeleted = -1;
    mod.controller("doctorsCtrl", ['$scope', '$state', '$stateParams', '$http', 'doctorContext', function ($scope, $state, $stateParams, $http, context) {
            
            loadDocs = function (){
                $http.get(context).then(function(response){
                    $scope.doctors = response.data;    
                    }, responseError);
            }
            
            loadDocs();

            this.deleteRecord = function (doc){
                return $http.delete(context+"/"+doc.id)
                        .then(function () {
                            loadDocs();
                        }, responseError)
            }
            
            this.saveDoctor = function () {
                if (!$scope.nombre || !$scope.especialidad || !$scope.consultorio || !$scope.cedula) alert("No puede dejar ningún campo vacio.");
                if (isNaN($scope.cedula)) alert("La cédula debe ser numérica.");
                if (isNaN($scope.consultorio)) alert("El consultorio debe ser un número.");
                else{
                    var doc = 
                    {
                        "name" :  $scope.nombre,    
                        "id" : $scope.cedula,      
                        "especialidad" : $scope.especialidad,        
                        "consultorio" : $scope.consultorio
                    };
                    doc = JSON.stringify(doc);
                    console.log(doc);
                    return $http.post(context, doc.toString())
                        .then(function () {
                            $state.go('doctorsList');
                        }, responseError)
                }
            }
            
            this.editDoc = function(doc) {
                $state.go('editDoctor');
                docIdDeleted = doc.id;
                $scope.tit = "Editar " + doc.name;
            }
            
            this.editDoctorFinal = function () {
                if (!$scope.nombre || !$scope.especialidad || !$scope.consultorio || !$scope.cedula) alert("No puede dejar ningún campo vacio.");
                if (isNaN($scope.cedula)) alert("La cédula debe ser numérica.");
                if (isNaN($scope.consultorio)) alert("El consultorio debe ser un número.");
                else{
                    var doc = 
                    {
                        "name" :  $scope.nombre,    
                        "id" : $scope.cedula,      
                        "especialidad" : $scope.especialidad,        
                        "consultorio" : $scope.consultorio
                    };
                    doc = JSON.stringify(doc);
                    console.log(doc);
                    return $http.put(context+"/"+docIdDeleted, doc.toString())
                        .then(function () {
                            $state.go('doctorsList');
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