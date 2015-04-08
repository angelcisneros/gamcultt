package mx.ipn.escom.entidades;
// Generated 8/04/2015 05:34:35 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Encargado generated by hbm2java
 */
@Entity
@Table(name="encargado"
    ,catalog="gamcultt"
)
public class Encargado  implements java.io.Serializable {


     private int id;
     private Casa casa;
     private Usuario usuario;
     private String telefono;
     private String contrasena;
     private Set<Propuesta> propuestas = new HashSet<Propuesta>(0);

    public Encargado() {
    }

	
    public Encargado(Casa casa, Usuario usuario) {
        this.casa = casa;
        this.usuario = usuario;
    }
    public Encargado(Casa casa, Usuario usuario, String telefono, String contrasena, Set<Propuesta> propuestas) {
       this.casa = casa;
       this.usuario = usuario;
       this.telefono = telefono;
       this.contrasena = contrasena;
       this.propuestas = propuestas;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="usuario"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
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

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="telefono", length=45)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="password", length=45)
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="encargado")
    public Set<Propuesta> getPropuestas() {
        return this.propuestas;
    }
    
    public void setPropuestas(Set<Propuesta> propuestas) {
        this.propuestas = propuestas;
    }




}

