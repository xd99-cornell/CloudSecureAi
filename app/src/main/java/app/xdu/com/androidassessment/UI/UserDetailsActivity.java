package app.xdu.com.androidassessment.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import app.xdu.com.androidassessment.R;
import app.xdu.com.androidassessment.ViewData.RVAdapter2;

public class UserDetailsActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private CommonPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Intent intent = getIntent();
        intent.getIntExtra("id", 1);

        mToolbar =  findViewById(R.id.main_toolbar);
        adapter = new RVAdapter2();
        setSupportActionBar(mToolbar);
        rv= findViewById(R.id.rv2);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
        presenter= new CommonPresenter(this, adapter);
        presenter.retrieveVideoDetails( intent.getIntExtra("id", 1));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refreshOrGoBack) {
            finish();
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
