/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceodeceo.test;

import com.ceodeceo.utils.DateValidatorSimpleDateFormat;

public class test {
    
    public static void main(String[] args) {
        DateValidatorSimpleDateFormat dtValidator = new DateValidatorSimpleDateFormat();
        
        System.out.println(dtValidator.isValid("31/01/2021"));
        
        
    }

}
