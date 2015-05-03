package vk_warehousing.transportAutragsErstellung.transport.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import vk_warehousing.transportAutragsErstellung.auftrag.data.Auftrag;
import vk_warehousing.transportAutragsErstellung.util.TimeUtil;

public class Transport {
    
    private String transportNummer, routenNummer;
    private Integer anzahlAuftraege;
    private Calendar dauerBisBeladung; //hh:mm
    private List<Auftrag> auftraege =
            new ArrayList<>();
    
    public static final String DAUER_FORMAT ="HH:mm";
    
    public Transport(String transportNummer, String routenNummer, Integer anzahlAuftraege, String dauerBisBeladung) 
            throws Exception
    {
        //plausi        
        if (TimeUtil.compareTime(DAUER_FORMAT, dauerBisBeladung,"00:00")==0)
        {
            throw new Exception("Dauer darf nicht 00:00 sein!");
        }
        //Setzen
        this.transportNummer = transportNummer;
        this.routenNummer = routenNummer;
//        this.dauerBisBeladung = GregorianCalendar.getInstance();
//        this.dauerBisBeladung.setTime(dauerBisBeladung);
        this.dauerBisBeladung = TimeUtil.convertToCalendar(
                                DAUER_FORMAT,dauerBisBeladung);
        this.anzahlAuftraege = anzahlAuftraege;
    }

    public Calendar getDauerBisBeladung() {
        return dauerBisBeladung;
    }
    public String getDauerBisBeladungAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String d = sdf.format(dauerBisBeladung.getTime());
        return d;
    }

    public String getTransportNummer() {
        return transportNummer;
    }

    public String getRoutenNummer() {
        return routenNummer;
    }

    public Integer getAnzahlAuftraege() {
        return anzahlAuftraege;
    }
    
    public void addAuftrag(Auftrag auftrag)
    {
        auftraege.add(auftrag);
    }
    
    public List<Auftrag> getAufraege()
    {
        return auftraege;
    }
    
}
