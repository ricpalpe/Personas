/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.HistoriaLaboralModelo;
import Vista.FrmHistoriaLaboral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Sala319
 */
public class ControladoresHistorial_Laboral implements ActionListener, MouseListener{
    
    FrmHistoriaLaboral vtnHistoriaLaboral;
    HistoriaLaboralModelo modelo = new HistoriaLaboralModelo();
    
    public enum AccionMVC{
        __VER_HISTORIAL,
        __AGREGAR_HISTORIAL,
        __ELIMINAR_HISTORIAL,
        __ADICIONAR_HISTORIAL,
        __NOMBRE
    } 
    
    public String FormatoFecha(Date fecha){        
        if (!(fecha == null)){            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            String formattedTime = formato.format(fecha);
            return formattedTime;
        }        
        return null;
    }
    public ControladoresHistorial_Laboral(FrmHistoriaLaboral vista){
        this.vtnHistoriaLaboral = vista;
      }

    
    public void Iniciar(){
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows."
//                                      + "WindowsLookAndFeel");
//            SwingUtilities.updateComponentTreeUI(vtnHistoriaLaboral);
            vtnHistoriaLaboral.setVisible(true);
            vtnHistoriaLaboral.setLocationRelativeTo(null);
//        } catch (UnsupportedLookAndFeelException ex) {}
//          catch (ClassNotFoundException ex){
//                JOptionPane.showMessageDialog(vtnHistoriaLaboral, "Error de driver de "
//                + "Video: "+ex.getMessage());
//          }
//          catch (InstantiationException ex){}
//          catch (IllegalAccessException ex){}
        
        this.vtnHistoriaLaboral.jBtnVerHisorial.setActionCommand("__VER_HISTORIAL");
        this.vtnHistoriaLaboral.jBtnVerHisorial.addActionListener(this);
        
        this.vtnHistoriaLaboral.jBtnAdicionarHistorial.setActionCommand("__ADICIONAR_HISTORIAL");
        this.vtnHistoriaLaboral.jBtnAdicionarHistorial.addActionListener(this);
        
        this.vtnHistoriaLaboral.jBtnAgregarHistorial.setActionCommand("__AGREGAR_HISTORIAL");
        this.vtnHistoriaLaboral.jBtnAgregarHistorial.addActionListener(this);
        
        this.vtnHistoriaLaboral.jBtnEliminarHistorial.setActionCommand("__ELIMINAR_HISTORIAL");
        this.vtnHistoriaLaboral.jBtnEliminarHistorial.addActionListener(this);
        
        this.vtnHistoriaLaboral.jTextDocumento.setActionCommand("__NOMBRE");
        this.vtnHistoriaLaboral.jTextDocumento.addActionListener(this);        
        
        this.vtnHistoriaLaboral.jTableHistoriaLaboral.addMouseListener(this);
        this.vtnHistoriaLaboral.jTableHistoriaLaboral.setModel(new DefaultTableModel());   
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        if(e.getButton()== 1)//boton izquierdo
        {
            int fila = this.vtnHistoriaLaboral.jTableHistoriaLaboral.rowAtPoint(e.getPoint());
            if(fila > -1){
                this.vtnHistoriaLaboral.jTextDocumento.setText(String.valueOf(
                        this.vtnHistoriaLaboral.jTableHistoriaLaboral.getValueAt(fila, 0)));
                this.vtnHistoriaLaboral.jDateChooserFIngreso.setDateFormatString(String.valueOf(
                        this.vtnHistoriaLaboral.jTableHistoriaLaboral.getValueAt(fila, 1)));
                this.vtnHistoriaLaboral.jCbCodigoCargo.setSelectedItem(String.valueOf(
                        this.vtnHistoriaLaboral.jTableHistoriaLaboral.getValueAt(fila, 2)));
                this.vtnHistoriaLaboral.jCbCodigoOficina.setSelectedItem(String.valueOf(
                        this.vtnHistoriaLaboral.jTableHistoriaLaboral.getValueAt(fila, 3)));
                this.vtnHistoriaLaboral.jDateChooserFEgreso.setDateFormatString(String.valueOf(
                        this.vtnHistoriaLaboral.jTableHistoriaLaboral.getValueAt(fila, 4)));
                this.vtnHistoriaLaboral.jTextDocumento.setEditable(false);
                this.vtnHistoriaLaboral.jDateChooserFIngreso.setEnabled(false);
                this.vtnHistoriaLaboral.jCbCodigoCargo.setEditable(false);
                this.vtnHistoriaLaboral.jCbCodigoOficina.setEditable(false);
                this.vtnHistoriaLaboral.jDateChooserFEgreso.setEnabled(false);
               
                 
            }
        }
    }
    
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch(AccionMVC.valueOf(e.getActionCommand())){
            
            case __VER_HISTORIAL:{
//                this.vtnHistoriaLaboral.jTableHistoriaLaboral.setModel(this.modelo.getTablaHistorial());
//                this.vtnHistoriaLaboral.jTableHistoriaLaboral.requestFocus();
//                break;
                this.vtnHistoriaLaboral.jTableHistoriaLaboral.setModel(this.modelo.
                            getTablaHistorial(this.vtnHistoriaLaboral.jTextNombre.getText()));                                                         
                    break; 
                
            }
            case __ADICIONAR_HISTORIAL:{
                this.vtnHistoriaLaboral.jTextDocumento.setEditable(true);
                this.vtnHistoriaLaboral.jTextNombre.setEditable(true);
                this.vtnHistoriaLaboral.jDateChooserFIngreso.setEnabled(true);
                this.vtnHistoriaLaboral.jCbCodigoCargo.setEditable(true);
                this.vtnHistoriaLaboral.jCbCodigoOficina.setEditable(true);
                this.vtnHistoriaLaboral.jDateChooserFEgreso.setEnabled(true);
                this.vtnHistoriaLaboral.jTextDocumento.requestFocus();
//                this.vtnHistoriaLaboral.jTextNombre.setText("");
////                this.vtnHistoriaLaboral.jDateChooserFIngreso.setDateFormatString("");
//                this.vtnHistoriaLaboral.jCbCodigoCargo.setSelectedItem("");
//                this.vtnHistoriaLaboral.jCbCodigoOficina.setSelectedItem("");
//                this.vtnHistoriaLaboral.jDateChooserFEgreso.setDateFormatString("");
                break;
            }
            case __AGREGAR_HISTORIAL:{                
                if (this.modelo.NuevoHistorial(
                        this.vtnHistoriaLaboral.jTextDocumento.getText(),
                        this.vtnHistoriaLaboral.jTextNombre.getText(),
                        FormatoFecha(this.vtnHistoriaLaboral.jDateChooserFIngreso.getDate()),
                        this.vtnHistoriaLaboral.jCbCodigoCargo.getSelectedItem().toString(),
                        this.vtnHistoriaLaboral.jCbCodigoOficina.getSelectedItem().toString(),
                        FormatoFecha(this.vtnHistoriaLaboral.jDateChooserFEgreso.getDate()))){
                this.vtnHistoriaLaboral.jTableHistoriaLaboral.setModel(this.modelo.getTablaHistorial());
                JOptionPane.showMessageDialog(vtnHistoriaLaboral, "Historial  Creado!.");
                this.vtnHistoriaLaboral.jTextDocumento.setText("");
                this.vtnHistoriaLaboral.jTextNombre.setText("");
//                this.vtnHistoriaLaboral.jDateChooserFIngreso.setDate("");
                this.vtnHistoriaLaboral.jCbCodigoCargo.setSelectedItem("");
                this.vtnHistoriaLaboral.jCbCodigoOficina.setSelectedItem("");
                this.vtnHistoriaLaboral.jDateChooserFEgreso.setDateFormatString("");
            }
            else
                JOptionPane.showMessageDialog(vtnHistoriaLaboral,"Datos Incorrectos!.");
            break;
        }
        case __ELIMINAR_HISTORIAL:{
        if(this.modelo.EliminarHistorial(this.vtnHistoriaLaboral.jTextDocumento.getText())){
            this.vtnHistoriaLaboral.jTableHistoriaLaboral.setModel(this.modelo.getTablaHistorial());
            JOptionPane.showMessageDialog(vtnHistoriaLaboral, "Historial Eliminado.");
            this.vtnHistoriaLaboral.jTextDocumento.setText("");
            this.vtnHistoriaLaboral.jTextNombre.setText("");
       
             }
          break;
           }
        case __NOMBRE:{
            this.vtnHistoriaLaboral.jTextNombre.setText(this.modelo.TraerNombre(this.vtnHistoriaLaboral.jTextDocumento.getText()));
          break;
           }
        }
    }
}

