package com.neoteric.loginotps.request;

import lombok.Generated;

    public class OTPVerificationRequest {
        private String phoneNumber;
        private String otp;

        @Generated
        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        @Generated
        public String getOtp() {
            return this.otp;
        }

        @Generated
        public void setPhoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Generated
        public void setOtp(final String otp) {
            this.otp = otp;
        }

        @Generated
        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof OTPVerificationRequest)) {
                return false;
            } else {
                OTPVerificationRequest other = (OTPVerificationRequest)o;
                if (!other.canEqual(this)) {
                    return false;
                } else {
                    Object this$phoneNumber = this.getPhoneNumber();
                    Object other$phoneNumber = other.getPhoneNumber();
                    if (this$phoneNumber == null) {
                        if (other$phoneNumber != null) {
                            return false;
                        }
                    } else if (!this$phoneNumber.equals(other$phoneNumber)) {
                        return false;
                    }

                    Object this$otp = this.getOtp();
                    Object other$otp = other.getOtp();
                    if (this$otp == null) {
                        if (other$otp != null) {
                            return false;
                        }
                    } else if (!this$otp.equals(other$otp)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        @Generated
        protected boolean canEqual(final Object other) {
            return other instanceof OTPVerificationRequest;
        }

        @Generated
        public int hashCode() {
            boolean PRIME = true;
            int result = 1;
            Object $phoneNumber = this.getPhoneNumber();
            result = result * 59 + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
            Object $otp = this.getOtp();
            result = result * 59 + ($otp == null ? 43 : $otp.hashCode());
            return result;
        }

        @Generated
        public String toString() {
            String var10000 = this.getPhoneNumber();
            return "OTPVerificationRequest(phoneNumber=" + var10000 + ", otp=" + this.getOtp() + ")";
        }

        @Generated
        public OTPVerificationRequest() {
        }

        @Generated
        public OTPVerificationRequest(final String phoneNumber, final String otp) {
            this.phoneNumber = phoneNumber;
            this.otp = otp;
        }
    }


