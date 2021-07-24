package ru.skillbox.blogenginediploma.api.response.tag;

import lombok.Data;

@Data
public class TagResponseItem implements Comparable<TagResponseItem> {
    private String name;
    private float weight;

    @Override
    public int compareTo(TagResponseItem o) {
        return (int) (o.weight - weight);
    }
}
