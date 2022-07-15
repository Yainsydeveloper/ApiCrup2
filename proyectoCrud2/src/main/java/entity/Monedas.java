
package entity;

/**
 *
 * @author yains
 */
public class Monedas {
     private int idbilletera;
    private String moneda;
    private String fundador;
    private int limiteDeEmision;
    private double precio;
    private int cantidad;

    public Monedas(int idbilletera, String moneda, String fundador, int limiteDeEmision, double precio, int cantidad) {
        this.idbilletera = idbilletera;
        this.moneda = moneda;
        this.fundador = fundador;
        this.limiteDeEmision = limiteDeEmision;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Monedas(String moneda, String fundador, int limiteDeEmision, double precio, int cantidad) {
        this.moneda = moneda;
        this.fundador = fundador;
        this.limiteDeEmision = limiteDeEmision;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getIdbilletera() {
        return idbilletera;
    }

    public void setIdbilletera(int idbilletera) {
        this.idbilletera = idbilletera;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public int getLimiteDeEmision() {
        return limiteDeEmision;
    }

    public void setLimiteDeEmision(int limiteDeEmision) {
        this.limiteDeEmision = limiteDeEmision;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    @Override
    public String toString() {
        return "Monedas{" + "idbilletera=" + idbilletera + ", moneda=" + moneda + ", fundador=" + fundador + ", limiteDeEmision=" + limiteDeEmision + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
        
}
