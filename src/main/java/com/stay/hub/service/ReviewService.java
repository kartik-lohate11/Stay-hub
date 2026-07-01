package com.stay.hub.service;

import com.stay.hub.dto.ReviewDto;
import com.stay.hub.dto.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    ReviewDto addReview(ReviewRequest request);

    ReviewDto updateReview(Long id,
                           ReviewRequest request);

    void deleteReview(Long id);

    List<ReviewDto> getReviews(Long residenceId);
}
