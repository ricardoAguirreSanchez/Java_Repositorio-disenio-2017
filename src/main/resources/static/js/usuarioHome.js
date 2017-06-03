var app = angular.module('usuarioHome', [ 'ui.bootstrap',
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

app.controller('logOutController', [ '$scope', function($scope) {
	$scope.redirectToLogOut = function() {
		window.location.href = "logout";
	};
	
	// Variables
	var aside = $('aside');
	var headerBotonMenu = $('.header_boton_menu');
	var asideOpciones = $('.aside_opciones>li>a');

	// href en el logo
	$('.header_logo, .header_logout').click(function() {
		window.location.href = '';
	});

	// Botón para desplegar sidebar en tamaños de pantalla chicos
	headerBotonMenu.click(function() {
		aside.toggleClass('desplegado');
		headerBotonMenu.toggleClass('active');
	});

	asideOpciones.click(function() {

		var padre = $(this).parents('li');
		var padres = $('aside ul>li');

		if (!padre.hasClass('active')) {
			agregarClaseActive(padre, padres);
			cambiarDeOpcion(padre);
		};
	});
} ]);

app.factory('usuarioHomeFunctions',[ '$http','ajaxFunctions', function($http,ajaxFunctions) {



    var setCallbackDefault = function (callback){
		ajaxFunctions.setCallbackErrorDefault(callback)
	}
	
	var getIndicadores = function(desdeDonde, functionSuccessOk) {
		mostrarLoader(desdeDonde);
		return ajaxFunctions.realizarPedidoAjax({method:'get',
			async: false,
			 url: 'indicador/'},functionSuccessOk)  
	};
	
	
	return {
		getIndicadores: getIndicadores,
		setCallbackDefault: setCallbackDefault
	};
}])

app.controller('usuarioHomeController', ['$scope','$rootScope','usuarioHomeFunctions', '$uibModal', function($scope, $rootScope, usuarioHomeFunctions, $uibModal, $http){
	$rootScope.tipo='cuentas';
	
	
	$scope.init = function() {
		setTimeout(function(){
//			$scope.cargarIndicadores();
		}, 400);
	
	
	}
	
	usuarioHomeFunctions.setCallbackDefault(function(){
		if(!$scope.modalAbierto){
			$scope.showModal("ERROR GRAVE, MODIFICAR TEXTO");
			ocultarLoader('');
		}
	});
	var aside = $('aside');
	var headerBotonMenu = $('.header_boton_menu');
	var asideOpciones = $('.aside_opciones>li>a');


	// href en el logo
	$('.header_logo, .header_logout').click(function() {
		window.location.href = '';
	});

	// Botón para desplegar sidebar en tamaños de pantalla chicos
	headerBotonMenu.click(function() {
		aside.toggleClass('desplegado');
		headerBotonMenu.toggleClass('active');
	});

	asideOpciones.click(function() {

		var padre = $(this).parents('li');
		var padres = $('aside ul>li');

		if (!padre.hasClass('active')) {
			agregarClaseActive(padre, padres);
			cambiarDeOpcion(padre);
		};
	});
	$scope.cargarIndicadores = function(){
		$rootScope.tipo='indicadores'
	}
	$scope.cargarCuentas = function(){
		$rootScope.tipo='cuentas'
	}

	function validarCampos(erroresForm){
		for(x in erroresForm){
			if (erroresForm.hasOwnProperty(x)) {
				errorElements = erroresForm[x];
				for(element in errorElements){
					if(x.hasOwnProperty(element)){
						errorElements[element].$touched = true;
					}
				}
			}
		}
	}
}]);

app.controller('adminHomeController' 
		,['$rootScope'              
		,'$scope'		
		,'variacionFunction'
//Seteo en $rootScope el modal de error para poder acceder desde el AjaxResponse.	              
,function($rootScope,$scope,variacionFunction,$uibModal) {	   		     	            	
	$rootScope.showModal = function showModal(errorMsg) {
	$rootScope.modalAbierto = true;
	 var modalInstance = $uibModal.open({
	  						animation : true,
 							templateUrl : 'modalError.html',
   							controller : 'ModalInstanceCtrl',
   							windowClass : 'modal_error',
   							resolve : {
   								error : function() {
   									return errorMsg
   								}
   							}
	  })
  }	              
}] );
////Controller encargado del modal.
app.controller('ModalInstanceCtrl', function($scope, $uibModalInstance, $rootScope,
				error) {
	$scope.error = error;
	$scope.cerrar = function() {
		$rootScope.modalAbierto = false;
		$uibModalInstance.close();
	};
	$uibModalInstance.closed.then(function(){$rootScope.modalAbierto = false})
});

//Metodo para que el "Atras" del browser vaya a la ultima pestaña clickeada del menu de opciones.
$(window).on('hashchange', function() {
	clase = window.location.hash.substr(2);
	$('.icon_ba_'+clase).click()
});


function agregarClaseActive(agregarActive, borrarActive) {
	borrarActive.removeClass('active');
	agregarActive.addClass('active');
}

//Metodo para el cambio de menu.
function cambiarDeOpcion(father) {
	if (father.is('#opcion_cuentas')) {
		$('.wrapper>:not(#cuentas)').fadeOut(200);
		$('#cuentas').delay(200).fadeIn(200);
	} else if (father.is('#opcion_indicador')) {
		$('.wrapper>:not(#indicador)').fadeOut(200);
		$('#indicadores').delay(200).fadeIn(200);
	} else if (father.is('#opcion_metodologia')) {
		$('.wrapper>:not(#metodologia)').fadeOut(200);
		$('#metodologia').delay(200).fadeIn(200);		
	} else if (father.is('#opcion_comparar')) {
		$('.wrapper>:not(#comparar)').fadeOut(200);
		$('#comparar').delay(200).fadeIn(200);			
	}
    else if (father.is('#opcion_cuenta_page')) {
        $('.wrapper>:not(#cuentaPage)').fadeOut(200);
        $('#cuentaPage').delay(200).fadeIn(200);
    }

	;
}


//Metodo para mostrar el editar perfil.
$('.aside_usuario').click(function() {
//	$('.wrapper>*').fadeOut(200);
	$('.wrapper>:not(#perfil)').fadeOut(200);
	$('#perfil').delay(200).fadeIn(200);
	$('.aside_opciones>li').removeClass('active');
});

function ocultarLoader(pantalla) {
	$('#'+pantalla).css('opacity', '1');
	$('.loader').hide();
}

function mostrarLoader(pantalla) {
	$('.loader').show();
	$('#'+pantalla).css('opacity', '0.2');
}

