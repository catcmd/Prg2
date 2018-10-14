public class Dozent extends Person implements besuchbar{
    private Veranstaltung[] gehalteneVeranstaltungen;
    public Dozent(String vorname, String nachname){
        super(vorname,nachname);
    }
    public Termin getTermin(){
        return null;
    }
}
