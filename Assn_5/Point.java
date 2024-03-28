interface Movable {
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();
}
class MovablePoint implements Movable {
    private int x;
    private int y;

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y++;
    }

    public void moveDown() {
        y--;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public String toString() {
        return "MovablePoint [x=" + x + ", y=" + y + "]";
    }
}
class MovableCircle implements Movable {
    private MovablePoint center;
    private int radius;

    public MovableCircle(int x, int y, int radius) {
        this.center = new MovablePoint(x, y);
        this.radius = radius;
    }

    public void moveUp() {
        center.moveUp();
    }

    public void moveDown() {
        center.moveDown();
    }

    public void moveLeft() {
        center.moveLeft();
    }

    public void moveRight() {
        center.moveRight();
    }

    public String toString() {
        return "MovableCircle [center=" + center + ", radius=" + radius + "]";
    }
}

import java.util.Scanner;

class MovableDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial coordinates for MovablePoint:");
        System.out.print("X coordinate: ");
        int pointX = scanner.nextInt();
        System.out.print("Y coordinate: ");
        int pointY = scanner.nextInt();

        MovablePoint point = new MovablePoint(pointX, pointY);

        System.out.println("Enter initial coordinates for MovableCircle:");
        System.out.print("X coordinate for center: ");
        int circleX = scanner.nextInt();
        System.out.print("Y coordinate for center: ");
        int circleY = scanner.nextInt();
        System.out.print("Radius: ");
        int circleRadius = scanner.nextInt();

        MovableCircle circle = new MovableCircle(circleX, circleY, circleRadius);

        System.out.println("Moving the point and circle...");
        point.moveUp();
        circle.moveLeft();

        System.out.println("New position of MovablePoint: " + point);
        System.out.println("New position of MovableCircle: " + circle);

        scanner.close();
    }
}
