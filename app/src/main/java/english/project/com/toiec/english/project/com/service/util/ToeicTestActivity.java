package english.project.com.toiec.english.project.com.service.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;

import english.project.com.toiec.MainActivity;
import english.project.com.toiec.R;

public class ToeicTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toeic_test);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if(message.equals(ConstantDefine.BOOK_LONGMAN_Intermediate)){

        }else if(message.equals(ConstantDefine.BOOK_LONGMAN_Advanced))
        {

        }else{
            //ConstantDefine.BOOK_LONGMAN_MoreTest
        }
    }
}
