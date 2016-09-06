

(function (ng){
    var mod = ng.module("patientModule", ["ngMessages"]);
    mod.constant("patientContext", "api/patient");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/patient/';
            $urlRouterProvider.otherwise("/patientList");

            $stateProvider.state('patientList', {
                url: 'patientList',
                views: {
                    'mainVxiew': {
                        controller: 'patientCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'patient.list.html'
                    }
                }
            })
            
            .state('editPatient', {
            url:"/editPatient",
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
