public class CBListe {
    private Dugum ilk;

    public CBListe(){
        this.ilk=null;
    }

    public void basaEkle(int deger){
        Dugum yeni=new Dugum(deger);
        if(this.ilk==null){
            this.ilk=yeni;
            return;
        }
        this.ilk.setOnceki(yeni);
        yeni.setSonraki(this.ilk);
        this.ilk=yeni;
    }

    public void sonaEkle(int deger){
        Dugum yeni = new Dugum(deger);
        if(this.ilk==null){
            this.ilk=yeni;
            return;
        }
        Dugum temp=this.ilk;
        while(temp.getSonraki()!=null){
            temp=temp.getSonraki();
        }
        temp.setSonraki(yeni);
        yeni.setOnceki(temp);
    }

    public void arayaEkle(int deger,int indis){
        if((this.ilk==null) || (indis==1)){
            this.basaEkle(deger);
            return;
        }
        Dugum yeni=new Dugum(deger);
        Dugum temp=this.ilk;
        int sayac=1;
        while(temp.getSonraki()!=null){
            if(sayac+1==indis){
                break;
            }
            sayac++;
            temp=temp.getSonraki();
        }
           temp.getSonraki().setOnceki(yeni);
           yeni.setSonraki(temp.getSonraki());
           temp.setSonraki(yeni);
           yeni.setOnceki(temp);
    }

    public int elemanSil(int deger){
            if(this.ilk==null){
                return -1;
            }
            if(this.ilk.getVeri()==deger){
                this.ilk=this.ilk.getSonraki();
                this.ilk.setOnceki(null);
                return 0;
            }
            Dugum temp=this.ilk;
            while(temp.getVeri()!=deger){
                if(temp.getSonraki()==null){
                    return -2;
                }
                temp=temp.getSonraki();
            }
            if(temp.getSonraki()!=null){
                temp.getSonraki().setOnceki(temp.getOnceki());
                temp.getOnceki().setSonraki(temp.getSonraki());
            }else{
                temp.getOnceki().setSonraki(null);
            }
            return 0;

    }

    public int listeElemanSayisi(){
        int sayac=0;
        Dugum temp=this.ilk;
        while(temp!=null){
            sayac++;
            temp=temp.getSonraki();
        }
        return sayac;
    }

    public void sıralıEkle(int data){
        Dugum newNode = new Dugum(data);
        if(this.ilk==null)this.ilk=newNode;
        else if(data<this.ilk.getVeri()){
            newNode.setSonraki(this.ilk);
            this.ilk.setOnceki(newNode);
            this.ilk=newNode;
        }else{
            Dugum temp=this.ilk;
            while((temp.getSonraki()!=null) && (temp.getSonraki().getVeri()<data)){
                temp=temp.getSonraki();
            }
            newNode.setSonraki(newNode.getSonraki());
            if(temp.getSonraki()!=null)
            temp.getSonraki().setOnceki(newNode);
            temp.setSonraki(newNode);
            newNode.setOnceki(temp);
        
        }
    }

    public Dugum elemanBul(int data){
        Dugum temp=this.ilk;
        while(temp!=null){
            if(temp.getVeri()==data)
            return temp;
            temp=temp.getSonraki();
        }        
        return null;
    }
}
