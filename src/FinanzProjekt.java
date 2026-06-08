import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FinanzProjekt {
    public static void main(String[] args) {
        // 1) Normales Konto (Elternklasse)
        Konto giro = new Konto("Anna", 1000.0);
        giro.einzahlen(500.0);
        giro.abheben(2000.0);   // schlägt fehl -> aber KEIN Absturz
        giro.abheben(300.0);

        // 2) Sparkonto (Kindklasse) – nutzt geerbte UND eigene Methoden
        Sparkonto sparen = new Sparkonto("Boris", 2000.0, 0.05);  // 5 % Zinsen
        sparen.einzahlen(1000.0);     // geerbte Methode aus Konto
        sparen.zinsenGutschreiben();  // eigene Methode des Sparkontos

        // 3) LISTEN-TYP 2: LinkedList als QUEUE (Warteschlange).
        //    WARUM? Geplante Zahlungen werden der Reihe nach abgearbeitet (FIFO).
        //    ПОЧЕМУ Queue? Платежи обрабатываются в порядке поступления.
        Queue<Double> geplanteZahlungen = new LinkedList<>();
        geplanteZahlungen.offer(100.0);   // hinten anstellen
        geplanteZahlungen.offer(250.0);
        geplanteZahlungen.offer(50.0);

        System.out.println("\n=== Geplante Zahlungen abarbeiten (FIFO) ===");
        while (!geplanteZahlungen.isEmpty()) {
            double zahlung = geplanteZahlungen.poll();  // vorderstes Element holen
            System.out.println("Zahle " + zahlung + " EUR vom Girokonto ab:");
            giro.abheben(zahlung);
        }

        // 4) LISTEN-TYP 3: List.of(...) = UNVERÄNDERLICHE Liste für Konstanten.
        //    WARUM? Die angebotenen Kontoarten ändern sich nie.
        //    ПОЧЕМУ? Список типов счетов неизменен.
        List<String> kontoarten = List.of("Girokonto", "Sparkonto", "Tagesgeld");
        System.out.println("\n=== Angebotene Kontoarten ===");
        for (String art : kontoarten) {
            System.out.println(" - " + art);
        }

        // 5) Endergebnis ausgeben
        System.out.println();
        giro.zeigeBuchungen();
        System.out.println();
        sparen.zeigeBuchungen();
    }


}

