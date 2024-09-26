
 
package modelo;

import java.sql.SQLException;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.IngresarEscritor;

/**
 *
 * @author Estudiante
 */
public class Escritor {

    /**
     * @return the id_escritor
     */
    public int getId_escritor() {
        return id_escritor;
    }

    /**
     * @param id_escritor the id_escritor to set
     */
    public void setId_escritor(int id_escritor) {
        this.id_escritor = id_escritor;
    }

    /**
     * @return the Nombre_Escritor
     */
    public String getNombre_Escritor() {
        return Nombre_Escritor;
    }

    /**
     * @param Nombre_Escritor the Nombre_Escritor to set
     */
    public void setNombre_Escritor(String Nombre_Escritor) {
        this.Nombre_Escritor = Nombre_Escritor;
    }

    /**
     * @return the Edad_Escritor
     */
    public int getEdad_Escritor() {
        return Edad_Escritor;
    }

    /**
     * @param Edad_Escritor the Edad_Escritor to set
     */
    public void setEdad_Escritor(int Edad_Escritor) {
        this.Edad_Escritor = Edad_Escritor;
    }

    /**
     * @return the Peso_Escritor
     */
    public double getPeso_Escritor() {
        return Peso_Escritor;
    }

    /**
     * @param Peso_Escritor the Peso_Escritor to set
     */
    public void setPeso_Escritor(double Peso_Escritor) {
        this.Peso_Escritor = Peso_Escritor;
    }

    /**
     * @return the Correo_Escritor
     */
    public String getCorreo_Escritor() {
        return Correo_Escritor;
    }

    /**
     * @param Correo_Escritor the Correo_Escritor to set
     */
    public void setCorreo_Escritor(String Correo_Escritor) {
        this.Correo_Escritor = Correo_Escritor;
    }
     private int id_escritor;
    private String Nombre_Escritor;
    private int Edad_Escritor;
    private double Peso_Escritor;
    private String Correo_Escritor;
    
    
    
    public void Guardar(){
        
          Connection conexion = ClaseConexion.getConexion();
          try{
          
              PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO tbEscritor (Nombre_Escritor, Edad_Escritor, Peso_Escritor, Correo_Escritor) VALUES (?,?,?,?)");
          
                addProducto.setString(1,getNombre_Escritor());
                addProducto.setInt(2,getEdad_Escritor());
                addProducto.setDouble(3,getPeso_Escritor());
                addProducto.setString(4,getCorreo_Escritor());
                
                
                addProducto.executeUpdate();
                
          
          }
           catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
         
}
    
     public void Mostrar (JTable tabla){
        
       Connection conexion = ClaseConexion.getConexion();
       DefaultTableModel modeloDeDatos = new DefaultTableModel();
       
        modeloDeDatos.setColumnIdentifiers(new Object[]{"id_escritor","Nombre_Escritor","Edad_Escritor","Peso_Escritor","Correo_Escritor"});
          try{
             Statement statement = conexion.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM tbEscritor;");
            
          while(rs.next()){
           modeloDeDatos.addRow(new Object[]{rs.getInt("id_escritor"),
               rs.getString("Nombre_Escritor"),
               rs.getInt("Edad_Escritor"),
               rs.getInt("Peso_Escritor"),
               rs.getString("Correo_Escritor")});
           tabla.setModel(modeloDeDatos);
          
          }
          
          
          }
          catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
        
          
        
        
        }
     
       public void Eliminar(JTable tabla){
          Connection conexion = ClaseConexion.getConexion();
          int filaSeleccionada = tabla.getSelectedRow();
          String miId = tabla.getValueAt(filaSeleccionada,0).toString();
          try{
             PreparedStatement deleteEstudiante = conexion.prepareStatement("DELETE FROM tbEscritor where id_escritor = ?");
              deleteEstudiante.setString(1,miId);
              deleteEstudiante.executeUpdate(); 
          }catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
       }
       
       public void cargarDatosTABLA(IngresarEscritor vista){
    
       int filaSeleccionada = vista.jtbEscitor.getSelectedRow();
       if (filaSeleccionada != -1){
           String id_escritorTb = vista.jtbEscitor.getValueAt(filaSeleccionada, 0).toString();
           String Nombre_EscritorTb = vista.jtbEscitor.getValueAt(filaSeleccionada, 1).toString();
           String Edad_EscritorTb = vista.jtbEscitor.getValueAt(filaSeleccionada,2).toString();
           String Peso_EscritorTb = vista.jtbEscitor.getValueAt(filaSeleccionada,3).toString();
           String Correo_EscritorTb = vista.jtbEscitor.getValueAt(filaSeleccionada, 4).toString();
           
           vista.txtNombre.setText(Nombre_EscritorTb);
           vista.txtEdad.setText(Edad_EscritorTb);
           vista.txtPeso.setText(Peso_EscritorTb);
           vista.txtCorreo.setText(Correo_EscritorTb);
           
           
           
           
       }
       }
     
       public void Actualizar(JTable tabla){
           
           Connection conexion = ClaseConexion.getConexion();
           int filaSeleccionada = tabla.getSelectedRow();
           if (filaSeleccionada != -1){
           
           String miID = tabla.getValueAt(filaSeleccionada, 0).toString();
           try{
               
               PreparedStatement updateUser = conexion.prepareStatement("UPDATE tbEscritor SET Nombre_Escritor = ?, Edad_Escritor = ?, Peso_Escritor = ?, Correo_Escritor = ? WHERE id_escritor = ?");
               updateUser.setString(1,getNombre_Escritor());
               updateUser.setInt(2,getEdad_Escritor());
               updateUser.setDouble(3,getPeso_Escritor());
               updateUser.setString(4,getCorreo_Escritor());
               updateUser.setString(5,miID);
               updateUser.executeUpdate();
               
           }catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
           
           }else {
            System.out.println("no");
        }
           
       }
       
}



