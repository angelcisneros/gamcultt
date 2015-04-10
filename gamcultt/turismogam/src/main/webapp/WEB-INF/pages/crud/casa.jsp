<%@ include file="/WEB-INF/pages/templates/head.jsp"%>
<%@ include file="/WEB-INF/pages/templates/navbar.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="contenido" class="container-fluid">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 ">
            <h2><strong>Casas</strong></h2>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 form-inline">
            <a id="addCasaButton" class="btn btn-primary btn-lg" role="button">Agregar Nuevo Casa +</a>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-md-1 col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10">
            <div class="row table-responsive">
                <table id="casaTable" class="table table-striped table-bordered table-hover">
                    <thead id="casaThead" class="text-center">
                        <tr>
                            <th>Nombre</th>
                            <th>Direccion</th>
                            <th>Telefono</th>
                            <th>Horario</th>
                            <th>Informacion</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>

                    <tbody id="casaTbody">
                        <c:forEach items="${casas}" var="c" varStatus="status">
                            <tr valign="top">
                                <td class="id">
                                    <label class="nombre">${c.nombre}</label>&#32;
                                    <label id="${c.id}" class="ocultar">${c.id}</label>
                                </td>
                                <td>
                                    <label class="direccion">${c.direccion}</label>&#32;
                                </td>
                                <td>
                                    <label class="telefono">${c.telefono}</label>

                                </td>
                                <td>
                                    <label class="horario">${c.horario}</label>

                                </td>                                    
                                <td>
                                    <label class="informacion">${c.informacion}</label>
                                </td>     
                                <td>
                                    <div class="btn-group" role="group" aria-label="">
                                        <button class="btn btn-primary casaUpdateButton">Editar</button>
                                        <button class="btn btn-danger casaDeleteButton">Eliminar</button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-1 col-lg-1"></div>
    </div>
</div>

<!-- POPUP AGREGAR ALUMNO -->
<div class="modal fade" id="popUpCasaAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Agregar Nueva Casa</strong></h4>
            </div>
            <div class="modal-body">
                <form id="casaAddForm">
                    <label>Nombre de la Casa:</label>
                    <input id="nombreAdd" name="nombre" class="form-control" type="text" placeholder="Ingrese el nombre del Casa">
                    <br>
                    <label>Direccion:</label>
                    <input id="direccionAdd" name="direccion" class="form-control" type="text" placeholder="Ingrese la direccion de la Casa">
                    <br>
                    <label>Telefono:</label>
                    <input id="telefonoAdd" name="telefono" class="form-control" type="text" placeholder="Ingrese el Telefono">
                    <br>
                    <label>Horario:</label>
                    <input id="horarioAdd" name="horario" class="form-control" type="email" placeholder="Ingrese el Horario de la Casa">
                    <br>
                    <label>Informacion:</label>
                    <input id="informacionAdd" name="informacion" class="form-control" type="text" placeholder="Ingrese informacion extra de la casa">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="addCasa" type="button" class="btn btn-primary">Agregar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- POPUP ACTUALIZAR ALUMNO -->
<div class="modal fade" id="popUpCasaUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Actualizar Casa</strong></h4>
            </div>
            <div class="modal-body">
                <form id="casaUpdateForm">
                    <label>Nombre(s):</label>
                    <input id="nombreUpdate" name="nombre" class="form-control" type="text" placeholder="Ingrese el nombre del Casa">
                    <br>
                    <label>Apellido Paterno:</label>
                    <input id="paternoUpdate" name="paterno" class="form-control" type="text" placeholder="Ingrese el Apellido Paterno del Casa">
                    <br>
                    <label>Apellido Materno:</label>
                    <input id="maternoUpdate" name="materno" class="form-control" type="text" placeholder="Ingrese el Apellino Materno del Casa">
                    <br>
                    <label>Correo:</label>
                    <input id="correoUpdate" name="mail" class="form-control" type="email" placeholder="Ingrese el Correo">
                    <br>
                    <label>Grado:</label>
                    <select id="gradoUpdate" name="grado.id" class="form-control">
                        <option value="0" label="Seleccione...">Seleccione...</option>
                        <c:forEach items="${grado}" var="g" varStatus="status">
                            <option value="${g.id}" label="${g.nombre}">${g.nombre}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <label>Empresa</label>
                    <select id="empresaUpdate" name="empresa.id" class="form-control">
                        <option value="0" label="Seleccione...">Seleccione...</option>
                        <c:forEach items="${empresa}" var="e" varStatus="status">
                            <option value="${e.id}" label="${e.razonSocial}">${e.razonSocial}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <label>Teléfono 1:</label>
                    <input id="telefono1Update" name="telefono1" class="form-control" type="text" placeholder="Ingrese el Teléfono del Casa">
                    <br>
                    <label>Teléfono 2:</label>
                    <input id="telefono2Update" name="telefono2" class="form-control" type="text" placeholder="Ingrese el Teléfono del Casa">
                    <br>
                    <label>Dirección</label>
                    <textarea id="direccionUpdate" name="direccion" class="form-control"></textarea>

                    <input id="idUpdate" name="id" class="form-control ocultar" type="text" placeholder="Ingrese el nombre del Grado">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="updateCasa" type="button" class="btn btn-primary">Actualizar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- POPUP ELIMINAR ALUMNO -->
<div class="modal fade" id="popUpCasaDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Eliminar Casa</strong></h4>
            </div>
            <div class="modal-body">
                <form id="casaDeleteForm">
                    <strong><label>Nombre:</label></strong>
                    <label id="nombreDelete"></label>
                    <br>
                    <strong><label>Empresa</label></strong>
                    <label id="empresaDelete"></label>
                    <br>
                    <strong><label>Correo</label></strong>
                    <label id="correoDelete"></label>
                    <br>
                    <strong><label>Télefonos:</label></strong>
                    <label id="telefonoDelete"></label>
                    <br>
                    <strong><label>Dirección:</label></strong>
                    <label id="direccionDelete"></label>
                    <input id="idDelete" name="id" class="form-control ocultar" type="text" placeholder="Ingrese el nombre del Casa">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="deleteCasa" type="button" class="btn btn-primary">Eliminar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%@ include file="/WEB-INF/pages/templates/popUpRespuesta.jsp"%>
<script src="js/casa/casa.js" charset="UTF-8"></script>
<%@ include file="/WEB-INF/pages/templates/footer.jsp"%>
