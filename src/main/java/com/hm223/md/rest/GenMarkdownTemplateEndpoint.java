package com.hm223.md.rest;

import cn.hutool.core.io.FileUtil;
import com.hm223.md.model.TitleItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


/**
 * <p>
 * GenMarkdownTemplateEndpoint.
 * </p>
 *
 * @author huwenfeng
 * @date 2022/02/09
 */
@RestController("/md")
public class GenMarkdownTemplateEndpoint {

    private static final String TABLE_OF_CONTENTS = "Table of contents";
    private static final String PROJECT_NAME_CODE = "0";

    @PostMapping("/gen/{projectName}")
    public boolean gen(
            @PathVariable("projectName") String projectName,
            @RequestBody List<TitleItem> contents
    ) throws IOException {
        final String filePath = "README.md";
        File mdFile = FileUtil.file(filePath);
        if (mdFile.exists()) {
            FileUtil.del(mdFile);
        }
        boolean newFile = mdFile.createNewFile();
        if (!newFile) {
            throw new FileSystemException(filePath);
        }
        writeProjectName(projectName, mdFile);

        writeContents(projectName, contents, mdFile);
        return true;
    }

    private void writeProjectName(String projectName, File mdFile) {
        FileUtil.appendUtf8String("\r\n" + "# " + projectName + "\r\n", mdFile);
    }

    private void writeContents(String projectName, List<TitleItem> list, File mdFile) {
        final List<TitleItem> sortedList = list.stream()
                .sorted(Comparator.comparing(TitleItem::getCode)).collect(Collectors.toList());
        for (TitleItem titleItem : sortedList) {
            if (TABLE_OF_CONTENTS.equals(titleItem.getName())) {
                writeTitle(titleItem, mdFile, false);
                writeContent(List.of(new TitleItem(PROJECT_NAME_CODE, projectName)), mdFile);
                writeContent(sortedList, mdFile);
                continue;
            }

            writeTitle(titleItem, mdFile, true);
        }
    }

    private void writeTitle(TitleItem titleItem, File mdFile, boolean containsBody) {
        FileUtil.appendUtf8String("\r\n" + "#".repeat(titleItem.getCode().length()) + " " + titleItem.getName() + "\r\n", mdFile);
        if (containsBody) {
            FileUtil.appendUtf8String(titleItem.getBody() + "\r\n", mdFile);
        }
    }

    private void writeContent(List<TitleItem> items, File file) {
        for (TitleItem titleItem : items) {
            FileUtil.appendUtf8String(getPrefix(titleItem.getCode()) + genContent(titleItem.getName()) + "\r\n", file);
        }
    }

    private String genContent(String name) {
        return "[" + name + "](" + "#" + name.replace(" ", "-").toLowerCase(Locale.ROOT) + ")";
    }

    private String getPrefix(String code) {
        final String contentPrefix = "- ";
        if (code.length() == 1) {
            return contentPrefix;
        }
        if (code.length() > 1) {
            int tabSize = (code.length() - 1);
            return "\t".repeat(tabSize) + contentPrefix;
        }
        return "";
    }

}
