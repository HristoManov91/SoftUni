package Songs;

public class Songs {
    private String typeList;
    private String songName;
    private String time;

    public Songs (String typeList , String songName , String time){
        this.typeList = typeList;
        this.songName = songName;
        this.time = time;
    }

    public String getTypeList (){
        return this.typeList;
    }

    public String getSongName(){
        return this.songName;
    }

    public String getTime(){
        return this.time;
    }
}
