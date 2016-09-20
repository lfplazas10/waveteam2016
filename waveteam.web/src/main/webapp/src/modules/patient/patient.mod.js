

(function (ng){
    var mod = ng.module("patientModule", ["ngMessages"]);
    mod.constant("patientContext", "api/patient");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/patient/';
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
            
            $stateProvider.state('patientListforpatient', {
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

            });
        }]);
})(window.angular);
