
 
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Escritor;
import vista.IngresarEscritor;

/**
 *
 * @author Estudiante
 */
public class ctrlIngresarEscritor implements MouseListener{
    
    
    private Escritor modelo;
    private IngresarEscritor vista;
    
    public ctrlIngresarEscritor(Escritor modelo, IngresarEscritor vista){
    
    this.modelo= modelo;
    this.vista = vista;
    
    /*
    vista.btnIngresar.addMouseListener(this);
    vista.btnEliminar.addMouseListener(this);
    vista.jtEscritor.addMouseListener(this);
    vista.btnActualizar.addMouseListener(this);
    */ 
    
    modelo.Mostrar(vista.jtEscritor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      /*  
        if(e.getSource()== vista.btnIngresar){
        
        modelo.setNombre_Escritor(vista.txtNombre.getText());
      modelo.setEdad_Escritor(Integer.parseInt(vista.txtEdad.getText()));
      modelo.setPeso_Escritor(Double.parseDouble(vista.txtPeso.getText()));
      modelo.setCorreo_Escritor(vista.txtCorreo.getText());
        modelo.Guardar();
        modelo.Mostrar(vista.jtEscritor);

        
        
        }
        
        if(e.getSource() == vista.btnEliminar){
        modelo.Eliminar(vista.jtEscritor);
        modelo.Mostrar(vista.jtEscritor);
        }
        if(e.getSource() == vista.jtEscritor){
        modelo.cargarDatosTABLA(vista);
        
        }
        
        if(e.getSource()== vista.btnActualizar){
        modelo.setNombre_Escritor(vista.txtNombre.getText());
        modelo.setEdad_Escritor(Integer.parseInt(vista.txtEdad.getText()));
        modelo.setPeso_Escritor(Double.parseDouble(vista.txtPeso.getText()));
        modelo.setCorreo_Escritor(vista.txtCorreo.getText());
        
        modelo.Actualizar(vista.jtEscritor);
        modelo.Mostrar(vista.jtEscritor);
        }
        */
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
   
}
