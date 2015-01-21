package Classes;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by maciejgalos on 19.01.15.
 */
public final class JSONObjectToPosts {
    public static ArrayList<Post> convert(JSONObject response, String arrayName, Context context){
        ArrayList<Post> posts = new ArrayList<Post>();
        try{
        JSONArray recentPosts = response.getJSONArray(arrayName);
            for(int i=0;i<recentPosts.length();i++){
                Post p = JSONObjectToPosts.parseJSON(recentPosts.getJSONObject(i));
                posts.add(p);

            }




        }catch (Exception e){
            Toast.makeText(context, "Goes wrong", Toast.LENGTH_LONG).show();

        }


        return posts;
    }

    public static Post parseJSON(JSONObject obj){
        Post p = new Post();
        try{
            if(obj.has("date")){
                p.setDate(obj.getString("date"));
            }
            if(obj.has("author")){
                p.setAuthor(obj.getString("author"));
            }
            if(obj.has("topic")){
                p.setTopic(obj.getString("topic"));
            }
            if(obj.has("image_url")){
                p.setImage_url(obj.getString("image_url"));
            }
            if(obj.has("text")){
                p.setText(obj.getString("text"));
            }

            if(obj.has("keywords")){
                JSONArray array = obj.getJSONArray("keywords");
                String[] newArr = new String[array.length()];
                for (int i=0;i<array.length();i++){
                    newArr[i]=array.getString(i);
                }
                p.setKeywords(newArr);
                return p;
            }
        }catch (Exception e){

        }
        return  null;
    }

}
