package Scale;

public class Scale<E extends Comparable<E>> {//така вкарва метод за сравняване
    private E left;
    private E right;

    public Scale (E left , E right){
        this.left = left;
        this.right = right;
    }

    public E getHeavier (){
        int result = left.compareTo(right);
        if ( result > 0){
            return left;
        } else if (result < 0) {
            return right;
        } else {
            return null;
        }
    }
}
