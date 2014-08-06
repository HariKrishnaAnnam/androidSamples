/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hainva.feedlynavigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FeedlyActivity extends FragmentActivity {
 
    private static final int NUM_PAGES = 5;
    private FeedlyViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        mPager = (FeedlyViewPager) findViewById(R.id.pager);
        mPagerAdapter = new FeedlyPagerAdapter();
        mPager.setAdapter(mPagerAdapter);
    }


    /**
     * A simple pager adapter that represents 5 {@link PageFragment} objects, in
     * sequence.
     */
    private class FeedlyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == ((View) object);
		}
		
		@Override
	    public Object instantiateItem(ViewGroup collection, int position) {
			// Set the title view to show the page number.
			
			LayoutInflater inflater = FeedlyActivity.this.getLayoutInflater();
			
			ViewGroup rootView = (ViewGroup) inflater
	                .inflate(R.layout.fragment_screen_slide_page, null, false);

	        // Set the title view to show the page number.
	        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
	                getString(R.string.title_template_step, position + 1));
	        
	        if(position == 0)
	        {
	        	rootView.setBackgroundColor(Color.parseColor("#0066cc"));
	        } else if (position == 1)
	        {
	        	rootView.setBackgroundColor(Color.parseColor("#CC6699"));
	        } else if (position == 2)
	        {
	        	rootView.setBackgroundColor(Color.parseColor("#CC0066"));
	        } else if(position == 3)
	        {
	        	rootView.setBackgroundColor(Color.parseColor("#CC3300"));
	        } else if(position == 4)
	        {
	        	rootView.setBackgroundColor(Color.parseColor("#FF00FF"));
	        }
			
	        ((FeedlyViewPager) collection).addView(rootView,0);
	        return rootView;
	    }

	    @Override
	    public void destroyItem(ViewGroup collection, int position, Object view) {
	        ((FeedlyViewPager) collection).removeView((ViewGroup) view);
	    }
    }
}
