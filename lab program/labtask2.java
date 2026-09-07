import java.util.*;

public class RealTimeStreamAnalytics {

    static class DataEvent {
        String source;
        double value;

        DataEvent(String source, double value) {
            this.source = source;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = 0;
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        System.out.println("=== Real-Time Stream Analytics Engine ===");
        System.out.println("Enter events. Type -1 to stop.");

        while (true) {

            System.out.print("\nEnter source name: ");
            String source = sc.next();

            System.out.print("Enter value: ");
            double value = sc.nextDouble();

            if (value == -1) {
                break;
            }

            DataEvent event = new DataEvent(source, value);

            // Process incoming event
            count++;
            sum += event.value;

            if (event.value < min) {
                min = event.value;
            }

            if (event.value > max) {
                max = event.value;
            }

            double average = sum / count;

            // Real-time analytics
            System.out.println("\n--- Real-Time Analytics ---");
            System.out.println("Latest Source : " + event.source);
            System.out.println("Latest Value  : " + event.value);
            System.out.println("Total Events  : " + count);
            System.out.println("Sum           : " + sum);
            System.out.println("Average       : " + average);
            System.out.println("Minimum       : " + min);
            System.out.println("Maximum       : " + max);
        }

        System.out.println("\nStream processing stopped.");
        sc.close();
    }
}