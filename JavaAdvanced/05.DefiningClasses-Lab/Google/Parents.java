package Google;

public class Parents {
    private String parents;
    private String parentsBirthday;

    public Parents (String parents , String parentsBirthday){
        this.parents = parents;
        this.parentsBirthday = parentsBirthday;
    }

    public String getParents() {
        return this.parents;
    }

    public String getParentsBirthday() {
        return this.parentsBirthday;
    }
}
