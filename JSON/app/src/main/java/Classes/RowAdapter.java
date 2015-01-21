package Classes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.galos.maciej.json.R;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by maciejgalos on 19.01.15.
 */



public class RowAdapter extends ArrayAdapter<Post> {
    class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


    private Context context;
    private int layoutResourceID;
    private ArrayList<Post> data;

    public RowAdapter(Context context, int layoutResourceID, ArrayList<Post> data){
        super(context,layoutResourceID,data);
        this.context = context;
        this.layoutResourceID = layoutResourceID;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RowHolder holder = null;

        if(row == null){
            LayoutInflater inFlater = ((Activity)context).getLayoutInflater();
            row = inFlater.inflate(layoutResourceID, parent, false);

            holder =new RowHolder();
            holder.author=(TextView)row.findViewById(R.id.textViewAuthor);
            holder.date=(TextView)row.findViewById(R.id.textViewDate);
            holder.image_url=(TextView)row.findViewById(R.id.textViewUrl);
            holder.text=(TextView)row.findViewById(R.id.textViewText);
            holder.topic=(TextView)row.findViewById(R.id.textViewTopic);
            holder.keywords=(TextView)row.findViewById(R.id.textViewKeyWords);
            holder.imageView=(ImageView)row.findViewById(R.id.imageView);




            row.setTag(holder);
        }else {
            holder =(RowHolder) row.getTag();

        }

        Post item = data.get(position);
        holder.text.setText(item.getText());
        holder.image_url.setText(item.getImage_url());
        holder.author.setText(item.getAuthor());
        holder.topic.setText(item.getTopic());
        holder.date.setText(item.getDate());
        String keywords="";
        for(int i=0;i<item.getKeywords().length;i++){
            keywords=keywords+item.getKeywords()[i]+"/n";
        }
        holder.keywords.setText(keywords);

        if (Patterns.WEB_URL.matcher(item.getImage_url()).matches()) {
            new DownloadImageTask(holder.imageView).execute(item.getImage_url());
        } else
            holder.imageView.setImageResource(R.drawable.ic_launcher);



        return row;

    }

    static class RowHolder{
        public TextView date;
        public TextView author;
        public TextView topic;
        public TextView image_url;
        public TextView text;
        public TextView keywords;
        public ImageView imageView;

    }


}