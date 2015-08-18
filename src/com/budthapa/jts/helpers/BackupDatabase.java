/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.helpers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author budthapa
 */
public class BackupDatabase {
        String backupLocation="DB_BACKUP_LOCATION";
        String installLocation="DB_INSTALL_LOCATION";
        

    /**
     * Backup Database
     *
     * @param dbName
     * @param dbUserName
     * @param dbPassword
     * @param timeStamp
     * @return
     */
    public boolean backupDB(String dbName, String dbUserName, String dbPassword) {
        Property prop=new Property();
        installLocation=prop.getProperties().getProperty(installLocation);
        backupLocation=prop.getProperties().getProperty(backupLocation);
        
        try {
            String[] cmd = new String[5];
//            cmd[0] = "\"C:\\Program Files/(x86)\\MySQL\\MySQL/Server/5.1\\bin\\mysqldump\"  -u root -p pass macfast -r backup.sql";

//            cmd[0] = "C:\\Program Files(x86)\\MySQL\\MySQL Server 5.1\\bin\\mysqldump"; //this will backup tables only
//            cmd[0] = "C:\\Program Files(x86)\\MySQL\\MySQL Server 5.1\\bin\\mysqldump"; //this will backup tables and stored procedures
//            cmd[1] = " --add-drop-database --routines -u " + dbUserName;
//            cmd[2] = " -p" + dbPassword + " " + dbName;
//            cmd[3] = " -r";
            CodeSource codeSource = BackupDatabase.class.getProtectionDomain().getCodeSource();

            //give the location of this class file
            File jarFile = new File(codeSource.getLocation().toURI().getPath());

            //give the folder location of the above file
            String jarDir = jarFile.getParentFile().getPath();

            // command to backup db
            //This works
//            Process runtimeProcess;
//            String c[]=new String[10];
//            c[0]="cmd.exe";
//            c[1]="/c";
//            c[2]="C:\\Program Files (x86)\\MySQL\\MySQL Server 5.1\\bin\\mysqldump";
//            c[3]="-u";
//            c[4]="root";
//            c[5]="-ppass";
//            c[6]="job_tracking_system";
//            c[7]="--add-drop-database";
//            c[8]="-r";
//            c[9]="E:\\job_tracking_system_backup.sql";
//            runtimeProcess = Runtime.getRuntime().exec(c);

            
            Process runtimeProcess;
            String c[]=new String[10];
            c[0]="cmd.exe";
            c[1]="/c";
            c[2]=installLocation;
            c[3]="-u";
            c[4]=dbUserName;
            c[5]="-p"+dbPassword;
            c[6]=dbName;
            c[7]="--add-drop-database";
            c[8]="-r";
            c[9]=backupLocation;
            runtimeProcess = Runtime.getRuntime().exec(c);

            System.out.println("db "+dbName+" user "+dbUserName+" pas "+dbPassword+" ins "+installLocation+" bk "+backupLocation);
            
            int processComplete;
            try {
                // Causes the current thread to wait, if necessary, until the
                // subprocess represented by this {@code Process} object has
                // terminated, or the specified waiting time elapses.
                processComplete = runtimeProcess.waitFor();
                System.out.println("processComplete " + processComplete);
                if (processComplete == 0) {
                    System.out.println("backup success");
                    return true;
                } else {
                    return false;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(BackupDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(BackupDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
