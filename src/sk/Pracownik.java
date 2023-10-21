package sk;
//TODO do usuniecia
public class Pracownik extends User implements PracownikInt{
    private int idPracownika;
    public Pracownik(){};
    public Pracownik(String imie,String nazwisko,String email,String login,String haslo,int idPracownika){
        super(imie, nazwisko, email, login, haslo);
        this.idPracownika=idPracownika;
    }

    public int getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(int idPracownika) {
        this.idPracownika = idPracownika;
    }

    public void utworzZestaw(Magazyn m){
        m.utworzZestaw();
    }

    public double podajProdukt(Magazyn m, String nazwa,int typ)
    {
        double p=0;
        switch(typ) {
            case 1:
                for(int i=0;i<m.getPlytyGl().size();i++)
                {
                    if(m.getPlytyGl().get(i).getNazwa().equals(nazwa))
                    {
                        if(m.getPlytyGl().get(i).getLiczba()!=0)
                        {
                            m.getPlytyGl().get(i).setLiczba(m.getPlytyGl().get(i).getLiczba()-1);
                            p= m.getPlytyGl().get(i).getCena();
                        }
                        break;
                    }
                }
                break;
            case 2:
                for(int i=0;i<m.getProcesory().size();i++)
                {
                    if(m.getProcesory().get(i).getNazwa().equals(nazwa))
                    {
                        if(m.getProcesory().get(i).getLiczba()!=0)
                        {
                            m.getProcesory().get(i).setLiczba(m.getProcesory().get(i).getLiczba()-1);
                            p= m.getProcesory().get(i).getCena();
                        }
                        break;
                    }
                }
                break;
            case 3:
                for(int i=0;i<m.getKartyGraf().size();i++)
                {
                    if(m.getKartyGraf().get(i).getNazwa().equals(nazwa))
                    {
                        if(m.getKartyGraf().get(i).getLiczba()!=0)
                        {
                            m.getKartyGraf().get(i).setLiczba(m.getKartyGraf().get(i).getLiczba()-1);
                            p= m.getKartyGraf().get(i).getCena();
                        }
                        break;
                    }
                }
                break;
            case 4:
                for(int i=0;i<m.getPamRam().size();i++)
                {
                    if(m.getPamRam().get(i).getNazwa().equals(nazwa))
                    {
                        if(m.getPamRam().get(i).getLiczba()!=0)
                        {
                            m.getPamRam().get(i).setLiczba(m.getPamRam().get(i).getLiczba()-1);
                            p= m.getPamRam().get(i).getCena();
                        }
                        break;
                    }
                }
                break;
            case 5:
                for(int i=0;i<m.getDyski().size();i++)
                {
                    if(m.getDyski().get(i).getNazwa().equals(nazwa))
                    {
                        if(m.getDyski().get(i).getLiczba()!=0)
                        {
                            m.getDyski().get(i).setLiczba(m.getDyski().get(i).getLiczba()-1);
                            p= m.getDyski().get(i).getCena();
                        }
                        break;
                    }
                }
                break;
            case 6:
                for(int i=0;i<m.getZestawy().size();i++)
                {
                    if(m.getZestawy().get(i).getNazwa().equals(nazwa))
                    {
                        if(m.getZestawy().get(i).czyDostepne())
                        {
                            m.getZestawy().get(i).getPlytaGlowna().setLiczba(m.getZestawy().get(i).getPlytaGlowna().getLiczba()-1);
                            m.getZestawy().get(i).getProcesor().setLiczba(m.getZestawy().get(i).getProcesor().getLiczba()-1);
                            m.getZestawy().get(i).getKartaGraf().setLiczba(m.getZestawy().get(i).getKartaGraf().getLiczba()-1);
                            m.getZestawy().get(i).getPamRam().setLiczba(m.getZestawy().get(i).getPamRam().getLiczba()-1);
                            m.getZestawy().get(i).getDysk().setLiczba(m.getZestawy().get(i).getDysk().getLiczba()-1);
                            p= m.getZestawy().get(i).getCena();
                        }
                        break;
                    }
                }
                break;
        }
        if(p==0)
        {
            System.out.println("Przepraszamy, nie znaleziono produktu o takiej nazwie!");
        }
        return p;
    }

    public void odlozProdukt(Magazyn m, String nazwa,int typ)
    {
        double p=0;
        switch(typ) {
            case 1:
                for(int i=0;i<m.getPlytyGl().size();i++)
                {
                    if(m.getPlytyGl().get(i).getNazwa().equals(nazwa))
                    {
                            m.getPlytyGl().get(i).setLiczba(m.getPlytyGl().get(i).getLiczba()+1);
                        break;
                    }
                }
                break;
            case 2:
                for(int i=0;i<m.getProcesory().size();i++)
                {
                    if(m.getProcesory().get(i).getNazwa().equals(nazwa))
                    {
                            m.getProcesory().get(i).setLiczba(m.getProcesory().get(i).getLiczba()+1);
                        break;
                    }
                }
                break;
            case 3:
                for(int i=0;i<m.getKartyGraf().size();i++)
                {
                    if(m.getKartyGraf().get(i).getNazwa().equals(nazwa))
                    {
                            m.getKartyGraf().get(i).setLiczba(m.getKartyGraf().get(i).getLiczba()+1);
                        break;
                    }
                }
                break;
            case 4:
                for(int i=0;i<m.getPamRam().size();i++)
                {
                    if(m.getPamRam().get(i).getNazwa().equals(nazwa))
                    {
                            m.getPamRam().get(i).setLiczba(m.getPamRam().get(i).getLiczba()+1);
                        break;
                    }
                }
                break;
            case 5:
                for(int i=0;i<m.getDyski().size();i++)
                {
                    if(m.getDyski().get(i).getNazwa().equals(nazwa))
                    {
                            m.getDyski().get(i).setLiczba(m.getDyski().get(i).getLiczba()+1);
                        break;
                    }
                }
                break;
            case 6:
                for(int i=0;i<m.getZestawy().size();i++)
                {
                    if(m.getZestawy().get(i).getNazwa().equals(nazwa))
                    {
                            m.getZestawy().get(i).getPlytaGlowna().setLiczba(m.getZestawy().get(i).getPlytaGlowna().getLiczba()+1);
                            m.getZestawy().get(i).getProcesor().setLiczba(m.getZestawy().get(i).getProcesor().getLiczba()+1);
                            m.getZestawy().get(i).getKartaGraf().setLiczba(m.getZestawy().get(i).getKartaGraf().getLiczba()+1);
                            m.getZestawy().get(i).getPamRam().setLiczba(m.getZestawy().get(i).getPamRam().getLiczba()+1);
                            m.getZestawy().get(i).getDysk().setLiczba(m.getZestawy().get(i).getDysk().getLiczba()+1);
                        break;
                    }
                }
                break;
        }
    }

    //wypisuje informacje konkretnego produktu
    public double sprawdzOferte(Magazyn m, String nazwa,int typ)
    {
        double p=0;
        switch(typ) {
            case 1:
                for(int i=0;i<m.getPlytyGl().size();i++)
                {
                    if(m.getPlytyGl().get(i).getNazwa().equals(nazwa))
                    {
                        p= m.getPlytyGl().get(i).getCena();
                        break;
                    }
                }
                break;
            case 2:
                for(int i=0;i<m.getProcesory().size();i++)
                {
                    if(m.getProcesory().get(i).getNazwa().equals(nazwa))
                    {
                        p= m.getProcesory().get(i).getCena();
                        break;
                    }
                }
                break;
            case 3:
                for(int i=0;i<m.getKartyGraf().size();i++)
                {
                    if(m.getKartyGraf().get(i).getNazwa().equals(nazwa))
                    {
                        p= m.getKartyGraf().get(i).getCena();
                        break;
                    }
                }
                break;
            case 4:
                for(int i=0;i<m.getPamRam().size();i++)
                {
                    if(m.getPamRam().get(i).getNazwa().equals(nazwa))
                    {
                        p= m.getPamRam().get(i).getCena();
                        break;
                    }
                }
                break;
            case 5:
                for(int i=0;i<m.getDyski().size();i++)
                {
                    if(m.getDyski().get(i).getNazwa().equals(nazwa))
                    {
                        p= m.getDyski().get(i).getCena();
                        break;
                    }
                }
                break;
            case 6:
                for(int i=0;i<m.getZestawy().size();i++)
                {
                    if(m.getZestawy().get(i).getNazwa().equals(nazwa))
                    {
                        p= m.getZestawy().get(i).getCena();
                        break;
                    }
                }
                break;
        }
        if(p==0)
        {
            System.out.println("Przepraszamy, nie znaleziono produktu o takiej nazwie i typie w ofercie!");
        }
        return p;
    }

    public String toString(){
        return super.toString()+
                "\nId pracownika: "+idPracownika;
    }
}
