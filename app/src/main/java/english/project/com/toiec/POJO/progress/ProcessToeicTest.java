package english.project.com.toiec.POJO.progress;

/**
 * Created by AnhTVc on 2/21/17.
 * Chứa tiến trình người dùng cho từng bài toeic test
 * Một quyển sách thì có nhiều bài test
 * Chương trình thì có nhiều quyển sách
 */

public class ProcessToeicTest {
    private int processPastOne;         // mặc định 10 question
    private int processPastTwo;         // mặc định 30 câu
    private int processPastThree;
    private int processPastFour;
    private int processPastFive;
    private int processPastSix;
    private int processPastSeven;

    public void setProcessPastOne(int processPastOne) {
        this.processPastOne = processPastOne;
    }

    public void setProcessPastTwo(int processPastTwo) {
        this.processPastTwo = processPastTwo;
    }

    public void setProcessPastThree(int processPastThree) {
        this.processPastThree = processPastThree;
    }

    public void setProcessPastFour(int processPastFour) {
        this.processPastFour = processPastFour;
    }

    public void setProcessPastFive(int processPastFive) {
        this.processPastFive = processPastFive;
    }

    public void setProcessPastSix(int processPastSix) {
        this.processPastSix = processPastSix;
    }

    public void setProcessPastSeven(int processPastSeven) {
        this.processPastSeven = processPastSeven;
    }

    public int getProcessPastSeven() {
        return processPastSeven;
    }

    public int getProcessPastOne() {
        return processPastOne;
    }

    public int getProcessPastTwo() {
        return processPastTwo;
    }

    public int getProcessPastThree() {
        return processPastThree;
    }

    public int getProcessPastFour() {
        return processPastFour;
    }

    public int getProcessPastFive() {
        return processPastFive;
    }

    public int getProcessPastSix() {
        return processPastSix;
    }
}
