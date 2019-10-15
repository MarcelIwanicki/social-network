package com.sharing.overload.repository;

import com.sharing.overload.entity.AppPostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPostCommentRepository extends JpaRepository<AppPostComment, Long> {
}
