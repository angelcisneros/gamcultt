<%@ include file="/WEB-INF/pages/templates/head.jsp"%>
<%@ include file="/WEB-INF/pages/templates/navbar.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="contenido" class="container-fluid">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 ">
            <h2><strong>Salas</strong></h2>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-10 form-inline">
            <a id="addSalaButton" class="btn btn-primary btn-lg" role="button">Agregar Nuevo Sala +</a>
        </div>
    </div>
    <hr />
    <div class="row">
        <div class="col-md-1 col-lg-1"></div>
        <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10">
            <div class="row table-responsive">
                <table id="salaTable" class="table table-striped table-bordered table-hover">
                    <thead id="salaThead" class="text-center">
                        <tr>
                            <th>Nombre</th>
                            <th>Casa</th>
                            <th>Capacidad</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>

                    <tbody id="salaTbody">
                        <c:forEach items="${salas}" var="s" varStatus="status">
                            <tr valign="top">
                                <td class="nombre">
                                    <label class="nombre">${s.nombre}</label>
                                    <label id="${s.id}" class="ocultar">${s.id}</label>
                                </td>
                                <td class="nombreCasa">
                                    <label class="nombreCasa">${s.casa.nombre}</label>
                                </td>
                                <td class="capacidad">
                                    <label class="capacidad">${s.capacidad}</label>
                                </td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="">
                                        <button class="btn btn-primary salaUpdateButton">Editar</button>
                                        <button class="btn btn-danger salaDeleteButton">Eliminar</button>
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
<div class="modal fade" id="popUpSalaAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Agregar Nueva Sala</strong></h4>
            </div>
            <div class="modal-body">
                <form id="salaAddForm">
                    <label>Nombre:</label>
                    <input id="nombreAdd" name="nombre" class="form-control" type="text" placeholder="Ingrese el nombre de la Sala">
                    <br>
                    <label>Casa:</label>
                    <select id="casaAdd" name="casa.id" class="form-control">
                        <option value="0" label="Seleccione...">Seleccione...</option>
                        <c:forEach items="${casas}" var="c" varStatus="status">
                            <option value="${c.id}" label="${c.nombre}">${c.nombre}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <label>Capacidad:</label>
                    <input id="capacidadAdd" name="capacidad" class="form-control" type="text" placeholder="Ingrese la capacidad de Sala">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="addSala" type="button" class="btn btn-primary">Agregar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- POPUP ACTUALIZAR CASA -->
<div class="modal fade" id="popUpSalaUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Actualizar Sala</strong></h4>
            </div>
            <div class="modal-body">
                <form id="salaUpdateForm">
                    <label>Nombre:</label>
                    <input id="nombreUpdate" name="nombre" class="form-control" type="text" placeholder="Ingrese el nombre de la Sala">
                    <br>
                    <label>Casa:</label>
                    <select id="casaUpdate" name="casa.id" class="form-control">
                        <option value="0" label="Seleccione...">Seleccione...</option>
                        <c:forEach items="${casas}" var="c" varStatus="status">
                            <option value="${c.id}" label="${c.nombre}">${c.nombre}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <label>Capacidad:</label>
                    <input id="capacidadUpdate" name="capacidad" class="form-control" type="text" placeholder="Ingrese la capacidad de Sala">
                    <input id="idUpdate" name="id" class="form-control ocultar" type="text" placeholder="Ingrese el nombre del Grado">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="updateSala" type="button" class="btn btn-primary">Actualizar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- POPUP ELIMINAR ALUMNO -->
<div class="modal fade" id="popUpSalaDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header amarillo">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title"><strong>Eliminar Sala</strong></h4>
            </div>
            <div class="modal-body">
                <form id="salaDeleteForm">
                    <strong><label>Nombre:</label></strong>
                    <label id="nombreDelete"></label>
                    <br>
                    <strong><label>Casa:</label></strong>
                    <label id="casaDelete"></label>
                    <br>
                    <strong><label>Capacidad:</label></strong>
                    <label id="capacidadDelete"></label>
                    <input id="idDelete" name="id" class="form-control ocultar" type="text" placeholder="Ingrese el nombre del Sala">
                </form>
            </div>
            <div class="modal-footer amarillo">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button id="deleteSala" type="button" class="btn btn-primary">Eliminar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%@ include file="/WEB-INF/pages/templates/popUpRespuesta.jsp"%>
<script src="js/sala/sala.js" charset="UTF-8"></script>
<%@ include file="/WEB-INF/pages/templates/footer.jsp"%>
