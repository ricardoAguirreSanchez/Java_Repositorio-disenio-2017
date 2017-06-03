<!-- INDICADORES -->

<div class="row" ng-controller="cuentaPageController"
     ng-init="init();">

    <div class="h1">
        <h1>
            <i class="icon_ba icon_ba_cotizacion"></i>{{cuentaPage.empresa}} {{cuentaPage.nombre}} <span
                class="indicadores_vistas" id="indicadores_vistas"><i
                class="icon_ba icon_ba_secciones_menu vista_tabla"></i></span>
        </h1>
    </div>

    <div id="cuenta_page_table" style="padding: 10px 15px 0px 15px;">
        <div id="cuentaPageTable">
            <table ng-table="cuentaPageTable"
                   class="table  table-bordered"
                   show-filter="false">
                <tbody>
                <tr ng-repeat="cuenta in cuentaPageTable.data" ng-class="{'selected':$index == selectedRowCuenta}" ng-click="setClickedRowCuenta($index)">
                    <td data-title="'Gross Booking'"><div class="text-center">
                        <span>{{cuenta.grossBooking}}</span>
                    </div></td>
                    <td data-title="'ROI'"><div class="text-center">
                        <span>{{cuenta.roi}}</span>
                    </div></td>
                    <td data-title="'Profit'"><div>
                        <span>{{cuenta.profit}}</span>
                    </div></td>
                    <td data-title="'Cost'"><div>
                        <span>{{cuenta.cost}}</span>
                    </div></td>
                    <td data-title="'Fecha inicio'"><div>
                        <span>{{cuenta.fechaInicio | date: "yyyy-MM-dd"}}</span>
                    </div></td>
                    <td data-title="'Fecha fin'"><div>
                        <span>{{cuenta.fechaFin | date: "yyyy-MM-dd"}}</span>
                    </div></td>
                </tr>
                </tbody>
            </table>
            <div ng-hide="cuentaPageTable.data.length">Usted no posee valores.</div>
        </div>
    </div>

    <div id="indicadores_table" style="padding: 10px 15px 0px 15px; margin: 80px;
">
    <div id="indicadoresTable">
        <table ng-table="indicadoresTable"
               class="table table-condensed table-bordered"
               show-filter="false">
            <tbody>
            <tr ng-repeat="indicador in indicadoresTable.data"  ng-class="{'selected':$index == selectedRow}" ng-click="setClickedRow($index, indicador.id)">
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

    <button class="pull-center col-lg-3 button btn" ng-click="aplicarIndicador()">Aplicar indicador</button>
    <div style="padding: 45px 50px 0px 15px;"><span class="text-center" id="cargaCorrecta"></span></div>

</div>
<!-- FIN INDICADORES -->