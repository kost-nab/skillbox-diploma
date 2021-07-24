package ru.skillbox.blogenginediploma.api.response.tag;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

@Data
@NoArgsConstructor
public class TagResponse {
    private Set<TagResponseItem> tags = new TreeSet<>();

    public TagResponse(Collection<TagResponseItem> tags) {
        this.tags.addAll(tags);
    }
}
