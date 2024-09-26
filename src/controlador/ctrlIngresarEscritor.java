/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    vista.btnIngresar.addMouseListener(this);
    modelo.Mostrar(vista.jtbEscitor);
    vista.btnEliminar.addMouseListener(this);
    vista.jtbEscitor.addMouseListener(this);
    vista.btnActualizar.addMouseListener(this);
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()== vista.btnIngresar){
        
        modelo.setNombre_Escritor(vista.txtNombre.getText());
      modelo.setEdad_Escritor(Integer.parseInt(vista.txtEdad.getText()));
      modelo.setPeso_Escritor(Double.parseDouble(vista.txtPeso.getText()));
      modelo.setCorreo_Escritor(vista.txtCorreo.getText());
        modelo.Guardar();
        modelo.Mostrar(vista.jtbEscitor);

        
        
        }
        
        if(e.getSource() == vista.btnEliminar){
        modelo.Eliminar(vista.jtbEscitor);
        modelo.Mostrar(vista.jtbEscitor);
        }
        if(e.getSource() == vista.jtbEscitor){
        modelo.cargarDatosTABLA(vista);
        
        }
        
        if(e.getSource()== vista.btnActualizar){
        modelo.setNombre_Escritor(vista.txtNombre.getText());
        modelo.setEdad_Escritor(Integer.parseInt(vista.txtEdad.getText()));
        modelo.setPeso_Escritor(Double.parseDouble(vista.txtPeso.getText()));
        modelo.setCorreo_Escritor(vista.txtCorreo.getText());
        
        modelo.Actualizar(vista.jtbEscitor);
        modelo.Mostrar(vista.jtbEscitor);
        }
        
        
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
