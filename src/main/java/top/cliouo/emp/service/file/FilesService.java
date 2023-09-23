package top.cliouo.emp.service.file;

public interface FilesService {
    String saveFile(byte[] file, String fileName);

    byte[] getFileContent(String path);
}
