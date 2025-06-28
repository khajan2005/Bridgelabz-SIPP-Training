import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaTimeManager {
    private List<String> movieTitles = new ArrayList<>();
    private List<String> showTimes = new ArrayList<>();
    public void addMovie(String title, String time) {
        if (isValidTimeFormat(time)) {
            movieTitles.add(title);
            showTimes.add(time);
            System.out.println("Movie added successfully.");
        } else {
            System.out.println("Invalid time format! Please use HH:mm (e.g., 14:30).");
        }
    }
    public void searchMovie(String keyword) {
        boolean found = false;
        for (int i = 0; i < movieTitles.size(); i++) {
            if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Movie: " + movieTitles.get(i) + " | Showtime: " + showTimes.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found with keyword: " + keyword);
        }
    }
    public void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }

        System.out.println("\nMovie Schedule Report:");
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);

        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println("Movie: " + titlesArray[i] + " | Showtime: " + timesArray[i]);
        }
    }
    private boolean isValidTimeFormat(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) {
            return false;
        }
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
    }
    public static void main(String[] args) {
        CinemaTimeManager manager = new CinemaTimeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCinemaTime - Movie Schedule Manager");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter movie title: ");
                String title = scanner.nextLine();
                System.out.print("Enter showtime (HH:mm): ");
                String time = scanner.nextLine();
                manager.addMovie(title, time);
            } else if (choice == 2) {
                System.out.print("Enter search keyword: ");
                String keyword = scanner.nextLine();
                manager.searchMovie(keyword);
            } else if (choice == 3) {
                manager.displayAllMovies();
            } else if (choice == 4) {
                System.out.println("Exiting CinemaTime Manager.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
