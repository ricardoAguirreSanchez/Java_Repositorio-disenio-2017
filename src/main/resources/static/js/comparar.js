app.controller('compararController',['$rootScope','$scope','ngTableParams', 'variacionFunction','$http','servicioCuentaIndicador',
	function($rootScope, $scope, ngTableParams, variacionFunction, $http,servicioCuentaIndicador) {

        $scope.initComparar = function(){
            var parametros={
            	metodologia: $scope.metodologia,
            	reglasSeleccionadas: $scope.reglasSeleccionadas
            };
            $http.get('/metodologias').success(function(data){
            	$scope.metologias=data;
                console.log("La metodologia "+$scope.metologias[0].nombre+" se agrego correctamente.");
            }).error(function(data){
            	console.log("error");
            });
        };
        
		$http.get('/metodologias').success(function (data) {
			var dataMetodologia = data;
			$scope.filters = {
				id : '',
				first_name: '',
				cuentaTenencia: ''};
			$scope.metodologiaTabla=dataMetodologia;
		});
		
		$http.get('/empresas').success(function (data) {
			var dataEmpresas = data;
			$scope.empresas=dataEmpresas;
			$scope.filters = {
				id : '',
				first_name: '',
				cuentaTenencia: ''};
			$scope.empresaTable = new ngTableParams({
				page : 1,
				count : 10,
//				filter:$scope.filters,
				sorting:{}
			}, {
				total: dataEmpresas.length,
				dataset: dataEmpresas
			});
		});
		
        $scope.metodologiaSeleccionada = "";
        $scope.reglaChecked = "";
        $scope.agregarRegla = function(metodologia){
        	$scope.metodologiaSeleccionada = metodologia;
        	
        }
        $scope.cuentaGanadora = null;
        $scope.compararEmpresas = function(){
            var parametros={
            		nombre: $scope.metodologiaSeleccionada.nombre,
            		listaCondiciones: $scope.metodologiaSeleccionada.listaCondiciones
            };
            $http({
                url:'/realizarComparacion',
                params : parametros,
                method : 'POST'
            }).success(function(data){
            	$scope.cuentasGanadoras=data;
                console.log("La metodologia "+$scope.cuentasGanadoras+" se agrego correctamente.");
            }).error(function(data){
            	console.log("error");
            });
        };

}]);


