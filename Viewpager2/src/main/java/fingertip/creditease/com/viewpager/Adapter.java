package fingertip.creditease.com.viewpager;

import android.app.Fragment;
//import android.support.v4.app.FragmentPagerAdapter;

/**
 * Describe：
 * <p>
 * Author：LZL
 * <p>
 * Date：2016/10/12 下午1:13
 */

public class Adapter extends FragmentPagerAdapter {
    public Adapter() {
        super();
    }
    @Override
    public Fragment getItem(int position) {
        return ArrayListFragment.newInstance(position);
    }
}
