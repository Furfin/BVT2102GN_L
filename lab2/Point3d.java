public class Point3d extends Point2d {

        /** координата Z **/
        private double zCoord;
    
        /** Конструктор инициализации **/
        public Point3d ( double x, double y, double z) {
            super(x, y);
            zCoord = z;
        }
    
        /** Конструктор по умолчанию **/
        public Point3d () {
            //Вызывает конструктор и передаёт ему два значения
            this(0, 0, 0);
        }

        /** Возвращает координату Z **/
        public double getZ () {
            return zCoord;
        }
        
        /** Установка знaчения координаты Z. **/
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
