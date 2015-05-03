package vk_warehousing.transportAutragsErstellung.auftragFilter;

import java.util.List;
import vk_warehousing.transportAutragsErstellung.auftrag.data.Auftrag;

public interface AuftragFilter {
    
    public abstract List<Auftrag> filter( List<Auftrag> liste);

    public abstract int size();

    public abstract Auftrag get(int row);

    public abstract void add(Auftrag auftrag);
    
    public abstract List<Auftrag> getOriginalAuftraege();
        
}
