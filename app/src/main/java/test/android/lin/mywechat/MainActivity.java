package test.android.lin.mywechat;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements Fragment1.OnBackListener {
    private FragmentTabHost mTabHost;
    private RadioGroup mTabRg;
    private final Class[] fragments =
            {
                    Fragment1.class, Fragment2.class, Fragment3.class, Fragment4.class
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);
        mTabRg = (RadioGroup) findViewById(R.id.tab_rg_menu);
        int count = fragments.length;
        for (int i = 0; i < count; i++) {
            TabSpec tabSpec = mTabHost.newTabSpec(i + "").setIndicator(i + "");
            mTabHost.addTab(tabSpec, fragments[i], null);
        }
        mTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tab_rb_weixin:
                        mTabHost.setCurrentTab(0);
                        break;
                    case R.id.tab_rb_faxian:
                        mTabHost.setCurrentTab(1);
                        break;
                    case R.id.tab_rb_tongxunlu:
                        mTabHost.setCurrentTab(2);
                        break;
                    case R.id.tab_rb_wo:
                        mTabHost.setCurrentTab(3);
                        break;
                }
            }
        });
        mTabHost.setCurrentTab(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void backEvent() {
        Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
    }
}
