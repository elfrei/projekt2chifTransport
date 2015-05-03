package vk_warehousing.transportAutragsErstellung.transport.data;

import java.util.Date;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import vk_warehousing.transportAutragsErstellung.util.TimeUtil;


public class DauerInputVerifier 
extends InputVerifier
{
    @Override
    public boolean verify(JComponent input) {
        JFormattedTextField jfTF =(JFormattedTextField) input;
        String sInput = jfTF.getText();
        //Check ob String im Textfeld richtiges Format!
        try
        {
            Date d = TimeUtil.convertToDate(Transport.DAUER_FORMAT, sInput);
            return true; //Umwandeln erfolgreich
        }
        catch (Exception e)
        {
            return false; //Umwandeln NICHt erfolgreich            
        }
    }
    
}
