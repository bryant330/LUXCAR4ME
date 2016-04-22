package kakibuku.hou.com.luxcar4me;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.cm_login_layout) LinearLayout loginLayout;
    @Bind(R.id.cm_register_layout) LinearLayout registerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.cm_login_button)
    void onClickLogin(){
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.cm_show_login_link)
    void onClickShowLogin() {
        registerLayout.setVisibility(View.GONE);
        loginLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.cm_show_register_link)
    void onClickShowRegister() {
        registerLayout.setVisibility(View.VISIBLE);
        loginLayout.setVisibility(View.GONE);
    }


}
