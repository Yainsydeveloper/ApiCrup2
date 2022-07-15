package web;

import data.BilleteraDAO;
import entity.Monedas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{
    
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    editarMoneda(req,res);
                    break;
                case "eliminar":
                    eliminarMoneda(req,res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        } else {
            accionDefault(req, res);
        }
    }

    
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    guardarMoneda(req, res);
                    break;
                case "modificar":
                    modificarMoneda(req,res);
                    break;
                default:
                    accionDefault(req, res);
                    break;

            }
        }
    }
    
    private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List <Monedas> moned_list = new BilleteraDAO().findAll();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("pepe", moned_list);
        sesion.setAttribute("cantidadMonedas", calcularCant(moned_list));
        sesion.setAttribute("precioTotal", calcularPrecio(moned_list));
        //req.getRequestDispatcher("libros.jsp").forward(req, res);
        res.sendRedirect("moned_class.jsp");        
       
    }
    
    private void guardarMoneda(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String moneda = req.getParameter("moneda");
        String fundador = req.getParameter("fundador");
        int limiteDeEmision= Integer.parseInt(req.getParameter("limiteDeEmision"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));
        
        Monedas moned = new Monedas(moneda, fundador, limiteDeEmision, precio, cantidad);
        int regMod = new BilleteraDAO().create(moned);
        System.out.println("Insertados: " + regMod);
        accionDefault(req,res);
    }
    
    private void editarMoneda(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int idbilletera = Integer.parseInt(req.getParameter("idbilletera"));
        Monedas mod = new BilleteraDAO().findBookById(idbilletera);
        req.setAttribute("moned", mod);
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editarMoneda.jsp").forward(req, res);
    }
    
        private void modificarMoneda(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String moneda = req.getParameter("moneda");
        String fundador = req.getParameter("fundador");
        int limiteDeEmision = Integer.parseInt(req.getParameter("cantPaginas"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));

        int idbilletera = Integer.parseInt(req.getParameter("idbilletera"));

        Monedas mod = new Monedas(idbilletera, moneda, fundador, limiteDeEmision, precio, cantidad);

        int regMod = new BilleteraDAO().update(mod);

        System.out.println("SE ACTUALIZARON: " + regMod + " REGISTROS");

        accionDefault(req, res);
    }
    private void eliminarMoneda(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idbilletera = Integer.parseInt(req.getParameter("idbilletera"));
        
        int regDel = new BilleteraDAO().delete(idbilletera);
        
        System.out.println("REGISTROS ELIMINADOS: "+ regDel);
        
        accionDefault(req, res);
    }
  
    private int calcularCant(List<Monedas> lista){
        int cantidad=0;
        for (int i = 0; i < lista.size(); i++) {
            cantidad += lista.get(i).getCantidad();
        }
        return cantidad;
    }
    
    private double calcularPrecio(List<Monedas> lista){
        double precio=0;
        for (int i = 0; i < lista.size(); i++) {
            precio += (lista.get(i).getCantidad()*lista.get(i).getPrecio());
        }
        return precio;
    }
    
}
