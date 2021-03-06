/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceodeceo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateValidatorDateTimeFormatter {
    public static boolean isValid(final String date) {

        boolean valid = false;
        try {
            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            //DateTimeFormatter.ofPattern("uuuu-M-d")
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern("d/M/uuuu")
                            .withResolverStyle(ResolverStyle.STRICT)
            );
            valid = true;

        } catch (DateTimeParseException e) {
            e.printStackTrace();
            valid = false;
        }

        return valid;
    }
}
