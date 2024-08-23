package com.Examen_Prog2_2;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Création d'un hôtel
        Hotel hotel1 = new Hotel("Hotel By Jimmy", -18.8792, 47.5079, "Le meilleur hotel", "0341234567", "contact@hotelbyjimmy.com");
        Room room101 = new Room(101, 50000.0);
        Room room102 = new Room(102, 55000.0);
        hotel1.addRoom(room101);
        hotel1.addRoom(room102);

        // Ajout d'avis pour l'hôtel et les chambres
        Review hotelReview = new Review("Rakoto jean", "koto@gmail.com", 2, "Le service n'est pas de qualité", LocalDate.of(2024, 8, 18));
        Review roomReview = new Review("Randria", "randria@gmail.com", 4, "Chambre propre et bien entretenue", LocalDate.of(2024, 8, 19));
        hotel1.addReview(hotelReview);
        room101.addReview(roomReview);

        // Création de parcs naturels
        NaturalPark park1 = new NaturalPark("Parc National Tsimbazaza", -18.9342, 48.4074, "Un parc naturel réputé pour ses lémuriens.");
        NaturalPark park2 = new NaturalPark("Parc National de Ranomafana", -21.2572, 47.5125, "Un parc avec une biodiversité incroyable.");

        // Ajout d'hôtels à proximité des parcs
        park1.addNearbyHotel(hotel1);
        park2.addNearbyHotel(hotel1);

        // Création de la carte
        Map madagascarMap = new Map();
        madagascarMap.addHotel(hotel1);
        madagascarMap.addPark(park1);
        madagascarMap.addPark(park2);

        // Utilisation des fonctionnalités principales

        // Affichage de tous les avis

        System.out.println("Tous les avis:");
        madagascarMap.getAllReviews().forEach(System.out::println);

        // Trouver le meilleur hôtel (celui avec le plus grand nombre de parcs à proximité)
        Hotel bestHotel = madagascarMap.findBestHotel();
        System.out.println("Meilleur hôtel basé sur les parcs à proximité : " + bestHotel.getName());

        // Rechercher les lieux dans une région spécifique de Madagascar
        double minLat = -19.0, maxLat = -18.0, minLong = 47.0, maxLong = 48.0;
        System.out.println("Lieux situés entre [" + minLat + ", " + maxLat + "] et [" + minLong + ", " + maxLong + "]:");
        madagascarMap.getAllPlacesInside(minLat, maxLat, minLong, maxLong).forEach(System.out::println);

        // Trouver le prix minimum pour une nuitée pour visiter les parcs spécifiés
        List<NaturalPark> parksToVisit = List.of(park1, park2);
        double cheapestPrice = madagascarMap.findCheapestHotelPrice(parksToVisit);
        System.out.println("Prix minimum pour une nuitée dans les hôtels proches des parcs sélectionnés : " + cheapestPrice + " Ariary");

        // Obtenir les éléments ayant reçu au moins un avis
        System.out.println("Éléments ayant au moins un avis:");
        madagascarMap.getAllReviewedItems().forEach(System.out::println);
    }
}
