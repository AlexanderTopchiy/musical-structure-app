package com.example.android.musicalstructure;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OpusAdapter extends ArrayAdapter<Opus> {
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Opus} object located at this position in the list
        Opus currentWord= (Opus) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID opus_text_view
        TextView opusTextView = (TextView) listItemView.findViewById(R.id.opus_text_view);
        // Get the name of opus from the current opus object and
        // set this text on the name TextView
        opusTextView.setText(currentWord.getOpus());

        // Find the TextView in the list_item.xml layout with the ID composer_text_view
        TextView composerTextView = (TextView) listItemView.findViewById(R.id.composer_text_view);
        // Get the name of the composer from the current opus object and
        // set this text on the name TextView
        composerTextView.setText(currentWord.getNameOfComposer());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
