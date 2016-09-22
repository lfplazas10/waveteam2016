var mostrarDoctores = false;
var mostrarCitas = false;
var idEditar = 1;
(function (ng) {
    var mod = ng.module("consultorioModule");
    mod.controller("consultoriosCtrl", ['$scope', '$state', '$stateParams', '$http', 'consultorioContext', function ($scope, $state, $stateParams, $http, context) {
            mostrarDoctores = false;
            mostrarCitas = false;
            //Prueba: citas
            this.mostrarCitas = function () {
                return mostrarCitas;
            }
            $scope.citas = [];
            this.getCitas = function ()
            {
                $scope.doctores = $scope.consultorioActual.doctoresAsignados;
                angular.forEach($scope.doctores, function (value, index) {
                    $http.get("api/doctors/" + value.id + "/disponibilidad").then(function (response) {
                        $scope.citas = $scope.citas.concat(response.data);
                    }, responseError);
                })
                if (mostrarCitas === false)
                {
                    mostrarCitas = true;
                } else {
                    mostrarCitas = false;
                }
            }
            
            //Prueba: doctores
            
            $scope.allDoctors = [];
            $http.get("api/doctors").then(function (response) {
                $scope.allDoctors = response.data;
            }, responseError);

            this.desasignarDoctor = function (id) {
                $http.delete("api/consultorios/" + $scope.consultorioActual.id + "/doctores/" + id)
                        .then(function (response) {
                            $state.reload();
                            mostrarDoctores = true;
                        }, responseError);
            }
            this.asignarDoctor = function () {
                var yaExiste = false;
                if (!$scope.selectedDoctor) {
                    alert("Please select a doctor first.");
                    return;
                }

                var selectedDoctor = $scope.selectedDoctor;
                var doc = {
                    id: selectedDoctor.id,
                    name: selectedDoctor.name,
                    especialidad: selectedDoctor.especialidad,
                    consultorio: selectedDoctor.consultorio
                }
                $scope.doctores = $scope.consultorioActual.doctoresAsignados;
                angular.forEach($scope.doctores, function (value, index) {
                    if (value.id === doc.id) {
                        alert("Ese doctor ya se encuentra asignado.");
                        yaExiste = true;
                    }
                })
                if (!yaExiste)
                {
                    var nuevoDoc = JSON.stringify(doc);
                    $http.post("api/consultorios/" + $scope.consultorioActual.id + "/doctores", nuevoDoc)
                            .then(function (response) {
                                $state.reload();
                                mostrarDoctores = true;
                            }, responseError);
                }
            }


            this.mostrarDoctores = function () {
                return mostrarDoctores;
            }

            this.getDoctores = function ()
            {
                $scope.doctores = $scope.consultorioActual.doctoresAsignados;
                //HAY QUE COMPLETAR!!
                angular.forEach($scope.doctores, function (value, index) {
                    if (value.id === doc.id) {
                        alert("Ese doctor ya se encuentra asignado.");
                        yaExiste = true;
                    }
                })
                if (mostrarDoctores === false)
                {
                    mostrarDoctores = true;
                } else {
                    mostrarDoctores = false;
                }
            }
            //Funcionamiento normal de consultorios:
            $scope.consultorios = [];

            //Comando GET!
            $http.get(context).then(function (response) {
                $scope.consultorios = response.data;
            }, responseError);


            if ($stateParams.consultorioId !== null && $stateParams.consultorioId !== undefined) {
                id = $stateParams.consultorioId;
                $http.get(context + "/" + id)
                        .then(function (response) {
                            $scope.consultorioActual = response.data;
                        }, responseError);
            } else
            {
                $scope.consultorioActual = {
                    id: undefined,
                    nombre: '',
                    horario: '',
                    atencionUrgencias: '',
                    unidadCuidadosIntensivos: ''
                };

                $scope.alerts = [];
            }

            this.getConsultorio = function (idBusqueda) {
                $http.get(context + "/" + idBusqueda).then(function (response) {
                    $scope.consultorioBusqueda = response.data;
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
                $http.delete(context + "/" + id)
                        .then(function (response) {
                            $state.go('getConsultorios');
                        }, responseError)
            }


            //Comando PUT
            this.actualizarConsultorioId = function (id) {
                idEditar = id;

                $state.go('actualizarConsultorio');
            }

            this.actualizarConsultorio = function () {
                console.log(idEditar);
                consultorioActual = $scope.consultorioActual;
                consultorioActual.id = idEditar;
                var cons = {
                    id: consultorioActual.id,
                    nombre: consultorioActual.nombre,
                    horario: consultorioActual.horario,
                    atencionUrgencias: consultorioActual.atencionUrgencias,
                    unidadCuidadosIntensivos: consultorioActual.unidadCuidadosIntensivos
                }

                nuevoConsultorio = JSON.stringify(cons);

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