package com.step.ap.controller;

import com.step.ap.config.annotation.NoAuth;
import com.step.ap.entity.AppVersion;
import com.step.ap.service.AppVersionService;
import com.step.ap.service.FileSystemStorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

@Api("应用版本")
@AllArgsConstructor
@RestController
@RequestMapping("api/appVersions")
public class AppVersionController {
    private final AppVersionService appVersionService;

    @ApiOperation("编辑")
    @PutMapping
    public void updateById(@RequestBody AppVersion appVersion) {
        appVersionService.updateById(appVersion);
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        appVersionService.removeById(id);
    }

    @NoAuth
    @ApiOperation("apk下载")
    @GetMapping("downloadApk/{versionId}")
    public ResponseEntity<Resource> downloadApk(@PathVariable Integer versionId) {
        return appVersionService.downloadApk(versionId);
    }
}
