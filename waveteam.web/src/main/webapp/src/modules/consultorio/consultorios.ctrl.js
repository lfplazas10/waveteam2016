(function (ng) {
    var mod = ng.module("consultorioModule");
    mod.controller("consultoriosCtrl", ['$scope', '$state', '$stateParams', '$http', 'consultorioContext', function ($scope, $state, $stateParams, $http, context) {

            $scope.consultorios = {};
            
            //Comando GET!
            getConsultorios = function () {
                $http.get(context).then(function (response) {
                    console.log(response.data);
                    $scope.consultorios = response.data;
                }, responseError);
            }

            getConsultorios();

            //Comando POST!
            this.guardarConsultorio = function () {
                consultorioActual = $scope.consultorioActual;
                console.log("gato");
                console.log(consultorioActual);

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
            this.actualizarConsultorioId = function(){
                console.log(id);
                $scope.idBusqueda = id;
                $state.go('actualizarConsultorio');
            }
            this.actualizarConsultorio = function(){
                console.log("gato");
                console.log($scope.idBusqueda);
                console.log($scope.id);
                id=$scope.idBusqueda;
                console.log(id);
                consultorioActual = $scope.consultorioActual;
                $http.put(context+"/"+id, consultorioActual)
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

                self.showError(response.data);
            }
        }]);

})(window.angular);