/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceodeceo.utils;

import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DateValidatorSimpleDateFormat {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");   //SimpleDateFormat("yyyy-M-d")

    public static boolean isValid(final String date) {

        boolean valid = false;
        try {
            // why 2008-02-2x, 20-11-02, 12012-04-05 are valid date?
            sdf.parse(date);
            // strict mode - check 30 or 31 days, leap year
            sdf.setLenient(false);
            valid = true;
        } catch (ParseException e) {
            e.printStackTrace();
            valid = false;
        }
        return valid;
    }
}
