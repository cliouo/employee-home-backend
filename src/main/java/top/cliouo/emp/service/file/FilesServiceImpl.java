package top.cliouo.emp.service.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.cliouo.emp.exception.ServiceException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;
@Service
public class FilesServiceImpl implements FilesService {

    @Value("${file.path.local}")
    private String fileLocalPath;
    @Override
    public String saveFile(byte[] file, String fileName) {
        if (!StrUtil.isNotBlank(fileName)) {
            throw new ServiceException(ServiceExceptionCode.FILENAME_IS_BLAND);
        }
        // 保存文件
        Path path = Paths.get(fileLocalPath + fileName);
        try {
            Files.write(path, file);
        } catch (IOException e) {
            throw new ServiceException(ServiceExceptionCode.FILE_SAVE_ERROR);
        }
        return fileName;
    }

    @Override
    public byte[] getFileContent(String path) {
        if (!StrUtil.isNotBlank(path)) {
            throw new ServiceException(ServiceExceptionCode.FILE_NOT_EXISTS);
        }
        String filePath = fileLocalPath + path;
        return FileUtil.readBytes(filePath);
    }
}
