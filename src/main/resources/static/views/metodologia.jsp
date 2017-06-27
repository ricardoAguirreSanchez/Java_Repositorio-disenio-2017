<!-- INDICADORES -->
<div class="row" ng-controller="metodologiaController" style="padding-left:146px;">
	<div class="h1">
		<h1>
			<i class="icon_ba icon_ba_cotizacion"></i>Metodologias<span
				class="indicadores_vistas" id="metodologia_vistas"><i
				class="icon_ba icon_ba_secciones_menu vista_tabla"></i></span>
		</h1>
	</div>

	<div id="indicadores_table" style="padding: 10px 15px 0px 15px;">
		<div id="indicadoresTable">
			<table class="table table-condensed table-bordered table-striped tabla_datatable"
				   show-filter="false">
				<tbody>
				<tr style="background-color:#9c0000; color:white;">
					<th style=" height: 50px;text-align: center;">Reglas</th>
					<th style=" height: 50px;text-align: center;">Accion</th>
				</tr>
				<tr ng-repeat="regla in reglas track by $index">
					<td data-title="'Nombre'">
						<div class="text-center">
							<span>{{regla}}</span>
						</div>
					</td>
					<td data-title="">
						<div class="text-center">
							<span><input type="checkbox" ng-model="reglaChecked[$index]" ng-click="agregarRegla(regla, $index)"></span>
						</div>
					</td>
				</tr>
				</tbody>
			</table>
			<div ng-hide="reglas.length">No existen Metodologias.</div>
		</div>
	</div>
	<div id="cuentas_table" style="padding: 10px 15px 0px 15px;">
		<div id="cuentasTable">
			<table ng-table="cuentasTable"
				   class="table table-striped table-bordered"
				   show-filter="false">
				<tbody>
				<tr ng-repeat="cuenta in cuentasTable.data">
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
<br>
<br>
<br>
<div>
	<h2 style="margin-left:1.5pc;">Simulador</h2>
	<br>
	<br>
	<div class="col-md-12 col-lg-12">
		<div class="col-md-6 col-lg-6">
			<h3>Reglas Seleccionadas</h3>
			<div>
				<ul>
					<li ng-repeat="regla in reglasSeleccionadas">{{regla}}</li>
				</ul>
			</div>
		</div>
		<div class="col-md-6 col-lg-6">
			<h3>Nombre metodologia</h3>
			<div>
				<input type="text" ng-model="metodologia" style="border: 1px solid black;"/>
			</div>
		</div>
	</div>
</div>
	<div id="cargaIndicadores" style="padding: 80px 50px 0px 15px;">
		<button class="pull-right col-lg-3 button btn" ng-click="enviarIndicador(nombreIndicador, indicadorPersonal)">Realizar</button>


	</div>


</div>
<!-- FIN INDICADORES -->