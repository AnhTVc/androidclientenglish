package english.project.com.toiec.english.project.com.service.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.google.gson.Gson;

import english.project.com.toiec.MainActivity;
import english.project.com.toiec.POJO.ToiecTest;
import english.project.com.toiec.R;
import english.project.com.toiec.question.PDFUtilImp;

public class ToeicTestActivity extends AppCompatActivity {

    DonutProgress donut_progresspastone, donut_progresspasttwo, donut_progresspastthree, donut_progresspastfour
            ,donut_progresspastfive, donut_progresspastsix, donut_progresspastseven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String URL_FILE_RESULT_TEMP = "/Users/nguyenmanhtuan/Documents/AnhTVc/other/2-Intermediate/test_2.json";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toeic_test);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_BOOK_NAME);

        // Init button in progress
        donut_progresspastone = (DonutProgress) findViewById(R.id.donut_progresspastone);
        donut_progresspasttwo = (DonutProgress) findViewById(R.id.donut_progresspasttwo);
        donut_progresspastthree = (DonutProgress) findViewById(R.id.donut_progresspastthree);
        donut_progresspastfour = (DonutProgress) findViewById(R.id.donut_progresspastfour);
        donut_progresspastfive = (DonutProgress) findViewById(R.id.donut_progresspastfive);
        donut_progresspastsix = (DonutProgress) findViewById(R.id.donut_progresspastsix);
        donut_progresspastseven = (DonutProgress) findViewById(R.id.donut_progresspastseven);
        // complete init

        PDFUtilImp pdfUtilImp = new PDFUtilImp();
        String content = pdfUtilImp.fileToString(URL_FILE_RESULT_TEMP);
        Gson gson = new Gson();
        ToiecTest toiecTest = gson.fromJson(content, ToiecTest.class);


    }

    void loadProgress(){

    }
}
