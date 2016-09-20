

(function (ng){
    var mod = ng.module("patientModule", ["ngMessages"]);
    mod.constant("patientContext", "api/patient");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/patient/';
            var citasbasePath = 'src/modules/citas/';
            $urlRouterProvider.otherwise("/");

            $stateProvider.state('patientList', {
                url: '/patientList',
                views: {
                    'mainView': {
                        controller: 'patientCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'patient.list.html'
                    }
                }
            })

            .state('patientListforpatient', {
                url: '/patientListforpatient',
                views: {
                    'mainView': {
                        controller: 'patientCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'patientforpatient.list.html'
                    }
                }
            })

             .state('editPatientforpatient', {
            url:'/patientforpatient/{ptnID:int}/edit',
            param: { 'ptnID:': null},
                views: {
                'mainView': {
                    controller: 'patientCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'patientforpatient.edit.html'
                }
            }
        })

            .state('editPatient', {
            url:'/patient/{ptnID:int}/edit',
            param: { 'ptnID:': null},
                views: {
                'mainView': {
                    controller: 'patientCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'patient.edit.html'
                }
            }
        })
         .state('addPatient', {
            url:"/addPatient",
            views: {
                'mainView': {
                    controller: 'patientCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'patient.create.html'
                }
            }

            })
//             .state('citasList', {
//                url: '/citas/citasList',
//                views: {
//                    'mainView': {
//                        controller: 'citasCtrl',
//                    controllerAs: 'ctrl',
//                    templateUrl: citasbasePath + 'citas.list.html'
//                    }
//                }
//            })
            .state('citasList', {

                url: '/patient/{ptnID:int}/getcitas',
            param: { 'ptnID:': null},
                views: {
                    'mainView': {
                         controller: 'patientCtrl',
                         controllerAs: 'ctrl',
                        templateUrl: basePath + 'patientcitas.list.html'
                    }
                }
            })
            ;
        }]);
})(window.angular);
