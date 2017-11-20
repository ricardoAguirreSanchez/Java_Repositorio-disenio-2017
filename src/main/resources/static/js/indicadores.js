app.controller('indicadorController',['$rootScope','$scope','ngTableParams', 'variacionFunction','$http','servicioCuentaIndicador',
	function($rootScope, $scope, ngTableParams, variacionFunction, $http,servicioCuentaIndicador) {


    //TODO fix, es necesario enviar el userId correcto
        $scope.enviarIndicador=function(nombre ,indicador){
            var parametros={
                indicador: indicador,
                nombre: nombre,
                userId: '7'
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


