package com.king.file.handle;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by king on 2017/8/16.
 */
public interface FileHandler {
    /**
     * 保存上传的的文件
     *
     * @param multipartFile 被上传的文件的对象
     * @return 文件的名称列表
     * @throws IOException
     */
    List<String> saveFile(MultipartFile... multipartFile) throws IOException;

    /**
     * 将目标文件转换成字节数组。
     *
     * @param file 目标文件
     * @return 一个字节数组
     * @throws IOException
     */
    byte[] fileToByteArray(File file) throws IOException;

}
