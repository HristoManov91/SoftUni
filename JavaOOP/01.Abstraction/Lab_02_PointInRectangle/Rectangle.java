package Lab_02_PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point bottomRight;

    public Rectangle(Point bottomLeft , Point bottomRight){
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public boolean containsPoint(Point point){
        return bottomRight.isLessOrEqual(point) && bottomLeft.isGreaterOrEqual(point);
    }
}
