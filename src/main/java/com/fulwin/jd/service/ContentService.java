package com.fulwin.jd.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Time;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import co.elastic.clients.elasticsearch.core.search.Highlight;
import co.elastic.clients.elasticsearch.core.search.HighlightField;
import co.elastic.clients.elasticsearch.core.search.HighlighterFragmenter;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.fulwin.jd.pojo.Content;
import com.fulwin.jd.utils.HtmlParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContentService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    //parse data to es index
    public Boolean parseContent(String keyword) throws IOException {
        List<Content> contents = new HtmlParseUtil().parseJd(keyword);

        BulkRequest.Builder br = new BulkRequest.Builder();
        Time time = Time.of(builder -> builder
                .time("2m")
        );
        br.timeout(time);

        for (Content c : contents) {
            br.operations(op -> op
                    .index(idx -> idx
                            .index("products")
                            .document(c)
                    )
            );
        }

        BulkResponse result = elasticsearchClient.bulk(br.build());


        // Log errors, if any
        if (result.errors()) {
            System.out.println("Bulk had errors");
            for (BulkResponseItem item: result.items()) {
                if (item.error() != null) {
                    System.out.println(item.error().reason());
                }
            }
            return false;
        }
        return true;
    }

    //search
    public List<Content> searchPage(String keywords, int pageNo, int pageSize) throws IOException {
        if(pageNo <= 1){
            pageNo = 1;
        }

        //condition search
        int finalPageNo = pageNo;
        //highlight settings
        Highlight highlight = Highlight.of(h -> h
                        .fields("title", HighlightField.of(f -> f
                                .preTags("<span style='color:red'>")
                                .postTags("</span>")
                                .requireFieldMatch(false)
                        ))
        );
        SearchResponse<Content> response = elasticsearchClient.search(s -> s
                        .index("products")
                        .timeout("1m")
                        .from(finalPageNo)
                        .size(pageSize)
                        .highlight(highlight)
                        .query(q -> q
                                .term(t -> t
                                        .field("title")
                                        .value(keywords)
                                )
                        ),
                Content.class
        );
        ArrayList<Content> list = new ArrayList<>();
        for (Hit<Content> hit : response.hits().hits()) {
            Map<String, List<String>> highlight1 = hit.highlight();
            List<String> title = highlight1.get("title");
            for (String s : title) {
                assert hit.source() != null;
                hit.source().setTitle(s);
            }
            list.add(hit.source());
        }
        return list;
    }
}
