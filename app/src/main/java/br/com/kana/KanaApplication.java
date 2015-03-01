package br.com.kana;

import android.app.Application;
import android.content.res.AssetManager;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.kana.model.KanaSymbol;

/**
 * Created by everton on 01/03/15.
 */
public class KanaApplication extends Application {

    private List<KanaSymbol> kanas;
    private TextToSpeech tts;
    private boolean japanseseAvailable = false;

    @Override
    public void onCreate() {
        super.onCreate();

        String jsonString = loadAppData();

        kanas = new Gson().fromJson(jsonString, new TypeToken<ArrayList<KanaSymbol>>() {
        }.getType());


        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {

                    int result = tts.setLanguage(Locale.JAPANESE);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    } else {
                        japanseseAvailable = true;
                    }

                } else {
                    Log.e("TTS", "Initilization Failed!");
                }
            }
        });

        Log.d("KanaApplication", kanas.toString());

    }

    public void speak(String something) {
        tts.speak(something, TextToSpeech.QUEUE_FLUSH, null);
    }

    public String loadAppData() {

        try {

            AssetManager manager = this.getAssets();
            InputStream file = manager.open("katakana.json");

            byte[] data = new byte[file.available()];
            file.read(data);
            file.close();
            return new String(data);

        } catch (IOException ex) {
            Log.e("KanaApplication", ex.getMessage(), ex);
            return "";
        }
    }

    public List<KanaSymbol> getKatakanas() {
        return kanas;
    }
}
