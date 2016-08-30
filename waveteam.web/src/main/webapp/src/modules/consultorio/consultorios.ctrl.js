(function (ng) {
    var mod = ng.module("consultorioModule");
    mod.controller("consultoriosCtrl", ['$scope', '$state', '$stateParams', '$http', 'consultorioContext', function ($scope, $state, $stateParams, $http, context) {
            
            $scope.consultorios={};
            
            getConsultorios = function(){
                $https.get(context).then(function(response){
                    $scope.consultorios = response.data;
                }, responseError);
            }
            
            getConsultorios();
            
            //Verifica si se deberia tener un consultorio seleccionado con el ID del parametro
            if ($stateParams.cityId !== null && $stateParams.cityId !== undefined) {
                
                // toma el id del parámetro
                id = $stateParams.cityId;
                // obtiene el dato del recurso REST
                $http.get(context + "/" + id)
                    .then(function (response) {
                        // $http.get es una promesa
                        // cuando llegue el dato, actualice currentRecord
                        $scope.currentRecord = response.data;
                    }, responseError);

            // el controlador no recibió un cityId
            } else
            {
                // el registro actual debe estar vacio
                $scope.consultorioActual = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    name: '' /*Tipo String*/,
                };
              
                $scope.alerts = [];
            }
            this.guardarConsultorio = function (id) {
                consultorioActual = $scope.consultorioActual;
                
                //Se debe crear un registro
                if (id == null) {
                    //Comando POST!
                    return $http.post(context, consultorioActual)
                        .then(function () {
                            $state.go('citiesList');
                        }, responseError);
                        
                //Actualizar un registro
                } else {
                    
                    //Comando PUT!
                    return $http.put(context + "/" + consultorioActual.id, consultorioActual)
                        .then(function () {
                            $state.go('citiesList');
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