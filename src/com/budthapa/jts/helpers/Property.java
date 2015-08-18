/*
 * To change this license header, choose License Headers in Project Property.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Buddhi Bal Thapa, budthapa@gmail.com
 */
public class Property {
    private final String CONFIG_FILE="./config.properties";

    public Properties getProperties() {
        Properties property = null;
        
        try (InputStream is = new FileInputStream(CONFIG_FILE)) {
            property = new Properties();
            property.load(is);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
        }
        return property;
    }
}
