package top.cliouo.emp.controller.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.cliouo.emp.service.file.FilesService;

import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("files")
public class FilesController {

    @Autowired
    FilesService filesService;

    @ResponseBody
    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam(value = "path", required = false) String path) throws Exception {
        return filesService.saveFile(IoUtil.readBytes(file.getInputStream()), file.getOriginalFilename());
    }

    @GetMapping("{path}")
    public void download(HttpServletResponse response,
                         @PathVariable("path") String path) throws IOException {
        byte[] fileContent = filesService.getFileContent(path);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(path, "UTF-8"));
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        // 输出附件
        IoUtil.write(response.getOutputStream(), false, fileContent);
    }
}
