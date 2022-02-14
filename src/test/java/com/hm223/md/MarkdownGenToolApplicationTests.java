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
                        "  {\"code\":\"1\", \"name\":\"Install\"},\n" +
                        "  {\"code\":\"2\", \"name\":\"Table of contents\"},\n" +
                        "  {\"code\":\"3\", \"name\":\"Demo Preview Parent \"},\n" +
                        "  {\"code\":\"4\", \"name\":\"Test End\"},\n" +
                        "  {\"code\":\"31\", \"name\":\"Son One\"},\n" +
                        "  {\"code\":\"32\", \"name\":\"Son Two\"}\n" +
                        "]"
        );

        Assertions.assertTrue(Boolean.parseBoolean(respBody));

    }

}
