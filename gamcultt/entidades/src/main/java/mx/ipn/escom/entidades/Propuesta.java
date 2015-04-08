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
 * Propuesta generated by hbm2java
 */
@Entity
@Table(name="propuesta"
    ,catalog="gamcultt"
)
public class Propuesta  implements java.io.Serializable {

    @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="id", unique=true, nullable=false)
     @Getter @Setter private Integer id;
    @ManyToOne(fetch=FetchType.LAZY)
     @Getter @Setter private Encargado encargado;
    @Column(name="representante", nullable=false, length=105)
     @Getter @Setter private String representante;
    @Column(name="objetivo", nullable=false, length=65535)
     @Getter @Setter private String objetivo;
    @Column(name="personas")
     @Getter @Setter private Integer personas;
    @Column(name="descripcion", nullable=false, length=65535)
     @Getter @Setter private String descripcion;
    @Column(name="correo", nullable=false, length=85)
     @Getter @Setter private String correo;
     @Column(name="telefono", length=25)
     @Getter @Setter private String telefono;
     @Column(name="asistencia_estimada", nullable=false)
     @Getter @Setter private int asistenciaEstimada;

    public Propuesta() {
    }

	
    public Propuesta(Encargado encargado, String representante, String objetivo, String descripcion, String correo, int asistenciaEstimada) {
        this.encargado = encargado;
        this.representante = representante;
        this.objetivo = objetivo;
        this.descripcion = descripcion;
        this.correo = correo;
        this.asistenciaEstimada = asistenciaEstimada;
    }
    public Propuesta(Encargado encargado, String representante, String objetivo, Integer personas, String descripcion, String correo, String telefono, int asistenciaEstimada) {
       this.encargado = encargado;
       this.representante = representante;
       this.objetivo = objetivo;
       this.personas = personas;
       this.descripcion = descripcion;
       this.correo = correo;
       this.telefono = telefono;
       this.asistenciaEstimada = asistenciaEstimada;
    }
    }


