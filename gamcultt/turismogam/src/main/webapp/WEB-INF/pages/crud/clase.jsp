<%@ include file="/WEB-INF/pages/templates/head.jsp"%>
<%@ include file="/WEB-INF/pages/templates/navbar.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="contenido" class="container-fluid">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 ">
            <h2><strong>Clases</strong></h2>
        </div>
    </div>
    <hr />
     <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 form-inline">
            <a id="addClaseButton" class="btn btn-primary btn-lg" role="button">Agregar Nuevo Clase +</a>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-md-1 col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10">
            <div class="row table-responsive">
                <table id="claseTable" class="table table-striped table-bordered table-hover">
                    <thead id="claseThead" class="text-center">
                        <tr>
                            <th>Profesor</th>
                            <th>Sala</th>
                            <th>Taller</th>
                            <th>Costo</th>
                            <th>Horario</th>
                            <th>Status</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>
                    
                    <tbody id="claseTbody">
                        <c:forEach items="${clases}" var="c" varStatus="status">
                            <tr valign="top">
                                <td class="id">
                                    <label class="nombreProfesor">${c.profesor.nombre}</label>&#32;
                                    <label class="paternoProfesor">${c.profesor.paterno}</label>&#32;
                                    <label class="maternoProfesor">${c.profesor.materno}</label>
                                    <label id="${c.profesor.id}" class="ocultar">${c.profesor.id}</label>
                                </td>
                                <td>
                                    <label>${c.sala.nombre}</label>
                                </td>
                                <td>
                                    <label>${c.taller.nombre}</label>
                                </td>
                                <td>
                                    <label>${c.costo}</label>
                                </td>
                                 <td>
                                    <label>${c.horario}</label>
                                </td>
                                <td>
                                    <label>${c.status}</label>
                                </td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="">
                                    <button class="btn btn-primary claseUpdateButton">Editar</button>
                                    <button class="btn btn-danger claseDeleteButton">Eliminar</button>
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
<div class="modal fade" id="popUpClaseAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Agregar Nueva Clase</strong></h4>
            </div>
            <div class="modal-body">
                <form id="claseAddForm">
                    <label>Profesor:</label>
                        <select id="profesorAdd" name="profesor.id" class="form-control">
                            <option value="0" label="Seleccione...">Seleccione...</option>
                            <c:forEach items="${profesores}" var="p" varStatus="status">
                                <option value="${p.id}" label="${p.nombre} ${p.paterno} ${p.materno}">${p.nombre} ${p.paterno} ${p.materno}</option>
                            </c:forEach>
                        </select>
                    <br>
                    <label>Sala:</label>
                        <select id="salaAdd" name="sala.id" class="form-control">
                            <option value="0" label="Seleccione...">Seleccione...</option>
                            <c:forEach items="${salas}" var="s" varStatus="status">
                                <option value="${s.id}" label="${s.nombre}">${s.nombre}</option>
                            </c:forEach>
                        </select>
                    <br>
                    <label>Taller:</label>
                        <select id="tallerAdd" name="taller.id" class="form-control">
                            <option value="0" label="Seleccione...">Seleccione...</option>
                            <c:forEach items="${talleres}" var="t" varStatus="status">
                                <option value="${t.id}" label="${t.nombre}">${t.nombre}</option>
                            </c:forEach>
                        </select>
                    <br>
                    <label>Costo:</label>
                    <input id="costoAdd" name="costo" class="form-control" type="number" placeholder="Ingrese el costo del taller">
                    <br>
                    <label>Horario:</label>
                    <input id="horarioAdd" name="horario" class="form-control" type="text" placeholder="Ingrese el horario">
                    <br>
                    <label>Status:</label>
                    <input id="atatusAdd" name="status" class="form-control" type="text" placeholder="Ingrese el status">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="addClase" type="button" class="btn btn-primary">Agregar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- POPUP ACTUALIZAR ALUMNO -->
<div class="modal fade" id="popUpClaseUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Actualizar Clase</strong></h4>
            </div>
            <div class="modal-body">
                <form id="claseUpdateForm">
                    <label>Nombre(s):</label>
                    <input id="nombreUpdate" name="nombre" class="form-control" type="text" placeholder="Ingrese el nombre del Clase">
                    <br>
                    <label>Apellido Paterno:</label>
                    <input id="paternoUpdate" name="paterno" class="form-control" type="text" placeholder="Ingrese el Apellido Paterno del Clase">
                    <br>
                    <label>Apellido Materno:</label>
                    <input id="maternoUpdate" name="materno" class="form-control" type="text" placeholder="Ingrese el Apellino Materno del Clase">
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
                    <input id="telefono1Update" name="telefono1" class="form-control" type="text" placeholder="Ingrese el Teléfono del Clase">
                    <br>
                    <label>Teléfono 2:</label>
                    <input id="telefono2Update" name="telefono2" class="form-control" type="text" placeholder="Ingrese el Teléfono del Clase">
                    <br>
                    <label>Dirección</label>
                    <textarea id="direccionUpdate" name="direccion" class="form-control"></textarea>
                    
                    <input id="idUpdate" name="id" class="form-control ocultar" type="text" placeholder="Ingrese el nombre del Grado">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="updateClase" type="button" class="btn btn-primary">Actualizar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- POPUP ELIMINAR ALUMNO -->
<div class="modal fade" id="popUpClaseDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Eliminar Clase</strong></h4>
            </div>
            <div class="modal-body">
                <form id="claseDeleteForm">
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
                    <input id="idDelete" name="id" class="form-control ocultar" type="text" placeholder="Ingrese el nombre del Clase">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="deleteClase" type="button" class="btn btn-primary">Eliminar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%@ include file="/WEB-INF/pages/templates/popUpRespuesta.jsp"%>
<script src="js/clase/clase.js" charset="UTF-8"></script>
<%@ include file="/WEB-INF/pages/templates/footer.jsp"%>
