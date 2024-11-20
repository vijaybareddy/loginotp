package com.neoteric.loginotps.repository;

import com.neoteric.loginotps.model.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {

    /**
     * Find the latest OTP record by phone number.
     *
     * @param phoneNumber The phone number.
     * @return The latest OTP if found.
     */
    Optional<OTP> findTopByPhoneNumberOrderByExpiryDateDesc(String phoneNumber);
}
