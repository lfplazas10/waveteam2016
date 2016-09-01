
var idEditar=1;
var existe = false;
(function (ng) {
    var mod = ng.module("consultorioModule");
    mod.controller("consultoriosCtrl", ['$scope', '$state', '$stateParams', '$http', 'consultorioContext', function ($scope, $state, $stateParams, $http, context) {

            $scope.consultorios = {};
            
            //Comando GET!
            getConsultorios = function () {
                $http.get(context).then(function (response) {
                    $scope.consultorios = response.data;
                }, responseError);
            }

            getConsultorios();
            
            this.getConsultorio = function(idBusqueda){
                $http.get(context+"/"+idBusqueda).then(function (response) {     
                    $scope.consultorioBusqueda = response.data;                    
                    console.log(response.data);
                    existe = true;
                }, responseError);
            };
            
            this.idValido = function(idBusqueda){
                return existe;
            }
            //Comando POST!
            this.guardarConsultorio = function () {
                consultorioActual = $scope.consultorioActual;
                    return $http.post(context, consultorioActual)
                            .then(function (response) {
                                $state.go('getConsultorios');
                            }, responseError);
                        
            }
            
            //Comando DELETE!
            this.eliminarConsultorio = function(consultorio){
                $http.delete(context+"/"+consultorio.id)
                        .then(function(response){
                            getConsultorios();
                }, responseError)
            }


            //Comando PUT
            this.actualizarConsultorioId = function(id){
                console.log("gatitoasd");
                idEditar = id;
                console.log(idEditar);
                
                $state.go('actualizarConsultorio');
            }
            
            this.actualizarConsultorio = function(){
                console.log(idEditar);
                consultorioActual = $scope.consultorioActual;
                $http.put(context+"/"+idEditar, consultorioActual)
                        .then(function(response){
                            $state.go('getConsultorios');
                }, responseError);
            }
            
            //===================================
            
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
                alert(response.data);
            }
        }]);

})(window.angular);