public class Point3d {
        /** координата X **/
        private double xCoord;
        /** координата Y **/
        private double yCoord;
        /** координата Z **/
        private double zCoord;
    
        /** Конструктор инициализации **/
        public Point3d ( double x, double y, double z) {
            xCoord = x;
            yCoord = y;
            zCoord = z;
        }
    
        /** Конструктор по умолчанию **/
        public Point3d () {
            //Вызывает конструктор и передаёт ему два значения
            this(0, 0, 0);
        }
    
        /** Возвращает координату X **/
        public double getX () {
            return xCoord;
        }
    
        /** Возвращает координату Y **/
        public double getY () {
            return yCoord;
        }

        /** Возвращает координату Z **/
        public double getZ () {
            return zCoord;
        }
    
        /** Установка занчения координаты X. **/
        public void setX ( double val) {
        xCoord = val;
        }
    
        /** Установка занчения координаты Y. **/
        public void setY ( double val) {
        yCoord = val;
        }

        /** Установка занчения координаты Z. **/
        public void setZ ( double val) {
            zCoord = val;
        }

        public boolean objectComp(Point3d object) {
            if ((this.getX() == object.getX()) && (this.getY() == object.getY()) && 
            (this.getZ() == object.getZ())) {
                return true;
            } else {
                return false;
            }
        }

        public double distanceTo(Point3d object) {
            return Math.round(Math.sqrt(Math.pow((this.getX()-object.getX()),2)+
            Math.pow(this.getY()-object.getY(),2)+
            Math.pow(this.getZ()-object.getZ(),2))*
            Math.pow(10, 2))/Math.pow(10, 2);
        }
}
