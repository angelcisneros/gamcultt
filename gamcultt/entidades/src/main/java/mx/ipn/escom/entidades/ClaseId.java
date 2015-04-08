package mx.ipn.escom.entidades;
// Generated 8/04/2015 05:34:35 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ClaseId generated by hbm2java
 */
@Embeddable
public class ClaseId  implements java.io.Serializable {


     private int profesor;
     private int taller;

    public ClaseId() {
    }

    public ClaseId(int profesor, int taller) {
       this.profesor = profesor;
       this.taller = taller;
    }
   


    @Column(name="profesor", nullable=false)
    public int getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }


    @Column(name="taller", nullable=false)
    public int getTaller() {
        return this.taller;
    }
    
    public void setTaller(int taller) {
        this.taller = taller;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ClaseId) ) return false;
		 ClaseId castOther = ( ClaseId ) other; 
         
		 return (this.getProfesor()==castOther.getProfesor())
 && (this.getTaller()==castOther.getTaller());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getProfesor();
         result = 37 * result + this.getTaller();
         return result;
   }   


}


