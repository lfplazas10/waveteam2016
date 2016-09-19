var mostrarDoctores = false;
var mostrarCitas = false;
var idEditar = 1;
(function (ng) {
    var mod = ng.module("consultorioModule");
    mod.controller("consultoriosCtrl", ['$scope', '$state', '$stateParams', '$http', 'consultorioContext', function ($scope, $state, $stateParams, $http, context) {
            mostrarDoctores = false;
            mostrarCitas = false;
            //Prueba: citas
            this.mostrarCitas=function(){
                return mostrarCitas;
            }
            this.getCitas = function()
            {
                console.log("ME SOLICITAN citas")
                $scope.citas = $scope.consultorioActual.citasAsignadas;
                console.log("$scope.citas");
                if (mostrarCitas === false)
                {
                    mostrarCitas = true;
                }else{
                    mostrarCitas = false;
                }
            }
            
            //Prueba: doctores
            this.mostrarDoctores=function(){
                return mostrarDoctores;
            }
            this.getDoctores = function()
            {
                console.log("ME SOLICITAN DOCTORES")
                $scope.doctores = $scope.consultorioActual.doctoresAsignados;
                console.log("$scope.doctores");
                if (mostrarDoctores === false)
                {
                    mostrarDoctores = true;
                }else{
                    mostrarDoctores = false;
                }
            }
             //Funcionamiento normal de consultorios:
            $scope.consultorios = {};
            
            //Comando GET!
            $http.get(context).then(function (response) {
                $scope.consultorios = response.data;
            }, responseError);


            if ($stateParams.consultorioId !== null && $stateParams.consultorioId !== undefined) {
                id = $stateParams.consultorioId;
                console.log("BUSCANDO UN SOLO ID "+id)
                $http.get(context + "/" + id)
                        .then(function (response) {
                            $scope.consultorioActual = response.data;
                            
                    console.log("ME VINO UN "+$scope.consultorioActual);
                        }, responseError);
            } else
            {
                $scope.consultorioActual = {
                    id: undefined,
                    nombre: '',
                    horario: '',
                    atencionUrgencias:'',
                    unidadCuidadosIntensivos:''
                };

                $scope.alerts = [];
            }

            this.getConsultorio = function (idBusqueda) {
                $http.get(context + "/" + idBusqueda).then(function (response) {
                    $scope.consultorioBusqueda = response.data;
                    console.log(response.data);
                    existe = true;
                }, responseError);
            };


            //Comando POST!
            this.guardarConsultorio = function () {
                consultorioActual = $scope.consultorioActual;
                return $http.post(context, consultorioActual)
                        .then(function (response) {
                            $state.go('getConsultorios');
                        }, responseError);
            }

            //Comando DELETE!
            this.eliminarConsultorio = function (id) {
                console.log("BORRANDO " + id);
                $http.delete(context + "/" + id)
                        .then(function (response) {
                            $state.go('getConsultorios');
                        }, responseError)
            }


            //Comando PUT
            this.actualizarConsultorioId = function (id) {
                console.log("gatitoasd");
                idEditar = id;
                console.log(idEditar);

                $state.go('actualizarConsultorio');
            }

            this.actualizarConsultorio = function () {
                console.log(idEditar);
                consultorioActual = $scope.consultorioActual;
                consultorioActual.id = idEditar;
                var cons = {
                    id:consultorioActual.id,
                    nombre:consultorioActual.nombre,
                    horario:consultorioActual.horario,
                    atencionUrgencias:consultorioActual.atencionUrgencias,
                    unidadCuidadosIntensivos:consultorioActual.unidadCuidadosIntensivos
                }
                
                nuevoConsultorio = JSON.stringify(cons);
                console.log("MI ID ES " + consultorioActual.id);
                console.log(consultorioActual);
                                console.log(nuevoConsultorio);

                $http.put(context + "/" + idEditar, nuevoConsultorio)
                        .then(function (response) {
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

            function responseError(response) {
                alert(response.data);
            }
        }]);

})(window.angular);