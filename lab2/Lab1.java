import java.util.*;

public class Lab1 {
    public static void main(String args[]) {
        Scanner input = new Scanner (System.in);
        // три координаты вводимых пользователем точек
        double x;
        double y;
        double z;
        // получение координат первой точки
        System.out.println("Enter x y z coords for the first point: ");
        x = input.nextDouble();
        y = input.nextDouble();
        z = input.nextDouble();
        Point3d fisrtPoint = new Point3d(x,y,z);
        // получение координат второй точки
        System.out.println("Enter x y z coords for the second point: ");
        x = input.nextDouble();
        y = input.nextDouble();
        z = input.nextDouble();
        Point3d secondPoint = new Point3d(x,y,z);
        // получение координат третьей точки
        System.out.println("Enter x y z coords for the third point: ");
        x = input.nextDouble();
        y = input.nextDouble();
        z = input.nextDouble();
        Point3d thirdPoint = new Point3d(x,y,z);
        
        input.close();
        // если есть хотя бы две одинаковые точки не считать площадь
        if (fisrtPoint.objectComp(secondPoint) || fisrtPoint.objectComp(thirdPoint) || secondPoint.objectComp(thirdPoint)) {
            System.out.println("Unable to calculate area");
        } else {
            System.out.println(calculateArea(fisrtPoint, secondPoint, thirdPoint));
        }
    }

    // рассчёт площади
    static double calculateArea(Point3d firstPoint, Point3d secondPoint, Point3d thirdPoint) {
        double a;
        double b;
        double c;
        double p;
        a = firstPoint.distanceTo(secondPoint);
        b = firstPoint.distanceTo(thirdPoint);
        c = secondPoint.distanceTo(thirdPoint);
        p = (a + b + c)/2;
        return Math.sqrt((p)*(p-a)*(p-b)*(p-c));
    }
}
