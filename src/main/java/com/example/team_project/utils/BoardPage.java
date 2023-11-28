package com.example.team_project.utils;

public class BoardPage {
    public static String pagingStr(int totalCount, int pageSize, int blockPage,
                                   int pageNum, String reqUrl, String classIdx) {
        StringBuilder pagingStr = new StringBuilder("<nav aria-label='Page navigation example'>")
                .append("<ul class='pagination justify-content-center'>");

        int totalPages = (int) Math.ceil((double) totalCount / pageSize);
        int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;

        if (pageTemp != 1) {
            pagingStr.append("<li class='page-item'><a class='page-link' href='")
                    .append(reqUrl).append("?pageNum=1&classIdx=").append(classIdx)
                    .append("'>First</a></li>")
                    .append("<li class='page-item'><a class='page-link' href='")
                    .append(reqUrl).append("?pageNum=").append(pageTemp - 1).append("&classIdx=")
                    .append(classIdx).append("'>Previous</a></li>");
        }

        int blockCount = 1;
        while (blockCount <= blockPage && pageTemp <= totalPages) {
            if (pageTemp == pageNum) {
                pagingStr.append("<li class='page-item'><a class='page-link'>")
                        .append(pageTemp).append("</li>");
            } else {
                pagingStr.append("<li class='page-item'><a class='page-link' href='")
                        .append(reqUrl).append("?pageNum=").append(pageTemp).append("&classIdx=")
                        .append(classIdx).append("'>").append(pageTemp).append("</a></li>");
            }
            pageTemp++;
            blockCount++;
        }

        if (pageTemp <= totalPages) {
            pagingStr.append("<li class='page-item'>")
                    .append("<a class='page-link' href='").append(reqUrl)
                    .append("?pageNum=").append(pageTemp).append("&classIdx=").append(classIdx)
                    .append("'>Next</a></li>")
                    .append("<li class='page-item'> <a class='page-link' href='").append(reqUrl).append("?pageNum=").append(totalPages)
                    .append("&classIdx=").append(classIdx).append("'>Last</a></li>");
        }

        pagingStr.append("</ul></nav>");

        return pagingStr.toString();
    }
}