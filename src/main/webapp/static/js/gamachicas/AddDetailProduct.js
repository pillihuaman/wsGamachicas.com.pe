var CreateTable = '<table id="grid-table" tabindex="0" role="presentation"' +
    'aria-multiselectable="true" aria-labelledby="gbox_grid-table"  ' +
    'class="ui-jqgrid-btable ui-common-table" style="width: 420px;">' +
    '<tbody>                                                        ' +
    '<tr class="jqgfirstrow" role="row" aria-selected="true">       ' +
    '<td role="gridcell" style="height: 3px; width: 35px;"></td>    ' +
    '<td role="gridcell" style="height: 3px; width: 25px;"></td>    ' +
    '<td role="gridcell" style="height: 3px; width: 80px;"></td>    ' +
    '<td role="gridcell" style="height: 3px; width: 100px;"></td>   ' +
    '<td role="gridcell" style="height: 3px; width: 100px;"></td>   ' +
    '</tr>                                                          ' +
    '</tbody>                                                       ' +
    '</table>                                                       ';

function Nuevo() {
    debugger;
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";
    document.getElementById("editmodgrid-table").style.display = 'block';
    document.getElementById("editmodgrid-table").style.top = '40%';;
    document.getElementsByClassName("fm-button").style.height = 'auto';

}

var i = 0;

function ClonePlus() {

    var int = parseInt(i);
    var idremove = 'idremove';
    var original = document.getElementById('divDetalleProducto');
    // var originalB = document.getElementById('idremove');
    var clone = original.cloneNode(true); // "deep" clone
    // var cloneB = originalB.cloneNode(true); // "deep" clone

    var idclone = "divDetalleProducto" + ++i;
    // var idremoveb= "idremove" + ++i;
    clone.id = idclone;
    // cloneB.id = idremoveb;
    original.parentNode.appendChild(clone);



}

function CloneLess(id) {

    var ar = []
    $('div').each(function() {
        ar.push(this.id);
    });
    // var el = document.getElementById(id.id);
    // el.remove();
}

function isEmpty(obj) {
    for (var key in obj) {
        if (obj.hasOwnProperty(key))
            return false;
    }
    return true;
}

$('.GuardarProducto').click(function() {
    debugger;
    $('').appendTo('#msgResponse');
    var ListDetailproduct = new Array();
    var idProducto = $("#idProducto").val();
    if (idProducto == -1 || idProducto == null) {
        clearForm();
        CreateMessage('Seleccione un Producto!', 'danger')
    } else {
        var $rows = $("#frmFormDetalleProducto input").each(function(index) {});
        var Detailproduct = new Object();
        for (var i = 0; i < $rows.length; i++) {
            if (i == 0) {
                if ($rows[0].value == '') {

                CreateMessage('Debe ingredar el tipo', 'danger')
               
            } else if ($rows[1].value == '') {
                CreateMessage('Debe ingredar la description', 'danger') 
            } else {
                Detailproduct.tipo = $rows[0].value;
                Detailproduct.description = $rows[1].value;
                Detailproduct.idProducto = idProducto;
                DetailProductIns(Detailproduct);
                LoadTableDetalleProducto();
               
             }

        }
    }

}
});

$("#idProducto").change(function() {
    LoadTableDetalleProducto();
});

function CreateMessage(message, tipo) {
    debugger;
    var msg = '<div class="alert alert-' + tipo + '"' + ' role="alert">' + message + '</div>'
    $(msg).appendTo('#msgResponse');
}

function LoadTableDetalleProducto() {
	debugger;
    Removetr();
    clearForm()
    var idProducto = $("#idProducto").val();
    if (idProducto == -1 || idProducto == null) {
        alert("Seleccione un producto.")
    } else {
        var Detailproduct = new Object();
        Detailproduct.idProducto = idProducto;
        var inputVal = document.getElementById("urldomain").value;
        var url = inputVal + "/WebService" + "/ListDetailProductByIdProduct";
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: url,
            data: JSON.stringify(Detailproduct),
            dataType: 'json',
            cache: false,
            success: function(data) {
                debugger;
                if (data !== null) {

                    if (data.length > 0) {
                        // Create Tr to GridDetalle Producto
                        //
                        const Createtr = '<tr role="row" id="21" tabindex="-1"class="jqgrow ui-row-ltr ui-widget-content">' +
                            '<td role="gridcell" style="text-align: center; width: 35px;"aria-describedby="grid-table_cb">' +
                            '<input role="checkbox" type="checkbox" id="jqg_grid-table_21" class="cbox cbox"name="jqg_grid-table_21">' +
                            '</td>' +
                            '<td role="gridcell" aria-describedby="grid-table_subgrid"class="ui-sgcollapsed sgcollapsed" style="">' +
                            '<a style="cursor: pointer;" class="ui-sghref">' +
                            '<span class="ui-icon ace-icon fa fa-plus center bigger-110 blue"></span> ' +
                            '</a>' +
                            '</td>' +
                            '<td role="gridcell" style="" title="" aria-describedby="grid-table_myac">' +
                            '<div style="margin-left: 8px;">' +
                            '<div title="" style="float: left; cursor: pointer;"' +
                            'class="ui-pg-div ui-inline-edit" id="jEditButton_21"' +
                            'onclick="jQuery.fn.fmatter.rowactions.call(this,"edit");"' +
                            'onmouseover="jQuery(this).addClass("ui-state-hover");"' +
                            'onmouseout="jQuery(this).removeClass("ui-state-hover");"' +
                            'data-original-title="Edit selected row">                   ' +
                            '<span class="ui-icon ui-icon-pencil"></span>               ' +
                            '</div>                                                     ' +
                            '<div title="" style="float: left;"                         ' +
                            'class="ui-pg-div ui-inline-del" id="jDeleteButton_21"      ' +
                            'onclick="jQuery.fn.fmatter.rowactions.call(this,"del");"   ' +
                            'onmouseover="jQuery(this).addClass("ui-state-hover");"     ' +
                            'onmouseout="jQuery(this).removeClass("ui-state-hover");"   ' +
                            'data-original-title="Delete selected row">                 ' +
                            '<span class="ui-icon ui-icon-trash"></span>                ' +
                            '</div>                                                     ' +
                            '<div title="" style="float: left; display: none"           ' +
                            'class="ui-pg-div ui-inline-save" id="jSaveButton_21"       ' +
                            'onclick="jQuery.fn.fmatter.rowactions.call(this,"save");"  ' +
                            'onmouseover="jQuery(this).addClass("ui-state-hover");"     ' +
                            'onmouseout="jQuery(this).removeClass("ui-state-hover");"   ' +
                            'data-original-title="Save row">                            ' +
                            '<span class="ui-icon ui-icon-disk"></span>                 ' +
                            '</div>                                                     ' +
                            '<div title="" style="float: left; display: none;"          ' +
                            'class="ui-pg-div ui-inline-cancel" id="jCancelButton_21"   ' +
                            'onclick="jQuery.fn.fmatter.rowactions.call(this,"cancel");"' +
                            'onmouseover="jQuery(this).addClass("ui-state-hover");"     ' +
                            'onmouseout="jQuery(this).removeClass("ui-state-hover");"   ' +
                            'data-original-title="Cancel row editing">      ' +
                            '<span class="ui-icon ui-icon-cancel"></span>   ' +
                            '</div>                                         ' +
                            '</div>                                         ' +
                            '</td>                                          ' +
                            '<td role="gridcell" style="" title="21"        ' +
                            'aria-describedby="grid-table_id">              ' +
                            '@TIPO                                          ' +
                            '</td>                                          ' +
                            '<td role="gridcell" style="" title="2007-12-03"' +
                            'aria-describedby="grid-table_sdate">           ' +
                            '@DESCRIPCION                                   ' +
                            '</td>                                          ' +
                            '</tr>                                          ';


                        // //Fin tr
                        for (i = 0; i < data.length; i++) {
                            var table = $('#grid-table tr:last');
                            const stripped = Createtr.replace('@TIPO', data[i].tipo);
                            const FinalTab = stripped.replace('@DESCRIPCION', data[i].description);
                            // const stripped = phrase.replace(/@DESCRIPCION/g, data[i].description);
//                            data[i].description;
//                            data[i].tipo;
//                            data[i].idProducto;
                            $('#grid-table tr:last').after(FinalTab);
                        }
                    }
                } else {
                    var msg = '<div class="alert alert-danger" role="alert">' +
                        'Se presento un error inesperado.!' +
                        '</div>'
                    $(msg).appendTo('#msgResponse');
                }

            },
            error: function(e) {

                var json = "<h4>Ajax Response</h4>&lt;pre&gt;" + e.responseText +
                    "&lt;/pre&gt;";
                $('#feedback').html(json);
                alert(e);
                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);

            }
        });
    }
}

function Removetr() {

    debugger;
    $('#grid-table').remove();
    $(CreateTable).appendTo('#tblCreate');

}

function clearForm() {

    debugger;
    $('#tipo').val('');
    $('#descripcion').val('');
//    var div = document.getElementById("msgResponse");
//    $("#msgResponse").css({
//        'background-color': '',
//        'opacity': ''
//    });
  $("#msgResponse").empty();

}



function DetailProductIns(Detailproduct) {
    debugger;

    var inputVal = document.getElementById("urldomain").value;
    var url = inputVal + "/WebService" + "/DetailProductIns";
    // var obj = '{'+'"idProducto" : 1' +'}'
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: url,
        data: JSON.stringify(Detailproduct),
        dataType: 'json',
        cache: false,
        success: function(data) {
        	 if(data==true)
        		 {
        		 CreateMessage('Se Guardo Correctamente!', 'success');
        		 
        		 }
        	 else
        	 { CreateMessage('Se detecto error inesperado', 'danger'); }
           
        },
        error: function(e) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;" + e.responseText +
                "&lt;/pre&gt;";
            $('#feedback').html(json);
            alert(e);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}