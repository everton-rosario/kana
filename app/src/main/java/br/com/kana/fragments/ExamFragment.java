package br.com.kana.fragments;

/**
 * Created by everton on 01/03/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.kana.R;
import br.com.kana.model.Exam;
import br.com.kana.model.KanaSymbol;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExamFragment extends BaseFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Exam exam;

    private ViewPager mPager;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ExamFragment newInstance(int sectionNumber) {
        ExamFragment fragment = new ExamFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);

        return fragment;
    }

    private Exam createExam() {
        Exam exam = new Exam();
        return exam;
    }

    public ExamFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_carousel, container, false);

        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPager.setAdapter(new KatakanaAdapter(getActivity().getSupportFragmentManager(), getApp().getKatakanas()));

        exam = createExam();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    /*
     * Adapter para percorrer os itens disponiveis no Pager
     */
    public static class KatakanaAdapter extends FragmentPagerAdapter {

        private final List<KanaSymbol> kanas;

        public KatakanaAdapter(FragmentManager fm, List<KanaSymbol> kanas) {
            super(fm);
            this.kanas = kanas;
        }

        @Override
        public Fragment getItem(int position) {
            return QuestionFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return kanas.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "step " + position;
        }
    }


    /*
     * Fragment que representa cada card dentro do ViewPager
     */
    public static class QuestionFragment extends BaseFragment {

        private int step;

        public QuestionFragment() {
        }

        public static QuestionFragment newInstance(int step) {

            QuestionFragment fragment = new QuestionFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("step", step);
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            this.step = getArguments().getInt("step");

            View rootView = inflater.inflate(R.layout.fragment_card, container, false);

            TextView symbol = (TextView) rootView.findViewById(R.id.symbol);
            symbol.setText(getApp().getKatakanas().get(step).getKatakana());
            symbol.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getApp().speak(getApp().getKatakanas().get(step).getKatakana());
                }
            });


//            final int maxHeight=symbol.getHeight();
//            symbol.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, maxHeight, getResources().getDisplayMetrics()));

            TextView romaji = (TextView) rootView.findViewById(R.id.romaji);
            romaji.setText(getApp().getKatakanas().get(step).getRomaji());

            return rootView;
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        }
    }

}