function onChangeEmail(){
    toggleButtonsDisabled();
    toggleEmailErrors();
}

function onChangePassword(){
    toggleButtonsDisabled();
    togglePasswordErrors();
}

function toggleEmailErrors(){
    const email = form.email().value;
    form.emailRequiredError().style.display = email ? "none" : "block";
    form.emailInvalidError().style.display = validateEmail ? "none" : "block";
}

function togglePasswordErrors(){
    const password = form.password().value;
    form.passwordRequiredError().style.display = password ? "none" : "block";
}

function toggleButtonsDisabled(){
    const emailValid = isEmailValid();
    const passwordValid = isPasswordValid();

    form.recoverPassword().disabled = !emailValid;
    form.loginButton().disabled = !emailValid || !passwordValid;
}

function isPasswordValid(){
    const password = form.password().value;
    if(!password){
        return false;
    }
    return true;
}

function isEmailValid(){
    const email = form.email().value;
    if(!email){
        return false;
    }
    return validateEmail(email);
}

// Refatoração do código

const form = {
    email: () => document.getElementById('email'),
    emailInvalidError: () => document.getElementById('email-invalid-error'),
    emailRequiredError: () => document.getElementById('email-required-error'),
    loginButton: () => document.getElementById('login-button'),
    password: () => document.getElementById('password'),
    passwordRequiredError: () => document.getElementById('password-required-error'),
    recoverPassword: () => document.getElementById('recover-password-button'),
}