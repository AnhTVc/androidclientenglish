package english.project.com.toiec.POJO.progress;

/**
 * Created by AnhTVc on 2/21/17.
 */

public class ProcessUser {
    private ProcessBookTest MoreTest;
    private ProcessBookTest Advanced;
    private ProcessBookTest Intermediate;

    public void setMoreTest(ProcessBookTest moreTest) {
        MoreTest = moreTest;
    }

    public void setAdvanced(ProcessBookTest advanced) {
        Advanced = advanced;
    }

    public void setIntermediate(ProcessBookTest intermediate) {
        Intermediate = intermediate;
    }

    public ProcessBookTest getMoreTest() {
        return MoreTest;
    }

    public ProcessBookTest getAdvanced() {
        return Advanced;
    }

    public ProcessBookTest getIntermediate() {
        return Intermediate;
    }
}
