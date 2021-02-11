package Lab_03_GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left , T right){
        this.left = left;
        this.right = right;
    }

    public T getHeavier(){
        int result = this.left.compareTo(this.right);
        if (result > 0){
            return left;
        } else if (result < 0){
            return right;
        } else {
            return null;
        }
    }
}
