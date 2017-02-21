package english.project.com.toiec.question;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import english.project.com.toiec.POJO.progress.ProcessUser;
import english.project.com.toiec.english.project.com.service.util.ConstantDefine;

/**
 * Created by AnhTVc on 2/21/17.
 */

public class PDFUtilImp implements PDFUtil {
    @Override
    public String fileToString(String filepath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean autoInitProcessFile(Context context) {
        // Init Progress cho tuong quyen sach
        // 1.Intermediate: co 2 bai test
        // 2. Advanced: co 2 bai test
        // 3. MoreTest: co 4 bai test

        ProcessUser processUser = new ProcessUser();
        Gson gson = new Gson();
        File path = context.getFilesDir();
        File file;
        try {
            file = new File(path, ConstantDefine.FILE_NAME_PROCESS_USER);
            FileOutputStream stream = new FileOutputStream(file);

            String content = gson.toJson(processUser);
            stream.write(content.getBytes());

            stream.close();
            return true;
        } catch (Exception e) {
            // Error while creating file
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkFileExist(File f) {
        if(f.exists() && !f.isDirectory())
            return true;
        else
            return false;
    }
}
