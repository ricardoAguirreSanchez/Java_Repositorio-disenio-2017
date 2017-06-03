<!-- INDICADORES -->
<div class="row" ng-controller="cuentaController"
	ng-init="init()">
	<div class="h1">
		<h1>
			<i class="icon_ba icon_ba_peso"></i>Cuentas<span
				class="indicadores_vistas" id="indicadores_vistas"><i
				class="icon_ba icon_ba_secciones_menu vista_tabla"></i></span>
		</h1>
	</div>
	<span id="filtersCotizaciones" class="button-group tipo_tenencia tipo_cotizacion">
		<div id="divFilters">
			<div class="pull-right col-md-4 fondo_gris box-tools" style="margin-bottom: 15px;">
				<div class="has-feedback">
					<input type="text" placeholder="Nombre.." class="form-control" ng-model="filters.nombre">
					<span class="fa fa-search form-control-feedback"></span>
				</div>
			</div>
		</div>
	</span>

	<div id="cuentas_table" style="padding: 10px 15px 0px 15px;">
		<div id="cuentasTable">
			<table ng-table="cuentasTable"
				   class="table table-striped table-bordered"
				   show-filter="false">
				<tbody>
				<tr ng-repeat="cuenta in cuentasTable.data" href="#cuentaPage" ng-click="cargarPage(cuenta.id)">
					<td data-title="'Nombre'" sortable="'nombre'" style="text-align: center;"><div class="text-center">
						<span>{{cuenta.tipoCuenta}}</span>
					</div></td>
					<td data-title="'Empresa'" sortable="'empresa'"><div class="text-center">
						<span>{{cuenta.empresa}}</span>
					</div></td>
				</tr>
				</tbody>
			</table>
			<div ng-hide="cuentasTable.data.length">Usted no posee cuentas.</div>
		</div>
	</div>
</div>
<div ng-controller="cuentaPageController"></div>
<!-- FIN INDICADORES -->