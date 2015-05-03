package vk_warehousing.transportAutragsErstellung.auftragFilter;

import java.util.ArrayList;
import java.util.List;
import vk_warehousing.transportAutragsErstellung.auftrag.data.Auftrag;


public class AuftragByTNrFilter 
implements AuftragFilter
{
    private String transportNummer;
    private List<Auftrag> originalListe,
            filterListe;
    
    public AuftragByTNrFilter(String transportNummer) {
        this.transportNummer = transportNummer;
        this.filterListe= new ArrayList<>();
    }

    @Override
    public List<Auftrag> filter(List<Auftrag> originalListe) {
        this.originalListe = originalListe;
        
        for (Auftrag auftrag : originalListe) {
            if (auftrag.getTransportNummer().
                    equals(transportNummer))
            {
                filterListe.add(auftrag);
            }
        }
        return filterListe;
    }

    @Override
    public int size() {
        return filterListe.size();
    }

    @Override
    public Auftrag get(int row) {
        return filterListe.get(row);
    }

    @Override
    public void add(Auftrag auftrag) {
        if (auftrag.getTransportNummer().
                 equals(transportNummer))
        {
         filterListe.add(auftrag);
        }
        originalListe.add(auftrag);
    }

    @Override
    public List<Auftrag> getOriginalAuftraege() {
        return originalListe;
    }
 }
