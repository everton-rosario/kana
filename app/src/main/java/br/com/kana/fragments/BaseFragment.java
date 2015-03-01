package br.com.kana.fragments;

import android.support.v4.app.Fragment;

import br.com.kana.KanaApplication;

/**
 * Created by everton on 01/03/15.
 */
public class BaseFragment extends Fragment {
    public KanaApplication getApp() {
        return (KanaApplication) getActivity().getApplication();
    }
}
