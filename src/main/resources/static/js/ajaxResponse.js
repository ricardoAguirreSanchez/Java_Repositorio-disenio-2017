var app = angular.module('ajaxApp', [ 'ngAnimate', 'ui.bootstrap' ]);
app.factory('ajaxFunctions', [ '$http', function($http) {
	
	function crearMensaje(data) {
		var mensaje = {
			header:  {
				status: "SUCCESS"
			},
			data: data
		};
		return mensaje;
		}
	
	var optionsSend = {data: "",
					   dataType: "json",
					   withCredentials: false, 
					   headers: {'Content-Type': 'application/json; charset=utf-8'},
					   async: true
					  }
	
	var callbackError
    var setCallbackErrorDefault = function(newCallback) {
       callbackError = newCallback;
	}
	
	var realizarPedidoAjax = function realizarPedidoAjax(options,functionSuccessOk){
		$.extend( optionsSend, options ); 
		
		pedidoAjax = $http({
			url: optionsSend.url,
			data : crearMensaje(optionsSend.data),
			method : optionsSend.method,
			dataType: optionsSend.dataType,
			withCredentials: optionsSend.withCredentials,
			headers: optionsSend.headers,
			async: optionsSend.async
//			responseType : 'json'
		}).success(function(data){
			functionSuccessOk(data);			
		})
		.error(function(){
			callbackError();
		})
		
		return pedidoAjax;
	}

	return {
		realizarPedidoAjax : realizarPedidoAjax,
		setCallbackErrorDefault: setCallbackErrorDefault
	}
}]);