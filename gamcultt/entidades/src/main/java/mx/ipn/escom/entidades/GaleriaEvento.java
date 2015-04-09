package mx.ipn.escom.entidades;
// Generated 9/04/2015 01:23:35 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GaleriaEvento generated by hbm2java
 */
@Entity
@Table(name="galeria_evento"
    ,catalog="gamcultt"
)
public class GaleriaEvento  implements java.io.Serializable {


     private Integer id;
     private Evento evento;
     private String nombre;
     private String extencion;
     private String ruta;

    public GaleriaEvento() {
    }

    public GaleriaEvento(Evento evento, String nombre, String extencion, String ruta) {
       this.evento = evento;
       this.nombre = nombre;
       this.extencion = extencion;
       this.ruta = ruta;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento", nullable=false)
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="extencion", nullable=false, length=5)
    public String getExtencion() {
        return this.extencion;
    }
    
    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }

    
    @Column(name="ruta", nullable=false, length=85)
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }




}


