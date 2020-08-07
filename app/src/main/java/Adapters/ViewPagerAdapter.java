package Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fragments.Home_fragment;
import fragments.Leaderboard_fragment;
import fragments.Profile_fragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Home_fragment(); //ChildFragment1 at position 0
            case 1:
                return new Leaderboard_fragment(); //ChildFragment2 at position 1
            case 2:
                return new Profile_fragment(); //ChildFragment3 at position 2
        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 3; //three fragments
    }
}
