package weather;

import java.util.Scanner;

public class UserInterface {
    private final LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;
    }

    public void run() {
        System.out.println("Aplikacja jest uruchomiona!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Witaj w elektornicznym pamiętniku, co chcesz zrobić?");
            System.out.println("1. Add new location");
            System.out.println("2. Display the current locations");
            System.out.println("3. Update the weather status");
            System.out.println("0. Close the app");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewEntry();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private void addNewEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a data of location you want to add");
        System.out.print("Your location's city is: ");
        String city = scanner.nextLine();
        System.out.println("Your location's region is: ");
        String region = scanner.nextLine();
        System.out.println("Your location's country is: ");
        String country = scanner.nextLine();
        System.out.println("Your location's latitude is: ");
        Double latitude = scanner.nextDouble();
        System.out.println("Your location's longitude is: ");
        Double longitude = scanner.nextDouble();
        String httpResponseBody = locationController.addNewLocation(city, region, country, latitude, longitude);
        System.out.println("Odpowiedź z servera: " + httpResponseBody);
        System.out.println();
    }
}
