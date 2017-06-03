
app.controller('cuentaPageController',['$rootScope','$scope', '$http','ngTableParams', '$uibModal','variacionFunction','servicioCuentaIndicador',
    function($rootScope,$scope,$http ,ngTableParams, $uibModal,variacionFunction, servicioCuentaIndicador) {


        $scope.selectedRow = null;
        $scope.selectedRowCuenta = null;
        $scope.cuentaPage  = null;
        $scope.indicadores = null;
        $scope.valorSelected = null;
        $scope.indicadorSelected = null;

        $scope.setClickedRow = function(index){
            $scope.indicadorSelected= $scope.indicadores[index];
            $scope.selectedRow = index;
        }
        $scope.setClickedRowCuenta = function(index){
            $scope.valorSelected= $scope.cuentaPage.valores[index];
            $scope.selectedRowCuenta = index;
        }
        $rootScope.cargarNuevoId = function(){
        	$scope.id=servicioCuentaIndicador.getId();


            $http.get('/cuentas/' + $scope.id).success(function (data) {
                $scope.cuentaPage = {
                    empresa: data.empresa,
                    nombre: data.tipoCuenta,
                    valores: data.cuentaValores
                };
                $scope.cuentaPageTable = new ngTableParams({
                    page : 1,
                    count : 10,
                    sorting:{}
                }, {
                    total:  data.cuentaValores.length,
                    dataset: data.cuentaValores
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


}]);

