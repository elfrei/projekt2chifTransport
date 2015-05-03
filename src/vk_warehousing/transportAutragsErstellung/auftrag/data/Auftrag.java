package vk_warehousing.transportAutragsErstellung.auftrag.data;

public class Auftrag {
    
    private String transportNummer, auftragNummer, kundenNummer;
    private Integer anzahlArtikel, kommissionsDauer;
    
    public static final String OHNE_T_NR = "-";

    public Auftrag(String auftragNummer, String kundenNummer, Integer anzahlArtikel, Integer kommissionsDauer) {
        this.transportNummer= OHNE_T_NR;
        this.auftragNummer = auftragNummer;
        this.kundenNummer = kundenNummer;
        this.anzahlArtikel = anzahlArtikel;
        this.kommissionsDauer = kommissionsDauer;
    }

    public String getTransportNummer() {
        return transportNummer;
    }
    
    public Integer getKommissionsDauer() {
        return kommissionsDauer;
    }

    
    public String getAuftragNummer() {
        return auftragNummer;
    }

    public String getKundenNummer() {
        return kundenNummer;
    }

    public Integer getAnzahlArtikel() {
        return anzahlArtikel;
    }

    public void setTransportNummer(String transportNummer) {
        this.transportNummer = transportNummer;
    }


    

    
}
