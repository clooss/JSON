package com.galos.maciej.json;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import Classes.DataBase;
import Classes.JSONObjectToPosts;
import Classes.RowAdapter;


public class MainActivity extends ActionBarActivity {

    private DataBase dataBase = DataBase.getInstance();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            String jsonData = jsonToStringFormAssetFolder("document.json", getApplicationContext());
            dataBase.setPosts(JSONObjectToPosts.convert(new JSONObject(jsonData),"recent_posts",getApplicationContext()));
            Toast.makeText(getApplicationContext(),String.valueOf(dataBase.getPosts().size()),Toast.LENGTH_LONG).show();


        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Goes wrong",Toast.LENGTH_LONG).show();

        }
        listView=(ListView)findViewById(R.id.listView);
        RowAdapter adapter = new RowAdapter(this,R.layout.item_layout,dataBase.getPosts());
        listView.setAdapter(adapter);
        listView.invalidate();

    }

    public static String jsonToStringFormAssetFolder(String fileName, Context context) throws IOException{
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(fileName);

        byte[] data = new byte[file.available()];
        file.read(data);
        file.close();
        return new String(data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
