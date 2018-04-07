package com.example.android.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class RomanticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);


        // Create an array of opuses.
        ArrayList<Opus> opuses = new ArrayList<Opus>();

        // Adding opuses to an array.
        opuses.add(new Opus("Brahms", "Symphony No.4 in E minor"));
        opuses.add(new Opus("Liszt", "Transcendental Étude no.04 \"Mazeppa\""));
        opuses.add(new Opus("Liszt", "Liebestraum No. 3, Notturno"));
        opuses.add(new Opus("Chopin", "Nocturne op.9 No.2"));
        opuses.add(new Opus("Chopin", "Etude in E minor, Op. 25, No. 5"));
        opuses.add(new Opus("Schubert", "Piano Sonata No.13 in A-dur"));
        opuses.add(new Opus("Schubert", "Impromptu Op.90 No.4 in A-flat major"));
        opuses.add(new Opus("Viardot", "\"Haí Lulí\""));
        opuses.add(new Opus("Schumann", "Concerto for Violoncello and Orchestra A minor"));
        opuses.add(new Opus("Delibes", "Lakmé - Flower Duet"));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        OpusAdapter adapter = new OpusAdapter(this, opuses);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }
}
