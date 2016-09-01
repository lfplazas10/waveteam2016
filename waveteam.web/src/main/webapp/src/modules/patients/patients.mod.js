

(function (ng){
    var mod = ng.module("patientModule", ["ngMessages"]);
    mod.constant("patientContext", "api/patients");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/patients/';
            $urlRouterProvider.otherwise("/patientsList");

            $stateProvider.state('patientsList', {
                url: 'patientsList',
                views: {
                    'mainVxiew': {
                        controller: 'patientsCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'patients.list.html'
                    }
                }
            })
            
            .state('editPatient', {
            url:"/editPatient",
            views: {
                'mainView': {
                    controller: 'patientsCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'patients.edit.html'
                }
            }
        })
         .state('addPatient', {
            url:"/addPatient",
            views: {
                'mainView': {
                    controller: 'patientsCtrl',
                    controllerAs: 'ctrl',
                    templateUrl: basePath + 'patients.create.html'
                }
            }

            });
        }]);
})(window.angular);
