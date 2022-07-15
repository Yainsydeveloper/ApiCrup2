<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Billetera</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <form action = "${pageContext.request.contextPath}/servletControlador?accion=modificar&idbilletera=${moned.idbilletera}"
              method="POST" class="was-validated">
            <jsp:include page="/WEB-INF/paginas/comunes/editarNav.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div clas="card">
                                <div class="card-header">
                                    <h4>Editar Moneda</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre de Moneda</label>
                                        <input type="text" class="form-control" name="moneda" required="" value="${moned.moneda}">
                                    </div>
                                    <div class="form-group">
                                        <label for="autor">Fundador</label>
                                        <input type="text" class="form-control" name="fundador" value="${moned.fundador}">
                                    </div>
                                    <div class="form-group">
                                        <label for="cantPaginas">Limite de Emisi�n</label>
                                        <input type="number" class="form-control" name="limiteDeEmision" required="" value="${moned.limiteDeEmision}">
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Valor de la Moneda</label>
                                        <input type="currency" class="form-control" name="precio" required="" value="${moned.precio}">
                                    </div>
                                    <div class="form-group">
                                        <label for="copias">Cantidad de Monedas</label>
                                        <input type="number" class="form-control" name="cantidad" required="" value="${moned.cantidad}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>


        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

