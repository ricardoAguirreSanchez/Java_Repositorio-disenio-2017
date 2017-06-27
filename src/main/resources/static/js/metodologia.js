app.controller('metodologiaController',['$rootScope','$scope','ngTableParams', 'variacionFunction','$http','servicioCuentaIndicador',
	function($rootScope, $scope, ngTableParams, variacionFunction, $http,servicioCuentaIndicador) {
$scope.reglas=["Maximizar ROE", "Minimizar Deuda", "Margenes de Ganancia", "Longevidad", "Maximo total pasivo", "Maxima cantidad cuestas", "Menor capital contable"]

        $scope.enviarMetodologia = function(){
            var parametros={
            	metodologia: $scope.metodologia,
            	reglasSeleccionadas: $scope.reglasSeleccionadas
            };
            $http({
                url:'/agregarMetodologia',
                params : parametros,
                method : 'POST'
            }).success(function(data){
            	var resp=data
                console.log("La metodologia "+parametros.metodologia+" se agrego correctamente.");
            }).error(function(data){
            	console.log("error");
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

		$http.get('/metodologias').success(function (data) {
			var dataMetodologia = data;
			$scope.filters = {
				id : '',
				first_name: '',
				cuentaTenencia: ''};
			$scope.metodologiaTabla=dataMetodologia;
		});

}]);


