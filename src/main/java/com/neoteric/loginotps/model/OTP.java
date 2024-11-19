package com.neoteric.loginotps.model;



import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Generated;

import java.time.LocalDateTime;

public class OTP {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            name = "phone_number",
            nullable = false
    )
    private String phoneNumber;
    @Column(
            name = "otp_code",
            nullable = false
    )
    private String otpCode;
    @Column(
            name = "expiry_date",
            nullable = false
    )
    private LocalDateTime expiryDate;

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Generated
    public String getOtpCode() {
        return this.otpCode;
    }

    @Generated
    public LocalDateTime getExpiryDate() {
        return this.expiryDate;
    }

    @Generated
    public void setId(final Long id) {
        this.id = id;
    }

    @Generated
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Generated
    public void setOtpCode(final String otpCode) {
        this.otpCode = otpCode;
    }

    @Generated
    public void setExpiryDate(final LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OTP)) {
            return false;
        } else {
            OTP other = (OTP)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label59;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label59;
                    }

                    return false;
                }

                Object this$phoneNumber = this.getPhoneNumber();
                Object other$phoneNumber = other.getPhoneNumber();
                if (this$phoneNumber == null) {
                    if (other$phoneNumber != null) {
                        return false;
                    }
                } else if (!this$phoneNumber.equals(other$phoneNumber)) {
                    return false;
                }

                Object this$otpCode = this.getOtpCode();
                Object other$otpCode = other.getOtpCode();
                if (this$otpCode == null) {
                    if (other$otpCode != null) {
                        return false;
                    }
                } else if (!this$otpCode.equals(other$otpCode)) {
                    return false;
                }

                Object this$expiryDate = this.getExpiryDate();
                Object other$expiryDate = other.getExpiryDate();
                if (this$expiryDate == null) {
                    if (other$expiryDate != null) {
                        return false;
                    }
                } else if (!this$expiryDate.equals(other$expiryDate)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof OTP;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $phoneNumber = this.getPhoneNumber();
        result = result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        Object $otpCode = this.getOtpCode();
        result = result * 59 + ($otpCode == null ? 43 : $otpCode.hashCode());
        Object $expiryDate = this.getExpiryDate();
        result = result * 59 + ($expiryDate == null ? 43 : $expiryDate.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        Long var10000 = this.getId();
        return "OTP(id=" + var10000 + ", phoneNumber=" + this.getPhoneNumber() + ", otpCode=" + this.getOtpCode() + ", expiryDate=" + String.valueOf(this.getExpiryDate()) + ")";
    }

    @Generated
    public OTP(final Long id, final String phoneNumber, final String otpCode, final LocalDateTime expiryDate) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.otpCode = otpCode;
        this.expiryDate = expiryDate;
    }

    @Generated
    public OTP() {
    }
}