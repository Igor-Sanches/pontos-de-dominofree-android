package apps.igordutrasanches.pontosdedominofree.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igord on 21/03/2019.
 */

public class AdaptarFragments extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titulos = new ArrayList<>();

    public AdaptarFragments(FragmentManager fm){
        super(fm);
    }

    public void adicionar(Fragment fragment, String titulo){
        this.fragments.add(fragment);
        this.titulos.add(titulo);
    }

    @Override
    public Fragment getItem(int possition){
        return this.fragments.get(possition);
    }

    @Override
    public int getCount(){
        return this.fragments.size();
    }

    @Override
    public String getPageTitle(int position){
        return this.titulos.get(position);
    }
}