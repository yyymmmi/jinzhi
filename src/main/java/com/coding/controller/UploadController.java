package com.coding.controller;

import com.coding.domain.Artificialdata;
import com.coding.mapper.ArtificialDataMapper;
import com.guanweiming.common.utils.Result;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Slf4j
@Api(tags = "上传图片接口")
@RequestMapping("upload")
@RestController
@AllArgsConstructor
public class UploadController {

    private static String baseDir = "F:\\pic";
    private final ArtificialDataMapper artifitialDataMapper;


    @PostMapping("files")
    public String upload(MultipartFile file,@RequestParam String id ) throws IOException {

        String name = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        File outFile = new File(baseDir + name);
        FileUtils.copyToFile(file.getInputStream(), outFile);

        Artificialdata record = new Artificialdata();
        record.setInspectorId(id);
        List<Artificialdata> list = artifitialDataMapper.select(record);
        record.setArtifitialPic(name);
        artifitialDataMapper.updateByPrimaryKeySelective(record);


        return name;
    }

    @GetMapping("download")
    public void download(String name, HttpServletResponse response) throws IOException {
        File file = new File(baseDir + name);
        IOUtils.copy(FileUtils.openInputStream(file), response.getOutputStream());
    }

    @GetMapping("show/{name:.+}")
    public void show(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        File file = new File(baseDir + name);
        IOUtils.copy(FileUtils.openInputStream(file), response.getOutputStream());
    }

}
