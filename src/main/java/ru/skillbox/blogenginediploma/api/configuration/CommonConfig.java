package ru.skillbox.blogenginediploma.api.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skillbox.blogenginediploma.api.configuration.mapping.TimestampConverter;
import ru.skillbox.blogenginediploma.api.response.post.PostResponse;
import ru.skillbox.blogenginediploma.model.Post;

@Configuration
public class CommonConfig {
    @Autowired private TimestampConverter timestampConverter;

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
                        .map(Post::getTime, PostResponse::setTimestamp));
    }

}
