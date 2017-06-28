<!-- INDICADORES -->
<div class="row" ng-controller="compararController" style="padding-left:146px;" ng-init="initComparar()">
	<div class="h1">
		<h1>
			<i class="icon_ba icon_ba_cotizacion"></i>Comparar<span
				class="indicadores_vistas" id="comparar"><i
				class="icon_ba icon_ba_secciones_menu vista_tabla"></i></span>
		</h1>
	</div>

	<div id="indicadores_table" style="padding: 10px 15px 0px 15px;">
		<div id="indicadoresTable">
			<table class="table table-condensed table-bordered table-striped tabla_datatable"
				   show-filter="false">
				<tbody>
				<tr style="background-color:#9c0000; color:white;">
					<th style=" height: 50px;text-align: center;">Metologia</th>
					<th style=" height: 50px;text-align: center;">Accion</th>
				</tr>
				<tr ng-repeat="regla in metodologiaTabla">
					<td data-title="'Nombre'">
						<div class="text-center">
							<span>{{regla.nombre}}</span>
						</div>
					</td>
					<td data-title="">
						<div class="text-center">
							<span><input type="radio" name="radioMetodologia" ng-model="reglaChecked" ng-click="agregarRegla(regla)"></span>
						</div>
					</td>
				</tr>
				</tbody>
			</table>
			<div ng-hide="metodologiaTabla.length">No existen Metodologias.</div>
		</div>
	</div>
	<div id="cuentas_table" style="padding: 10px 15px 0px 15px;">
		<div id="cuentasTable">
			<table ng-table="cuentasTable"
				   class="table table-striped table-bordered"
				   show-filter="false">
				<tbody>
				<tr ng-repeat="empresa in empresas">
					<td data-title="'Nombre Empresa'" sortable="'nombre'" style="text-align: center;"><div class="text-center">
						<span>{{empresa.nombre}}</span>
					</div></td>
					<td data-title="'Creacion'" sortable="'empresa'"><div class="text-center">
						<span>{{empresa.fechaCreacion}}</span>
					</div></td>
				</tr>
				</tbody>
			</table>
			<div ng-hide="empresas.length">Usted no posee cuentas.</div>
		</div>
	</div>
<br>
<br>
<br>
	<div id="cargaIndicadores" style="padding: 80px 50px 0px 15px;">
		<button class="pull-right col-lg-3 button btn" ng-click="compararEmpresas()">Comparar</button>
	</div>
	<div ng-repeat="cuentaGanadora in cuentasGanadoras">
		APRETA F12 Y VERAS EL RESULTADO
	</div>
	


</div>
<!-- FIN INDICADORES -->