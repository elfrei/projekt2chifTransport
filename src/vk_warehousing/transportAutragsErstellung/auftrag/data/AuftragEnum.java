package vk_warehousing.transportAutragsErstellung.auftrag.data;


public enum AuftragEnum {
    TRANSPORT_NUMMER("Transp.Nr"),
    AUFTRAG_NUMMER("Auftrag Nr"),
    KUNDEN_NUMMER("Kunden Nr"),     
    ANZAHL_ARTIKEL("Artikeln"),
    KOMMISSIONS_DAUER("Komm.Dauer");
    
    private String bezeichnung;
    
    AuftragEnum(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
    
}
