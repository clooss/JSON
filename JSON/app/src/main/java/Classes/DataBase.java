package Classes;

import java.util.ArrayList;

/**
 * Created by maciejgalos on 19.01.15.
 */
public class DataBase {

    private static volatile DataBase instance =null;
    private ArrayList<Post> posts;
    private DataBase(){
        posts=new ArrayList<Post>();
    }
    public static DataBase getInstance(){
        if(instance == null){
            synchronized (DataBase.class){
                instance = new DataBase();
            }
        }
        return  instance;
    }
    public void addPost(Post p){
        posts.add(p);
    }
    public ArrayList<Post> getPosts(){
        return posts;
    }
    public void setPosts(ArrayList<Post> posts){
        this.posts=posts;
    }
}
