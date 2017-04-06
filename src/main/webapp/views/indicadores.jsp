<!-- INDICADORES -->
<div class="row" ng-controller="indicadorController"
	ng-init="init()">
	<div class="h1">
		<h1>
			<i class="icon_ba icon_ba_cotizacion"></i>Indicadores<span
				class="indicadores_vistas" id="indicadores_vistas"><i
				class="icon_ba icon_ba_secciones_menu vista_tabla"></i></span>
		</h1>
	</div>
<!-- 	Descomentar cuando tenga Tabla MGM -->
	<div id="indicadores_table">
		<div id="indicadoresTable">
		<table ng-table="indicadoresTable"
			class="table table-striped table-bordered tabla_datatable"
			show-filter="false">
			<tbody>
				<tr ng-repeat="indicador in indicadoresTable.data"">
					<td data-title="'S&iacute;mbolo'" sortable="'simbolo'"><div>
							<span>{{indicador.simbolo1}}</span>
						</div></td>
				</tr>
			</tbody>
		</table>
		<div ng-hide="indicadoresTable.data.length">Usted no posee indicadores.</div>		
		</div>
	</div>
</div>
<!-- FIN INDICADORES -->