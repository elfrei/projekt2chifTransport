package vk_warehousing.transportAutragsErstellung.transport.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import vk_warehousing.transportAutragsErstellung.auftrag.data.Auftrag;
import vk_warehousing.transportAutragsErstellung.transport.data.Transport;
import vk_warehousing.transportAutragsErstellung.transport.data.TransportEnum;

public class TransportTableModel 
extends AbstractTableModel
{
    private List<Transport> transporte =
            new ArrayList<>();
    
    @Override
    public int getRowCount() {
            return transporte.size();
    }

    @Override
    public int getColumnCount() {
        return TransportEnum.values().length;
    }
    
    @Override
    public String getColumnName(int col)
    {
        return TransportEnum.values()[col].getBezeichnung();
    }

    @Override
    public Object getValueAt(int row, int col) {
        //1.Datenobjekt der Reihe(row) aus Model holen
        Transport t = transporte.get(row);
        //2. Datenelement aus Spalte(col) asu Datenobjekt holen
        TransportEnum colEnum = TransportEnum.values()[col];
        
        switch (colEnum)
        {
            case TRANSPORT_NUMMER:
                return t.getTransportNummer();
            case ROUTEN_NUMMER:
                return t.getRoutenNummer();
            case ANZAHL_AUFTRAEGE:
                return t.getAnzahlAuftraege();
            case DAUER_BIS_BELADUNG:
                String d= t.getDauerBisBeladungAsString();
                return d;
        }
        return "????";
    }
    
    //Business methode
    public void add(Transport transport)
    {
        transporte.add(transport);
        super.fireTableDataChanged();
    }

    public Transport get(int row) {
        return transporte.get(row);
    }

    public void addAuftrag (Transport transport,
            Auftrag auftrag)
    {
        transport.addAuftrag(auftrag);
        super.fireTableDataChanged();
    }    
}
