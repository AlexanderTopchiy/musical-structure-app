package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassicalActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);


        // Create an array of opuses.
        ArrayList<Opus> opuses = new ArrayList<Opus>();

        // Adding opuses to an array.
        opuses.add(new Opus("Beethoven", "Symphony No. 9"));
        opuses.add(new Opus("Beethoven", "Symphony No. 3"));
        opuses.add(new Opus("Beethoven", "Sonata No. 8  \"Pathétique\""));
        opuses.add(new Opus("Mozart", "Oboe Concerto in C major"));
        opuses.add(new Opus("Mozart", "Sonata for Two Pianos in D"));
        opuses.add(new Opus("Mozart", "Piano Sonata No 16 C major "));
        opuses.add(new Opus("Haydn", "Piano Concerto No. 11 in D major"));
        opuses.add(new Opus("Haydn", "Symphony no. 94 \"Surprise\" "));
        opuses.add(new Opus("Haydn", "Symphony No. 45 \"Farewell\""));
        opuses.add(new Opus("Boccherini", "Minuet in E Major"));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        OpusAdapter adapter = new OpusAdapter(this, opuses);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // play_list file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlayerActivity
        listView.setOnItemClickListener(this);
    }

    /**
     * Method to identify ListView item clicked and launch PlayerActivity
     */
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        // Get the selected opus.
        Opus currentOpus = (Opus) adapterView.getItemAtPosition(position);

        // Extract strings from Opus object.
        String opusForPlaying = currentOpus.getOpus();
        String composerForPlaying = currentOpus.getNameOfComposer();

        // Sending the name of composer and his opus to PlayerActivity.
        Intent opusIntent = new Intent(this, PlayerActivity.class);
        opusIntent.putExtra("opus", opusForPlaying);
        opusIntent.putExtra("composer", composerForPlaying);
        startActivity(opusIntent);
    }
}