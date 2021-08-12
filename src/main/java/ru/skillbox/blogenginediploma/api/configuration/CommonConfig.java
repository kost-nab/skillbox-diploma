package ru.skillbox.blogenginediploma.api.configuration;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skillbox.blogenginediploma.api.configuration.mapping.TimestampConverter;
import ru.skillbox.blogenginediploma.api.response.post.PostResponse;
import ru.skillbox.blogenginediploma.model.Post;

@Configuration
public class CommonConfig {
    @Autowired
    TimestampConverter timestampConverter;

    @Bean
    public ModelMapper commonMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setSkipNullEnabled(true);
        addTypeMaps(mapper);
        mapper.validate();
        return mapper;
    }

    private void addTypeMaps(ModelMapper mapper) {
        mapper.createTypeMap(Post.class, PostResponse.class)
                .addMapping(Post::getAuthor, PostResponse::setUser)
                .addMappings(m -> m.using(timestampConverter)
                        .map(Post::getTime, PostResponse::setTimestamp)
                )
                // TODO Добавить маппинг
                .addMappings(mapping -> mapping.skip(PostResponse::setLikeCount))
                .addMappings(mapping -> mapping.skip(PostResponse::setDislikeCount))
                .addMappings(mapping -> mapping.skip(PostResponse::setCommentCount))
        ;
    }

}
