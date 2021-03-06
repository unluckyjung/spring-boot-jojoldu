package com.jojoldu.book.springboot.service.posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(final PostsSaveRequestDto postsSaveRequestDto) {
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(final Long id, final PostsUpdateRequestDto postsUpdateRequestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(notFoundUser(id));

        posts.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(final Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(notFoundUser(id));
        return new PostsResponseDto(posts);
    }

    private Supplier<IllegalArgumentException> notFoundUser(final Long id) {
        return () -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id);
    }

}
