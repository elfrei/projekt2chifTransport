package vk_warehousing.transportAutragsErstellung.transport.data;


public enum TransportEnum {
    TRANSPORT_NUMMER("Trans.Nr"),
    ROUTEN_NUMMER("Routen Nr"),     
    DAUER_BIS_BELADUNG("Dauer bis Belad."),
    ANZAHL_AUFTRAEGE("Aufträge");
    
    private String bezeichnung;
    
    TransportEnum(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
    
}
