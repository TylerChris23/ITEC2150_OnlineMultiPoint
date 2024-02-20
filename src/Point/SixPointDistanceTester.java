package Point;


import java.util.Scanner;

public class SixPointDistanceTester {
    private static Scanner input = new Scanner(System.in); //we will retrieve multipoints of x and y coordinates.
    public static void main(String[] args) {
        NamedPoint[] points = enterNamedPoint();
        computeShortestDistance(points);
    }

    public static NamedPoint[] enterNamedPoint() {
        NamedPoint[] points = new NamedPoint[6]; // ensures the array is capable of storing both coordinate and names
        System.out.println("Enter 6 points x and y coordinates: ");
        for (int i = 0; i < points.length; i++) {
            System.out.print("Point " + (char) ('a' + i) + ": ");// lines up Point a, Point b...
            double x = input.nextDouble();// inputs x point
            double y = input.nextDouble(); // inputs y point
            String name = input.next();
            points[i] = new NamedPoint(x, y, name);
        }
        return points;
    }

    public static void computeShortestDistance(NamedPoint[] points) {
        double shortestDistance = Point.distance(points[0], points[1]);
        NamedPoint p1 = points[0];
        NamedPoint p2 = points[1];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double aDistance = Point.distance(points[i], points[j]);
                if (aDistance < shortestDistance) {
                    shortestDistance = aDistance;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        System.out.printf("The shortest distance of two points are %s(%.1f,%.1f) and %s(%.1f,%.1f) and their distance is (%.2f\n)",
                p1.getName(), p1.getX(), p1.getY(), p2.getName(), p2.getX(), p2.getY(), shortestDistance);
    }
}
