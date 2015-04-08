package mx.ipn.escom.entidades;
// Generated 8/04/2015 05:34:35 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Profesor generated by hbm2java
 */
@Entity
@Table(name="profesor"
    ,catalog="gamcultt"
)
public class Profesor  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String paterno;
     private String materno;
     private String correo;
     private String telefono;
     private String celular;
     private Set<Clase> clases = new HashSet<Clase>(0);

    public Profesor() {
    }

	
    public Profesor(String nombre, String paterno, String materno, String correo) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.correo = correo;
    }
    public Profesor(String nombre, String paterno, String materno, String correo, String telefono, String celular, Set<Clase> clases) {
       this.nombre = nombre;
       this.paterno = paterno;
       this.materno = materno;
       this.correo = correo;
       this.telefono = telefono;
       this.celular = celular;
       this.clases = clases;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="paterno", nullable=false, length=45)
    public String getPaterno() {
        return this.paterno;
    }
    
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    
    @Column(name="materno", nullable=false, length=45)
    public String getMaterno() {
        return this.materno;
    }
    
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    
    @Column(name="correo", nullable=false, length=45)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    @Column(name="telefono", length=45)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="celular", length=45)
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="profesor")
    public Set<Clase> getClases() {
        return this.clases;
    }
    
    public void setClases(Set<Clase> clases) {
        this.clases = clases;
    }




}

