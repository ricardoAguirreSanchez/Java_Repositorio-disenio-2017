
app.controller('cuentaPageController',['$rootScope','$scope', '$http','ngTableParams', '$uibModal','variacionFunction','servicioCuentaIndicador',
    function($rootScope,$scope,$http ,ngTableParams, $uibModal,variacionFunction, servicioCuentaIndicador) {


        $scope.selectedRow = null;
        $scope.selectedRowCuenta = null;
        $scope.cuentaPage  = null;
        $scope.indicadores = null;
        $scope.valorSelected = null;
        $scope.indicadorSelected = null;

         $scope.cuentaValores = null;


        $scope.setClickedRow = function(index, id){
            $scope.indicadorSelected= $scope.indicadores[index];
            $scope.selectedRow = index;
            $scope.indicadorId=id;
        }
        $scope.setClickedRowCuenta = function(index, id){
            $scope.valorSelected= $scope.cuentaPage.valores[index];
            $scope.selectedRowCuenta = index;
            $scope.cuentaId=id;
        }

        $rootScope.cargarCuentaValores = function(id) {
            console.log("hola que tal tu como estas")
            $http.get('/cuentaValores/' + id).success(function (data) {
                $scope.cuentaValores = data;})
        }
        $rootScope.cargarNuevoId = function(){
        	$scope.id=servicioCuentaIndicador.getId();
            $rootScope.cargarCuentaValores($scope.id);

            $http.get('/cuentas/' + $scope.id).success(function (data) {
                $scope.cuentaPage = {
                    empresa: data.empresa,
                    nombre: data.tipoCuenta,
                    valores: $scope.cuentaValores
                };

                $scope.cuentaPageTable = new ngTableParams({
                    page : 1,
                    count : 10,
                    sorting:{}
                }, {
                    total: $scope.cuentaValores.length,
                    dataset: $scope.cuentaValores
                });
            });

            $http.get('/indicadores').success(function (data) {
                $scope.indicadores = data;
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
                    total:     data.length,
                    dataset: data
                });
            });
        }
        $scope.aplicarIndicador=function(){
        	var envio={
        			indicadorId:$scope.indicadorId,
        			cuentaId:$scope.cuentaId,
        			valorCuentaId:$scope.cuentaValores[0].id	
        	}

        	$http({
        		url:'/aplicarIndicadores',
        		method:'POST',
        		data:envio
        		
        	}).success(function(data){
        		alert("Indicadores aplicados correctamente. Resultado final: "+data);
        	}).error(function(data){
        		alert("Ocurrio un error inesperado.")
        	});
        }

}]);

