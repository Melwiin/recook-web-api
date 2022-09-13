package org.recook.api.File;

import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FileService {
    public final String resPath = System.getProperty("user.dir") + "\\src\\main\\resources\\recipe_images\\";

    public String saveFile(MultipartFile file) throws IOException {
        String fileExtension = "." + StringUtils.getFilenameExtension(file.getOriginalFilename());
        String fileName = UUID.randomUUID().toString() + fileExtension;
        file.transferTo(new File(resPath + fileName));
        return fileName;
    }
}
