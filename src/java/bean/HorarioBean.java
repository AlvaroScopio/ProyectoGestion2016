package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class HorarioBean implements Serializable{
    
    private String dia;
    private String horaInicio;
    private String horaFin;
    private String aula;
    private static final ArrayList<Order> orderList = new ArrayList<Order>(Arrays.asList());

    public HorarioBean() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String Hora_inicio) {
        this.horaInicio = Hora_inicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String Hora_fin) {
        this.horaFin = Hora_fin;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public  ArrayList<Order> getOrderList() {
        return orderList;
    }
    
    public void addAction() throws SQLException {

        Order order = new Order(this.dia, this.horaInicio, this.horaFin, this.aula);
        orderList.add(order);
        
    }
    
    public void deleteAction(Order order) {

        orderList.remove(order);
    }
    
    public String guardarAction(){
        
        orderList.clear();
        return "/index2?faces-redirect=true";
        
    }
    
    public static class Order {

        String dia;
        String Hora_inicio;
        String Hora_fin;
        String nombreaula;

        public Order(String dia, String hi,String hf, String nombreaula ) {
            this.dia = dia;
            this.Hora_inicio = hi;
            this.Hora_fin = hf;
            this.nombreaula = nombreaula;

        }     

        public String getDia() {
            return dia;
        }

        public void setDia(String dia) {
            this.dia = dia;
        }

        public String getHora_inicio() {
            return Hora_inicio;
        }

        public void setHora_inicio(String Hora_inicio) {
            this.Hora_inicio = Hora_inicio;
        }

        public String getHora_fin() {
            return Hora_fin;
        }

        public void setHora_fin(String Hora_fin) {
            this.Hora_fin = Hora_fin;
        }

        public String getNombreaula() {
            return nombreaula;
        }

        public void setNombreaula(String nombreaula) {
            this.nombreaula = nombreaula;
        }

    }
    
}
