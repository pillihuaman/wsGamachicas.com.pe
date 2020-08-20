<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group">
	<label class="col-sm-12 control-label no-padding-right">
		Detalles Tecnico del Producto</label>
	<div class="controls col-sm-6">
		<label class="control-label" for="username">Productos:</label> <select
			id="idProducto" class="form-control optionidProducto">
			<option value="-1">Selecionar..</option>
			<c:forEach items="${ListProduct}" var="item">
				<option value="<c:out value="${item.idPfroduct}" />"><c:out
						value="${ item.name}" /></option>
			</c:forEach>

		</select>
	</div>
</div>
<div class="ui-jqgrid ui-widget ui-widget-content ui-corner-all"
	id="gbox_grid-table" dir="ltr" style="width: 320px;">
	<div class="jqgrid-overlay ui-widget-overlay" id="lui_grid-table"></div>
	<div class="loading ui-state-default ui-state-active"
		id="load_grid-table" style="display: none;">Loading...</div>
	<div class="ui-jqgrid-view " role="grid" id="gview_grid-table"
		style="width: 320px;">
		<!--<div
				class="ui-jqgrid-titlebar ui-jqgrid-caption ui-widget-header ui-corner-top ui-helper-clearfix">
				<a role="link"
					class="ui-jqgrid-titlebar-close HeaderButton ui-corner-all"
					title="Toggle Expand Collapse Grid" style="right: 0px;"><span
					class="ui-jqgrid-headlink ui-icon ui-icon-circle-triangle-n"></span></a><span
					class="ui-jqgrid-title">jqGrid with inline editing</span>
			</div>-->
		<div class="ui-jqgrid-hdiv ui-state-default"
			style="width: 420px; display: block;">
			<div class="ui-jqgrid-hbox">
				<table class="ui-jqgrid-htable ui-common-table "
					style="width: 420px;" role="presentation"
					aria-labelledby="gbox_grid-table">
					<thead>
						<tr class="ui-jqgrid-labels" role="row">
							<th id="grid-table_cb" role="columnheader"
								class="ui-th-column ui-th-ltr ui-state-default"
								style="width: 35px;"><div id="jqgh_grid-table_cb">
									<input role="checkbox" id="cb_grid-table" class="cbox"
										type="checkbox"><span class="s-ico"
										style="display: none"><span sort="asc"
										class="ui-grid-ico-sort ui-icon-asc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-n"></span><span
										sort="desc"
										class="ui-grid-ico-sort ui-icon-desc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-s"></span></span>
								</div></th>
							<th id="grid-table_subgrid" role="columnheader"
								class="ui-th-column ui-th-ltr ui-state-default"
								style="width: 25px;"><div id="jqgh_grid-table_subgrid">
									<span class="s-ico" style="display: none"><span
										sort="asc"
										class="ui-grid-ico-sort ui-icon-asc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-n"></span><span
										sort="desc"
										class="ui-grid-ico-sort ui-icon-desc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-s"></span></span>
								</div></th>
							<th id="grid-table_myac" role="columnheader"
								class="ui-th-column ui-th-ltr ui-state-default"
								style="width: 80px;"><span
								class="ui-jqgrid-resize ui-jqgrid-resize-ltr"
								style="cursor: col-resize;">&nbsp;</span>
								<div id="jqgh_grid-table_myac" class="ui-jqgrid-sortable">
									<span class="s-ico" style="display: none"><span
										sort="asc"
										class="ui-grid-ico-sort ui-icon-asc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-n"></span><span
										sort="desc"
										class="ui-grid-ico-sort ui-icon-desc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-s"></span></span>
								</div></th>
							<th id="grid-table_id" role="columnheader"
								class="ui-th-column ui-th-ltr ui-state-default"
								style="width: 100px;"><span
								class="ui-jqgrid-resize ui-jqgrid-resize-ltr"
								style="cursor: col-resize;">&nbsp;</span>
								<div id="jqgh_grid-table_id" class="ui-jqgrid-sortable">
									TIPO<span class="s-ico" style="display: none"><span
										sort="asc"
										class="ui-grid-ico-sort ui-icon-asc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-n"></span><span
										sort="desc"
										class="ui-grid-ico-sort ui-icon-desc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-s"></span></span>
								</div></th>
							<th id="grid-table_id" role="columnheader"
								class="ui-th-column ui-th-ltr ui-state-default"
								style="width: 100px;"><span
								class="ui-jqgrid-resize ui-jqgrid-resize-ltr"
								style="cursor: col-resize;">&nbsp;</span>
								<div id="jqgh_grid-table_id" class="ui-jqgrid-sortable">
									DESCRIPCIÓN<span class="s-ico" style="display: none"><span
										sort="asc"
										class="ui-grid-ico-sort ui-icon-asc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-n"></span><span
										sort="desc"
										class="ui-grid-ico-sort ui-icon-desc ui-sort-ltr ui-state-disabled ui-icon ui-icon-triangle-1-s"></span></span>
								</div></th>

						</tr>
					</thead>
				</table>
			</div>
		</div>
		<div class="ui-jqgrid-bdiv"
			style="height: auto; width: 420px; display: block;">
			<div style="position: relative;">
				<div id="tblCreate"></div>

			</div>
		</div>
	</div>
	<div id="grid-pager"
		class="ui-jqgrid-pager ui-state-default ui-corner-bottom" dir="ltr"
		style="width: 420px;">
		<div id="pg_grid-pager" class="ui-pager-control" role="group">
			<table class="ui-pg-table ui-common-table ui-pager-table ">
				<tbody>
					<tr>
						<td id="grid-pager_left" align="left"><table
								class="ui-pg-table navtable ui-common-table">
								<tbody>
									<tr>
										<td class="ui-pg-button ui-corner-all" title=""
											id="add_grid-table" data-original-title="Add new row"><div
												class="ui-pg-div" data-toggle="modal"
												data-target="#exampleModalCenter">
												<span class="ui-icon ace-icon fa fa-plus-circle purple"></span>
											</div></td>
										<td class="ui-pg-button ui-corner-all" title=""
											id="edit_grid-table" data-original-title="Edit selected row"><div
												class="ui-pg-div">
												<span class="ui-icon ace-icon fa fa-pencil blue"></span>
											</div></td>
										<td class="ui-pg-button ui-corner-all" title=""
											id="view_grid-table" data-original-title="View selected row"><div
												class="ui-pg-div">
												<span class="ui-icon ace-icon fa fa-search-plus grey"></span>
											</div></td>
										<td class="ui-pg-button ui-corner-all" title=""
											id="del_grid-table" data-original-title="Delete selected row"><div
												class="ui-pg-div">
												<span class="ui-icon ace-icon fa fa-trash-o red"></span>
											</div></td>
										<td class="ui-pg-button ui-state-disabled" style="width: 4px;"
											data-original-title="" title=""><span
											class="ui-separator"></span></td>
										<td class="ui-pg-button ui-corner-all" title=""
											id="search_grid-table" data-original-title="Find records"><div
												class="ui-pg-div">
												<span class="ui-icon ace-icon fa fa-search orange"></span>
											</div></td>
										<td class="ui-pg-button ui-corner-all" title=""
											id="refresh_grid-table" data-original-title="Reload Grid"><div
												class="ui-pg-div">
												<span class="ui-icon ace-icon fa fa-refresh green"></span>
											</div></td>
									</tr>
								</tbody>
							</table></td>
						<td id="grid-pager_center" align="center"
							style="white-space: pre; width: 420px;"><table
								class="ui-pg-table ui-common-table ui-paging-pager">
								<tbody>
									<tr>
										<!-- <td id="first_grid-pager"
												class="ui-pg-button ui-corner-all ui-state-disabled"
												title="First Page"><span
												class="ui-icon ace-icon fa fa-angle-double-left bigger-140"></span></td>
											<td id="prev_grid-pager"
												class="ui-pg-button ui-corner-all ui-state-disabled"
												title="Previous Page"><span
												class="ui-icon ace-icon fa fa-angle-left bigger-140"></span></td>
											<td class="ui-pg-button ui-state-disabled"><span
												class="ui-separator"></span></td>
											<td id="input_grid-pager" dir="ltr">Page <input
												class="ui-pg-input ui-corner-all" type="text" size="2"
												maxlength="7" value="0" role="textbox"> of <span
												id="sp_1_grid-pager">3</span></td>
											<td class="ui-pg-button ui-state-disabled"><span
												class="ui-separator"></span></td>
											<td id="next_grid-pager" class="ui-pg-button ui-corner-all"
												title="Next Page" style="cursor: default;"><span
												class="ui-icon ace-icon fa fa-angle-right bigger-140"></span></td>
											<td id="last_grid-pager" class="ui-pg-button ui-corner-all"
												title="Last Page"><span
												class="ui-icon ace-icon fa fa-angle-double-right bigger-140"></span></td>
											<td dir="ltr"><select
												class="ui-pg-selbox ui-widget-content ui-corner-all"
												role="listbox" title="Records per Page"><option
														role="option" value="10" selected="selected">10</option>
													<option role="option" value="20">20</option>
													<option role="option" value="30">30</option></select></td>-->
									</tr>
								</tbody>
							</table></td>
						<!--  <td id="grid-pager_right" align="right"><div dir="ltr"
									style="text-align: right" class="ui-paging-info">View 1 -
									10 of 23</div></td>-->
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!--<div id="grid-pager"
			class="ui-jqgrid-pager ui-state-default ui-corner-bottom" dir="ltr"
			style="width: 320px; display: block;">
			<div id="pg_grid-pager" class="ui-pager-control" role="group">
				<table class="ui-pg-table ui-common-table ui-pager-table ">
					<tbody>
						<tr>
							<td id="grid-pager_left" align="left"><table
									class="ui-pg-table navtable ui-common-table">
									<tbody>
										<tr>
											<td class="ui-pg-button ui-corner-all" title=""
												id="add_grid-table" data-original-title="Add new row"><div
													class="ui-pg-div">
													<span class="ui-icon ace-icon fa fa-plus-circle purple"></span>
												</div></td>
											<td class="ui-pg-button ui-corner-all" title=""
												id="edit_grid-table" data-original-title="Edit selected row"><div
													class="ui-pg-div">
													<span class="ui-icon ace-icon fa fa-pencil blue"></span>
												</div></td>
											<td class="ui-pg-button ui-corner-all" title=""
												id="view_grid-table" data-original-title="View selected row"><div
													class="ui-pg-div">
													<span class="ui-icon ace-icon fa fa-search-plus grey"></span>
												</div></td>
											<td class="ui-pg-button ui-corner-all" title=""
												id="del_grid-table"
												data-original-title="Delete selected row"><div
													class="ui-pg-div">
													<span class="ui-icon ace-icon fa fa-trash-o red"></span>
												</div></td>
											<td class="ui-pg-button ui-state-disabled"
												style="width: 4px;" data-original-title="" title=""><span
												class="ui-separator"></span></td>
											<td class="ui-pg-button ui-corner-all" title=""
												id="search_grid-table" data-original-title="Find records"><div
													class="ui-pg-div">
													<span class="ui-icon ace-icon fa fa-search orange"></span>
												</div></td>
											<td class="ui-pg-button ui-corner-all" title=""
												id="refresh_grid-table" data-original-title="Reload Grid"><div
													class="ui-pg-div">
													<span class="ui-icon ace-icon fa fa-refresh green"></span>
												</div></td>
										</tr>
									</tbody>
								</table></td>
							<td id="grid-pager_center" align="center"
								style="white-space: pre; width: 337px;"><table
									class="ui-pg-table ui-common-table ui-paging-pager">
									<tbody>
										<tr>
											<td id="first_grid-pager" class="ui-pg-button ui-corner-all"
												title="First Page" style="cursor: default;"><span
												class="ui-icon ace-icon fa fa-angle-double-left bigger-140"></span></td>
											<td id="prev_grid-pager" class="ui-pg-button ui-corner-all"
												title="Previous Page" style="cursor: default;"><span
												class="ui-icon ace-icon fa fa-angle-left bigger-140"></span></td>
											<td class="ui-pg-button ui-state-disabled"
												style="cursor: default;"><span class="ui-separator"></span></td>
											<td id="input_grid-pager" dir="ltr">Page <input
												class="ui-pg-input ui-corner-all" type="text" size="2"
												maxlength="7" value="0" role="textbox"> of <span
												id="sp_1_grid-pager">3</span></td>
											<td class="ui-pg-button ui-state-disabled"
												style="cursor: default;"><span class="ui-separator"></span></td>
											<td id="next_grid-pager"
												class="ui-pg-button ui-corner-all ui-state-disabled"
												title="Next Page" style="cursor: default;"><span
												class="ui-icon ace-icon fa fa-angle-right bigger-140"></span></td>
											<td id="last_grid-pager"
												class="ui-pg-button ui-corner-all ui-state-disabled"
												title="Last Page" style="cursor: default;"><span
												class="ui-icon ace-icon fa fa-angle-double-right bigger-140"></span></td>
											<td dir="ltr"><select
												class="ui-pg-selbox ui-widget-content ui-corner-all"
												role="listbox" title="Records per Page"><option
														role="option" value="10" selected="selected">10</option>
													<option role="option" value="20">20</option>
													<option role="option" value="30">30</option></select></td>
										</tr>
									</tbody>
								</table></td>
							<td id="grid-pager_right" align="right"><div dir="ltr"
									style="text-align: right" class="ui-paging-info">View 21
									- 23 of 23</div></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>-->
</div>

<div class="modal fade container" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<form action="" id="frmFormDetalleProducto">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Registra
						Detalle Producto</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" onclick="clearForm();">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<span class="input-icon"> <input type="text" id="tipo"
						placeholder="Tipo" class="form-control" />
					</span> <span class="input-icon input-icon-right"> <input
						id="descripcion" type="text" placeholder="Descripción"
						class="form-control" />
					</span>
				</div>
				<div id="msgResponse"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						onclick="clearForm();" data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary GuardarProducto">Guardar</button>
				</div>
			</div>
		</div>
	</form>
</div>
