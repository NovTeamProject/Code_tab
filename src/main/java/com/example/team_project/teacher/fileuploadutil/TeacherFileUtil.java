package com.example.team_project.teacher.fileuploadutil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public class TeacherFileUtil {
    //파일 업로드
    public static String uploadFile(HttpServletRequest req, String sDirectory)
            throws ServletException, IOException {
        // 이 경로가 없으면 만들어줌. 상위 directory까지 전부...
        Path saveDirectoryPath = Paths.get(sDirectory);
        Files.createDirectories(saveDirectoryPath);

        Part part = req.getPart("class-image");

        Collection<Part> parts = req.getParts();

        String partHeader = part.getHeader("content-disposition");
        System.out.println("partHeader=" + partHeader);

        String[] phArr = partHeader.split("filename=");
        String originalFileName = phArr[1].trim().replace("\"", "");

        if (!originalFileName.isEmpty()) {
            part.write(sDirectory + File.separator + originalFileName);
        }
        return originalFileName;
    }

    public static String renameFile(String sDirectory, String fileName) {
        String originalNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String now = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.KOREA).format(new Date());

        String newFileName = now + "__" + originalNameWithoutExtension + ext;

        //기존 파일명을 새로운 파일명으로 변경
        File oldFile = new File(sDirectory + File.separator + fileName);
        File newFile = new File(sDirectory + File.separator + newFileName);
        oldFile.renameTo(newFile);

        return newFileName;
    }

    public static void download(HttpServletRequest req, HttpServletResponse resp, String directory, String sfileName, String ofileName) {
        String sDirectory = req.getServletContext().getRealPath(directory);
        try {
            // parent, child
            File file = new File(sDirectory, sfileName);
            InputStream inputStream = new FileInputStream(file);

            // 한글 파일명 깨짐 방지
            String client = req.getHeader("User-Agent");
            if (client.indexOf("WOW64") == -1) {
                ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
            } else {
                ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            resp.reset();
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition",
                    "attachment; filename=\"" + ofileName + "\"");
            resp.setHeader("Content-Length", "" + file.length());

            ServletOutputStream oStream = resp.getOutputStream();
            byte[] b = new byte[(int)file.length()];
            int readBuffer = 0;
            while ((readBuffer = inputStream.read(b)) > 0) {
                oStream.write(b, 0, readBuffer);
            }
            inputStream.close();
            oStream.flush();
            oStream.close();
        } catch (Exception e) {
            System.out.println("파일 다운로드 중 오류 발생...");
        }
    }

    public static void deleteFile(HttpServletRequest req, String directory, String filename) {
        String sDirectory = req.getServletContext().getRealPath(directory);
        File file = new File(sDirectory + File.separator + filename);
        if (file.exists()) {
            file.delete();
        }
    }
}
