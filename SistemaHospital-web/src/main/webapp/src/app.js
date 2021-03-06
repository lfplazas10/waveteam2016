(function (ng) {

    var app = ng.module("mainApp", [
        "ui.router",
        "doctorModule",
        "ngMessages",
        "patientModule",
        "especialidadModule",
        "consultorioModule", 
        "consultaHistoricaModule", 
        "citasModule"
    ]);

    app.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    app.config(['$urlRouterProvider', function ($urlRouterProvider) {
            $urlRouterProvider.otherwise('/');
        }]);

  
})(window.angular);
