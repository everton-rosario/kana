package br.com.kana;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.kana.model.KanaSymbol;

/**
 * Created by everton on 01/03/15.
 */
public class KanaApplication extends Application {

    private List<KanaSymbol> kanas;

    @Override
    public void onCreate() {
        super.onCreate();

        String jsonString = loadAppData();

        kanas = new Gson().fromJson(jsonString, new TypeToken<ArrayList<KanaSymbol>>() {
        }.getType());


        Log.d("KanaApplication", kanas.toString());

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
