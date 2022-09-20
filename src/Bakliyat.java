import java.util.*;

public class Bakliyat {

    // Variables
    private String urunAdi;
    private float urunMiktari;
    private Date urunSkt;
    private String urunMiktarBirimi;
    private String urunCesidi;

    //Getter Setter Methods
    public String getUrunAdi() {
        return urunAdi;
    }

    public float getUrunMiktari() {
        return urunMiktari;
    }

    public Date getUrunSkt() {
        return urunSkt;
    }

    public String getUrunMiktarBirimi() {
        return urunMiktarBirimi;
    }

    public String getUrunCesidi() {
        return urunCesidi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public void setUrunMiktari(float urunMiktari) {
        this.urunMiktari = urunMiktari;
    }

    public void setUrunSkt(Date urunSkt) {
        this.urunSkt = urunSkt;
    }

    public void setUrunMiktarBirimi(String urunMiktarBirimi) {
        this.urunMiktarBirimi = urunMiktarBirimi;
    }

    public void setUrunCesidi(String urunCesidi) {
        this.urunCesidi = urunCesidi;
    }

    public Bakliyat(String urunAdi, float urunMiktari, Date urunSkt, String urunMiktarBirimi, String urunCesidi) {
        this.urunAdi = urunAdi;
        this.urunMiktari = urunMiktari;
        this.urunSkt = urunSkt;
        this.urunMiktarBirimi = urunMiktarBirimi;
        this.urunCesidi = urunCesidi;
    }

    public void urunStokAzalt(float azalacakMiktar)
    {
        this.urunMiktari+=azalacakMiktar;
    }

    public void urunStokArttir(float artacakMiktar)
    {
        this.urunMiktari+=artacakMiktar;
    }

}
