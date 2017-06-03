app.service('servicioCuentaIndicador', function() {
	var id = '';
return {
	getId: function(){
		return id;
	},
	setId: function(value){
		id=value;
	}
};
});
