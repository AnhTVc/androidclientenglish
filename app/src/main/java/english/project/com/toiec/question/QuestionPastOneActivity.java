package english.project.com.toiec.question;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import english.project.com.toiec.POJO.ToiecTest;
import english.project.com.toiec.R;
import english.project.com.toiec.english.project.com.service.util.ToeicTestActivity;

public class QuestionPastOneActivity extends AppCompatActivity {

    /**
     * Mô tả
     * Thể hiện phần question past one của bài toeic
     * nếu người dung đang làm dở => hiển thi dialog hỏi lại có muốn làm nữa hay không. Kiểm tra trong progress user
     * nếu người dùng chưa làm thì bắt đầu làm. Nếu người dùng thoát lưu xuống process user (làm xong câu nào
     *      lưu proces câu ấy)
     * 10 câu hỏi cho mỗi past one
     * click next load câu hỏi tiếp theo
     * Hoàn thành 10 câu hỏi quay trở lại trang tổng hợp các câu hỏi
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_past_one);

        ToiecTest toiecTest = ToeicTestActivity.toiecTest;

    }
}
