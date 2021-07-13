/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceodeceo.utils;

public class isDateFormat {
    
    public boolean isValid(String date) {
        String[] registro;
        boolean valid = false;
              
        try {
            registro = date.split("/");
            if (registro.length == 3) {
                return true;
            }            
        } catch (Exception e) {
        }        
        return valid;
    }
    
    public static void main(String[] args) {
        isDateFormat obj = new isDateFormat();
        System.out.println(obj.isValid("01/01/2021"));
    }

}
