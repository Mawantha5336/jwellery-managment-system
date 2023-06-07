/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSpacegrayIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import gui.SignUp;

/**
 *
 * @author DELL
 */
public class Splash_Screen {
    
    
     public static void main(String[] args) {
        try {
            Thread.sleep(6000);
           // LookAndFeel laf = new SyntheticaBlackEyeLookAndFeel();
           // UIManager.setLookAndFeel(laf);
           UIManager.setLookAndFeel(new FlatCobalt2IJTheme());
            new SignUp().setVisible(true);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    
}
