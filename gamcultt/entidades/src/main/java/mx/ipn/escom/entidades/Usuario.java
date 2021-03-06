package mx.ipn.escom.entidades;
// Generated 9/04/2015 01:23:35 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="gamcultt"
)
public class Usuario  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String correo;
     private boolean tipo;
     private String password;
     private Encargado encargado;

    public Usuario() {
    }

	
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, boolean tipo, String password) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.tipo = tipo;
        this.password = password;
    }
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, boolean tipo, String password, Encargado encargado) {
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.correo = correo;
       this.tipo = tipo;
       this.password = password;
       this.encargado = encargado;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="Nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido_paterno", nullable=false, length=45)
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    
    @Column(name="apellido_materno", nullable=false, length=45)
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    
    @Column(name="correo", nullable=false, length=45)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    @Column(name="tipo", nullable=false)
    public boolean isTipo() {
        return this.tipo;
    }
    
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="usuario")
    public Encargado getEncargado() {
        return this.encargado;
    }
    
    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }




}


