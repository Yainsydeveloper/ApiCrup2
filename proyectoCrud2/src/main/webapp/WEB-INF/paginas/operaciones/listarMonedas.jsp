<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="monedas">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">                 
                        <h4>
                            <i class="fa-solid fa-coins"></i>
                            Criptomonedas
                        </h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Monedas</th>
                                <th>Fundador</th>
                                <th>Limite de Emisión</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="moned" items="${pepe}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${moned.moneda}</td>
                                    <td>${moned.fundador}</td>
                                    <td>${moned.limiteDeEmision} Millones</td>
                                    <td><fmt:formatNumber value="${moned.precio}" type="currency"/></td>
                                    <td>${moned.cantidad}</td>
                                    <!-- COMPLETAR HREF CUANDO ESTE TERMINADO JSP EDITAR -->
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idbilletera=${moned.idbilletera}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad de Monedas</h3>
                        <h4 class="display-4">
                            <i class="fa-solid fa-hand-holding-dollar"></i>
                            ${cantidadMonedas}
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-secondary text-white mb-3">
                    <div class="card-body">
                        <h3>Inversión</h3>
                        <h4 class="display-4">
                            <i class="fa-solid fa-landmark"></i>
                            <fmt:formatNumber value="${precioTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarMoneda.jsp"/>