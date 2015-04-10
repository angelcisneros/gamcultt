/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var trClick;
//MUESTRA LOS POPUPS CON SUS VALORES
$(document).on('ready', function() {

    //POPUP AGREGAR
    $('#addAlumnoButton').on('click', function() {
        $('#nombreAlumnoUpdate').removeAttr('style');
        cierraPopUpChiquito($('#nombreAlumnoUpdate'));
        $('#popUpAlumnoAdd').modal('show');
    });

    //POPUP EDITAR
    $('.alumnoUpdateButton').on('click', function() {
        rellenaPopUpUpdate(this);
    });

    //POPUP ELIMINAR
    $('.alumnoDeleteButton').on('click', function() {
        rellenaPopUpsDelete(this);
    });
});

//PETICIONES AJAX AL SERVIDOR
$(document).on('ready', function() {

    //AGREGAR EN BASE
    $('#addAlumno').on('click', function() {
        $('#nombreAdd').removeAttr('style');
        var requisitos = 0;
        var nombre = $('#nombreAdd').val();
        var paterno = $('#paternoAdd').val();
        var materno = $('#maternoAdd').val();
        var edad = $('#edadAdd').val();
        var nombreTutor = $('#nombreTutorAdd').val();

        if (nombre === '') {
            muestraPopUpCampoNoVacio($('#nombreAdd'));
            $('#nombreAdd').css("border", "1px solid red");
        } else {
            $('#nombreAdd').removeAttr('style');
            cierraPopUpChiquito($('#nombreAdd'));
            requisitos++;
        }

        if (paterno === '') {
            muestraPopUpCampoNoVacio($('#paternoAdd'));
            $('#paternoAdd').css("border", "1px solid red");
        } else {
            $('#paternoAdd').removeAttr('style');
            cierraPopUpChiquito($('#paternoAdd'));
            requisitos++;
        }
        if (materno === '') {
            muestraPopUpCampoNoVacio($('#maternoAdd'));
            $('#maternoAdd').css("border", "1px solid red");
        } else {
            $('#maternoAdd').removeAttr('style');
            cierraPopUpChiquito($('#maternoAdd'));
            requisitos++;
        }

        if($.isNumeric(edad)){
            $('#edadAdd').removeAttr('style');
            cierraPopUpChiquito($('#edadAdd'));
            requisitos++;
        }else{
            $('#edadAdd').css("border", "1px solid red");
            muestraPopUpCampoNumerico($('#edadAdd'));
        }
       
        
        if (nombreTutor === '') {
            muestraPopUpCampoNoVacio($('#nombreTutorAdd'));
            $('#nombreTutorAdd').css("border", "1px solid red");
        } else {
            $('#nombreTutorAdd').removeAttr('style');
            cierraPopUpChiquito($('#nombreTutorAdd'));
            requisitos++;
        }
        if (requisitos === 5) {

            $.ajax({
                type: 'POST',
                url: "agregarAlumno/",
                dataType: 'text',
                data: $('#alumnoAddForm').serialize(),
                success: function(respuesta) {
                    var respuesta = respuesta.split('#');
                    if (respuesta[0] === 'Correcto...') {
                        $('#tituloPopUp').text(respuesta[0]);
                        $('#contenidoPopUp').text(respuesta[1]);
                        $('#popUpAlumnoAdd').modal('hide');
                        $('#popUpRespuesta').modal('show');
                        $('.nuevoAlumno').removeClass();
                        $("#alumnoTbody").prepend(
                                '<tr valign="top" class="nuevoAlumno success">'+
                                '<td class="id">'+
                                    '<label class="nombre">' + nombre + '</label>&#32;'+
                                    '<label class="paterno">' + paterno + '</label>&#32;'+
                                    '<label class="materno">' + materno + '</label>'+
                                    '<label id="' + respuesta[2] + '" class="ocultar">' + respuesta[2] + '</label>'+
                                '</td>'+
                                '<td>'+
                                    '<label>' + edad + '</label>'+
                                '</td>'+
                                '<td>'+
                                    '<label>' + nombreTutor + '</label>'+
                                '</td>'+
                                '<td>'+
                                    '<div class="btn-group" role="group" aria-label="">'+
                                    '<button class="btn btn-primary alumnoUpdateButton">Editar</button>'+
                                    '<button class="btn btn-danger alumnoDeleteButton">Eliminar</button>'+
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

    //ACTUALIZAR BASE
    $('#updateAlumno').on('click', function() {
        var requisitos = 0;
        var nombre = $('#nombreUpdate').val();
        var paterno = $('#paternoUpdate').val();
        var materno = $('#maternoUpdate').val();
        var empresa = $('#empresaUpdate').val();
        var grado = $('#gradoUpdate').val();
        var mail = $('#correoUpdate').val();
        var telefono1 = $('#telefono1Update').val();
        var telefono2 = $('#telefono2Update').val();
        var direccion = $('#direccionUpdate').val();

        if (nombre === '') {
            muestraPopUpCampoNoVacio($('#nombreUpdate'));
            $('#nombreUpdate').css("border", "1px solid red");
        } else {
            $('#nombreUpdate').removeAttr('style');
            requisitos++;
        }

        if (paterno === '') {
            muestraPopUpCampoNoVacio($('#paternoUpdate'));
            $('#paternoUpdate').css("border", "1px solid red");
        } else {
            $('#paternoUpdate').removeAttr('style');
            requisitos++;
        }
        if (materno === '') {
            muestraPopUpCampoNoVacio($('#maternoUpdate'));
            $('#maternoUpdate').css("border", "1px solid red");
        } else {
            $('#maternoUpdate').removeAttr('style');
            requisitos++;
        }
        if (mail === '') {
            muestraPopUpCampoNoVacio($('#correoUpdate'));
            $('#correoUpdate').css("border", "1px solid red");
        } else {
            $('#correoUpdate').removeAttr('style');
            requisitos++;
        }
        if (empresa === '0' || empresa === 0) {
            muestraPopUpCampoNoVacio($('#empresaUpdate'));
            $('#empresaUpdate').css("border", "1px solid red");
        } else {
            $('#empresaUpdate').removeAttr('style');
            requisitos++;
        }

        if (grado === '0' || grado === 0) {
            muestraPopUpCampoNoVacio($('#gradoUpdate'));
            $('#gradoUpdate').css("border", "1px solid red");
        } else {
            $('#gradoUpdate').removeAttr('style');
            requisitos++;
        }
        if (telefono1 === '') {
            muestraPopUpCampoNoVacio($('#telefono1Update'));
            $('#telefono1Update').css("border", "1px solid red");
        } else {
            $('#telefono1Update').removeAttr('style');
            requisitos++;
        }

        if (requisitos === 7) {
            $.ajax({
                type: 'POST',
                url: "editarAlumno/",
                dataType: 'text',
                data: $('#alumnoUpdateForm').serialize(),
                success: function(respuesta) {
                    var respuesta = respuesta.split('#');
                    if (respuesta[0] === 'Correcto...') {
                        $('#tituloPopUp').text(respuesta[0]);
                        $('#contenidoPopUp').text(respuesta[1]);
                        $('#popUpAlumnoUpdate').modal('hide');
                        $('#popUpRespuesta').modal('show');
                        $('.nuevoAlumno').removeClass();
                        $(trClick).attr('class', 'success nuevoAlumno');
                        $(trClick).html(
                                '<td class="id" >' +
                                '<label class="grado">' + $('#gradoUpdate option:selected').text() + '</label>&#32;' +
                                '<label class="nombre">' + nombre + '</label>&#32;' +
                                '<label class="paterno">' + paterno + '</label>&#32;' +
                                '<label class="materno">' + materno + '</label>' +
                                '<label id="' + $('#idUpdate').val() + '" class="ocultar">' + $('#idUpdate').val() + '</label>' +
                                '</td>' +
                                ' <td>' +
                                '<label>' + $('#empresaUpdate option:selected').text() + '</label>' +
                                '</td>' +
                                '<td>' +
                                '<label class="telefono1">' + telefono1 + '</label> y ' +
                                '<label class="telefono2">' + telefono2 + '</label>' +
                                '</td>' +
                                '<td>' +
                                '<label>' + direccion + '</label>' +
                                '</td>' +
                                '<td>' +
                                '<button class="btn btn-primary alumnoUpdateButton">Editar</button>' +
                                '<button class="btn btn-danger alumnoDeleteButton">Eliminar</button>' +
                                ' </td>'
                                );
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alert('error');
                }
            });
        }

    });

    $('#deleteAlumno').on('click', function() {
        $.ajax({
            type: 'POST',
            url: "eliminarAlumno/",
            dataType: 'text',
            data: $('#alumnoDeleteForm').serialize(),
            success: function(respuesta) {
                var respuesta = respuesta.split('#');
                if (respuesta[0] === 'Correcto...') {
                    $('#tituloPopUp').text(respuesta[0]);
                    $('#contenidoPopUp').text(respuesta[1]);
                    $('#popUpAlumnoDelete').modal('hide');
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


$('#alumnoTbody').on('click', '.alumnoUpdateButton', function() {
    rellenaPopUpUpdate(this);
});

$('#alumnoTbody').on('click', '.alumnoDeleteButton', function() {
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

    $('#popUpAlumnoDelete').modal('show');
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

    $('#popUpAlumnoUpdate').modal('show');
}
