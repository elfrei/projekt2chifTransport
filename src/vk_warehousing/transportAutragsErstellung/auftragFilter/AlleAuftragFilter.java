package vk_warehousing.transportAutragsErstellung.auftragFilter;

import java.util.ArrayList;
import java.util.List;
import vk_warehousing.transportAutragsErstellung.auftrag.data.Auftrag;

public class AlleAuftragFilter 
implements AuftragFilter
{
    private List<Auftrag> liste = new ArrayList<>();
    
    @Override
    public List<Auftrag> filter( List<Auftrag>liste) {
        this.liste = liste;
        return liste;
    }

    @Override
    public int size() {
        return liste.size();
    }

    @Override
    public Auftrag get(int row) {
        return liste.get(row);
    }

    @Override
    public void add(Auftrag auftrag) {
        liste.add(auftrag);
    }

    @Override
    public List<Auftrag> getOriginalAuftraege() {
        return liste;
    }

}
