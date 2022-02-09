package com.hm223.md;

import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarkdownGenToolApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Gen Markdown File Test")
    void genMarkdownFileTest() {
        String respBody = HttpUtil.post("http://localhost:8081/gen/ProjectA",
                "[\n" +
                        "  {\"code\":\"01\", \"name\":\"Install\"},\n" +
                        "  {\"code\":\"02\", \"name\":\"Table of contents\"},\n" +
                        "  {\"code\":\"03\", \"name\":\"Demo Preview\"},\n" +
                        "  {\"code\":\"04\", \"name\":\"Test Parent\"},\n" +
                        "  {\"code\":\"041\", \"name\":\"Son One\"},\n" +
                        "  {\"code\":\"042\", \"name\":\"Son Two\"}\n" +
                        "]"
        );

        Assertions.assertTrue(Boolean.parseBoolean(respBody));

    }

}
