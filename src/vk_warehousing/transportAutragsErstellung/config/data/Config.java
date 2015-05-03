
package vk_warehousing.transportAutragsErstellung.config.data;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Config {
    
    /*******
    Singleton:
    statische Zugriffsmethoden auf das Objekt
    ******/
    private static Config theInstance = null;
    public static Config theInstance()
    {
        if (theInstance==null)
        {
            theInstance = new Config();
        }
        return theInstance;
    }
    //    * Objekt Konstruktor ABER PRIVATE, erlaube nur einen einzigen Aufruf!!
    private Config()
    {
        try
        {
            load();
        }
        catch(Exception e)
        {
            //todo: Logging
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }
    
    /*************
    Restliche Klasse als Objekt (wie sonst)
    * Objekt Attribute
    * Objekt Business Methoden (getter, calc, usw)
    *******/
//    private Set<String> transportNummern= new HashSet<>()
//            , routenNummern = new HashSet<>();
    private Set<String> transportNummern= new TreeSet<>()
            , routenNummern = new TreeSet<>();
    
  
    public void addTransportNummer(String transportNummer)
            throws Exception
    {
        //todo: Plausi für falschen Prefix
        
        //Einfügen
        boolean inserted = transportNummern.add(
                transportNummer);
        //Meldung wenn Nr schon vorhanden
        if (!inserted)
        {
            throw new Exception("Transportnummer schon vorhanden!");
        }
    }
    
    public DefaultComboBoxModel<String> getTransportModel()
    {
        //init ComboBox für TransportNummer
        DefaultComboBoxModel<String> tNrModel = 
                new DefaultComboBoxModel(transportNummern.toArray()
                    );
        return tNrModel;
    }

    public DefaultComboBoxModel<String> getRoutenModel()
    {
        //init ComboBox für RoutenNummer
        DefaultComboBoxModel<String> rNrModel = 
                new DefaultComboBoxModel(routenNummern.toArray()
                    );
        return rNrModel;
    }
    
    public Object[] getTransportNummernAsArray()
    {
        return transportNummern.toArray();
    }
    
    public void addRoutenNummer(String routenNummer)
            throws Exception
    {
        //todo: Plausi für falschen Prefix
        
        //Einfügen
        boolean inserted = routenNummern.add(
                                routenNummer);
        //Meldung wenn Nr schon vorhanden
        if (!inserted)
        {
            throw new Exception("Routennummer schon vorhanden!");
        }
    }
    
    public void removeTransportNummer(String trNr)
    {
        
    }
    
    public Object[] getRoutenNummernAsArray()
    {
        return routenNummern.toArray();
    }    
    public void load()
            throws Exception
    {
        //Testdaten
        addTransportNummer("T001");
        addTransportNummer("T002");

        addRoutenNummer("R001");
        addRoutenNummer("R002");
        
        //todo Laden von ConfigDatei 
        //todo Überlege sinnvolle Struktur
    }

    public void save() 
            throws Exception
    {
        //todo: write to Config file
        //todo Überlege sinnvolle Struktur
            JOptionPane.showMessageDialog(null,
        "Save on WindowClosing:"+ 
                "T:"+transportNummern + 
                "R:"+routenNummern);
        
    }
}
