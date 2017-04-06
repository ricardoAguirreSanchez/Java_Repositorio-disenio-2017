app.controller('cuentaController',['$rootScope','$scope','ngTableParams', '$uibModal','variacionFunction',
                                      function($rootScope,$scope, ngTableParams, $uibModal,variacionFunction) {
	$scope.filters = {
			id : '',
			first_name: '',
			cuentaTenencia: ''
	};
	
	$scope.cuentasTable = new ngTableParams({
		page : 1,
		count : 10,
		filter:$scope.filters,
		sorting:{}
	}, {
		dataset: [  {nombre:"EBITDA", valorAlfa:"valorAlfa1",valorBeta:"valorBeta1", valorDelta:"valorDelta1"},
		            {nombre:"FDS", valorAlfa:"valorAlfa2",valorBeta:"valorBeta2", valorDelta:"valorDelta2"},
					{nombre:"Free Cash Flow", valorAlfa:"valorAlfa3",valorBeta:"valorBeta3", valorDelta:"valorDelta3"},
					{nombre:"Ingreso Neto", valorAlfa:"valorAlfa4",valorBeta:"valorBeta4", valorDelta:"valorDelta4"},
					{nombre:"Cuenta Inventada", valorAlfa:"valorAlfa5",valorBeta:"valorBeta5", valorDelta:"valorDelta5"},
					{nombre:"Cuenta Malisima", valorAlfa:"valorAlfa6",valorBeta:"valorBeta6", valorDelta:"valorDelta6"}]
	});
	
}])



