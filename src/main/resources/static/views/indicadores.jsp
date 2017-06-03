<!-- INDICADORES -->
<div class="row" ng-controller="indicadorController"
	ng-init="init(); reloadIndicadores();">
	<div class="h1">
		<h1>
			<i class="icon_ba icon_ba_cotizacion"></i>Indicadores<span
				class="indicadores_vistas" id="indicadores_vistas"><i
				class="icon_ba icon_ba_secciones_menu vista_tabla"></i></span>
		</h1>
	</div>

	<div id="indicadores_table" style="padding: 10px 15px 0px 15px;">
		<div id="indicadoresTable">
			<table ng-table="indicadoresTable"
				   class="table table-condensed table-bordered table-striped tabla_datatable"
				   show-filter="false">
				<tbody>
				<tr ng-repeat="indicador in indicadoresTable.data">
					<td data-title="'Nombre'">
						<div class="text-center">
							<span>{{indicador.nombre}}</span>
						</div>
					</td>
					<td data-title="'Expresion'">
						<div class="text-center">
							<span>{{indicador.expresion}}</span>
						</div>
					</td>
				</tr>
				</tbody>
			</table>
			<div ng-hide="indicadoresTable.data.length">Usted no posee indicadores.</div>
		</div>
	</div>


	<div id="cargaIndicadores" style="padding: 80px 50px 0px 15px;">
		<div class="pull-left col-lg-3">
			<input class="form-control" placeholder="Nombre..." type="text" ng-model="nombreIndicador" style="">
		</div>
		<div class="pull-left col-lg-6">
			<input class="form-control" placeholder="Indicador..." type="text" ng-model="indicadorPersonal" style="">
		</div>
		<button class="pull-right col-lg-3 button btn" ng-click="enviarIndicador(nombreIndicador, indicadorPersonal)">Cargar indicador</button>
		<div style="padding: 45px 50px 0px 15px;"><span class="text-center" id="cargaCorrecta"></span></div>


	</div>


</div>
<!-- FIN INDICADORES -->