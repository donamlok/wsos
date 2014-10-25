package com.donamlok.wsos;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridPagerAdapter;
import android.support.wearable.view.ImageReference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by pepe on 25/10/14.
 */
//public class SampleGridPagerAdapter extends FragmentGridPagerAdapter {
public class SampleGridPagerAdapter extends GridPagerAdapter {

    private final Context mContext;

    public SampleGridPagerAdapter(Context ctx, FragmentManager fm) {
        super();//fm);
        mContext = ctx;
    }

/*
    static final int[][] BG_IMAGES = {
            {R.drawable.pantalla1, R.drawable.pantalla2, R.drawable.pantalla3},
            {R.drawable.pantalla4, R.drawable.pantalla5, R.drawable.pantalla6, R.drawable.pantalla7},
            {R.drawable.pantalla8, R.drawable.pantalla9}};
            */

static final int[][] BG_IMAGES = {
        {R.drawable.pantalla11, R.drawable.pantalla12, R.drawable.pantalla3, R.drawable.pantalla4, R.drawable.pantalla5},
        {R.drawable.pantalla3}};

// A simple container for static data in each page
private static class Page {
    // static resources
    boolean hasInteraction;
    int backGroundImg;

    public Page(boolean a_hasInteraction, int a_backGroundImg)
    {
        hasInteraction = a_hasInteraction;
        backGroundImg = a_backGroundImg;


    }
}

    Page mPage1 = new Page(false,R.drawable.rellotge1);
    Page mPage2 = new Page(false,R.drawable.rellotge2);
    Page mPage3 = new Page(false,R.drawable.corverd);
    Page mPage4 = new Page(false,R.drawable.passos);
    Page mPage5 = new Page(false,R.drawable.fill);
    Page mPage6 = new Page(false,R.drawable.familia);
    Page mPage7 = new Page(true,R.drawable.teunegre);

// Create a static set of pages in a 2D array
private final Page[][] PAGES = {
        {mPage1, mPage2},
        {mPage3},
        {mPage4},
        {mPage5, mPage6},
        {mPage7} };
/*
        // Override methods in FragmentGridPagerAdapter
// Obtain the UI fragment at the specified position
        //@Override
        public Fragment getFragment(int row, int col) {
            Page page = PAGES[row][col];
            String title = "Hola";// page.titleRes != 0 ? mContext.getString(page.titleRes) : null;
            String text = "Adeu"; // page.textRes != 0 ? mContext.getString(page.textRes) : null;
            CardFragment fragment = CardFragment.create("","");

            // Advanced settings (card gravity, card expansion/scrolling)
            fragment.setCardGravity(page.cardGravity);
            fragment.setExpansionEnabled(page.expansionEnabled);
            fragment.setExpansionDirection(page.expansionDirection);
            fragment.setExpansionFactor(page.expansionFactor);
            return fragment;
        }
*/
    @Override
    protected Object instantiateItem(ViewGroup container, int row, int col)
    {

        final View view = LayoutInflater.from(mContext).inflate(R.layout.grid_view_pager_item, container, false);
        final ImageButton tmpImgBut = (ImageButton)view.findViewById(R.id.imageButton);
        Page tmpPage = PAGES[row][col];
        tmpImgBut.setImageResource(tmpPage.backGroundImg);
        if (tmpPage.hasInteraction)
        {
            tmpImgBut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tmpImgBut.setImageResource(R.drawable.teublanc);
                }
            });
        }
        container.addView(view);


/*
        final View view = LayoutInflater.from(mContext).inflate(R.layout.rect_activity_wear, container, false);
        final ImageButton tmpImgBut = (ImageButton)view.findViewById(R.id.imageButton);
        tmpImgBut.setImageResource(PAGES[row][col].backGroundImg);
        container.addView(view);
        */

        /*
        ViewGroup linearLayout = (ViewGroup) view.findViewById(R.id.layout);

        ImageButton bt = new ImageButton(mContext);
        bt.setImageResource(PAGES[row][col].backGroundImg);
        linearLayout.addView(bt);
*/
        /*
        final int outRow = row;
        final int outCol = col;
        tmpImgBut.setImageResource(PAGES[row][col].backGroundImg);
        //tmpImgBut.setBackgroundResource(PAGES[row][col].backGroundImg);
        ((ViewGroup) tmpImgBut.getParent()).removeView(tmpImgBut);
            tmpImgBut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (PAGES[outRow][outCol].hasInteraction)
                    {
                        tmpImgBut.setImageResource(R.drawable.pantalla11);
                    }
                }
            });
            */
        return view;


        /*
        final ViewGroup tmpViewGroup = (ViewGroup)view.findViewById(R.id.pager);
        final ImageButton tmpImgBut = new ImageButton(mContext);
        tmpImgBut.setImageResource(BG_IMAGES[row][col]);
        tmpViewGroup.addView(tmpImgBut);
        return view;
        */
    }

    @Override
    protected void destroyItem(ViewGroup container, int row, int col, Object view) {
        container.removeView((View)view);
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
/*
    // Obtain the background image for the page at the specified position
    @Override
    public ImageReference getBackground(int row, int column) {
        return ImageReference.forDrawable(PAGES[row][column].backGroundImg);
    }
*/
    // Obtain the number of pages (vertical)
    @Override
    public int getRowCount() {
        return PAGES.length;
    }

    // Obtain the number of pages (horizontal)
    @Override
    public int getColumnCount(int rowNum) {
        return PAGES[rowNum].length;
    }

}

