app.controller('metodologiaController',['$rootScope','$scope','ngTableParams', 'variacionFunction','$http','servicioCuentaIndicador',
	function($rootScope, $scope, ngTableParams, variacionFunction, $http,servicioCuentaIndicador) {
$scope.reglas=["Maximizar ROE", "Minimizar Deuda", "Margenes de Ganancia", "Longevidad", "Maximo total pasivo", "Maxima cantidad cuestas", "Menor capital contable"]

        $scope.enviarMedologia = function(){
            var parametros={
            	metodologia: $scope.metodologia,
            	reglasSeleccionadas: $scope.reglasSeleccionadas
            };
            $http({
                url:'/metodologia',
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
        
        $scope.reglasSeleccionadas = [];
        $scope.reglaChecked = [];
        $scope.agregarRegla = function(regla, index){
        	if($scope.reglaChecked[index]==true)
        		$scope.reglasSeleccionadas.push(regla);
        	else
        		$scope.reglasSeleccionadas.splice($scope.reglasSeleccionadas.indexOf(regla),1);
        	
        }

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


