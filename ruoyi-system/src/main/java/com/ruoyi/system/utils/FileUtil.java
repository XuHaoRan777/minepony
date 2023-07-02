package com.ruoyi.system.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtil {

    /**
     * 将输入流保存为一个新文件到指定的目录。
     *
     * @param inputStream 要保存的输入流
     * @param directory   目标目录
     * @param fileName    目标文件名
     * @throws IOException 如果保存文件失败
     */
    public static void saveFile(InputStream inputStream, String directory, String fileName) throws IOException {
        Path dirPath = Paths.get(directory);
        if (Files.notExists(dirPath)) {
            Files.createDirectories(dirPath);
        }
        Path filePath = dirPath.resolve(fileName);
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 删除指定的文件
     *
     * @param targetPath 目标文件路径
     * @throws IOException 文件删除异常
     */
    public static void deleteFile(String targetPath) throws IOException {
        Path path = Paths.get(targetPath);
        Files.delete(path);
    }

    /**
     * 读取指定文件的内容。
     *
     * @param filePath 要读取的文件路径
     * @return InputStream 包含文件内容的输入流
     * @throws IOException 如果文件读取失败
     */
    public static InputStream readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.newInputStream(path);
    }

    /**
     * 创建文件夹
     *
     * @param directoryPath 文件夹路径
     * @throws IOException 创建文件夹异常
     */
    public static void createDirectory(String directoryPath) throws IOException {
        Path path = Paths.get(directoryPath);
        if (!Files.isDirectory(path)) {
            Files.createDirectories(path);
        }
    }

    /**
     * 判断文件夹是否存在
     *
     * @param directoryPath 文件夹路径
     * @return 是否存在
     */
    public static boolean isDirectoryExists(String directoryPath) {
        Path path = Paths.get(directoryPath);
        return Files.isDirectory(path);
    }
}
