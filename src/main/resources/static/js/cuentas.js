app.controller('cuentaController',['$rootScope','$scope', '$http','ngTableParams', '$uibModal','variacionFunction','servicioCuentaIndicador', 
	function($rootScope,$scope,$http ,ngTableParams, $uibModal,variacionFunction, servicioCuentaIndicador) {

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
        


	}]);

