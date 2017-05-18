package example.haim.menusanddialogscont;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FloatingActionButton fab;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }


    @Override
    public void onClick(View fab) {
       new LoginFragment().show(getSupportFragmentManager(),"loginFragment");
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
        if (id == R.id.action_settings_shows_dialog) {
            if (dialog == null){
                dialog = new ProgressDialog(this);
                dialog.setCancelable(false);
                dialog.setTitle("Loggin You In");
                dialog.setMessage("Please Wait...");
            }
            dialog.show();
            fab.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            },2000);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
