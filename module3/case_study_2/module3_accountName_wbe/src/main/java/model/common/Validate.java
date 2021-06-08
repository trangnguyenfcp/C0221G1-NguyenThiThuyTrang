package model.common;

import model.bean.Customer;
import model.repository.CustomerRepository;

public class Validate {
    public static final String CUSTOMER_CODE = "^(KH-)[0-9]{4}$";
    public static final String PHONE = "^(\\(84\\)\\+|0)9[0|1][\\d]{7}$";
    public static final String ID_CARD = "^([\\d]{9}|[\\d]{12})$";
    public static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String NUMBER = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String SERVICE_CODE = "^[1-9][\\d]*$";

    public static String validateCustomerCode(String customerCode) {
        String msg = "";
        if ("".equals(customerCode)) {
            msg = "Please input code";
        } else if (!customerCode.matches(CUSTOMER_CODE)) {
            msg = "Customer Code is invalid";
        }
        return msg;
    }
    public static String validatePhone(String phone){
        String msg = "";
        if ("".equals(phone)) {
            msg = "Please input phone number";
        } else if (!phone.matches(PHONE)) {
            msg = "Phone number is invalid";
        }
        return msg;
    }
    public static String validateIdCard(String idCard){
        String msg = "";
        if ("".equals(idCard)) {
            msg = "Please input ID Card";
        } else if (!idCard.matches(ID_CARD)) {
            msg = "ID Card is invalid";
        }
        return msg;
    }
    public static String validateEmail(String email){
        String msg = "";
        if ("".equals(email)) {
            msg = "Please input Email";
        } else if (!email.matches(EMAIL)) {
            msg = "Email is invalid";
        }
        return msg;
    }
    public static String validateNumber(String number){
        String msg = "";
        if ("".equals(number)) {
            msg = "Please input number";
        } else if (!number.matches(NUMBER)) {
            msg = "Number is invalid";
        }
        return msg;
    }
}
