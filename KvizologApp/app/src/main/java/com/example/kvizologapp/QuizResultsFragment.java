package com.example.kvizologapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.facebook.CallbackManager;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class QuizResultsFragment extends Fragment {

    TextView txvPoints;
    ImageButton btnFacebook;
    CallbackManager callbackManager;
    ShareDialog shareDialog;

    public QuizResultsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_quiz_results, container, false);
        txvPoints = view.findViewById(R.id.txbResultPoints);
        btnFacebook = view.findViewById(R.id.btnFacebook);
        //Set points number
        txvPoints.setText((QuizGameActivity.POINTS_COUNTER) + " / "+QuizGameActivity.QUESTIONS_PER_CHATEGORY*4);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getResources().getString(R.string.results_message));
        stringBuilder.append(txvPoints.getText().toString());
        stringBuilder.append(getResources().getString(R.string.chek_out_message));
        btnFacebook.setOnClickListener(v -> {
            ShareLinkContent.Builder contentBulder = new ShareLinkContent.Builder()
                    //URL To Google Playstore App Page TO-DO
                    .setContentUrl(Uri.parse("https://developers.facebook.com"))
                    //Set number of points
                    .setQuote(stringBuilder.toString())
                    //Set hashtags for both languages
                    .setShareHashtag(new ShareHashtag.Builder().setHashtag(getResources().getString(R.string.hashtag_quizolog)).build());
            ShareDialog shareDialog = new ShareDialog(QuizResultsFragment.this);
            shareDialog.show(contentBulder.build(), ShareDialog.Mode.AUTOMATIC);
        });
        return view;
    }

}