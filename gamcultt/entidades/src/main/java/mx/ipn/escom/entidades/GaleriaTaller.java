package mx.ipn.escom.entidades;
// Generated 8/04/2015 05:34:35 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * GaleriaTaller generated by hbm2java
 */
@Entity
@Table(name="galeria_taller"
    ,catalog="gamcultt"
)
public class GaleriaTaller  implements java.io.Serializable {

    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="id", unique=true, nullable=false)  
     @Getter @Setter private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="taller", nullable=false)
     @Getter @Setter private Taller taller;
    @Column(name="nombre", nullable=false, length=45)
     @Getter @Setter private String nombre;
    @Column(name="extencion", nullable=false, length=5)
     @Getter @Setter private String extencion;
    @Column(name="ruta", nullable=false, length=85)
     @Getter @Setter private String ruta;

    public GaleriaTaller() {
    }

    public GaleriaTaller(Taller taller, String nombre, String extencion, String path) {
       this.taller = taller;
       this.nombre = nombre;
       this.extencion = extencion;
       this.ruta = path;
    }
}


