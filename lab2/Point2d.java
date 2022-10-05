public class Point2d {
    
    /** координата X **/
    private double xCoord;
    /** координата Y **/
    private double yCoord;

    /** Конструктор инициализации **/
    public Point2d ( double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    /** Конструктор по умолчанию **/
    public Point2d () {
        //Вызывает конструктор и передаёт ему два значения
        this(0, 0);
    }

    /** Возвращает координату X **/
    public double getX () {
        return xCoord;
    }

    /** Возвращает координату Y **/
    public double getY () {
        return yCoord;
    }

    /** Установка занчения координаты X. **/
    public void setX ( double val) {
    xCoord = val;
    }

    /** Установка занчения координаты Y. **/
    public void setY ( double val) {
    yCoord = val;
    }
}