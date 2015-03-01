package br.com.kana.activities;

import android.support.v7.app.ActionBarActivity;

import br.com.kana.KanaApplication;

/**
 * Created by everton on 01/03/15.
 */
public class BaseActionBarActivity extends ActionBarActivity {

    public KanaApplication getApp() {
        return (KanaApplication) getApplication();
    }

}
