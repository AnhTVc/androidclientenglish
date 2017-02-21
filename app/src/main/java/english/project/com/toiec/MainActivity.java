package english.project.com.toiec;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.File;

import english.project.com.toiec.english.project.com.service.util.ConstantDefine;
import english.project.com.toiec.english.project.com.service.util.ToeicTestActivity;
import english.project.com.toiec.question.PDFUtilImp;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    public final static String EXTRA_MESSAGE_BOOK_NAME = "english.project.com.toiec.MESSAGE.book.name";
    public final static String EXTRA_MESSAGE_TOEIC_TEST = "english.project.com.toiec.MESSAGE.toeic.test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Onclick button
        Button btnIntermediate = (Button) findViewById(R.id.btnIntermediate);
        Button btnAdvanced = (Button) findViewById(R.id.btnAdvanced);
        Button btnMoreTest = (Button) findViewById(R.id.btnMoreTest);

        btnIntermediate.setOnClickListener(this);
        btnAdvanced.setOnClickListener(this);
        btnMoreTest.setOnClickListener(this);

        // Check file save process of user in data
        PDFUtilImp pdfUtilImp = new PDFUtilImp();
        if(!pdfUtilImp.checkFileExist(
                new File(getApplicationContext().getFilesDir(), ConstantDefine.FILE_NAME_PROCESS_USER)))
            pdfUtilImp.autoInitProcessFile(getApplicationContext());

        // end check progress
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * Onclick to button begin in book name
     * Open dialog choose toeic test.
     * @param v: view
     */
    @Override
    public void onClick(View v){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        final Intent intent = new Intent(this, ToeicTestActivity.class);
        Button btnTestOne, btnTestTwo, btnTestThree, btnTestFour;

        switch (v.getId()) {
            case R.id.btnIntermediate:
                alertDialog.setContentView(R.layout.dialog_introduct_one_question);

                Button btnStart = (Button) alertDialog.findViewById(R.id.btnStart);
                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    // Open
                    intent.putExtra(EXTRA_MESSAGE_BOOK_NAME, ConstantDefine.BOOK_LONGMAN_Intermediate);
                    intent.putExtra(EXTRA_MESSAGE_TOEIC_TEST, ConstantDefine.TOEIC_TEST_ONE);
                    }
                });

                alertDialog.show();
                break;
            case R.id.btnAdvanced:
                alertDialog.setContentView(R.layout.dialog_introduct_two_question);

                btnTestOne = (Button) alertDialog.findViewById(R.id.btnTestOne);
                btnTestTwo = (Button) alertDialog.findViewById(R.id.btnTestTwo);
                intent.putExtra(EXTRA_MESSAGE_BOOK_NAME, ConstantDefine.BOOK_LONGMAN_Advanced);

                btnTestOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    intent.putExtra(EXTRA_MESSAGE_TOEIC_TEST, ConstantDefine.TOEIC_TEST_ONE);
                    }
                });

                btnTestTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    intent.putExtra(EXTRA_MESSAGE_TOEIC_TEST, ConstantDefine.TOEIC_TEST_TWO);
                    }
                });

                break;
            case R.id.btnMoreTest:
                alertDialog.setContentView(R.layout.dialog_introduct_four_question);

                btnTestOne = (Button) alertDialog.findViewById(R.id.btnTestOne);
                btnTestTwo = (Button) alertDialog.findViewById(R.id.btnTestTwo);
                btnTestThree = (Button) alertDialog.findViewById(R.id.btnTestThree);
                btnTestFour = (Button) alertDialog.findViewById(R.id.btnTestFour);
                btnTestOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    intent.putExtra(EXTRA_MESSAGE_TOEIC_TEST, ConstantDefine.TOEIC_TEST_ONE);
                    }
                });

                btnTestTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    intent.putExtra(EXTRA_MESSAGE_TOEIC_TEST, ConstantDefine.TOEIC_TEST_TWO);
                    }
                });
                btnTestThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    intent.putExtra(EXTRA_MESSAGE_TOEIC_TEST, ConstantDefine.TOEIC_TEST_THREE);
                    }
                });
                btnTestFour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent.putExtra(EXTRA_MESSAGE_TOEIC_TEST, ConstantDefine.TOEIC_TEST_FOUR);
                    }
                });
                break;
            default:
                break;
        }

        startActivity(intent);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
