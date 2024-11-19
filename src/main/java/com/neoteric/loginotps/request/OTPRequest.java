package com.neoteric.loginotps.request;


import lombok.Generated;

public class OTPRequest {
    private String route;
    private String message;
    private String numbers;
    private String flash;

    @Generated
    public String getRoute() {
        return this.route;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public String getNumbers() {
        return this.numbers;
    }

    @Generated
    public String getFlash() {
        return this.flash;
    }

    @Generated
    public void setRoute(final String route) {
        this.route = route;
    }

    @Generated
    public void setMessage(final String message) {
        this.message = message;
    }

    @Generated
    public void setNumbers(final String numbers) {
        this.numbers = numbers;
    }

    @Generated
    public void setFlash(final String flash) {
        this.flash = flash;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OTPRequest)) {
            return false;
        } else {
            OTPRequest other = (OTPRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$route = this.getRoute();
                    Object other$route = other.getRoute();
                    if (this$route == null) {
                        if (other$route == null) {
                            break label59;
                        }
                    } else if (this$route.equals(other$route)) {
                        break label59;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$numbers = this.getNumbers();
                Object other$numbers = other.getNumbers();
                if (this$numbers == null) {
                    if (other$numbers != null) {
                        return false;
                    }
                } else if (!this$numbers.equals(other$numbers)) {
                    return false;
                }

                Object this$flash = this.getFlash();
                Object other$flash = other.getFlash();
                if (this$flash == null) {
                    if (other$flash != null) {
                        return false;
                    }
                } else if (!this$flash.equals(other$flash)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof OTPRequest;
    }

    @Generated
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $route = this.getRoute();
        result = result * 59 + ($route == null ? 43 : $route.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $numbers = this.getNumbers();
        result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
        Object $flash = this.getFlash();
        result = result * 59 + ($flash == null ? 43 : $flash.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getRoute();
        return "OTPRequest(route=" + var10000 + ", message=" + this.getMessage() + ", numbers=" + this.getNumbers() + ", flash=" + this.getFlash() + ")";
    }

    @Generated
    public OTPRequest(final String route, final String message, final String numbers, final String flash) {
        this.route = route;
        this.message = message;
        this.numbers = numbers;
        this.flash = flash;
    }

    @Generated
    public OTPRequest() {
    }
}