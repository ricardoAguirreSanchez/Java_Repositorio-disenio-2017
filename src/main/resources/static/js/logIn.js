var app = angular.module('logInUsuario', [ 'ui.bootstrap',
		'ngTable', 'ajaxApp', 'ui.select']);

app.factory('variacionFunction', [ '$http', function($http) {

	var getTipoVariacion = function(variacion) {
		if(variacion<0)
			return "abajo";
		if(variacion>0)
			return "arriba";
		return "igual";
	}
	
	return {
		getTipoVariacion : getTipoVariacion
	}
}])

app.controller('logInController', [ '$scope', '$http', function($scope, $http) {
	$scope.user={
			username:'',
			password:'',
	};
	
	$scope.logIn=function(user){
		$http({
			url:'/logIn',
			params:user,
			method: 'POST'
				}).success(function (data) {
					window.location.href="/index";
					winwodw.location.assign(window.location.href)
			console.log("Se logeo correctamente");
		}).error(function(response){
			alert("Error al logearse.");
		});
	}
} ]);

