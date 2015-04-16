/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var trClick;
//MUESTRA LOS POPUPS CON SUS VALORES
$(document).on('ready', function() {

    //POPUP AGREGAR
    $('#addSalaButton').on('click', function() {
        $('#nombreSalaUpdate').removeAttr('style');
        cierraPopUpChiquito($('#nombreSalaUpdate'));
        $('#popUpSalaAdd').modal('show');
    });

    //POPUP EDITAR
    $('.salaUpdateButton').on('click', function() {
        rellenaPopUpUpdate(this);
    });

    //POPUP ELIMINAR
    $('.salaDeleteButton').on('click', function() {
        rellenaPopUpsDelete(this);
    });
});

//PETICIONES AJAX AL SERVIDOR
$(document).on('ready', function() {

    //AGREGAR EN BASE
    $('#addSala').on('click', function() {
        $('#nombreAdd').removeAttr('style');
        var requisitos = 0;
        var casa = $('#casaAdd').val();
        var nombre = $('#nombreAdd').val();
        var capacidad = $('#capacidadAdd').val();
        

        if (nombre === '') {
            muestraPopUpCampoNoVacio($('#nombreAdd'));
            $('#nombreAdd').css("border", "1px solid red");
        } else {
            $('#nombreAdd').removeAttr('style');
            cierraPopUpChiquito($('#nombreAdd'));
            requisitos++;
        }

        if (casa === '0' || casa === 0) {
            muestraPopUpCampoNoVacio($('#casaAdd'));
            $('#casaAdd').css("border", "1px solid red");
        } else {
            $('#casaAdd').removeAttr('style');
            cierraPopUpChiquito($('#casaAdd'));
            requisitos++;
        }
        if ($.isNumeric(capacidad)) {
            muestraPopUpCampoNoVacio($('#capacidadAdd'));
            $('#capacidadAdd').css("border", "1px solid red");
        } else {
            $('#capacidadAdd').removeAttr('style');
            cierraPopUpChiquito($('#capacidadAdd'));
            requisitos++;
        }

        
       
        if (requisitos === 3) {

            $.ajax({
                type: 'POST',
                url: "agregarSala/",
                dataType: 'text',
                data: $('#salaAddForm').serialize(),
                success: function(respuesta) {
                    var respuesta = respuesta.split('#');
                    if (respuesta[0] === 'Correcto...') {
                        $('#tituloPopUp').text(respuesta[0]);
                        $('#contenidoPopUp').text(respuesta[1]);
                        $('#popUpSalaAdd').modal('hide');
                        $('#popUpRespuesta').modal('show');
                        $('.nuevoSala').removeClass();
                        $("#salaTbody").prepend(
                                '<tr valign="top" class="success nuevoSala">'+
                                '<td class="id">'+
                                    '<label class="nombre">' + nombre +'</label>'+
                                    '<label id="' + respuesta[2] + '" class="ocultar">' + respuesta[2] + '</label>'+
                                '</td>'+
                                '<td>'+
                                    '<label class="casaNombre">' + $('#casaAdd option:selected').text() + '</label>'+
                                '</td>'+
                                '<td><label class="capacidad">' + capacidad + '</label>'+
                                '</td>'+
                                '<td>'+
                                    '<div class="btn-group" role="group" aria-label="">'+
                                        '<button class="btn btn-primary salaUpdateButton">Editar</button>'+
                                        '<button class="btn btn-danger salaDeleteButton">Eliminar</button>'+
                                    '</div>'+
                                '</td>'+
                            '</tr>'

                                );

                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alert('error');
                }
            });
        }

    });
//89/12 = 7.41 -7
//107/14 = 7.64 -5
//82/13 = 6.03 -1
//
    //ACTUALIZAR BASE
    $('#updateSala').on('click', function() {
       $('#nombreUpdate').removeAttr('style');
        var requisitos = 0;
        var casa = $('#casaUpdate').val();
        var nombre = $('#nombreUpdate').val();
        var capacidad = $('#capacidadUpdate').val();
        

        if (nombre === '') {
            muestraPopUpCampoNoVacio($('#nombreUpdate'));
            $('#nombreUpdate').css("border", "1px solid red");
        } else {
            $('#nombreUpdate').removeAttr('style');
            cierraPopUpChiquito($('#nombreUpdate'));
            requisitos++;
        }

        if (casa === '0' || casa === 0) {
            muestraPopUpCampoNoVacio($('#casaUpdate'));
            $('#casaUpdate').css("border", "1px solid red");
        } else {
            $('#casaUpdate').removeAttr('style');
            cierraPopUpChiquito($('#casaUpdate'));
            requisitos++;
        }
        if ($.isNumeric(capacidad)) {
            muestraPopUpCampoNoVacio($('#capacidadUpdate'));
            $('#capacidadUpdate').css("border", "1px solid red");
        } else {
            $('#capacidadUpdate').removeAttr('style');
            cierraPopUpChiquito($('#capacidadUpdate'));
            requisitos++;
        }

        
       
        if (requisitos === 3) {
            $.ajax({
                type: 'POST',
                url: "editarSala/",
                dataType: 'text',
                data: $('#salaUpdateForm').serialize(),
                success: function(respuesta) {
                    var respuesta = respuesta.split('#');
                    if (respuesta[0] === 'Correcto...') {
                        $('#tituloPopUp').text(respuesta[0]);
                        $('#contenidoPopUp').text(respuesta[1]);
                        $('#popUpSalaUpdate').modal('hide');
                        $('#popUpRespuesta').modal('show');
                        $('.nuevoSala').removeClass();
                        $(trClick).attr('class', 'success nuevoSala');
                        $(trClick).html(
                                '<tr valign="top" class="success nuevoSala">'+
                                '<td class="id">'+
                                    '<label class="nombre">' + nombre +'</label>'+
                                    '<label id="'+ $('#idUpdate').val()+ '" class="ocultar">' + respuesta[2] + '</label>'+
                                '</td>'+
                                '<td>'+
                                    '<label class="casaNombre">' + $('#casaUpdate :selected').text() + '</label>'+
                                '</td>'+
                                '<td><label class="capacidad">' + capacidad + '</label>'+
                                '</td>'+
                                '<td>'+
                                    '<div class="btn-group" role="group" aria-label="">'+
                                        '<button class="btn btn-primary salaUpdateButton">Editar</button>'+
                                        '<button class="btn btn-danger salaDeleteButton">Eliminar</button>'+
                                    '</div>'+
                                '</td>'+
                            '</tr>'
                                );
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alert('error');
                }
            });
        }

    });

    $('#deleteSala').on('click', function() {
        $.ajax({
            type: 'POST',
            url: "eliminarSala/",
            dataType: 'text',
            data: $('#salaDeleteForm').serialize(),
            success: function(respuesta) {
                var respuesta = respuesta.split('#');
                if (respuesta[0] === 'Correcto...') {
                    $('#tituloPopUp').text(respuesta[0]);
                    $('#contenidoPopUp').text(respuesta[1]);
                    $('#popUpSalaDelete').modal('hide');
                    $('#popUpRespuesta').modal('show');
                    $(trClick).remove();
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert('error');
            }
        });
    });

});


$('#salaTbody').on('click', '.salaUpdateButton', function() {
    rellenaPopUpUpdate(this);
});

$('#salaTbody').on('click', '.salaDeleteButton', function() {
    rellenaPopUpsDelete(this);
});

function rellenaPopUpsDelete(selector) {
    var tds = $($(selector).parent()).siblings('td');
    var id = $($($($(selector).parent()).siblings('td.id')).children('label.ocultar')).text();
    var nombre = $($(tds[0]).children('label.nombre')).text();
    var paterno = $($(tds[0]).children('label.paterno')).text();
    var materno = $($(tds[0]).children('label.materno')).text();
    var grado = $($(tds[0]).children('label.grado')).text();
    var mail = $($(tds[1]).children('label')).text();
    var empresa = $($(tds[2]).children('label')).text();
    var telefono1 = $($(tds[3]).children('label.telefono1')).text();
    var telefono2 = $($(tds[3]).children('label.telefono2')).text();
    var direccion = $(tds[4]).children('label.telefono2').text();
    trClick = $($(selector).parent()).parent();

    $('#idDelete').val(id);
    $('#nombreDelete').text(grado + ' ' + nombre + ' ' + paterno + ' ' + materno);
    $('#empresaDelete').text(empresa);
    $('#telefonoDelete').text(telefono1 + ' y ' + telefono2);
    $('#direccionDelete').text(direccion);
    $('#correoDelete').text(mail);

    $('#popUpSalaDelete').modal('show');
}

function rellenaPopUpUpdate(selector) {
    var tds = $($(selector).parent()).siblings('td');
    var id = $($($($(selector).parent()).siblings('td.id')).children('label.ocultar')).text();
    var nombre = $($(tds[0]).children('label.nombre')).text();
    var paterno = $($(tds[0]).children('label.paterno')).text();
    var materno = $($(tds[0]).children('label.materno')).text();
    var grado = $($(tds[0]).children('label.grado')).text();
    var mail = $($(tds[1]).children('label')).text();
    var empresa = $($(tds[2]).children('label')).text();
    var telefono1 = $($(tds[3]).children('label.telefono1')).text();
    var telefono2 = $($(tds[3]).children('label.telefono2')).text();
    var direccion = $(tds[4]).children('label.telefono2').text();
    trClick = $($(selector).parent()).parent();

    $('#idUpdate').val(id);
    $('#nombreUpdate').val(nombre);
    $('#paternoUpdate').val(paterno);
    $('#maternoUpdate').val(materno);
    setOption($('#gradoUpdate').children('option'), grado);
    setOption($('#empresaUpdate').children('option'), empresa);
    $('#telefono1Update').val(telefono1);
    $('#telefono2Update').val(telefono2);
    $('#direccionUpdate').val(direccion);
    $('#mailUpdate').val(mail);
    $('#popUpSalaUpdate').modal('show');
}
