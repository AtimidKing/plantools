package com.king.file.handle;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 2017/8/16.
 */
@Component
public class FileHandlerImpl implements FileHandler {

    @Override
    public List<String> saveFile(MultipartFile ...multipartFile) throws IOException {
        List<String> addressList = new ArrayList<>();
        for (int i =0 ;i<multipartFile.length;i++) {
            multipartFile[i].transferTo(new File(multipartFile[i].getOriginalFilename()));
            addressList.add(multipartFile[i].getOriginalFilename());
        }
        return addressList;
    }

    @Override
    public byte[] fileToByteArray(File file)throws IOException {
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream bos = null;
        try {

            fileInputStream = new FileInputStream(file);
            bos = new ByteArrayOutputStream((int) file.length());
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            return bos.toByteArray();
        } finally {
            fileInputStream.close();
            bos.close();
        }
    }
}
