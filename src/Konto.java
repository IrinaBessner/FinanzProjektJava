import java.util.ArrayList;
import java.util.List;

public class Konto {
    // protected = die Kindklasse (Sparkonto) darf darauf zugreifen
    // protected = доступно дочернему классу
    protected String inhaber;
    protected double kontostand;

    // LISTEN-TYP 1: ArrayList für die Buchungshistorie.
    // WARUM ArrayList? Wir hängen Buchungen hinten an und lesen sie
    // der Reihe nach – dafür ist die ArrayList ideal.
    // ПОЧЕМУ ArrayList? Добавляем записи в конец и читаем по порядку.
    protected List<String> buchungen = new ArrayList<>();

    // Konstruktor – wird beim Erzeugen eines Kontos aufgerufen
    // Конструктор – вызывается при создании счёта
    public Konto(String inhaber, double startbetrag) {
        this.inhaber = inhaber;
        this.kontostand = startbetrag;
        buchungen.add("Konto eröffnet mit " + startbetrag + " EUR");
    }

    // Geld einzahlen / Внести деньги
    public void einzahlen(double betrag) {
        kontostand += betrag;
        buchungen.add("Einzahlung: +" + betrag + " EUR");
    }

    // Geld abheben – MIT Prüfung, damit kein Fehler/Absturz entsteht
    // Снять деньги – с проверкой, чтобы не было ошибки
    public void abheben(double betrag) {
        if (betrag <= kontostand) {
            kontostand -= betrag;
            buchungen.add("Abhebung: -" + betrag + " EUR");
        } else {
            // Kein Absturz – wir notieren nur den Fehlversuch
            buchungen.add("FEHLGESCHLAGEN: Abhebung " + betrag + " EUR (zu wenig Geld)");
            System.out.println("   -> Nicht genug Guthaben für " + betrag + " EUR!");
        }
    }

    public double getKontostand() {
        return kontostand;
    }

    // Alle Buchungen anzeigen – mit for-each (nutzt intern einen Iterator)
    // Показать все операции
    public void zeigeBuchungen() {
        System.out.println("--- Buchungen von " + inhaber + " ---");
        for (String b : buchungen) {
            System.out.println("   " + b);
        }
        System.out.println("   >>> Aktueller Stand: " + kontostand + " EUR");
    }
}


