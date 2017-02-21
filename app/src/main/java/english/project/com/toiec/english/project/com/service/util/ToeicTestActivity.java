package english.project.com.toiec.english.project.com.service.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.google.gson.Gson;

import java.io.File;

import english.project.com.toiec.MainActivity;
import english.project.com.toiec.POJO.ToiecTest;
import english.project.com.toiec.POJO.progress.ProcessBookTest;
import english.project.com.toiec.POJO.progress.ProcessToeicTest;
import english.project.com.toiec.POJO.progress.ProcessUser;
import english.project.com.toiec.R;
import english.project.com.toiec.question.PDFUtilImp;

public class ToeicTestActivity extends AppCompatActivity implements View.OnClickListener {

    DonutProgress donut_progresspastone, donut_progresspasttwo, donut_progresspastthree, donut_progresspastfour
            ,donut_progresspastfive, donut_progresspastsix, donut_progresspastseven;
    String messageBookName, messageToeicTest;
    LinearLayout linerLayoutPastOne, linerLayoutPastTwo, linerLayoutPastThree
            ,linerLayoutPastFour, linerLayoutPastFive, linerLayoutPastSix
            , linerLayoutPastSeven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String URL_FILE_RESULT_TEMP = "/Users/nguyenmanhtuan/Documents/AnhTVc/other/2-Intermediate/test_2.json";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toeic_test);

        // Load Message send from MainActivity
        Intent intent = getIntent();
        messageBookName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_BOOK_NAME);
        messageToeicTest = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_TOEIC_TEST);

        // Init button in progress
        donut_progresspastone = (DonutProgress) findViewById(R.id.donut_progresspastone);
        donut_progresspasttwo = (DonutProgress) findViewById(R.id.donut_progresspasttwo);
        donut_progresspastthree = (DonutProgress) findViewById(R.id.donut_progresspastthree);
        donut_progresspastfour = (DonutProgress) findViewById(R.id.donut_progresspastfour);
        donut_progresspastfive = (DonutProgress) findViewById(R.id.donut_progresspastfive);
        donut_progresspastsix = (DonutProgress) findViewById(R.id.donut_progresspastsix);
        donut_progresspastseven = (DonutProgress) findViewById(R.id.donut_progresspastseven);
        // complete init

        // Load data from internet. Now is fix data
        PDFUtilImp pdfUtilImp = new PDFUtilImp();
        String content = pdfUtilImp.fileToString(URL_FILE_RESULT_TEMP);
        Gson gson = new Gson();
        ToiecTest toiecTest = gson.fromJson(content, ToiecTest.class);

        // Load progress
        String contentProcess = pdfUtilImp.fileToString(
                new File(getApplicationContext().getFilesDir(), ConstantDefine.FILE_NAME_PROCESS_USER));

        ProcessUser processUser = gson.fromJson(contentProcess, ProcessUser.class);
        loadProgress(processUser);

        // Event onclick
        linerLayoutPastOne = (LinearLayout) findViewById(R.id.linerLayoutPastOne); linerLayoutPastOne.setOnClickListener(this);
        linerLayoutPastTwo = (LinearLayout) findViewById(R.id.linerLayoutPastTwo); linerLayoutPastTwo.setOnClickListener(this);
        linerLayoutPastThree = (LinearLayout) findViewById(R.id.linerLayoutPastThree); linerLayoutPastThree.setOnClickListener(this);
        linerLayoutPastFour = (LinearLayout) findViewById(R.id.linerLayoutPastFour); linerLayoutPastFour.setOnClickListener(this);
        linerLayoutPastFive = (LinearLayout) findViewById(R.id.linerLayoutPastFive); linerLayoutPastFive.setOnClickListener(this);
        linerLayoutPastSix = (LinearLayout) findViewById(R.id.linerLayoutPastSix); linerLayoutPastSix.setOnClickListener(this);
        linerLayoutPastSeven = (LinearLayout) findViewById(R.id.linerLayoutPastSeven); linerLayoutPastSeven.setOnClickListener(this);

    }

    /**
     * Function loadProcess: Load process from Object ProcessUser to Screen
     * @param processUser: Object ProcessUser
     */
    private void loadProgress(ProcessUser processUser){
        ProcessBookTest processBookTest = new ProcessBookTest();
        ProcessToeicTest processToeicTest = new ProcessToeicTest();
        switch (messageBookName){
            case ConstantDefine.BOOK_LONGMAN_Intermediate:
                processBookTest = processUser.getIntermediate();
                break;
            case ConstantDefine.BOOK_LONGMAN_Advanced:
                processBookTest = processUser.getAdvanced();
                break;
            case ConstantDefine.BOOK_LONGMAN_MoreTest:
                processBookTest = processUser.getMoreTest();
                break;
            default:
                break;
        }

        switch (messageToeicTest){
            case ConstantDefine.TOEIC_TEST_ONE:
                processToeicTest = processBookTest.getProcessToeicTests().get(0);
                break;
            case ConstantDefine.TOEIC_TEST_TWO:
                processToeicTest = processBookTest.getProcessToeicTests().get(1);
                break;
            case ConstantDefine.TOEIC_TEST_THREE:
                processToeicTest = processBookTest.getProcessToeicTests().get(2);
                break;
            case ConstantDefine.TOEIC_TEST_FOUR:
                processToeicTest = processBookTest.getProcessToeicTests().get(3);
                break;
            default:
                break;
        }

        donut_progresspastone.setProgress(processToeicTest.getProcessPastOne() / ConstantDefine.MAX_QUESTION_PAST_ONE);
        donut_progresspasttwo.setProgress(processToeicTest.getProcessPastTwo() / ConstantDefine.MAX_QUESTION_PAST_TWO);
        donut_progresspastthree.setProgress(processToeicTest.getProcessPastThree() / ConstantDefine.MAX_QUESTION_PAST_THREE);
        donut_progresspastfour.setProgress(processToeicTest.getProcessPastFour() / ConstantDefine.MAX_QUESTION_PAST_FOUR);
        donut_progresspastfive.setProgress(processToeicTest.getProcessPastFive() / ConstantDefine.MAX_QUESTION_PAST_FIVE);
        donut_progresspastsix.setProgress(processToeicTest.getProcessPastSix() / ConstantDefine.MAX_QUESTION_PAST_SIX);
        donut_progresspastseven.setProgress(processToeicTest.getProcessPastSeven() / ConstantDefine.MAX_QUESTION_PAST_SEVEN);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linerLayoutPastOne:
                break;
            case R.id.linerLayoutPastTwo:
                break;
            case R.id.linerLayoutPastThree:
                break;
            case R.id.linerLayoutPastFour:
                break;
            case R.id.linerLayoutPastFive:
                break;
            case R.id.linerLayoutPastSix:
                break;
            case R.id.linerLayoutPastSeven:
                break;
            default:
                break;
        }
    }
}
