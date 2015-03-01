package br.com.kana.fragments;

/**
 * Created by everton on 01/03/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.kana.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MemorizeFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private ViewPager mPager;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MemorizeFragment newInstance(int sectionNumber) {
        MemorizeFragment fragment = new MemorizeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MemorizeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_carousel, container, false);

        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        //mPager.setAdapter();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
}