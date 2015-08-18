package com.budthapa.jts.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;


class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text)  {
        try {
            return dateFormatter.parseObject(text);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(DateLabelFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String valueToString(Object value) {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}