package vk_warehousing.transportAutragsErstellung.auftrag.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import vk_warehousing.transportAutragsErstellung.auftrag.data.Auftrag;
import vk_warehousing.transportAutragsErstellung.auftrag.data.AuftragEnum;
import vk_warehousing.transportAutragsErstellung.auftragFilter.AlleAuftragFilter;
import vk_warehousing.transportAutragsErstellung.auftragFilter.AuftragFilter;

public class AuftragTableModel 
extends AbstractTableModel
{
    private List<Auftrag> originalAuftraege =
            new ArrayList<>();

    private AuftragFilter auftragFilter = new AlleAuftragFilter();
    
    public void setAuftraege(List<Auftrag> auftraege)
    {
        /* todo vielleicht weg */
        //todo ?? unklare
        this.originalAuftraege = auftraege;
        super.fireTableDataChanged();
    }
   
    @Override
    public int getRowCount() {
        return auftragFilter.size();
            //return auftraege.size();
    }

    @Override
    public int getColumnCount() {
        return AuftragEnum.values().length;
    }
    
    @Override
    public String getColumnName(int col)
    {
        return AuftragEnum.values()[col].getBezeichnung();
    }

    @Override
    public Object getValueAt(int row, int col) {
        //1.Datenobjekt der Reihe(row) aus Model holen
        //Auftrag a = auftraege.get(row);
        Auftrag a = auftragFilter.get(row);
        //2. Datenelement aus Spalte(col) asu Datenobjekt holen
        AuftragEnum colEnum = AuftragEnum.values()[col];
        
        switch (colEnum)
        {
            case TRANSPORT_NUMMER:
                return a.getTransportNummer();
            case AUFTRAG_NUMMER:
                return a.getAuftragNummer();
            case KUNDEN_NUMMER:
                return a.getKundenNummer();
            case ANZAHL_ARTIKEL:
                return a.getAnzahlArtikel();
            case KOMMISSIONS_DAUER:
                return a.getKommissionsDauer();
        }
        return "????";
    }
    
    //Business methode
    public void add(Auftrag auftrag)
    {
        //auftraege.add(auftrag);
        auftragFilter.add(auftrag);
        super.fireTableDataChanged();
    }

    /*
    todo load from BufferedReader
    */
    public void load() {
        add(new Auftrag("A001","K001",2, 23));
        add(new Auftrag("A002","K002",3, 13));
        add(new Auftrag("A001","K002",1, 7));        
    }

    public Auftrag get(int index) {
        return auftragFilter.get(index);
        //return auftraege.get(index);
    }

    public void setAuftragFilter(AuftragFilter auftragFilter) {
        originalAuftraege = this.auftragFilter.getOriginalAuftraege();
        
        this.auftragFilter = auftragFilter;
        
        auftragFilter.filter(originalAuftraege);
        
        super.fireTableDataChanged();
        
    }
}
