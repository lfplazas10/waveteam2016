(function (ng) {
    var mod = ng.module("consultorioModule");
    mod.controller("consultoriosCtrl", ['$scope', '$state', '$stateParams', '$http', 'consultorioContext', function ($scope, $state, $stateParams, $http, context) {
            
//            $scope.consultorios={};
            getConsultorios = function(){
                $http.get(context).then(function(response){
                    console.log(response.data);
                    $scope.records = response.data;
                }, responseError);
            }
            
            getConsultorios();
            

            this.guardarConsultorio = function (id) {
                consultorioActual = $scope.consultorioActual;
                
                //Se debe crear un registro
                if (id == null) {
                    //Comando POST!
                    return $http.post(context, consultorioActual)
                        .then(function () {
                            $state.go('getConsultorios');
                        }, responseError);
                        
                //Actualizar un registro
                } else {
                    
                    //Comando PUT!
                    return $http.put(context + "/" + consultorioActual.id, consultorioActual)
                        .then(function () {
                            $state.go('getConsultorios');
                        }, responseError);
                };
            };
            
            
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