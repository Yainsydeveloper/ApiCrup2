<section id="actions" class="py-4 mb-4 bg-success">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <a href="index.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i>
                    Regresar a Inicio
                </a>
            </div>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary btn-block">
                    <i class="fas fa-check"></i>
                    Guardar Modificación
                </button>
            </div>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/servletControlador?accion=eliminar&idbilletera=${moned.idbilletera}" class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i>
                    Eliminar Moneda
                </a>                  
            </div>           
        </div>
    </div>
</section>
                
