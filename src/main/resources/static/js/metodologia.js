app.controller('metodologiaController',['$rootScope','$scope','ngTableParams', 'variacionFunction','$http','servicioCuentaIndicador',
	function($rootScope, $scope, ngTableParams, variacionFunction, $http,servicioCuentaIndicador) {
$scope.reglas=["Maximizar ROE", "Minimizar Deuda", "Margenes de Ganancia", "Longevidad", "Maximo total pasivo", "Maxima cantidad cuestas", "Menor capital contable"]

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

		$http.get('/cuentas').success(function (data) {
			var dataCuentas = data;
			$scope.filters = {
				id : '',
				first_name: '',
				cuentaTenencia: ''};
			$scope.cuentasTable = new ngTableParams({
				page : 1,
				count : 10,
				filter:$scope.filters,
				sorting:{}
			}, {
				total: dataCuentas.length,
				dataset: dataCuentas
			});
		});

}]);


