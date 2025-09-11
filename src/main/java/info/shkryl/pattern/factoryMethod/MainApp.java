package info.shkryl.pattern.factoryMethod;

import info.shkryl.pattern.factoryMethod.creator.Airline;
import info.shkryl.pattern.factoryMethod.detailCreator.AirbusAirlines;
import info.shkryl.pattern.factoryMethod.detailCreator.BoeingAirways;
import info.shkryl.pattern.factoryMethod.detailCreator.VIPJets;

public class MainApp {
    public static void main(String[] args) {
        // Авиакомпания 1
        Airline airline1 = new BoeingAirways();
        System.out.println(airline1.bookTicket("Нью-Йорк"));
        System.out.println();

        // Авиакомпания 2
        Airline airline2 = new AirbusAirlines();
        System.out.println(airline2.bookTicket("Лондон"));
        System.out.println();

        // Авиакомпания 3
        Airline airline3 = new VIPJets();
        System.out.println(airline3.bookTicket("Монте-Карло"));
    }
}
