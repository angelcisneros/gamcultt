<%@ include file="/WEB-INF/pages/templates/head.jsp"%>
<%@ include file="/WEB-INF/pages/templates/navbar.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="contenido" class="container-fluid">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 ">
            <h2><strong>Alumnos</strong></h2>
        </div>
    </div>
    <hr />
     <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 form-inline">
            <a id="addAlumnoButton" class="btn btn-primary btn-lg" role="button">Agregar Nuevo Alumno +</a>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-md-1 col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10">
            <div class="row table-responsive">
                <table id="alumnoTable" class="table table-striped table-bordered table-hover">
                    <thead id="alumnoThead" class="text-center">
                        <tr>
                            <th>Nombre</th>
                            <th>Edad</th>
                            <th>Nombre Tutor</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>
                    
                    <tbody id="alumnoTbody">
                        <c:forEach items="${alumnos}" var="a" varStatus="status">
                            <tr valign="top">
                                <td class="id">
                                    <label class="nombre">${a.nombre}</label>&#32;
                                    <label class="paterno">${a.paterno}</label>&#32;
                                    <label class="materno">${a.materno}</label>
                                    <label id="${a.id}" class="ocultar">${a.id}</label>
                                </td>
                                <td>
                                    <label>${a.edad}</label>
                                </td>
                                <td>
                                    <label>${a.nombreTutor}</label>
                                </td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="">
                                    <button class="btn btn-primary alumnoUpdateButton">Editar</button>
                                    <button class="btn btn-danger alumnoDeleteButton">Eliminar</button>
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
<div class="modal fade" id="popUpAlumnoAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Agregar Nueva Alumno</strong></h4>
            </div>
            <div class="modal-body">
                <form id="alumnoAddForm">
                    <label>Nombre(s):</label>
                    <input id="nombreAdd" name="nombre" class="form-control" type="text" placeholder="Ingrese el nombre del Alumno">
                    <br>
                    <label>Apellido Paterno:</label>
                    <input id="paternoAdd" name="paterno" class="form-control" type="text" placeholder="Ingrese el Apellido Paterno del Alumno">
                    <br>
                    <label>Apellido Materno:</label>
                    <input id="maternoAdd" name="materno" class="form-control" type="text" placeholder="Ingrese el Apellino Materno del Alumno">
                    <br>
                    <label>Edad:</label>
                    <input id="edadAdd" name="edad" class="form-control" type="email" placeholder="Ingrese el Edad">
                    <br>
                    <label>Nombre Tutor:</label>
                    <input id="nombreTutorAdd" name="nombreTutor" class="form-control" type="text" placeholder="Ingrese el Nombre del tutor">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="addAlumno" type="button" class="btn btn-primary">Agregar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- POPUP ACTUALIZAR ALUMNO -->
<div class="modal fade" id="popUpAlumnoUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Actualizar Alumno</strong></h4>
            </div>
            <div class="modal-body">
                <form id="alumnoUpdateForm">
                    <label>Nombre(s):</label>
                    <input id="nombreUpdate" name="nombre" class="form-control" type="text" placeholder="Ingrese el nombre del Alumno">
                    <br>
                    <label>Apellido Paterno:</label>
                    <input id="paternoUpdate" name="paterno" class="form-control" type="text" placeholder="Ingrese el Apellido Paterno del Alumno">
                    <br>
                    <label>Apellido Materno:</label>
                    <input id="maternoUpdate" name="materno" class="form-control" type="text" placeholder="Ingrese el Apellino Materno del Alumno">
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
                    <label>Tel�fono 1:</label>
                    <input id="telefono1Update" name="telefono1" class="form-control" type="text" placeholder="Ingrese el Tel�fono del Alumno">
                    <br>
                    <label>Tel�fono 2:</label>
                    <input id="telefono2Update" name="telefono2" class="form-control" type="text" placeholder="Ingrese el Tel�fono del Alumno">
                    <br>
                    <label>Direcci�n</label>
                    <textarea id="direccionUpdate" name="direccion" class="form-control"></textarea>
                    
                    <input id="idUpdate" name="id" class="form-control ocultar" type="text" placeholder="Ingrese el nombre del Grado">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="updateAlumno" type="button" class="btn btn-primary">Actualizar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- POPUP ELIMINAR ALUMNO -->
<div class="modal fade" id="popUpAlumnoDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Eliminar Alumno</strong></h4>
            </div>
            <div class="modal-body">
                <form id="alumnoDeleteForm">
                    <strong><label>Nombre:</label></strong>
                    <label id="nombreDelete"></label>
                    <br>
                    <strong><label>Empresa</label></strong>
                    <label id="empresaDelete"></label>
                    <br>
                    <strong><label>Correo</label></strong>
                    <label id="correoDelete"></label>
                    <br>
                    <strong><label>T�lefonos:</label></strong>
                    <label id="telefonoDelete"></label>
                    <br>
                    <strong><label>Direcci�n:</label></strong>
                    <label id="direccionDelete"></label>
                    <input id="idDelete" name="id" class="form-control ocultar" type="text" placeholder="Ingrese el nombre del Alumno">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="deleteAlumno" type="button" class="btn btn-primary">Eliminar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%@ include file="/WEB-INF/pages/templates/popUpRespuesta.jsp"%>
<script src="js/alumno/alumno.js" charset="UTF-8"></script>
<%@ include file="/WEB-INF/pages/templates/footer.jsp"%>
