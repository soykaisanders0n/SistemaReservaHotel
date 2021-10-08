/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;


import javax.swing.JOptionPane;

/**
 *
 * @author Chv0
 */
public class Validaciones {
    public static boolean Cedula(String cedula) {
        boolean estado=false;
        try{
            if(cedula.length()==10){
                if((Integer.parseInt(cedula.substring(0, 2))<=24) || Integer.parseInt(cedula.substring(0, 2))<=30){
                    int[] coeficientes={2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int digito_verificador=Integer.parseInt(cedula.substring(cedula.length()-1, cedula.length()));
                    int suma=0;
                    int multiplic=0;
                    int modulo;
                    
                    for(int i=0; i<cedula.length()-1; i++){
                        multiplic=Integer.parseInt(cedula.substring(i, i+1))*coeficientes[i];
                        multiplic=(multiplic>9) ? multiplic-=9 : multiplic;
                        suma += multiplic;
                    }
                    modulo=suma%10;
                    if((10-modulo)==digito_verificador){
                        estado=true;
                    }
                    if(modulo==0 & modulo==digito_verificador){
                        estado=true;
                    }
                }else{
                    estado=false;
                    JOptionPane.showMessageDialog(null, "Cedula no pertenece a Ecuador");
                }
            }
        }catch(NumberFormatException e){
            estado=false;
            JOptionPane.showMessageDialog(null, "Error al validar");
        }
        return estado; 
    }
}
   /* public String ValidarCedula(String cedula) {
        try {
            Long ced = Long.parseLong(cedula);
        } catch (Exception e) {
            return "Ingrese solo numeros";
        }

        if (cedula.length() != 10) {
            return "La cedula tiene que tener 10 numeros";
        }
        return "";

    }*/
    
