package english.project.com.toiec.question;

import android.content.Context;

import java.io.File;

/**
 * Created by AnhTVc on 2/21/17.
 */

public interface PDFUtil {
    /**
     * File To String
     *
     * @param filepath: duong dan toi file
     * @return
     */
    public String fileToString(String filepath);

    /**
     * Auto init progress file of user when setup
     * @return
     */
    public boolean autoInitProcessFile(Context context);

    /**
     * Kiểm tra sự tồn tại của file
     * @return: true or false
     * true: là tồn tại
     * false: là không tồn tại
     */
    public boolean checkFileExist(File f);
}