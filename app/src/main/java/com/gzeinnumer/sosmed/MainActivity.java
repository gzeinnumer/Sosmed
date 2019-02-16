package com.gzeinnumer.sosmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gzeinnumer.facebook.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fb)
    Button fb;
    @BindView(R.id.twitter)
    Button twitter;
    @BindView(R.id.Whatsapp)
    Button Whatsapp;
    @BindView(R.id.googlePlus)
    Button googlePlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fb, R.id.twitter, R.id.Whatsapp, R.id.googlePlus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fb:
                Intent fb = new Intent(Intent.ACTION_SEND);
                fb.setType("text/plain");
                String urlFb = "https://github.com/gzeinnumer";
                fb.putExtra(Intent.EXTRA_TEXT,urlFb);
                fb.setPackage("com.facebook.katana");
                startActivity(fb);
                break;
            case R.id.twitter:
                try {
                    Intent twitter = new Intent(Intent.ACTION_SEND);
                    twitter.setType("text/plain");
                    String urlTw = "buka My GitHub nih https://github.com/gzeinnumer";
                    twitter.putExtra(Intent.EXTRA_TEXT,urlTw);
                    twitter.setPackage("advanced.twitter.android");
                    startActivity(twitter);
                }catch (Exception e){
                    Toast.makeText(this, "Install Twitter dulu!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.Whatsapp:
                Intent wa = new Intent(Intent.ACTION_SEND);
                wa.setType("text/plain");
                String urlWa = "https://github.com/gzeinnumer";
                wa.putExtra(Intent.EXTRA_TEXT,urlWa);
                wa.setPackage("com.whatsapp");
                startActivity(wa);
                break;
            case R.id.googlePlus:
                try {
                    Intent gp = new Intent(Intent.ACTION_SEND);
                    gp.setType("text/plain");
                    String urlGP = "buka My GitHub nih https://github.com/gzeinnumer";
                    gp.putExtra(Intent.EXTRA_TEXT,urlGP);
                    gp.setPackage("com.google.android.apps.plus");
                    startActivity(gp);
                }catch (Exception e){
                    Toast.makeText(this, "Install GooglePlus dulu!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
