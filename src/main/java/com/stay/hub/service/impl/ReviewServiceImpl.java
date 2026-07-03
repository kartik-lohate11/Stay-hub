package com.stay.hub.service.impl;

import com.stay.hub.dto.ReviewDto;
import com.stay.hub.dto.mapper.ReviewMapper;
import com.stay.hub.dto.request.ReviewRequest;
import com.stay.hub.entity.ReviewData;
import com.stay.hub.exception.ResourceNotFound;
import com.stay.hub.repository.ReviewRepository;
import com.stay.hub.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewDto addReview(ReviewRequest request) {

        ReviewData review = reviewMapper.toEntity(request.reviewDto());

        ReviewData savedReview = reviewRepository.save(review);

        return reviewMapper.toDto(savedReview);
    }

    @Override
    public ReviewDto updateReview(Long id, ReviewRequest request) {

        ReviewData review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Review not found with id : " + id));

        reviewMapper.updateEntityFromDto(request.reviewDto(), review);

        ReviewData updatedReview = reviewRepository.save(review);

        return reviewMapper.toDto(updatedReview);
    }

    @Override
    public void deleteReview(Long id) {

        ReviewData review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Review not found with id : " + id));

        reviewRepository.delete(review);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReviewDto> getReviews(Long residenceId) {

        return reviewRepository.
                findByResidenceId(residenceId).
                stream().
                map(reviewMapper::toDto).
                toList();
    }
}
