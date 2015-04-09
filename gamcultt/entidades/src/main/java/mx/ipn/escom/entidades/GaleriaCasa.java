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
 * GaleriaCasa generated by hbm2java
 */
@Entity
@Table(name="galeria_casa"
    ,catalog="gamcultt"
)
public class GaleriaCasa  implements java.io.Serializable {


     private Integer id;
     private Casa casa;
     private String nombre;
     private String extencion;
     private String path;

    public GaleriaCasa() {
    }

    public GaleriaCasa(Casa casa, String nombre, String extencion, String path) {
       this.casa = casa;
       this.nombre = nombre;
       this.extencion = extencion;
       this.path = path;
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
    @JoinColumn(name="casa", nullable=false)
    public Casa getCasa() {
        return this.casa;
    }
    
    public void setCasa(Casa casa) {
        this.casa = casa;
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

    
    @Column(name="path", nullable=false, length=85)
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }




}


