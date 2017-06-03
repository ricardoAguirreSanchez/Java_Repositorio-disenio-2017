app.controller('indicadorController',['$rootScope','$scope','ngTableParams', 'variacionFunction','$http','servicioCuentaIndicador',
	function($rootScope, $scope, ngTableParams, variacionFunction, $http,servicioCuentaIndicador) {


        $scope.enviarIndicador=function(nombre ,indicador){
            var parametros={
                indicador: indicador,
                nombre: nombre
            };
            $http({
                url:'/indicadores',
                params : parametros,
                method : 'POST'
            }).success(function(response){
                var result = "El indicador no paso la evaluación, comprueba la sintaxis y vuelva a ingresarlo";

                if(response){
                    result = "El indicador fue cargado con exito";
                }
                document.getElementById('cargaCorrecta').innerHTML= result;
                console.log("Se ha enviado correctamente el indicador: "+ response);
                $scope.reloadIndicadores();
            });
        };

       $scope.reloadIndicadores = function(){
           $http.get('/indicadores').success(function (data) {
            var dataIndicadores = data;
            $scope.filters = {
                id : '',
                first_name: ''
            };
            $scope.indicadoresTable = new ngTableParams({
                page : 1,
                count : 10,
                filter:$scope.filters,
                sorting:{}
            }, {
                total: dataIndicadores.length,
                dataset: dataIndicadores
            });
        });
       }

}]);


