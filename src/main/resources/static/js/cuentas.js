app.controller('cuentaController',['$rootScope','$scope', '$http','ngTableParams', '$uibModal','variacionFunction','servicioCuentaIndicador', 
	function($rootScope,$scope,$http ,ngTableParams, $uibModal,variacionFunction, servicioCuentaIndicador) {
		$scope.agregar=false;
		$scope.cuenta={
				nombre:'',
				tipo:''
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
        $scope.cargarPage=function(id){
        	servicioCuentaIndicador.setId(id);
        	$rootScope.cargarNuevoId();
        	$rootScope.tipo='cuentaPage';
        }
        $scope.agregarCuenta=function(cuenta){
        	$http({
                url:'/agregarCuenta',
                params : cuenta,
                method : 'POST'
            }).success(function(response){
                console.log("Se ha enviado correctamente La cuenta");
            }).error(function(response){
            	console.log("No se pudo enviar La cuenta");
            });
        }


	}]);

