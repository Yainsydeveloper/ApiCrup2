<div class="modal fade" id="agregarMonedaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-success text-white">
                <h5 class="modal-title">Agregar Moneda</h5>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="moneda">Moneda</label>
                        <input type="text" class="form-control" name="moneda" required="">
                    </div>
                    <div class="form-group">
                        <label for="fundador">Fundador</label>
                        <input type="text" class="form-control" name="fundador">
                    </div>
                    <div class="form-group">
                        <label for="limiteDeEmision">Limite de Emisión</label>
                        <input type="number" class="form-control" name="cantPaginas" required="">
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="currency" class="form-control" name="precio" required="">
                    </div>
                    <div class="form-group">
                        <label for="cantidad">Cantidad de Monedas</label>
                        <input type="number" class="form-control" name="cantidad" required="">
                    </div>
                </div>
                <div class="modal-footer bg-success text-white">
                    <button class="btn btn-secondary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
