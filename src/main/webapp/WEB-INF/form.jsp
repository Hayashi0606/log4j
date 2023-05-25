<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>テスト</title>
        <style>body {padding: 30px;}</style>
    </head>
    <body>
        <h1>1行掲示板</h1>
        <form action="result" method="post">
            <label for="article">投稿</label>
            <input type="text" name="article">
            <p></p>
            <label for="name">名前</label>
            <input type="text" name="userName">
            <button type="submit">送信する</button>
        </form>

        <p></p>
        <table>
            <tr><th>投稿</th><th>名前</th></tr>
            <% String articles = request.getAttribute("articles").toString(); %>
            <% String[] lines = articles.split("\n", 0); %>
            <% for (String line: lines) { %>
                <tr>
                    <% String[] column = line.split(","); %>
                    <% for (String item: column) { %>
                        <td><%= item %></td>
                    <% } %>
                </tr>
            <% } %>
        </table>
    </body>
</html>