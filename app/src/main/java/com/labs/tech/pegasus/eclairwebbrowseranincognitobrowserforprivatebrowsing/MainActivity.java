package com.labs.tech.pegasus.eclairwebbrowseranincognitobrowserforprivatebrowsing;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.searchfield);
        final Intent site = new Intent(this, Duck.class);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String entered_url = editText.getText().toString();
                boolean handled = false;
                if (entered_url.length() == 0) {

                } else {
                    if (i == EditorInfo.IME_ACTION_SEND) {
                        site.putExtra("URL", "https://" + entered_url);
                        editText.setText(null);
                        startActivity(site);
                        handled = true;
                    }
                }
                return handled;
            }
        });

        btn_search = (Button) findViewById(R.id.search_button);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entered_url = editText.getText().toString();
                if(entered_url.length()==0){

                } else{
                    site.putExtra("URL", "https://" + entered_url);
                    editText.setText(null);
                    startActivity(site);
                }
            }
        });

        // Handling incoming URLs
        Intent iCome = getIntent();
        String action = iCome.getAction();
        String type = iCome.getType();



        findViewById(R.id.searchencrypt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.searchencrypt.com/");
                startActivity(site);

            }
        });
        findViewById(R.id.qwant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.quant.com");
                startActivity(site);
            }
        });
        findViewById(R.id.duck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.duckduckgo.com");
                startActivity(site);
            }
        });
        findViewById(R.id.startpage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.startpage.com");
                startActivity(site);
            }
        });
        findViewById(R.id.searx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.searx.com");
                startActivity(site);
            }
        });
        findViewById(R.id.gibiru).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.gibiru.com");
                startActivity(site);
            }
        });
        findViewById(R.id.swisscows).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.swisscows.com");
                startActivity(site);
            }
        });
        findViewById(R.id.metager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.metager.org");
                startActivity(site);
            }
        });
        findViewById(R.id.discon_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://search.disconnect.me/");
                startActivity(site);
            }
        });
        findViewById(R.id.wolfram).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                site.putExtra("URL", "https://www.wolframalpha.com");
                startActivity(site);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_screen_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_rate:
                onRate();
                break;
            case R.id.menu_share:
                onShare();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onShare() {

        Toast.makeText(this, "Sharing ...", Toast.LENGTH_SHORT).show();

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "https://play.google.com/store/apps/details?id=com.labs.tech.pegasus.eclairwebbrowseranincognitobrowserforprivatebrowsing";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    private void onRate() {

        Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }
}

