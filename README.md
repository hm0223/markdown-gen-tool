# Markdown Gen Tool

自用的快速生成项目README文档工具。

# Table of contents

- [Markdown Gen Tool](#markdown-gen-tool)
- [Table of contents](#table-of-contents)
- [Demo Preview](#demo-preview)

# Demo Preview

执行以下请求或者执行单元测试：

```http request
POST http://localhost:8081/gen/ProjectA
Content-Type: application/json

[
  {"code":"1", "name":"Install"},
  {"code":"2", "name":"Table of contents"},
  {"code":"3", "name":"Demo Preview Parent"},
  {"code":"4", "name":"Test End"},
  {"code":"31", "name":"Son One"},
  {"code":"32", "name":"Son Two"}
]
```

## Preview

执行生成的文档会在资源目录中：

![Show Gen Path](./image/show-gen-path.png)

生成的文档长这样：
![Demo Preview](./image/demo-preview.png)

