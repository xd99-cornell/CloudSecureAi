package app.xdu.com.androidassessment.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import app.xdu.com.androidassessment.R;
import app.xdu.com.androidassessment.ViewData.RVAdapter;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private CommonPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar =  findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        rv= findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        adapter = new RVAdapter();
        rv.setAdapter(adapter);
        presenter = new CommonPresenter(this, adapter);
        presenter.retrieveUserData();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refreshOrGoBack) {
            presenter.retrieveUserData();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
