package quickchart;
// Login validation functionality
public class Login {

private String username;
private String password;
private String cellPhone;
private String firstName;
private String lastName;

public Login(String username, String password, String cellPhone,
             String firstName, String lastName) {

    this.username = username;
    this.password = password;
    this.cellPhone = cellPhone;
    this.firstName = firstName;
    this.lastName = lastName;
}

public boolean checkUserName() {
    return username.contains("_") && username.length() <= 5;
}

public boolean checkPasswordComplexity() {
    return password.matches(
            "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$"
    );
}

public boolean checkCellPhoneNumber() {
    return cellPhone.matches("^\\+27\\d{9}$");
}

public String registerUser() {

    if (!checkUserName()) {
        return "Username is not correctly formatted.";
    }

    if (!checkPasswordComplexity()) {
        return "Password is not correctly formatted.";
    }

    if (!checkCellPhoneNumber()) {
        return "Cell phone number incorrectly formatted.";
    }

    return "User registered successfully!";
}

public boolean loginUser(String enteredUsername,
                         String enteredPassword) {

    return username.equals(enteredUsername)
            && password.equals(enteredPassword);
}

public String returnLoginStatus(boolean status) {

    if (status) {
        return "Welcome " + firstName + " "
                + lastName
                + ", it is great to see you again.";
    }

    return "Username or password incorrect, please try again.";
}
}

