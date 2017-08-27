package co.lujun.testrecyclerview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    private FragmentManager mFragmentManager;

    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getFragmentManager();

        fragments = new Fragment[]{
            new Fragment0(),
            new Fragment1(),
            new Fragment2(),
            new Fragment3()
        };
        replaceFragment(fragments[0]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void replaceFragment(Fragment fragment){
        mFragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.f_1) {
            replaceFragment(fragments[1]);
        }else if (id == R.id.f_2){
            replaceFragment(fragments[2]);
        }else {
            replaceFragment(fragments[3]);
        }

        return super.onOptionsItemSelected(item);
    }
}
