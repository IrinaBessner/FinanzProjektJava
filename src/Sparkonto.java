public class Sparkonto extends Konto {
    private double zinssatz;   // z. B. 0.05 = 5 % Zinsen

    // Konstruktor ruft mit super(...) den Konstruktor der Elternklasse auf
    // super(...) вызывает конструктор родителя
    public Sparkonto(String inhaber, double startbetrag, double zinssatz) {
        super(inhaber, startbetrag);   // erst das Konto aufbauen
        this.zinssatz = zinssatz;      // dann die eigene Eigenschaft setzen
    }

    // EIGENE Methode, die nur das Sparkonto hat
    // Собственный метод только сберегательного счёта
    public void zinsenGutschreiben() {
        // kontostand und buchungen sind GEERBT von Konto (protected!)
        double zinsen = kontostand * zinssatz;
        kontostand += zinsen;
        buchungen.add("Zinsen (" + (zinssatz * 100) + "%): +" + zinsen + " EUR");
    }
}


