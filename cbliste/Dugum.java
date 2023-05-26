public class Dugum {
    private int veri;
    private Dugum onceki;
    private Dugum sonraki;
    
    public int getVeri() {
        return veri;
    }
    public void setVeri(int veri) {
        this.veri = veri;
    }
    public Dugum getOnceki() {
        return onceki;
    }
    public void setOnceki(Dugum onceki) {
        this.onceki = onceki;
    }
    public Dugum getSonraki() {
        return sonraki;
    }
    public void setSonraki(Dugum sonraki) {
        this.sonraki = sonraki;
    }
    public Dugum(int deger){
        this.veri=deger;
        this.onceki=null;
        this.sonraki=null;
    }
    public Dugum(){
        this.veri=0;
        this.onceki=null;
        this.sonraki=null;
    }
}
